package com.sidneysimmons.kiwi.service;

import com.sidneysimmons.kiwi.service.domain.ApplicationEnvironment;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Environment service.
 * 
 * @author Sidney Simmons
 */
@Slf4j
@Service("environmentService")
public class EnvironmentService {

    private ApplicationEnvironment applicationEnvironment;

    /**
     * Get the application environment data. This is configured upon application startup.
     * 
     * @return the application environment data
     */
    public ApplicationEnvironment getApplicationEnvironment() {
        return applicationEnvironment;
    }

    /**
     * Configure the application environment.
     */
    @PostConstruct
    private void postConstruct() {
        applicationEnvironment = new ApplicationEnvironment();
        applicationEnvironment.setImplementationVersion(getClass().getPackage().getImplementationVersion());
        applicationEnvironment.setUpTime(DateTimeFormatter.ISO_INSTANT.format(Instant.now()));
        try {
            applicationEnvironment.setHostName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            applicationEnvironment.setHostName("Unknown");
            log.warn("Cannot determine host name. Using default.", e);
        }
    }

}
