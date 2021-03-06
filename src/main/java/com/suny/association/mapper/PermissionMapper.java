package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.entity.po.Permission;
import com.suny.association.entity.po.PermissionAllot;

import java.util.List;

/**
 * Comments:   权限的具体管理
 * @author :   孙建荣
 * Create Date: 2017/05/02 13:18
 */
public interface PermissionMapper extends IMapper<Permission> {
    List<PermissionAllot> queryPermissionQuote(int permissionId);
}
