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
public class BTask {
    @Autowired
    private AService aService;

    @Scheduled(cron = "*/10 * * * * *")
    public void run() {
        MDC.put("taskId", "schedule2");
        log.info("BTask 开始");
        aService.info("BTask");
        log.info("BTask 完成");
    }
}
