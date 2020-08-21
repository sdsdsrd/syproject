package com.example.skbproject.controller;

import com.example.skbproject.dto.BtvDto;
import com.example.skbproject.dto.TopGenreDto;
import com.example.skbproject.service.BtvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
public class BtvController {

    @Autowired
    private BtvService service;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/log")
    public List<BtvDto> getLog() {
        return service.getLog();
    }

    @GetMapping("/genre/{stbId}/{now}")
    public List<TopGenreDto> getTopGenre(@PathVariable int stbId, @PathVariable String now) {
        return service.getTopGenre(stbId, now);
    }


    @GetMapping("epsd/{stbId}/{now}")
    public List<String> getEpsdIdList(@PathVariable int stbId, @PathVariable String now) {
        String url = "http://localhost:8080/genre/" + stbId + "/" + now;

        List<TopGenreDto> topGenreDtos = restTemplate.getForObject(url, List.class);
        System.out.println(topGenreDtos.size());

        return service.getEpsdIdList(stbId, now);
    }


}
