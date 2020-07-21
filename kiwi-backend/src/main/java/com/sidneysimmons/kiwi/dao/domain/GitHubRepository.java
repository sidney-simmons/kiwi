package com.sidneysimmons.kiwi.dao.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * GitHub repository object.
 * 
 * @author Sidney Simmons
 */
@Data
public class GitHubRepository {

    private String name;
    private String description;

    @JsonAlias("html_url")
    private String htmlUrl;

    @JsonAlias("updated_at")
    private String updatedAt;

}
