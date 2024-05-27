package com.polytech.UrlShortner.service;

import com.polytech.UrlShortner.model.Url;
import com.polytech.UrlShortner.dto.UrlDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UrlService {
    Url generateShortLink(UrlDto urlDto);
    Url getEncodedUrl(String url);



}
