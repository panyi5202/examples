package com.example.mq.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author panyi on 2019/8/22.
 */
@Component
@Slf4j
public class AService {
    public void info(String s){
        log.info("AService-> {}",s);
    }
}
