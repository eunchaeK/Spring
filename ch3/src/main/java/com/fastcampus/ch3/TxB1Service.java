package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

@Component
public class TxB1Service {
    @Autowired B1Dao b1Dao;
    @Autowired
    DataSource ds;

    // 빈 다르게 해서 transaction 분리까지 ok
    // exception try catch해서 service 쪽에서 exception 때문에 rollback 안되도록
    // 근데 여기서 롤백이 안됨,,,
    // https://stackoverflow.com/questions/28480480/propagation-requires-new-does-not-create-a-new-transaction-in-spring-with-jpa  빈 관련
    // https://wfreud.tistory.com/340  rollback관련

//    @Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void insertB1WithTx() throws Exception{
        PlatformTransactionManager tm = new DataSourceTransactionManager(ds);
        DefaultTransactionDefinition txd = new DefaultTransactionDefinition();
        txd.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = tm.getTransaction(txd);

        try {
            b1Dao.insert(1, 100);   // 성공
            b1Dao.insert(1, 200);   // 실패
            tm.commit(status);
        } catch (Exception e){
            e.printStackTrace();
            tm.rollback(status);
        }
    }
}
