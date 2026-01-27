package com.qa.opencart.log;

import com.aventstack.chaintest.plugins.ChainTestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TestLogger {
    private static final Logger logger = LogManager.getLogger(TestLogger.class);

    public static void log(String message){
        logger.info(message);

        ChainTestListener.log(message);
    }

    public static void error(String message){
        logger.error(message);

        ChainTestListener.log(message);

    }
}
