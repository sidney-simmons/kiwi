package com.sidneysimmons.kiwi.controller;

import com.sidneysimmons.kiwi.controller.domain.RepositoriesResponse;
import com.sidneysimmons.kiwi.controller.domain.ViewNames;
import com.sidneysimmons.kiwi.dao.exception.GitHubDaoException;
import com.sidneysimmons.kiwi.service.GitHubService;
import com.sidneysimmons.kiwi.service.PropertyService;
import com.sidneysimmons.kiwi.service.domain.GitHubRepositoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Software controller.
 * 
 * @author Sidney Simmons
 */
@Slf4j
@Controller
@RequestMapping(value = "/software-engineer")
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

    /**
     * Get the GitHub repositories.
     * 
     * @return the repositories
     * @throws GitHubDaoException thrown if there is a problem getting the repositories
     */
    @GetMapping(value = "/get-repositories")
    public @ResponseBody RepositoriesResponse getRepositories() throws GitHubDaoException {
        String username = propertyService.getProperty("github.username");
        List<GitHubRepositoryDto> repositoryDtos = gitHubService.getRepositoriesForUser(username);
        RepositoriesResponse response = new RepositoriesResponse();
        response.setRepositories(repositoryDtos);
        return response;
    }

}
