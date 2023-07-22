package com.example.loggingservice.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public interface LogService {

    public void logInfo(String message);

    public void logError(String message);

    public void logDebug(String message);
}
