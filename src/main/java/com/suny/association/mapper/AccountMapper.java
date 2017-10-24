package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Account;
import org.apache.ibatis.annotations.Param;

/**
 * Comments:  账号表mapper接口映射
 * @author :   孙建荣
 * Create Date: 2017/03/05 23:05
 */
public interface AccountMapper extends IMapper<Account> {
    Account queryByPhone(Long phoneNumber);

    Account queryByMail(String email);

    Account queryQuoteByAccountId(Long accountId);

    Account queryQuoteByMemberId(Long memberId);


    Account queryByMemberId(int memberId);

    int changePassword(@Param("accountId") Long accountId, @Param("newPassword") String newPassword);
}