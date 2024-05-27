package com.polytech.UrlShortner.util;

import java.time.LocalDateTime;

public class ErrorResponseUrl {
    private String message;
    private LocalDateTime time;

    public ErrorResponseUrl(String message, LocalDateTime time) {
        this.message = message;
        this.time = time;
    }

    public ErrorResponseUrl() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
