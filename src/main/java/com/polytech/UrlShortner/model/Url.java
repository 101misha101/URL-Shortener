package com.polytech.UrlShortner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.time.LocalDateTime;

@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "originalUrl")
    private String originalUrl;

    @Column(name = "shortLink")
    private String shortLink;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public Url(long id, String originalUrl, String shortLink, LocalDateTime creationDate) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortLink = shortLink;
        this.creationDate = creationDate;
    }

    public Url() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id=" + id +
                ", originalUrl='" + originalUrl + '\'' +
                ", shortLink='" + shortLink + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
