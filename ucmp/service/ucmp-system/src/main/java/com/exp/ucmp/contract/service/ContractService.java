package com.exp.ucmp.contract.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exp.ucmp.contract.dto.CompanyDto;
import com.exp.ucmp.contract.dto.RetailSaleContractDto;
import com.exp.ucmp.contract.dto.WholesaleContractDto;

public interface ContractService {

	File retailSaleContract(RetailSaleContractDto paramsDto, HttpServletRequest request, HttpServletResponse response) throws IOException;

	List<CompanyDto> querySaleCompany();

	File wholesaleContract(WholesaleContractDto paramsDto, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
