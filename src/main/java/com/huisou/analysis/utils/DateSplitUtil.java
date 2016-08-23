package com.huisou.analysis.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 将两个日期中间的日期按天分割
 */
public class DateSplitUtil {

    private  static final Logger LOG = LoggerFactory.getLogger(DateSplitUtil.class);
    private String startTime;
    private String endTime;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public DateSplitUtil(String endTime) {
        setStartTime("2015-01-01");
        setEndTime(endTime);
    }

    public DateSplitUtil() throws ParseException {
        setStartTime("2015-01-01");
        setEndTime(sdf.format(new Date(System.currentTimeMillis())));
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> dateSplit() throws ParseException {
        List<String> dateList = new ArrayList<String>();
        Calendar date = Calendar.getInstance();
        while(!startTime.equals(endTime)){
            dateList.add(endTime);
            date.setTime(sdf.parse(endTime));
            date.add(Calendar.DAY_OF_YEAR, -1);
            endTime = sdf.format(date.getTime());
        }
        dateList.add(startTime);
        return dateList;
    }
}
