package com.suny.association.mapper;

import com.suny.association.mapper.interfaces.IMapper;
import com.suny.association.pojo.po.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * Comments:   成员表mapper映射
 * @author :   孙建荣
 * Create Date: 2017/03/05 23:05
 */

public interface MemberMapper extends IMapper<Member> {

    Member queryQuote(int memberId);

    List<Member> queryFreezeManager();

    List<Member> queryNormalManager();

    List<Member> queryFreezeMember();

    List<Member> queryNormalMember();

    List<Member> quoteByMemberRoleId(Integer memberRoleId);

    List<Member> queryLimitMemberRole(@Param("memberRoleId") Integer memberRoleId, @Param("memberGrade") Integer memberGrade);


}