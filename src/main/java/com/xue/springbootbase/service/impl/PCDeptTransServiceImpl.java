package com.xue.springbootbase.service.impl;

import com.xue.springbootbase.service.PCDeptTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-03-19
 */
@Service
public class PCDeptTransServiceImpl extends PCDeptTransService {
//    @Autowired
//    PCDeptTransService pcDeptTransService;
    // 场景：子类PCDeptTransServiceImpl继承父类PCDeptTransService，测试调父类事务是否生效
    // 结论：
    // 1、注入父类调用父类，调生效
    // 2、用this调用父类方法，失效
    // 3、用super调用父类方法，失败

    public void test() {
        super.insertDeptRecord();
    }
}
