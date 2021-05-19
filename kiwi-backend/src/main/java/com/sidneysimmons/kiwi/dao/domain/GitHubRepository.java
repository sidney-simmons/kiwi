package com.sidneysimmons.kiwi.dao.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

/**
 * GitHub repository object.
 */
@Data
public class GitHubRepository {

    private String name;
    private String description;

    @JsonAlias("html_url")
    private String htmlUrl;

    @JsonAlias("updated_at")
    private String updatedAt;

    @JsonAlias("archived")
    private Boolean archivedFlag;

    @JsonAlias("private")
    private Boolean privateFlag;

}
