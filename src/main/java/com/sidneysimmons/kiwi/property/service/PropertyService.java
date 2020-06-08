package com.sidneysimmons.kiwi.property.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Property service.
 * 
 * @author Sidney Simmons
 */
@Service("propertyService")
public class PropertyService {

    @Autowired
    private Environment environment;

    public String getProperty(String propertyName) {
        return environment.getProperty(propertyName);
    }

}
