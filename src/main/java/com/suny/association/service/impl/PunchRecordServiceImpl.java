package com.suny.association.service.impl;

import com.suny.association.mapper.PunchRecordMapper;
import com.suny.association.pojo.po.PunchRecord;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IPunchRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:39
 */
@Service
public class PunchRecordServiceImpl extends AbstractBaseServiceImpl<PunchRecord> implements IPunchRecordService {
    
    private  PunchRecordMapper punchRecordMapper;
    
    @Autowired
    public PunchRecordServiceImpl(PunchRecordMapper punchRecordMapper) {
        this.punchRecordMapper = punchRecordMapper;
    }
    
    public PunchRecordServiceImpl() {
    }
   
}