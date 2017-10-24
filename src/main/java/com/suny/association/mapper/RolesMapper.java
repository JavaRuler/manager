package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Roles;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Comments:  账号角色表mapper映射接口
 * @author :   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface RolesMapper extends IMapper<Roles> {

    List<Account> queryQuote(@Param("roleId") Integer roleId);

}