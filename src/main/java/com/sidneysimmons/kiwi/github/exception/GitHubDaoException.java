package com.sidneysimmons.kiwi.github.exception;

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
