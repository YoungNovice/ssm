package com.learn.ssm.chapter3.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Properties;

/**
 * @author xuanyang
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private Logger logger = Logger.getLogger(MyObjectFactory.class);

    private Object temp = null;

    @Override
    public <T> T create(Class<T> type) {
        T result = super.create(type);
        logger.info("创建对象" + result.toString());
        logger.info("equals before? " + temp == result);
        return  result;
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T result = super.create(type, constructorArgTypes, constructorArgs);
        logger.info("创建对象" + result.toString());
        temp = result;
        return result;
    }

    @Override
    public void setProperties(Properties properties) {
        logger.info("自定义ObjectFactory 初始化参数" + properties.toString());
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        logger.info("invoke isCollection" + type.toString());
        return super.isCollection(type);
    }
}
