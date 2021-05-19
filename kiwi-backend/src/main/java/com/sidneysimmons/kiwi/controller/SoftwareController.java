package com.sidneysimmons.kiwi.controller;

import com.sidneysimmons.kiwi.controller.domain.RepositoriesResponse;
import com.sidneysimmons.kiwi.controller.domain.ViewNames;
import com.sidneysimmons.kiwi.dao.exception.GitHubDaoException;
import com.sidneysimmons.kiwi.service.GitHubService;
import com.sidneysimmons.kiwi.service.PropertyService;
import com.sidneysimmons.kiwi.service.domain.GitHubRepositoryDto;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Software controller.
 */
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
     * @return the template name
     */
    @GetMapping(value = "")
    public String softwareEngineer() {
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
