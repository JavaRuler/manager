package com.suny.association.service.impl.core;

import com.suny.association.entity.po.Department;
import com.suny.association.entity.po.Member;
import com.suny.association.entity.po.MemberRoles;
import com.suny.association.entity.vo.ConditionMap;
import com.suny.association.service.interfaces.core.IMemberService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**************************************
 *  Description  
 *  @author 孙建荣
 *  @date 17-10-26.下午9:46
 *  @version 1.0
 **************************************/
public class MemberServiceImplTest {
    private static Logger logger = LoggerFactory.getLogger(MemberServiceImplTest.class);
    private IMemberService memberServiceImpl;

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:Spring/applicationContext.xml");
        memberServiceImpl = (IMemberService) applicationContext.getBean("memberServiceImpl");
    }

    @Test
    public void insert() throws Exception {
        Member member = new Member();
        member.setMemberName("测试成员姓名");
        member.setMemberId(10000);
        member.setMemberGradeNumber(2017);
        member.setMemberClassName("测试班级");
        memberServiceImpl.insert(member);
    }

    @Test
    public void selectMemberReference() throws Exception {
        memberServiceImpl.selectMemberReference(1);
    }

    @Test
    public void selectCount() {
        int count = memberServiceImpl.selectCount();
        logger.info("数据库中Member表中数据总数为:{}", count);
    }


    @Test
    public void insertAndReturnId() throws Exception {
        Member member = new Member();
        member.setMemberName("测试成员姓名并返回ID");
//        注释掉因为下面语句是为了测试主键冲突问题
//        member.setMemberId(10000);
        member.setMemberGradeNumber(2017);
        member.setMemberClassName("测试班级并返回ID");
        int returnId = memberServiceImpl.insertAndReturnId(member);
        logger.info("自动返回的ID为:{}", returnId);
    }

    @Test
    public void deleteById() throws Exception {
        memberServiceImpl.deleteById(10425);
    }

    @Test
    public void update() throws Exception {
        Member member = new Member();
        member.setMemberId(104241);
        member.setMemberName("测试更新的名字");
        member.setMemberGradeNumber(2014);
        member.setMemberClassName("测试更新名字");
        member.setMemberStatus(false);
        member.setMemberSex(false);
        member.setMemberDepartment(new Department(1, "办公室"));
        member.setMemberRoles(new MemberRoles(0, "干事"));
        memberServiceImpl.update(member);
    }

    @Test
    public void selectFreezeManager() throws Exception {
        List<Member> memberList = memberServiceImpl.selectFreezeManager();
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void selectNormalManager() throws Exception {
        List<Member> memberList = memberServiceImpl.selectNormalManager();
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void selectFreezeMember() throws Exception {
        List<Member> memberList = memberServiceImpl.selectFreezeMember();
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void selectNormalMember() throws Exception {
        List<Member> memberList = memberServiceImpl.selectNormalMember();
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void selectByMemberRoleId() throws Exception {
        List<Member> memberList = memberServiceImpl.selectByMemberRoleId(0);
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void insertBatchFormFile() throws Exception {
    }

    @Test
    public void selectEqualsMember() {
        Member member = new Member();
        member.setMemberName("刘国颂");
        member.setMemberGradeNumber(2016);
        member.setMemberClassName("软件三班");
        Boolean aBoolean = memberServiceImpl.selectEqualsMember(member);
        logger.info("{}", aBoolean);
    }

    @Test
    public void insertBatch() throws Exception {
        Member member = new Member();
        member.setMemberClassName("测试班级");
        member.setMemberName("测试名字");
        member.setMemberSex(false);
        member.setMemberDepartment(new Department(1, "办公室"));
        member.setMemberGradeNumber(2017);

        Member member2 = new Member();
        member2.setMemberClassName("测试班级");
        member2.setMemberName("测试名字");
        member2.setMemberSex(false);
        member2.setMemberDepartment(new Department(1, "办公室"));
        member2.setMemberGradeNumber(2017);

        List<Member> memberList = new ArrayList<>();
        memberList.add(member);
        memberList.add(member2);
        memberServiceImpl.insertBatch(memberList);

    }


    @Test
    public void selectById() throws Exception {
        Member member = memberServiceImpl.selectById(10000);
        logger.info(member.toString());
    }

    @Test
    public void selectByName() throws Exception {
        Member member = memberServiceImpl.selectByName("孙建荣");
        logger.info(member.toString());
    }

    @Test
    public void selectAll() throws Exception {
        List<Member> memberList = memberServiceImpl.selectAll();
        for (Member member : memberList) {
            logger.info(member.toString());
        }
    }

    @Test
    public void selectByParam() throws Exception {
        Member coditionMember = new Member();
        coditionMember.setMemberName("孙建荣");
        ConditionMap<Member> conditionMap = new ConditionMap<>(coditionMember, 0, 10);
        List<Member> memberList = memberServiceImpl.selectByParam(conditionMap);
        for (Member member : memberList) {
            logger.info(member.toString());
        }

    }

}