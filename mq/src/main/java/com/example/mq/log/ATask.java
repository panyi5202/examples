package com.example.mq.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author panyi on 2019/8/22.
 */
@Component
@Slf4j
public class ATask {
    @Autowired
    private AService aService;

    @Scheduled(cron = "*/5 * * * * *")
    public void run() {
        MDC.put("taskId", "schedule");
        log.info("Atask 开始");
        aService.info("ATask");
        log.info("Atask 完成");
        MDC.remove("taskId");
    }
}
