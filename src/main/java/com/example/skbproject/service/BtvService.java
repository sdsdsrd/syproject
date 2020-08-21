package com.example.skbproject.service;

import com.example.skbproject.dao.BtvDao;
import com.example.skbproject.dto.BtvDto;
import com.example.skbproject.dto.TopGenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class BtvService {

    @Autowired
    private BtvDao dao;

    public List<BtvDto> getLog() {
        return dao.getLog();
    }

    public List<TopGenreDto> getTopGenre(int stbId, String now) {
        Map<String, Object> map = new HashMap<>();
        map.put("stbId", stbId);
        String oneWeekAgoFrom = "";
        String oneWeekAgoTo = "";
        String twoWeekAgoFrom = "";
        String twoWeekAgoTo = "";
        String time = now.substring(0, 14);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date = dateFormat.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            calendar.add(Calendar.HOUR_OF_DAY, -1);
            oneWeekAgoFrom = dateFormat.format(calendar.getTime());
            map.put("oneWeekAgoFrom", oneWeekAgoFrom);
            calendar.add(Calendar.HOUR_OF_DAY, 2);
            oneWeekAgoTo = dateFormat.format(calendar.getTime());
            map.put("oneWeekAgoTo", oneWeekAgoTo);
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            twoWeekAgoTo = dateFormat.format(calendar.getTime());
            map.put("twoWeekAgoTo", twoWeekAgoTo);
            calendar.add(Calendar.HOUR_OF_DAY, -2);
            twoWeekAgoFrom = dateFormat.format(calendar.getTime());
            map.put("twoWeekAgoFrom", twoWeekAgoFrom);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dao.getTopGenre(map);
    }

    /*
    public List<String> getEpsdIdList(int stbId, String now) {
        String oneWeekAgoFrom = "";
        String oneWeekAgoTo = "";
        String twoWeekAgoFrom = "";
        String twoWeekAgoTo = "";
        String time = now.substring(0, 14);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            Date date = dateFormat.parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            calendar.add(Calendar.HOUR_OF_DAY, -1);
            oneWeekAgoFrom = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.HOUR_OF_DAY, 2);
            oneWeekAgoTo = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            twoWeekAgoTo = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.HOUR_OF_DAY, -2);
            twoWeekAgoFrom = dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dao.getEpsdIdList(stbId, oneWeekAgoFrom, oneWeekAgoTo, twoWeekAgoFrom, twoWeekAgoTo);
    }
     */


}
