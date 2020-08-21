package com.example.skbproject.dao;

import com.example.skbproject.dto.BtvDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BtvDao {
    List<BtvDto> getLog();
    List<Integer> getTopGenre(int stbId, String oneWeekAgoFrom, String oneWeekAgoTo, String twoWeekAgoFrom, String twoWeekAgoTo);
    //List<String> getEpsdIdList(int stbId, String oneWeekAgoFrom, String oneWeekAgoTo, String twoWeekAgoFrom, String twoWeekAgoTo);
}
