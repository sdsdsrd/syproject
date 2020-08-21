package com.example.skbproject.controller;

import com.example.skbproject.dto.BtvDto;
import com.example.skbproject.dto.TopGenreDto;
import com.example.skbproject.service.BtvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BtvController {

    @Autowired
    private BtvService service;

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
        return service.getEpsdIdList(stbId, now);
    }


}
