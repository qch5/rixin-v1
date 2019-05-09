package com.rixin.base.exception;

/**
 * User: dairan
 * Date: 2016-09-23 16:45
 */
public class WOException extends Exception {

    public WOException(String message) {
        super(message);
    }

    public WOException(String message, Throwable cause) {
        super(message, cause);
    }
}
