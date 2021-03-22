package com.xue.springbootbase.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：HUANG ZHI XUE
 * @date ：Create in 2021-03-21
 */

@Component
public class TransactionalComponent {

    public interface Cell {
        void run() throws Exception;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void required(Cell cell) throws Exception {
        cell.run();
    }
}
