package com.uni.life.generator.jpa.utils;

import com.google.common.base.CaseFormat;
import com.uni.life.generator.jpa.metadata.ModuleInfo;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DdlUtils {


    public Map<String, Map<String, List<Object>>> toModuleInfos(InputStream inputStream, String fileName,String outPut) throws Exception {

        List<ModuleInfo> moduleInfos = new ArrayList<>();

        boolean isE2007 = false;
        //判断是否是excel2007格式
        if (fileName.endsWith("xlsx")) {
            isE2007 = true;
        }

        try {
            InputStream input = inputStream;  //建立输入流
            Workbook wb;
            //根据文件格式(2003或者2007)来初始化
            if (isE2007) {
                wb = new XSSFWorkbook(input);
            } else {
                wb = new HSSFWorkbook(input);
            }

            Iterator<Sheet> iteratorSheet = wb.sheetIterator();

            Map<String, StringBuilder> map = new HashMap<>();
            while (iteratorSheet.hasNext()) {
                Sheet sheet = iteratorSheet.next();
                // 获取列数
                int cellNum = sheet.getRow(1).getPhysicalNumberOfCells();
                // 获取行数
                int rowCount = sheet.getLastRowNum() + 1;

                String table = null;
                for (int i = 1; i < rowCount; i++) {
                    //Row row;
                    Row headrow = sheet.getRow(0);


                    for (int j = 0; j < cellNum; j++) {


                        if (isMergedRegion(sheet, i, j)) {
                            table = getMergedRegionValue(sheet, i, j);

                            String table1 = table.substring(table.lastIndexOf("/") + 1);
                            table1 = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, table1);
                            if(!map.keySet().contains(table)){
                                StringBuilder stringBuilder = new StringBuilder();

                                stringBuilder.append("create table ").append("`").append(table1).append("`").append("(").append("\n");
                                stringBuilder.append("\t`id`\tbigint(12)\tNOT NULL\tAUTO_INCREMENT\tcomment\t'ID',\n");
                                map.put(table, stringBuilder);
                            }




                            //System.out.print(getMergedRegionValue(sheet, i, j) + "\t");
                        } else {

                            Row row = sheet.getRow(i);
                            System.out.println("===========" + row.getPhysicalNumberOfCells());
                            StringBuilder stringBuilder = map.get(table);

                            String headName = getCellValue(headrow.getCell(j));

                            String cv = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, getCellValue(row.getCell(j)));

                            //String cv = toLine(getCellValue(row.getCell(j)));
                            switch (headName.substring(headName.lastIndexOf("/") + 1)) {
                                case "Column":
                                    stringBuilder.append("\t").append("`").append(cv).append("`").append("\t");
                                    break;
                                case "Type":
                                    stringBuilder.append(cv);
                                    break;
                                case "Length":
                                    stringBuilder.append("(").append(cv).append(")").append("\t");
                                    break;
                                case "Null":
                                    if (cv.equalsIgnoreCase("y")) {
                                        stringBuilder.append("DEFAULT ").append("\t");
                                    } else {
                                        stringBuilder.append("NOT NULL").append("\t");
                                    }

                                    break;
                                case "Default":
                                    if(!cv.equals("")){
                                        stringBuilder.append("'").append(cv).append("'").append("\t");
                                    }
                                    if(cv.equalsIgnoreCase("null")){
                                        stringBuilder.append("NULL").append("\t");
                                    }
                                    break;
                                case "Comment":
                                    stringBuilder.append("comment").append("\t").append("'").append(cv).append("'").append(",\n");
                                    break;
                                /*case "Primary":
                                    stringBuilder.append("primary key (").append(cv).append(")").append("\n");
                                    break;*/

                            }
                            //System.out.print(row.getCell(j) + "\t");
                        }
                    }

                    //StringBuilder sb = map.get(table).append(")").append("engine=innodb auto_increment=0 comment = '';").append("\n");
                    //FileUtils.write(new File("ddl.sql"),sb.toString(), Charset.forName("UTF-8"),true);
//                    System.out.println(stringBuilder.toString());

                }
                map.forEach((k,v)->{
                    v.append(
                            "\t`app_id`\tvarchar(50)\tDEFAULT NULL \tcomment\t'应用ID',\n" +
                            "\t`tenant_id`\tvarchar(14)\tDEFAULT NULL\tcomment\t'租户ID',\n" +
                            "\t`is_active`\tint(1)\tNOT NULL\tcomment\t'',\n" +
                            "\t`created_by`\tvarchar(30)\tNOT NULL\tcomment\t'',\n" +
                            "\t`created_date`\tdatetime\tNOT NULL\tcomment\t'',\n");

                    v.append("\t").append("PRIMARY KEY (`id`)").append("\n");
                    int i = k.lastIndexOf("/");
                    String c = k.substring(0,i);
                    v.append(")").append("ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT = ").append("'").append(c).append("'").append(";\n\n");
                    try {
                        FileUtils.write(new File(outPut),v.toString(), Charset.forName("UTF-8"),true);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                //StringBuilder sb = map.get(table).append(")").append("engine=innodb auto_increment=0 comment = '';").append("\n");

                //System.out.println(map.get(table).toString());
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /**
     * 获取单元格的值
     *
     * @param cell
     * @return
     */
//    public String getCellValue(Cell cell) {
//        if (cell == null) return "";
//        return cell.getStringCellValue();
//    }
    public String getCellValue(Cell cell) {
        if (cell != null) {
            switch (cell.getCellType()) {
                case BLANK:
                    return "";
                case NUMERIC:
                    String strValue = String.valueOf(cell.getNumericCellValue());
                    if (strValue != null && strValue.indexOf(".") != -1
                            && strValue.indexOf("E") != -1) {
                        try {
                            return new DecimalFormat().parse(strValue).toString();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        if (strValue.endsWith(".0")) {
                            return strValue.substring(0, strValue.indexOf(".0"));
                        } else {
                            return strValue;
                        }
                    }
                case STRING:
                    return (cell.getStringCellValue() + "").trim();
                case FORMULA:
                    return (cell.getCellFormula() + "").trim();
                case BOOLEAN:
                    return cell.getBooleanCellValue() + "";
                case ERROR:
                    return cell.getErrorCellValue() + "";
            }
        }
        return "";
    }


    /**
     * 合并单元格处理,获取合并行
     *
     * @param sheet
     * @return List<CellRangeAddress>
     */
    public List<CellRangeAddress> getCombineCell(Sheet sheet) {
        List<CellRangeAddress> list = new ArrayList<>();
        //获得一个 sheet 中合并单元格的数量
        int sheetmergerCount = sheet.getNumMergedRegions();
        //遍历所有的合并单元格
        for (int i = 0; i < sheetmergerCount; i++) {
            //获得合并单元格保存进list中
            CellRangeAddress ca = sheet.getMergedRegion(i);
            list.add(ca);
        }
        return list;
    }

    private int getRowNum(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet) {
        int xr = 0;
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        for (CellRangeAddress ca : listCombineCell) {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
                    xr = lastR;
                }
            }

        }
        return xr;

    }

    /**
     * 判断单元格是否为合并单元格，是的话则将单元格的值返回
     *
     * @param listCombineCell 存放合并单元格的list
     * @param cell            需要判断的单元格
     * @param sheet           sheet
     * @return
     */
    public String isCombineCell(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet)
            throws Exception {
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        String cellValue = null;
        for (CellRangeAddress ca : listCombineCell) {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
                    Row fRow = sheet.getRow(firstR);
                    Cell fCell = fRow.getCell(firstC);
                    cellValue = getCellValue(fCell);
                    break;
                }
            } else {
                cellValue = "";
            }
        }
        return cellValue;
    }

    /**
     * 获取合并单元格的值
     *
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }

        return null;
    }


    /**
     * 判断指定的单元格是否是合并单元格
     *
     * @param sheet
     * @param row    行下标
     * @param column 列下标
     * @return
     */
    private boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String underscoreToCamelCase(String underscore){
        String[] ss = underscore.split("_");
        if(ss.length ==1){
            return underscore;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(ss[0]);
        for (int i = 1; i < ss.length; i++) {
            sb.append(upperFirstCase(ss[i]));
        }
        return sb.toString();
    }
    private static String upperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }

/**
        * 驼峰 转下划线
     * @param camelCase
     * @return
             */
    public static String toLine(String camelCase){
        Pattern humpPattern = Pattern.compile("[A-Z]");
        Matcher matcher = humpPattern.matcher(camelCase);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}
