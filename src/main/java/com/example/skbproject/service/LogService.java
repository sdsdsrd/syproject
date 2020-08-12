package com.example.skbproject.service;

import com.example.skbproject.dao.LogDao;
import com.example.skbproject.dto.LogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogDao logDao;

    public List<LogDto> getLog() {
        return logDao.getLog();
    }


}
