package com.example.skbproject.controller;

import com.example.skbproject.dto.BtvDto;
import com.example.skbproject.service.BtvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class BtvController {

    @Autowired
    private BtvService service;

    @GetMapping("/log")
    public List<BtvDto> getLog() {
        return service.getLog();
    }

    @GetMapping("/genre/{dayOfWeek}/{time}")
    public List<String> getTopGenre(@PathVariable int dayOfWeek, @PathVariable String time) {
        return service.getTopGenre(dayOfWeek, time);
    }

    @GetMapping("epsd/{now}")
    public List<String> getEpsdIdList(@PathVariable String now) throws ParseException {
        String time = now.substring(8, 10);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dateFormat.parse(now.substring(0,8));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7;
        return service.getEpsdIdList(dayOfWeek, time);
    }

}
