package com.exp.ucmp.contract.web;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.exp.ucmp.contract.utils.CustomXWPFDocument;
import com.exp.ucmp.contract.utils.WorderToNewWordUtils;

public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
    public static void main(String[] args) throws Exception {
        //需要进行文本替换的信息
        Map<String, Object> data = new HashMap<>();
        data.put("${signatureDate}", new Date());
        data.put("${partyAName}", "甲方");
        data.put("${partyACreditIdentifier}", "统一社会信用代码");
        data.put("${partyAContactNumber}", "甲方联系电话");
        data.put("${partyBName}", "乙方");
        data.put("${partyBAccountName}", "乙方账号");
        data.put("${partyBCreditIdentifier}", "乙方身份证件号 / 统一社会信用代码");
        data.put("${partyBContactNumber}", "乙方联系电话");
        data.put("${vinCode}", "车架号");
        data.put("${brandModel}", "品牌型号");
        data.put("${licensePlate}", "车牌号");
        data.put("${firstRegistrationTime}", "首次登记时间");
        data.put("${transactionPriceLowercase}", "不含税总价");
        data.put("${transactionPriceUppercase}", "不含税总价大写");
        data.put("${transactionPriceLowercaseB}", "含税总价");
        data.put("${transactionPriceUppercaseB}", "含税总价大写");
        data.put("${partyAAccountName}", "甲方账户名称");
        data.put("${partyAAccountNumber}", "甲方账号");
        data.put("${partyABankDeposit}", "甲方开户行");
        data.put("${handsel}", "小定金");
        data.put("${totalHandsel}", "总计小定金");
        data.put("${handselUppercase}", "小定金大写");
        data.put("${totalHandselUppercase}", "总计小定金大写");
        data.put("${balancePayment}", "尾款");
        data.put("${balancePaymentUppercase}", "尾款大写");
        data.put("${largeAmount}", "大定金");
        data.put("${carAmount}", "车辆数量");
        data.put("${totalPrice}", "总价");
        data.put("${totalPriceUppercase}", "总价大写");
        data.put("${partyBCompanyName}", "乙方公司名称");
        data.put("${partyBTaxpayerNumber}", "乙方纳税人识别号");
        data.put("${partyBAddress}", "乙方地址");
        data.put("${partyBBankDeposit}", "乙方开户行");
        data.put("${partyBAccountNumber}", "乙方账号");
        data.put("${deliveryMonth}", "交车月份");
        data.put("${deliveryDay}", "交车日");
        data.put("${dayAmount}", "自然日");

        //图片，如果是多个图片，就新建多个map
        /*Map<String,Object> picture1 = new HashMap<String, Object>();
        picture1.put("width", 100);
        picture1.put("height", 150);
        picture1.put("type", "jpg");
        picture1.put("content", WorderToNewWordUtils.inputStream2ByteArray(new FileInputStream("D:/docTest/p1.jpg"), true));
        data.put("${picture1}",picture1);*/

        //需要进行动态生成的信息
        List<Object> mapList = new ArrayList<Object>();

        //第一个动态生成的数据列表
        /*List<String[]> list01 = new ArrayList<>();
        list01.add(new String[]{"A","11111111111","22","22"});
        list01.add(new String[]{"A","22222222222","33","22"});
        list01.add(new String[]{"B","33333333333","44","22"});
        list01.add(new String[]{"C","44444444444","55","22"});*/

        //第二个动态生成的数据列表
        List<String[]> list02 = new ArrayList<String[]>();
        list02.add(new String[]{"A","11111111111","22","222","2222","22222","222222","2222222","22222222","222222222"});
        list02.add(new String[]{"d","22222222222","33","333","3333","33333","333333","3333333","33333333","333333333"});
        list02.add(new String[]{"B","33333333333","44","444","4444","44444","444444","4444444","44444444","444444444"});
//        list02.add(new String[]{"C","44444444444","55","22"});

//        mapList.add(list01);
        mapList.add(list02);

        //需要动态改变表格的位置；第一个表格的位置为0
        int[] placeList = {0};
        LOGGER.info("开始");
        CustomXWPFDocument doc = WorderToNewWordUtils.changWord("C:/Users/missingBear/Desktop/非全新车批售协议函预定金.docx",data,mapList,placeList);
        FileOutputStream fopts = new FileOutputStream("C:/Users/missingBear/Desktop/非全新车批售协议函预定金1.docx");
        doc.write(fopts);
        fopts.close();
    }

}
