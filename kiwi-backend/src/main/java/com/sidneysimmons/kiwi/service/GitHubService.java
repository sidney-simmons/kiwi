package com.sidneysimmons.kiwi.service;

import com.sidneysimmons.kiwi.dao.GitHubApiDao;
import com.sidneysimmons.kiwi.dao.domain.GitHubRepository;
import com.sidneysimmons.kiwi.dao.exception.GitHubDaoException;
import com.sidneysimmons.kiwi.service.domain.GitHubRepositoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * GitHub service.
 */
@Slf4j
@Service("gitHubService")
public class GitHubService {

    @Resource(name = "gitHubApiDao")
    private GitHubApiDao gitHubApiDao;

    /**
     * Get a list of repositories for a given user. This is cached.
     * 
     * @param username the username
     * @return the list of repositories
     * @throws GitHubDaoException thrown if there is a problem talking to the GitHub API
     */
    @CacheResult(cacheName = "gitHubCache")
    public List<GitHubRepositoryDto> getRepositoriesForUser(String username) throws GitHubDaoException {
        log.info("Finding repositories for username = " + username);
        List<GitHubRepository> repositories = gitHubApiDao.getRepositoriesForUser(username);
        List<GitHubRepositoryDto> repositoryDtos = new ArrayList<>();
        for (GitHubRepository repository : repositories) {
            if (shouldShowRepository(repository)) {
                repositoryDtos.add(new GitHubRepositoryDto(repository));
            }
        }
        return repositoryDtos;
    }

    /**
     * Check if the repository should be shown. Currently we show all repositories that aren't private
     * and/or archived.
     * 
     * @param repository the repository
     * @return true if the repository should be shown, false otherwise
     */
    private Boolean shouldShowRepository(GitHubRepository repository) {
        return !repository.getPrivateFlag() && !repository.getArchivedFlag();
    }

}
