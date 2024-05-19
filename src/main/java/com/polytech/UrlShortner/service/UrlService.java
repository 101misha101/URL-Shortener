package com.polytech.UrlShortner.service;

import com.polytech.UrlShortner.model.Url;
import com.polytech.UrlShortner.model.UrlDto;
import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    Url generateShortLink(UrlDto urlDto);
    void persistShortLink(Url url);
    Url getEncodedUrl(String url);
    void deleteShortLink(Url url);
}
