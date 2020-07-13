package com.neu.utils;

import groovy.util.logging.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AutoTask {
    @Scheduled(cron = "*/6****?")
    private void process(){
        log.info("autoTask");
    }
}
