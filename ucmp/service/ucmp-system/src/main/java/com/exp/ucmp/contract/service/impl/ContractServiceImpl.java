package com.exp.ucmp.contract.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.contract.dao.ContractDao;
import com.exp.ucmp.contract.dto.CarInfoDto;
import com.exp.ucmp.contract.dto.CompanyDto;
import com.exp.ucmp.contract.dto.RetailSaleContractDto;
import com.exp.ucmp.contract.dto.WholesaleContractDto;
import com.exp.ucmp.contract.service.ContractService;
import com.exp.ucmp.contract.utils.CustomXWPFDocument;
import com.exp.ucmp.contract.utils.MoneyToChineseUtil;
import com.exp.ucmp.contract.utils.WorderToNewWordUtils;

import cn.hutool.core.collection.CollectionUtil;

@Service
public class ContractServiceImpl implements ContractService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	@Autowired
	private ContractDao contractDao;
	
	@Autowired
    private UcmpAesConfig ucmpAesConfig;
	
	
	@Autowired
    private HwOBSConfig hwOBSConfig;

	@Override
	public File retailSaleContract(RetailSaleContractDto paramsDto, HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOGGER.info("==生成零售合同=="+JsonBeanUtil.beanToJson(paramsDto));
		//查询车辆销售价
		Double salePrice = this.contractDao.querySalePrice(paramsDto.getStockId());
		//查询公司信息
		CompanyDto companyDto = this.contractDao.queryCompanyDto(paramsDto.getTaxNumber());
		//需要进行文本替换的信息
        Map<String, Object> data = new HashMap<>();
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        data.put("${signatureDate}", form.format(new Date()));
        data.put("${partyAName}", companyDto.getCompanyTitle());
        data.put("${partyACreditIdentifier}", companyDto.getTaxNumber());
        data.put("${partyAContactNumber}", companyDto.getPhone());
        data.put("${partyBName}", paramsDto.getPartyBName());
        data.put("${partyBCreditIdentifier}", paramsDto.getPartyBCreditIdentifier());
        data.put("${partyBContactNumber}", paramsDto.getPartyBContactNumber());
        data.put("${vinCode}", paramsDto.getVin());
        data.put("${brandModel}", paramsDto.getBaseCarTypeName());
        data.put("${licensePlate}", paramsDto.getLicense());
        data.put("${firstRegistrationTime}", paramsDto.getFirstRegistrationTime());
        data.put("${transactionPriceLowercase}", paramsDto.getTransactionPriceLowercase());
        data.put("${transactionPriceUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(paramsDto.getTransactionPriceLowercase())));
        data.put("${transactionPriceLowercaseB}", salePrice);
        data.put("${transactionPriceUppercaseB}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(String.valueOf(salePrice))));
        data.put("${partyAAccountName}", companyDto.getCompanyTitle());
        data.put("${partyAAccountNumber}", companyDto.getReceivingBankAccount());
        data.put("${partyABankDeposit}", companyDto.getReceivingBank());
        data.put("${handsel}", paramsDto.getHandsel());
        data.put("${handselUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(paramsDto.getHandsel())));
        data.put("${balancePayment}", paramsDto.getBalancePayment());
        data.put("${balancePaymentUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(paramsDto.getBalancePayment())));
        data.put("${largeAmount}", paramsDto.getLargeAmount());
        String contractFilePath=ucmpAesConfig.getContractPath()+"/非全新车购买协议.docx";
        CustomXWPFDocument doc = WorderToNewWordUtils.changWord(contractFilePath,data,null,null);
        form=new SimpleDateFormat("yyyyMMddHHmmss");
        String filePath=ucmpAesConfig.getContractPath()+"/非全新车购买协议"+form.format(new Date())+".docx";
        FileOutputStream fopts = new FileOutputStream(filePath);
        doc.write(fopts);
        fopts.close();
        File fileNew = new File(filePath);
        return fileNew;
//        this.downloadFile(fileNew, request, response);
        /*InputStream inputStream = new FileInputStream(fileNew);
        String objKey = HwOBSConfig.getObjectKey() +UUID.randomUUID()+"-"+fileNew.getName();
        ObsClient obsClient = null;
        try {
            String bucketName = hwOBSConfig.getBucketName();
            LOGGER.info("判断桶bucketName" + bucketName);
            obsClient = hwOBSConfig.getInstance();
            LOGGER.info("初始化OBS");
            // 判断桶是否存在
            boolean exists = obsClient.headBucket(bucketName);
            LOGGER.info("判断桶是否存在" + exists);
            if(!exists){
                // 若不存在，则创建桶
                HeaderResponse headerResponse = obsClient.createBucket(bucketName);
                LOGGER.info("创建桶成功" + headerResponse.getRequestId());
            }
            long available = inputStream.available();
            PutObjectRequest request = new PutObjectRequest(bucketName,objKey,inputStream);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(available);
            request.setMetadata(objectMetadata);
            // 设置对象访问权限为公共读
            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
            PutObjectResult result = obsClient.putObject(request);

            // 读取该已上传对象的URL
            LOGGER.info("已上传对象的URL" + JsonBeanUtil.beanToJson(result));
            inputStream.close();
            fileNew.delete();
            return result.getObjectUrl();
        } catch (ObsException e) {
        	LOGGER.error("obs上传失败", e);
        } catch (IOException e) {
        	LOGGER.error("上传失败", e);
        }finally {
            hwOBSConfig.destroy(obsClient);
            inputStream.close();
        }*/
//		return null;
    }

	@Override
	public List<CompanyDto> querySaleCompany() {
		//查询公司信息
		return this.contractDao.queryCompanyDtoList();
	}

	@Override
	public File wholesaleContract(WholesaleContractDto paramsDto, HttpServletRequest request, HttpServletResponse response) throws Exception {
		LOGGER.info("==生成批售合同=="+JsonBeanUtil.beanToJson(paramsDto));
		//查询公司信息
		CompanyDto companyDto = this.contractDao.queryCompanyDto(paramsDto.getTaxNumber());
		if(CollectionUtil.isEmpty(paramsDto.getStockId())){
			throw new Exception("批售车辆不可为空");
		}
		//查询车辆信息
		List<CarInfoDto> carList = this.contractDao.queryCarInfo(paramsDto.getStockId());
		Double totalPrice = 0.0;
		
		List<String[]> list = new ArrayList<>();
		Integer i =1;
		for (CarInfoDto carInfoDto : carList) {
			if(carInfoDto.getSalePrice() == null){
				throw new Exception("批售车辆记录定价，请记录后再操作");
			}
			String config=carInfoDto.getBaseCarTypeName().replace(carInfoDto.getCarSeriesName(), "").trim(); 
			String[] str={i.toString(),carInfoDto.getCarSeriesName(),carInfoDto.getVinCode(),config,carInfoDto.getInteriorColor(),carInfoDto.getCarColour(),carInfoDto.getNewCarPrice(),carInfoDto.getFirstLicenseDate(),carInfoDto.getStockMileage(),carInfoDto.getSalePrice().toString()};
			list.add(str);
			totalPrice+=carInfoDto.getSalePrice();
			i++;
		}
		//需要进行文本替换的信息
        Map<String, Object> data = new HashMap<>();
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        data.put("${signatureDate}", form.format(new Date()));
        data.put("${partyAName}", companyDto.getCompanyTitle());
        data.put("${partyACreditIdentifier}", companyDto.getTaxNumber());
        data.put("${partyBName}", paramsDto.getPartyBName());
        data.put("${partyBAccountName}", paramsDto.getPartyBAccountName());
        data.put("${partyBContactNumber}", paramsDto.getPartyBContactNumber());
        data.put("${carAmount}", paramsDto.getStockId().size());
        data.put("${totalPrice}", totalPrice);
        data.put("${totalPriceUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(totalPrice.toString())));
        data.put("${partyAAccountName}", companyDto.getCompanyTitle());
        data.put("${partyAAccountNumber}", companyDto.getReceivingBankAccount());
        data.put("${partyABankDeposit}", companyDto.getReceivingBank());
        data.put("${partyBCompanyName}", paramsDto.getPartyBCompanyName());
        data.put("${partyBTaxpayerNumber}", paramsDto.getPartyBTaxpayerNumber());
        data.put("${partyBAddress}", paramsDto.getPartyBAddress());
        data.put("${partyBBankDeposit}", paramsDto.getPartyBBankDeposit());
        data.put("${partyBAccountNumber}", paramsDto.getPartyBAccountName());
        data.put("${handsel}", paramsDto.getHandsel());
        Integer totalHandsel = Integer.parseInt(paramsDto.getHandsel())*paramsDto.getStockId().size();
        data.put("${totalHandsel}", totalHandsel.toString());
        data.put("${handselUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(paramsDto.getHandsel())));
        data.put("${totalHandselUppercase}", MoneyToChineseUtil.convert(MoneyToChineseUtil.moneyFormat(totalHandsel.toString())));
        data.put("${deliveryMonth}", paramsDto.getLatestPickupDate().subSequence(5, 7));
        data.put("${deliveryDay}", paramsDto.getLatestPickupDate().subSequence(8, 10));
        data.put("${dayAmount}", paramsDto.getDayAmount());
        String contractFilePath=ucmpAesConfig.getContractPath()+"/非全新车批售协议函预定金.docx";
        //需要进行动态生成的信息
        List<Object> mapList = new ArrayList<>();
        mapList.add(list);
        //需要动态改变表格的位置；第一个表格的位置为0
        int[] placeList = {0};
        CustomXWPFDocument doc = WorderToNewWordUtils.changWord(contractFilePath,data,mapList,placeList);
        form=new SimpleDateFormat("yyyyMMddHHmmss");
        String filePath=ucmpAesConfig.getContractPath()+"/非全新车批售协议函预定金"+form.format(new Date())+".docx";
        FileOutputStream fopts = new FileOutputStream(filePath);
        doc.write(fopts);
        fopts.close();
        File fileNew = new File(filePath);
        return fileNew;
       /* String objKey = HwOBSConfig.getObjectKey() +UUID.randomUUID()+"-"+fileNew.getName();
        ObsClient obsClient = null;
        try {
            String bucketName = hwOBSConfig.getBucketName();
            LOGGER.info("判断桶bucketName" + bucketName);
            obsClient = hwOBSConfig.getInstance();
            LOGGER.info("初始化OBS");
            // 判断桶是否存在
            boolean exists = obsClient.headBucket(bucketName);
            LOGGER.info("判断桶是否存在" + exists);
            if(!exists){
                // 若不存在，则创建桶
                HeaderResponse headerResponse = obsClient.createBucket(bucketName);
                LOGGER.info("创建桶成功" + headerResponse.getRequestId());
            }
            long available = inputStream.available();
            PutObjectRequest request = new PutObjectRequest(bucketName,objKey,inputStream);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(available);
            request.setMetadata(objectMetadata);
            // 设置对象访问权限为公共读
            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
            PutObjectResult result = obsClient.putObject(request);

            // 读取该已上传对象的URL
            LOGGER.info("已上传对象的URL" + JsonBeanUtil.beanToJson(result));
            inputStream.close();
            fileNew.delete();
            return result.getObjectUrl();
        } catch (ObsException e) {
        	LOGGER.error("obs上传失败", e);
        } catch (IOException e) {
        	LOGGER.error("上传失败", e);
        }finally {
            hwOBSConfig.destroy(obsClient);
            inputStream.close();
        }*/
//		return null;
	}

}
