package com.polytech.UrlShortner.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.URL;

public class UrlDto {

    @URL(message = "Invalid URL")
    @NotBlank(message = "URL cannot be blank")
    private String originalUrl;


    public UrlDto() {
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
}
