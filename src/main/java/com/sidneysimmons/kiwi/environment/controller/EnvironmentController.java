package com.sidneysimmons.kiwi.environment.controller;

import com.sidneysimmons.kiwi.environment.domain.ApplicationEnvironment;
import com.sidneysimmons.kiwi.environment.service.EnvironmentService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Environment controller.
 * 
 * @author Sidney Simmons
 */
@RestController
@RequestMapping(value = "/environment")
public class EnvironmentController {

    @Resource(name = "environmentService")
    private EnvironmentService environmentService;

    /**
     * Return the application environment information.
     * 
     * @return the application environment information
     */
    @GetMapping(value = "get-environment")
    public ApplicationEnvironment getEnvironment() {
        return environmentService.getApplicationEnvironment();
    }

}
