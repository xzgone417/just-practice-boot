package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;


public interface ScheduledTasksService {

    /**
     * 接单截止前发送短信
     */
    JobHandlerResult receivingDeadlineSms();

    /**
     * 检测前1小时发送短信
     */
    JobHandlerResult detectionDate();

     /**
     * 检测前1小时发送短信
     */
     JobHandlerResult estimatedTransferTime();

    /**
     * 待接单截止半小时无车商接单提醒发送给二手车主管
     */
    JobHandlerResult receivingDeadlineBeforeSms();
}
