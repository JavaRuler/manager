package com.suny.association.service.interfaces.core;

import com.suny.association.entity.po.ApplicationMessage;
import com.suny.association.entity.po.CallbackResult;
import com.suny.association.service.IBaseService;

/**
 * Comments:
 * @author :   孙建荣
 * Create Date: 2017/03/07 22:11
 */
public interface ICallbackResultService extends IBaseService<CallbackResult> {
    CallbackResult makeUpCallBackResult(ApplicationMessage applicationMessage, int managerId, Boolean resultStatus);
}
