package com.huisou.analysis.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by puhui on 2016/8/8.
 */
public class ExcelUtil {

    //读取excel
    public static List readExcel(String inputFilePath,String sheetName){
        //创建一个list 用来存储读取的内容
        List list = new ArrayList();
        Cell cell =null;

        try {
            //创建输入流
            InputStream in = new FileInputStream(inputFilePath);

            //获取Excel文件对象
            Workbook rwb = Workbook.getWorkbook(in);

            //获取指定工作表及行数
            Sheet sheet = rwb.getSheet(sheetName);
            int rowCount = sheet.getRows();

            //去除表头，读取每一行的内容并存入list中
            for(int i=1;i<rowCount;i++){
                int columnCount = sheet.getColumns();
                String[] strs = new String[columnCount];
                for(int j=0;j<columnCount;j++){
                    cell = sheet.getCell(j,i);
                    strs[j] = cell.getContents();
                }
                list.add(strs);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    //写入excel

    public static void writeExcel(String outputFilePath,String db, String table,Map<String,String> map){

        try {
            //设置title的字体,背景色及边框
            WritableFont titleFont = new WritableFont(WritableFont.ARIAL,14,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
            WritableCellFormat titleCellFormat = new WritableCellFormat(titleFont);
            titleCellFormat.setBackground(Colour.GREEN);
            titleCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            //设置正文的字体，背景色及边框
            WritableFont textFont = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD,false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);
            WritableCellFormat textCellFormat = new WritableCellFormat(textFont);
            textCellFormat.setBackground(Colour.AUTOMATIC);
            textCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

            //获取title内容
            String confPath = ExcelUtil.class.getClassLoader().getResource("./conf/excel_title.json").getPath();
            JSONObject titles = JsonConfParserUtil.jsonConfParser(confPath);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String,String> titleMap = objectMapper.readValue(JSON.toJSONString(titles),Map.class);


            //若路径不存在，则创建文件夹
            outputFilePath = outputFilePath+File.separator+db+".xls";
            File outputFile = new File(outputFilePath);
            String path = outputFile.getParent();
            if(!(new File(path).exists())){
                new File(path).mkdirs();
            }

            WritableWorkbook wwb = null;
            WritableSheet sheet = null;
            //如果文件不存在，则创建文件并写入相关数据，否则就在原有数据中追加
            if(!outputFile.exists()){
                wwb = Workbook.createWorkbook(outputFile);
                sheet = wwb.createSheet("统计信息", 0);
                Label label = new Label(0,0,"统计信息");
                sheet.addCell(label);
                wwb.write();
                wwb.close();
            }

            Workbook rwb = Workbook.getWorkbook(outputFile);
            File tempfile = new File(path+File.separator+"tempfile.xls");
            wwb = Workbook.createWorkbook(tempfile,rwb);

            //获取当前工作表量，如果该table的数据已经存在，就接着写，如果不存在，就新建一张表存放数据
            int sheetNumber = rwb.getNumberOfSheets();
            if(!map.isEmpty()){
                boolean isSheetExist = false;
                for(String sheetName : rwb.getSheetNames()){
                    if(table.equals(sheetName)){
                        sheet = wwb.getSheet(table);
                        isSheetExist = true;
                        break;
                    }
                }
                if(!isSheetExist){
                    sheet = wwb.createSheet(table,sheetNumber);
                    //写入title
                    for (String key : titleMap.keySet()) {
                        Label label = new Label(Integer.parseInt(titleMap.get(key)),0,key,titleCellFormat);
                        sheet.addCell(label);
                    }
                }

                int rowCount = sheet.getRows();
                for (String key : map.keySet()) {
                    Label label = new Label(Integer.parseInt(titleMap.get(key)),rowCount,map.get(key),textCellFormat);
                    sheet.addCell(label);
                }

                wwb.write();
                wwb.close();
                outputFile.delete();
                tempfile.renameTo(outputFile);
            }



        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }
}
