package com.example.loggingservice.service.impl;

import com.example.loggingservice.service.LogService;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class LogServiceImpl implements LogService {

    private static final Logger infoLogger = LogManager.getLogger("infoLogger");
    private static final Logger errorLogger = LogManager.getLogger("errorLogger");
    private static final Logger debugLogger = LogManager.getLogger("debugLogger");

    public void logInfo(String message) {
        infoLogger.info(message);
    }

    public void logError(String message) {
        errorLogger.error(message);
    }

    public void logDebug(String message) {
        debugLogger.debug(message);
    }
}
