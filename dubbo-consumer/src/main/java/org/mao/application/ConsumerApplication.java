package org.mao.application;

import org.apache.dubbo.config.annotation.Reference;
import org.mao.dubbo.api.IFly;
import org.mao.dubbo.dto.FlyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@EnableAutoConfiguration
public class ConsumerApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerApplication.class);

    @Reference
    private IFly fly;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            FlyDTO flyDTO = new FlyDTO();
            flyDTO.setHow(1L);
            flyDTO.setWhen(new Date());
            flyDTO.setWho("me");
            Boolean canFly = fly.canFly(flyDTO);
            LOGGER.info("fly.canFly result: {}", canFly);
        };
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ConsumerApplication.class, args);
        System.exit(0);
    }
}
