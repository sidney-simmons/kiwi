package com.sidneysimmons.kiwi.controller.domain;

import com.sidneysimmons.kiwi.service.domain.GitHubRepositoryDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * List of GitHub repository DTO's.
 * 
 * @author Sidney Simmons
 */
@Data
public class RepositoriesResponse {

    private List<GitHubRepositoryDto> repositories = new ArrayList<>();

}