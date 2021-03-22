package com.xue.springbootbase.service;

import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.mybatis.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 部门事务操作
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-03-04
 */
public abstract class PCDeptTransService {
    @Resource
    DeptDao deptDao;
    /**
     * 插入新的记录
     */
    @Transactional(rollbackFor = Exception.class)
     public void insertDeptRecord() {
         DeptDO deptDO = new DeptDO();
         deptDO.setDeptno(9L);
         deptDO.setDbSource("sit");
         deptDO.setDname("策划部");
         deptDao.insert(deptDO);
         // 主动抛出异常
         throw new RuntimeException();
     };
}
