package org.mao.dubbo.impl;

import org.mao.dubbo.api.IFly;
import org.mao.dubbo.dto.FlyDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FlyImpl implements IFly {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlyImpl.class);

    @Override
    public Boolean canFly(FlyDTO dto) {
        LOGGER.info("{}", dto);
        if (dto.getWho().equals("me")) {
            return true;
        }
        return false;
    }
}
