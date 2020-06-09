package com.sidneysimmons.kiwi.github.dao;

import com.sidneysimmons.kiwi.github.domain.GitHubRepository;
import com.sidneysimmons.kiwi.github.exception.GitHubDaoException;
import com.sidneysimmons.kiwi.property.service.PropertyService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * GitHub DAO for interacting with the API.
 * 
 * @author Sidney Simmons
 */
@Service("gitHubApiDao")
public class GitHubApiDao {

    @Resource(name = "propertyService")
    private PropertyService propertyService;

    @Resource(name = "restTemplate")
    private RestTemplate restTemplate;

    /**
     * Get repositories for a given user.
     * 
     * @param username the username
     * @return the list of repositories
     * @throws GitHubDaoException thrown if there is a problem talking to the GitHub API
     */
    public List<GitHubRepository> getRepositoriesForUser(String username) throws GitHubDaoException {
        try {
            ResponseEntity<List<GitHubRepository>> response = restTemplate.exchange(resolveGitHubUrl("/users/" + username + "/repos"), HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<GitHubRepository>>() {
                    });
            return response.getBody();
        } catch (RestClientException e) {
            throw new GitHubDaoException("Exception occurred talking to the GitHub API.", e);
        }
    }

    /**
     * Resolve the GitHub API URL from properties.
     * 
     * @param contextPath a specific context path to append to the base URL
     * @return the full URL
     */
    private String resolveGitHubUrl(String contextPath) {
        return propertyService.getProperty("github.base-url") + contextPath;
    }

}
