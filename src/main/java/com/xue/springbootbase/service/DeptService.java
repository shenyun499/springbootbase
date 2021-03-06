package com.xue.springbootbase.service;

import com.xue.springbootbase.entity.DeptDO;

import java.util.List;

/**
 * Service Interface:DeptService
 * @author
 * @date 2020-10-20
 */
public interface DeptService {

    int insert(DeptDO deptDO);

    int update(DeptDO deptDO);

    int delete(String deptno);

    List<DeptDO> findList(DeptDO deptDO);

}