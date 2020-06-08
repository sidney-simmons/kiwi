package com.sidneysimmons.kiwi.software.controller;

import com.sidneysimmons.kiwi.ViewNames;
import com.sidneysimmons.kiwi.github.service.GitHubService;
import com.sidneysimmons.kiwi.property.service.PropertyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Software controller.
 * 
 * @author Sidney Simmons
 */
@Controller
@RequestMapping(value = "software-engineer")
public class SoftwareController {

    @Resource(name = "gitHubService")
    private GitHubService gitHubService;

    @Resource(name = "propertyService")
    private PropertyService propertyService;

    @GetMapping(value = "")
    public String softwareEngineer(Model model) {
        String username = propertyService.getProperty("github.username");
        model.addAttribute("repositories", gitHubService.getRepositoriesForUser(username));
        return ViewNames.SOFTWARE_ENGINEER;
    }

}