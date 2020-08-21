package com.example.skbproject.dao;

import com.example.skbproject.dto.BtvDto;
import com.example.skbproject.dto.TopGenreDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface BtvDao {
    List<BtvDto> getLog();
    List<TopGenreDto> getTopGenre(Map<String, Object> paramMap);
    //List<String> getEpsdIdList(int stbId, String oneWeekAgoFrom, String oneWeekAgoTo, String twoWeekAgoFrom, String twoWeekAgoTo);
}
