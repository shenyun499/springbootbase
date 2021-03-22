package com.xue.springbootbase.service.impl;

import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.mybatis.dao.DeptDao;
import com.xue.springbootbase.service.DeptTransService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门事务操作实现类
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-03-04
 */
@Service
public class DeptTransServiceImpl implements DeptTransService {
    private Logger logger = LoggerFactory.getLogger(DeptTransServiceImpl.class);

    @Autowired
    private DeptDao deptDao;

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

    //    public void insertDeptRecord() {
//        // 其他逻辑..
//
//        // 插入记录
//        this.insert();
//
//        // 其他逻辑..
//    }
}
