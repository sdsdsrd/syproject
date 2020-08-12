package com.example.skbproject.controller;

import com.example.skbproject.dto.LogDto;
import com.example.skbproject.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/log")
    public List<LogDto> getLog() {
        return logService.getLog();
    }


}
