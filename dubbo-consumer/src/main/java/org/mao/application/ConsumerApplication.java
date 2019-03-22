package org.mao.application;

import org.apache.log4j.PropertyConfigurator;
import org.mao.dubbo.api.IFly;
import org.mao.dubbo.dto.FlyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class ConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerApplication.class);

    public static void main(String[] args) throws Exception {
        PropertyConfigurator.configure("dubbo-demo/dubbo-consumer/src/main/resources/log4j.properties");
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        IFly fly = applicationContext.getBean(IFly.class);
        FlyDTO flyDTO = new FlyDTO();
        flyDTO.setHow(1L);
        flyDTO.setWhen(new Date());
        flyDTO.setWho("you");
        Boolean canFly = fly.canFly(flyDTO);
        LOGGER.info("fly.canFly result: {}", canFly);
    }
}
