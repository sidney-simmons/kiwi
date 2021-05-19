package com.sidneysimmons.kiwi.service.domain;

import lombok.Data;

/**
 * Domain object for storing environment related data.
 */
@Data
public class ApplicationEnvironment {

    private String implementationVersion;
    private String hostName;
    private String upTime;

}
