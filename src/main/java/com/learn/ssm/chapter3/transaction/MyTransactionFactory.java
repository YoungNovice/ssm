package com.learn.ssm.chapter3.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author xuanyang
 */
public class MyTransactionFactory implements TransactionFactory {

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Transaction newTransaction(Connection connection) {
        return new MyJdbcTransaction(connection);
    }

    @Override
    public Transaction newTransaction(DataSource dataSource,
          TransactionIsolationLevel transactionIsolationLevel, boolean b) {
        return new MyJdbcTransaction(dataSource, transactionIsolationLevel, b);
    }
}
