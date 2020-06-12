package com.sidneysimmons.kiwi.environment.domain;

import lombok.Data;

/**
 * Domain object for storing environment related data.
 * 
 * @author Sidney Simmons
 */
@Data
public class ApplicationEnvironment {

    private String implementationVersion;
    private String hostName;

}
