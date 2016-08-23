package com.huisou.analysis.utils;

import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by puhui on 2016/8/23.
 */
public class DateSplitUtilTest {

    @Test
    public void dateSplitTest() throws ParseException {

        List<String> dateList = new ArrayList<String>();

        DateSplitUtil ds = new DateSplitUtil();
        dateList = ds.dateSplit();
        for (int i=0;i<dateList.size();i++){
            System.out.println(dateList.get(i));
        }

    }

}
