package com.suny.association.service.impl;

import com.suny.association.enums.MemberEnum;
import com.suny.association.exception.BusinessException;
import com.suny.association.mapper.AccountMapper;
import com.suny.association.mapper.MemberMapper;
import com.suny.association.pojo.po.Account;
import com.suny.association.pojo.po.Member;
import com.suny.association.service.AbstractBaseServiceImpl;
import com.suny.association.service.interfaces.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Comments:  成员逻辑层类
 * Author:   孙建荣
 * Create Date: 2017/03/07 22:35
 */
@Service
public class MemberServiceImpl extends AbstractBaseServiceImpl<Member> implements IMemberService {
    private final MemberMapper memberMapper;
    private final AccountMapper accountMapper;
    
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, AccountMapper accountMapper) {
        this.memberMapper = memberMapper;
        this.accountMapper = accountMapper;
    }
    
    
    @Transactional
    @Override
    public void insert(Member member) {
        memberMapper.insertAndGetId(member);
        Integer memberId = member.getMemberId();
        if(memberId != null){
            createAccount(memberId);
        }
        else{
            throw new BusinessException(MemberEnum.FAIL_INSERT_MEMBER_INFO);
        }
    }
    
    @Transactional
    private void createAccount(Integer memberId) {
        Account autoAccount = new Account();
        Member member = new Member();
        member.setMemberId(memberId);
        String memberIdString = String.valueOf(memberId);
        autoAccount.setAccountName(memberIdString);      //设置账号名字
        autoAccount.setAccountMember(member);            //设置对应的管理员账号
        try {
            accountMapper.insert(autoAccount);
        } catch (Exception e) {
            throw new RuntimeException();
        }

        }
    
    @Transactional
    public int insertReturnCount(Member member) {
        return memberMapper.insertAndGetId(member);
    }
    
    @Transactional
    @Override
    public void deleteById(int id) {
        memberMapper.deleteById(id);
    }
    
    @Transactional
    @Override
    public void update(Member member) {
        memberMapper.update(member);
    }
    
    
    @Override
    public List<Member> queryFreezeManager() {
        return memberMapper.queryFreezeManager();
    }
    
    
    @Override
    public List<Member> queryNormalManager() {
        return memberMapper.queryNormalManager();
    }
    
    
    @Override
    public List<Member> queryFreezeMember() {
        return memberMapper.queryFreezeMember();
    }
    
    
    @Override
    public List<Member> queryNormalMember() {
        return memberMapper.queryNormalMember();
    }
    
    @Override
    public Member queryById(int id) {
        return memberMapper.queryById(id);
    }
    
  
    
    @Override
    public List<Member> queryAll() {
        return memberMapper.queryAll();
    }
    
    @Override
    public List<Member> queryAll(int limit, int offset, String departmentname, int status) {
        return memberMapper.queryAllByConditions(limit, offset, departmentname, status);
    }
    
    
}