package com.sidneysimmons.kiwi.github.service;

import com.sidneysimmons.kiwi.github.dao.GitHubApiDao;
import com.sidneysimmons.kiwi.github.domain.GitHubRepository;
import com.sidneysimmons.kiwi.github.domain.RepositoryDto;
import com.sidneysimmons.kiwi.github.exception.GitHubDaoException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * GitHub service.
 * 
 * @author Sidney Simmons
 */
@Slf4j
@Service("gitHubService")
public class GitHubService {

    @Resource(name = "gitHubApiDao")
    private GitHubApiDao gitHubApiDao;

    public List<RepositoryDto> getRepositoriesForUser(String username) {
        log.info("Finding repositories for username = " + username);
        List<RepositoryDto> repositoryDtos = new ArrayList<>();
        try {
            List<GitHubRepository> repositories = gitHubApiDao.getRepositoriesForUser(username);
            for (GitHubRepository repository : repositories) {
                repositoryDtos.add(buildRepositoryDto(repository));
            }
        } catch (GitHubDaoException e) {
            log.error("Cannot get repositories for user. Returning empty list.", e);
        }
        return repositoryDtos;
    }

    private RepositoryDto buildRepositoryDto(GitHubRepository repository) {
        RepositoryDto repositoryDto = new RepositoryDto();
        repositoryDto.setName(repository.getName());
        return repositoryDto;
    }

}
