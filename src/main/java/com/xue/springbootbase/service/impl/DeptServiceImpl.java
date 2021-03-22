package com.xue.springbootbase.service.impl;

import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.mybatis.dao.DeptDao;
import com.xue.springbootbase.service.DeptService;
import com.xue.springbootbase.service.DeptTransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * ServiceImpl:DeptServiceImpl
 * @author
 * @date 2020-10-20
 */
@Service("deptService")
// @Transactional(rollbackFor = Exception.class) 事务在新的impl，减少事务的范围（长事务导致：死锁、卡顿，占用数据库连接，数据库连接池有限）
public class DeptServiceImpl implements DeptService {
    private Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);

    @Autowired
    DeptDao deptDao;

    public void insertDeptRecord() throws Exception {
        // 其他逻辑..

        // 利用编程式事务插入记录
        TransactionalUtils.required(this::insert);

        // 其他逻辑..
    }

    public void insert() {
        // 插入新的记录
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(11L);
        deptDO.setDbSource("sit");
        deptDO.setDname("策划部");
        deptDao.insert(deptDO);
        // 主动抛出异常，从而验证事务是否生效，如果数据插入成功，则表明事务失效
        throw new RuntimeException("插入失败");
    }

/*
自注入方式解决事务失效
    @Autowired
    DeptService deptService;

    @Autowired
    DeptDao deptDao;

    public void insertDeptRecord() {
        // 其他逻辑..

        // 插入记录
        deptService.insert();

        // 其他逻辑..
    }

    @Transactional(rollbackFor = Exception.class)
    public void insert() {
        // 插入新的记录
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(10L);
        deptDO.setDbSource("sit");
        deptDO.setDname("策划部");
        deptDao.insert(deptDO);
        // 主动抛出异常，从而验证事务是否生效，如果数据插入成功，则表明事务失效
        throw new RuntimeException();
    }
*/

/*
采用编程式事务解决事务失效
@Autowired
    protected TransactionTemplate transactionTemplate;

    @Autowired
    DeptDao deptDao;

    public void insertDeptRecord() {
        // 其他逻辑..

        // 利用编程式事务插入记录
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    insert();
                } catch (Exception e) {
                    logger.error("插入失败", e);
                    transactionStatus.setRollbackOnly();
                }
            }
        });

        // 其他逻辑..
    }

    public void insert() {
        // 插入新的记录
        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(11L);
        deptDO.setDbSource("sit");
        deptDO.setDname("策划部");
        deptDao.insert(deptDO);
        // 主动抛出异常，从而验证事务是否生效，如果数据插入成功，则表明事务失效
        throw new RuntimeException();
    }*/


    @Override
    public int update(DeptDO deptDO) {
        return 0;
    }

    @Override
    public int delete(String deptno) {
        return 0;
    }

    @Override
    public List<DeptDO> findList(DeptDO deptDO) {
        // 其他逻辑操作

        // 更新操作

        // 其他逻辑操作 --出错
        return null;
    }

}