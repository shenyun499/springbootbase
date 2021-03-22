package com.xue.springbootbase.controller;

import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.service.DeptService;
import com.xue.springbootbase.service.DeptTransService;
import com.xue.springbootbase.service.impl.PCDeptTransServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门操作控制器
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-20
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    DeptTransService deptTransService;

    @Autowired
    PCDeptTransServiceImpl pcDeptTransService;

    @ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> findAll() {
        DeptDO deptDO = new DeptDO();
        deptDO.setDbSource("dept_dev");
        return deptService.findList(deptDO);
    }

    @ResponseBody
    @RequestMapping(value = "/test")
    public DeptDO test() throws Exception {
        DeptDO deptDO = new DeptDO();
        deptDO.setDbSource("dept_dev");
        deptService.insertDeptRecord();
        return deptDO;
    }

    @ResponseBody
    @RequestMapping(value = "/test2")
    public DeptDO test2() {
        DeptDO deptDO = new DeptDO();
        deptDO.setDbSource("dept_dev");
        pcDeptTransService.test();
        return deptDO;
    }

}
