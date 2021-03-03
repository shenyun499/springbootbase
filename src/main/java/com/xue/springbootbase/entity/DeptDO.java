package com.xue.springbootbase.entity;

import java.io.Serializable;

/**
 * 部门属性类
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2020-10-20
 */
public class DeptDO implements Serializable {
    /**
     * 部门编号
     */
    private Long deptno;

    /**
     * 部门名称
     */
    private String dname;

    /**
     * dbSource数据库源
     */
    private String dbSource;

    public Long getDeptno() {
        return deptno;
    }

    public void setDeptno(Long deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }

    @Override
    public String toString() {
        return "DeptDO{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}
