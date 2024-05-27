package com.polytech.UrlShortner.controllers;

import com.polytech.UrlShortner.dto.UrlDto;
import com.polytech.UrlShortner.model.Url;
import com.polytech.UrlShortner.service.UrlService;
import com.polytech.UrlShortner.util.Convertor;
import com.polytech.UrlShortner.util.ErrorUtil;
import com.polytech.UrlShortner.util.ResponseUrl;
import com.polytech.UrlShortner.util.UrlEcxeption;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UrlController {

    private final UrlService urlService;



    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/generate")
    public ResponseEntity<?> generateShortLink (@RequestBody @Valid UrlDto urlDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new UrlEcxeption(ErrorUtil.sendErrorToClient(bindingResult));
        }
        ResponseUrl response  = Convertor.convert(urlService.generateShortLink(urlDto), ResponseUrl.class);
        response.setShortLink("http://localhost:8080/api/" + response.getShortLink());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{shortLink}")
    public  ResponseEntity<?> redirectToOriginalLink (@PathVariable String shortLink,HttpServletResponse response) throws IOException {


        Url url = urlService.getEncodedUrl(shortLink);
        response.sendRedirect(url.getOriginalUrl());
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
