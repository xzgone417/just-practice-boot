package com.exp.ucmp.behavior.repository;

import com.exp.ucmp.behavior.dto.MessageDto;

public interface IRepository {
    
    Boolean saveBehavior(MessageDto messageDto) ;
    
    Boolean saveBehaviorResponse(MessageDto messageDto) ;
}
