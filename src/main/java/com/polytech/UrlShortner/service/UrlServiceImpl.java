package com.polytech.UrlShortner.service;

import com.google.common.hash.Hashing;
import com.polytech.UrlShortner.model.Url;
import com.polytech.UrlShortner.dto.UrlDto;
import com.polytech.UrlShortner.repository.UrlRepository;
import com.polytech.UrlShortner.util.Convertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {
        Url url =  Convertor.convert(urlDto,Url.class);
        url.setShortLink(encodeUrl(url.getOriginalUrl()));
        url.setCreationDate(LocalDateTime.now());
        urlRepository.save(url);

        return url;
    }

    private String encodeUrl(String url)
    {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;
    }



    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

}
