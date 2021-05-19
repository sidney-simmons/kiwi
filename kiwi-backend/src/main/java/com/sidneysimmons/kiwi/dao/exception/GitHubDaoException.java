package com.sidneysimmons.kiwi.dao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * GitHub DAO exception.
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Cannot communicate with the GitHub API.")
public class GitHubDaoException extends Exception {

    private static final long serialVersionUID = 1L;

    public GitHubDaoException() {
        super();
    }

    public GitHubDaoException(String message) {
        super(message);
    }

    public GitHubDaoException(Throwable cause) {
        super(cause);
    }

    public GitHubDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public GitHubDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
