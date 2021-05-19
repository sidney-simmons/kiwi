package com.sidneysimmons.kiwi.controller.domain;

import com.sidneysimmons.kiwi.service.domain.GitHubRepositoryDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * List of GitHub repository DTO's.
 */
@Data
public class RepositoriesResponse {

    private List<GitHubRepositoryDto> repositories = new ArrayList<>();

}