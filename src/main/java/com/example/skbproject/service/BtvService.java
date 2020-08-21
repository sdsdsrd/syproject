package com.example.skbproject.service;

import com.example.skbproject.dao.BtvDao;
import com.example.skbproject.dto.BtvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BtvService {

    @Autowired
    private BtvDao dao;

    public List<BtvDto> getLog() {
        return dao.getLog();
    }

    public List<Integer> getTopGenre(int stbId, String now) {
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
        return dao.getTopGenre(stbId, oneWeekAgoFrom, oneWeekAgoTo, twoWeekAgoFrom, twoWeekAgoTo);
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
