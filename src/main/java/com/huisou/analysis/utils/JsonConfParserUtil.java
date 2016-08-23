package com.huisou.analysis.utils;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * 将*.json文件中的配置转为JSONObject
 */
public class JsonConfParserUtil {

    public static JSONObject jsonConfParser(String filePath) throws IOException {
        BufferedReader reader  = new BufferedReader(new FileReader(new File(filePath)));
        StringBuffer jsonData = new StringBuffer();
        String line = null;
        while((line=reader.readLine())!=null){
            jsonData = jsonData.append(line);
        }

        JSONObject jsonFileData = JSONObject.parseObject(String.valueOf(jsonData));
        return jsonFileData;
    }
}
