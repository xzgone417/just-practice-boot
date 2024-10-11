package com.exp.ucmp.logistics.service;


import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import com.exp.ucmp.logistics.dto.DispatchRequestDto;
import com.exp.ucmp.logistics.dto.TransitPointInfoDto;

public interface LogisticsService {

	String submitTransferApplication(DispatchRequestDto dispatchRequestDto) throws IOException;

	Map<String, String> synTransitPointInfo(TransitPointInfoDto transitPointInfoDto) throws ParseException;

}
