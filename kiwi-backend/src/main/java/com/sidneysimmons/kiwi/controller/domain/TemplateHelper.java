package com.sidneysimmons.kiwi.controller.domain;

import com.sidneysimmons.kiwi.service.EnvironmentService;
import com.sidneysimmons.kiwi.service.domain.ApplicationEnvironment;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Template helper.
 */
@Service("th")
public class TemplateHelper {

    @Resource(name = "environmentService")
    private EnvironmentService environmentService;

    /**
     * Append the application version to the end of the given URL. Meant to be used for static resource
     * versioning.
     * 
     * @param url a URL
     * @return the new URL
     */
    public String appendVersion(String url) {
        ApplicationEnvironment environment = environmentService.getApplicationEnvironment();
        if (url.contains("?")) {
            return url.concat("&v=" + environment.getImplementationVersion());
        } else {
            return url.concat("?v=" + environment.getImplementationVersion());
        }
    }

}
