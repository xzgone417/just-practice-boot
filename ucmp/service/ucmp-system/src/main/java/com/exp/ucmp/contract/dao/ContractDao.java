package com.exp.ucmp.contract.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.contract.dto.CarInfoDto;
import com.exp.ucmp.contract.dto.CompanyDto;

public interface ContractDao {

	Double querySalePrice(Long stockId);

	CompanyDto queryCompanyDto(String taxNumber);

	List<CompanyDto> queryCompanyDtoList();

	List<CarInfoDto> queryCarInfo(@Param("stockIdList")List<Long> stockIdList);

}
