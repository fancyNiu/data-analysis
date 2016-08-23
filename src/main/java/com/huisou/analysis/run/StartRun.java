package com.huisou.analysis.run;


import com.huisou.analysis.utils.DateSplitUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by jingyang on 16-6-15.
 */
public class StartRun {

    private  static final Logger LOG = LoggerFactory.getLogger(StartRun.class);

    public static void main(String[] args) {

        //获取执行日期
        List<String> dateList = new ArrayList<String>();
        DateSplitUtil ds = null;
        try {
            ds = new DateSplitUtil();
            dateList = ds.dateSplit();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(!dateList.isEmpty()){

        }
    }
}
