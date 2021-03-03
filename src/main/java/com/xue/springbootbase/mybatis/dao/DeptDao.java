package com.xue.springbootbase.mybatis.dao;

import com.xue.springbootbase.entity.DeptDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门dao类
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-20
 */
@Mapper
public interface DeptDao {

    int insert(DeptDO deptDO);

    int update(DeptDO deptDO);

    int delete(String deptno);

    List<DeptDO> findList(DeptDO deptDO);

    List<DeptDO> findAll();
}
