package com.softgroup.kuznietsov.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by User on 08.03.2017.
 */
@Component
public class ApplicationStartListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger =  LoggerFactory.getLogger(ApplicationStartListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        logger.warn("======================== Application prepared event fired! ===========================");
    }
}
