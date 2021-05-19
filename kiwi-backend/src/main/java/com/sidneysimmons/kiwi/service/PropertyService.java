package com.sidneysimmons.kiwi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Property service.
 */
@Service("propertyService")
public class PropertyService {

    @Autowired
    private Environment environment;

    /**
     * Get a property with the given property name.
     * 
     * @param propertyName a property name
     * @return the property value
     */
    public String getProperty(String propertyName) {
        return environment.getProperty(propertyName);
    }

}
