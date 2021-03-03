package com.xue.springbootbase.controller;

import com.xue.springbootbase.entity.DeptDO;
import com.xue.springbootbase.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @ResponseBody
    @RequestMapping(value = "/listDeptInfo")
    public List<DeptDO> findAll() {
        DeptDO deptDO = new DeptDO();
        deptDO.setDbSource("dept_dev");
        return deptService.findList(deptDO);
    }
}
