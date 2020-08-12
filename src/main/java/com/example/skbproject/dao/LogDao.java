package com.example.skbproject.dao;

import com.example.skbproject.dto.LogDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LogDao {
    List<LogDto> getLog();
}
