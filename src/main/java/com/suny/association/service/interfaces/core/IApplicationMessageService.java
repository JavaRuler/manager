package com.suny.association.service.interfaces.core;

import com.suny.association.pojo.po.ApplicationMessage;
import com.suny.association.pojo.po.CallbackResult;
import com.suny.association.service.IBaseService;

/**
 * Comments:
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:10
 */
public interface IApplicationMessageService extends IBaseService<ApplicationMessage> {
    void updateApplyForResult(ApplicationMessage applicationMessage, CallbackResult callbackResult);
}
