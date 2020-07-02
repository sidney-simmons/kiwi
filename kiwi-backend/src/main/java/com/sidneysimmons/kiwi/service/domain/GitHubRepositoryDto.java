package com.sidneysimmons.kiwi.service.domain;

import com.sidneysimmons.kiwi.dao.domain.GitHubRepository;
import java.time.Instant;
import lombok.Data;

/**
 * GitHub repository DTO object.
 * 
 * @author Sidney Simmons
 */
@Data
public class GitHubRepositoryDto {

    private String name;
    private String description;
    private String htmlUrl;
    private Instant updatedAt;

    /**
     * Constructor to create the DTO from a repository object.
     * 
     * @param repository a repository object
     */
    public GitHubRepositoryDto(GitHubRepository repository) {
        this.name = repository.getName();
        this.description = repository.getDescription();
        this.htmlUrl = repository.getHtmlUrl();
        this.updatedAt = Instant.parse(repository.getUpdatedAt());
    }

}
