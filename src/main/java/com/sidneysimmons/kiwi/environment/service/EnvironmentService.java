package com.sidneysimmons.kiwi.environment.service;

import com.sidneysimmons.kiwi.environment.domain.ApplicationEnvironment;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
     * Append the application version to the end of the given URL. Meant to be used for static resource
     * versioning.
     * 
     * @param url a URL
     * @return the new URL
     */
    public String appendVersion(String url) {
        if (url.contains("?")) {
            return url.concat("&v=" + applicationEnvironment.getImplementationVersion());
        } else {
            return url.concat("?v=" + applicationEnvironment.getImplementationVersion());
        }
    }

    /**
     * Configure the application environment.
     */
    @PostConstruct
    private void postConstruct() {
        applicationEnvironment = new ApplicationEnvironment();
        applicationEnvironment.setImplementationVersion(getClass().getPackage().getImplementationVersion());
        try {
            applicationEnvironment.setHostName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            applicationEnvironment.setHostName("docker-swarm");
            log.warn("Cannot determine host name. Using default.", e);
        }
    }

}
