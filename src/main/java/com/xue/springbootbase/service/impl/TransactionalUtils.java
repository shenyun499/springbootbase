package com.xue.springbootbase.service.impl;

/**
 * 编程式事务
 *
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-03-21
 */
public class TransactionalUtils {

    private static volatile TransactionalComponent transactionalComponent;

    private static synchronized TransactionalComponent getTransactionalComponent() {
        if (transactionalComponent == null) {
            // 从容器中获取 transactionalComponent
            transactionalComponent = ApplicationContextUtils.getBean(TransactionalComponent.class);
        }
        return transactionalComponent;
    }

    public static void required(TransactionalComponent.Cell cell) throws Exception {
        getTransactionalComponent().required(cell);
    }
}
