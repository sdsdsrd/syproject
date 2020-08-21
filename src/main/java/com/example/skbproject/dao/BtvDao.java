package com.example.skbproject.dao;

import com.example.skbproject.dto.BtvDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BtvDao {
    List<BtvDto> getLog();
    List<String> getTopGenre(int dayOfWeek, String time);
    List<String> getEpsdIdList(int dayOfWeek, String time);
}
