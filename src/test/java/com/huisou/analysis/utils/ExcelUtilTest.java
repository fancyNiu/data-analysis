package com.huisou.analysis.utils;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by puhui on 2016/8/23.
 */
public class ExcelUtilTest {

    @Test
    public void writeExcelTest(){
        //String filePath = "alert_message"+File.separator+"20160817.xls";
        String filePath = "E:\\工作\\数据分析\\test";
//        String filePath = "alert_message/20160817.xls";
        Map<String,String> map = new HashMap<String,String>();
        map.put("max","1");
        map.put("min","1");
        String db = "openline";
        String table = "CreditAppCustomer";
        ExcelUtil.writeExcel(filePath,db,table,map);
    }


}
