package com.sidneysimmons.kiwi.software.controller;

import com.sidneysimmons.kiwi.ViewNames;
import com.sidneysimmons.kiwi.github.domain.GitHubRepositoryDto;
import com.sidneysimmons.kiwi.github.exception.GitHubDaoException;
import com.sidneysimmons.kiwi.github.service.GitHubService;
import com.sidneysimmons.kiwi.property.service.PropertyService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Software controller.
 * 
 * @author Sidney Simmons
 */
@Slf4j
@Controller
@RequestMapping(value = "software-engineer")
public class SoftwareController {

    @Resource(name = "gitHubService")
    private GitHubService gitHubService;

    @Resource(name = "propertyService")
    private PropertyService propertyService;

    /**
     * Return the main software engineer template/model.
     * 
     * @param model the model
     * @return the template name
     */
    @GetMapping(value = "")
    public String softwareEngineer(Model model) {
        String username = propertyService.getProperty("github.username");
        List<GitHubRepositoryDto> repositoryDtos = null;
        try {
            repositoryDtos = gitHubService.getRepositoriesForUser(username);
        } catch (GitHubDaoException e) {
            log.error("Cannot get repositories for user. Returning empty list.", e);
            repositoryDtos = new ArrayList<>();
        }
        model.addAttribute("repositories", repositoryDtos);
        return ViewNames.SOFTWARE_ENGINEER;
    }

}
