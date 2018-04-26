package com.learn.ssm.chapter3.interceptor;

import com.learn.ssm.chapter3.databaseid.MyDataBaseIdProvider;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Properties;

@Intercepts(@Signature(method = "prepare",
        type = StatementHandler.class, args = {Connection.class, Integer.class}))
public class MyInterceptor implements Interceptor{

    private Properties props;
    private Logger logger = Logger.getLogger(MyInterceptor.class);


    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        logger.info("插件的参数" + props);
        MetaObject metaObject = SystemMetaObject.forObject(target);
        //
        while (metaObject.hasGetter("h")) {
            Object origin = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(origin);
        }
        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        Object param = metaObject.getValue("delegate.boundSql.parameterObject");
        logger.info("执行的sql"+ sql);
        logger.info("参数"+ param);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        props = properties;
    }
}
