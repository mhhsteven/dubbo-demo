package org.mao.application;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class ProviderApplication {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("dubbo-demo/dubbo-provider/src/main/resources/log4j.properties");
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        countDownLatch.await();
    }
}
