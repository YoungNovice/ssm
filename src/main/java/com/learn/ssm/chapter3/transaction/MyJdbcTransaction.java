package com.learn.ssm.chapter3.transaction;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Young
 */
public class MyJdbcTransaction extends JdbcTransaction implements Transaction{

    private Logger logger = Logger.getLogger(MyJdbcTransaction.class);


    public MyJdbcTransaction(DataSource ds, TransactionIsolationLevel desiredLevel, boolean desiredAutoCommit) {
        super(ds, desiredLevel, desiredAutoCommit);
    }

    public MyJdbcTransaction(Connection connection) {
        super(connection);
    }

    @Override
    public Connection getConnection() throws SQLException {
        logger.info("my transaction getConnection");
        return super.getConnection();
    }

    @Override
    public void commit() throws SQLException {
        logger.info("my transaction commit");
        super.commit();
    }

    @Override
    public void rollback() throws SQLException {
        logger.info("my transaction getConnection");
        super.rollback();
    }

    @Override
    public void close() throws SQLException {
        logger.info("my transaction close");
        super.close();
    }

    @Override
    public Integer getTimeout() throws SQLException {
        logger.info("my transaction getTimeout");
        return super.getTimeout();
    }
}
