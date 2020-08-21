package com.example.skbproject.service;

import com.example.skbproject.dao.BtvDao;
import com.example.skbproject.dto.BtvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BtvService {

    @Autowired
    private BtvDao dao;

    public List<BtvDto> getLog() {
        return dao.getLog();
    }

    public List<String> getTopGenre(int dayOfWeek, String time) {
        return dao.getTopGenre(dayOfWeek, time);
    }

    public List<String> getEpsdIdList(int dayOfWeek, String time) {
        return dao.getEpsdIdList(dayOfWeek, time);
    }
}
