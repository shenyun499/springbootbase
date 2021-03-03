package com.xue.springbootbase.service.impl;

import com.xue.springbootbase.mybatis.dao.DeptDao;
import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ServiceImpl:DeptServiceImpl
 * @author
 * @date 2020-10-20
 */
@Transactional(rollbackFor = Exception.class)
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
    @Autowired
    private DeptDao deptDao;

    @Override
    public int insert(DeptDO deptDO) {
        return 0;
    }

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
        return deptDao.findList(deptDO);
    }

}