package com.uni.life.generator.jpa.utils;//package com.uni.framework.crud.generator.utils;
//
//import com.uni.framework.crud.generator.metadata.EntityInfo;
//import com.uni.framework.crud.generator.metadata.FieldInfo;
//import com.uni.framework.crud.generator.metadata.ModuleInfo;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.util.CellRangeAddress;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.text.ParseException;
//import java.util.*;
//
//
//public class ExcelUtilsBak {
//
//
//    public Map<String, Map<String, List<Object>>> toModuleInfos(InputStream inputStream, String fileName) throws Exception {
//
//        List<ModuleInfo> moduleInfos = new ArrayList<>();
//
//        boolean isE2007 = false;
//        //判断是否是excel2007格式
//        if (fileName.endsWith("xlsx")) {
//            isE2007 = true;
//        }
//
//        int rowIndex = 0;
//        Map<String, Map<String, List<Object>>> mapMap = new HashMap<>();
//        try {
//            InputStream input = inputStream;  //建立输入流
//            Workbook wb;
//            //根据文件格式(2003或者2007)来初始化
//            if (isE2007) {
//                wb = new XSSFWorkbook(input);
//            } else {
//                wb = new HSSFWorkbook(input);
//            }
//
//            Iterator<Sheet> iteratorSheet = wb.sheetIterator();
//
//
//            while (iteratorSheet.hasNext()) {
//                Sheet sheet = iteratorSheet.next();
//
//                ModuleInfo moduleInfo = new ModuleInfo();
//                moduleInfo.setModuleName(sheet.getSheetName());
//
//
//
//                List<EntityInfo> entityInfos = new ArrayList<>();
//                moduleInfo.setEntityInfos(entityInfos);
//
//                moduleInfos.add(moduleInfo);
//
//
//
//                Map<String, List<Object>> mapListMap = new HashMap<>();
//                mapMap.put(sheet.getSheetName(), mapListMap);
//
//                // 获取列数
//                int cellNum = sheet.getRow(1).getPhysicalNumberOfCells();
//                // 获取行数
//                int rowCount = sheet.getLastRowNum() + 1;
//
//                EntityInfo entityInfo = new EntityInfo();
//                List<FieldInfo> fieldInfos = new ArrayList<>();
//                entityInfo.setFields(fieldInfos);
//
//
//                List<Object> listObj = new ArrayList<>();
//                for (int i = 1; i < rowCount; i++) {
//                    rowIndex = i;
//                    Row row;
//
//                    StringBuilder stringBuilder = new StringBuilder();
//                    FieldInfo fieldInfo = new FieldInfo();
//                    for (int j = 0; j < cellNum; j++) {
//
//                        if (isMergedRegion(sheet, i, j)) {
//                            //int value = entityInfo.getFields().size();
//
//                            if (entityInfo.getClassName() == null) {
//
//                                fieldInfos = new ArrayList<>();
//                                String val[] = getMergedRegionValue(sheet, i, j).split("/");
//                                entityInfo.setClassName(val[0]);
//                                entityInfo.setComment(val[1]);
//                            }
//
//                            Object value = mapListMap.get(getMergedRegionValue(sheet, i, j));
//                            if (value == null) {
//                                listObj = new ArrayList<>();
//                                mapListMap.put(getMergedRegionValue(sheet, i, j), listObj);
//                            }
//
//                            System.out.print(getMergedRegionValue(sheet, i, j) + "\t");
//                        } else {
//                            row = sheet.getRow(i);
//
//                            switch (j) {
//                                case 1:
//                                    break;
//                                case 2:
//
//                                    break;
//                                case 3:
//                                    fieldInfo.setName(getCellValue(row.getCell(j)));
//                                    break;
//                                case 4:
//
//                                    break;
//                                case 5:
//                                    break;
//                                case 6:
//                                    break;
//                                case 7:
//                                    break;
//                                case 8:
//                                    break;
//                                case 9:
//                                    break;
//                            }
//                            stringBuilder.append(row.getCell(j));
//                            System.out.print(row.getCell(j) + "\t");
//                        }
//                    }
//
//                    fieldInfos.add(fieldInfo);
//
//                    listObj.add(stringBuilder.toString());
//                    System.out.print("\n");
//                }
//            }
//
//            int msize = moduleInfos.size();
//            int size = mapMap.size();
//            System.out.println(size);
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return mapMap;
//    }
//
//
//    /**
//     * 获取单元格的值
//     *
//     * @param cell
//     * @return
//     */
////    public String getCellValue(Cell cell) {
////        if (cell == null) return "";
////        return cell.getStringCellValue();
////    }
//    public String getCellValue(Cell cell) {
//        if (cell != null) {
//            switch (cell.getCellType()) {
//                case BLANK:
//                    return "";
//                case NUMERIC:
//                    String strValue = String.valueOf(cell.getNumericCellValue());
//                    if (strValue != null && strValue.indexOf(".") != -1
//                            && strValue.indexOf("E") != -1) {
//                        try {
//                            return new DecimalFormat().parse(strValue).toString();
//                        } catch (ParseException e) {
//                            e.printStackTrace();
//                        }
//                    } else {
//                        if (strValue.endsWith(".0")) {
//                            return strValue.substring(0, strValue.indexOf(".0"));
//                        } else {
//                            return strValue;
//                        }
//                    }
//                case STRING:
//                    return (cell.getStringCellValue() + "").trim();
//                case FORMULA:
//                    return (cell.getCellFormula() + "").trim();
//                case BOOLEAN:
//                    return cell.getBooleanCellValue() + "";
//                case ERROR:
//                    return cell.getErrorCellValue() + "";
//            }
//        }
//        return "";
//    }
//
//
//    /**
//     * 合并单元格处理,获取合并行
//     *
//     * @param sheet
//     * @return List<CellRangeAddress>
//     */
//    public List<CellRangeAddress> getCombineCell(Sheet sheet) {
//        List<CellRangeAddress> list = new ArrayList<>();
//        //获得一个 sheet 中合并单元格的数量
//        int sheetmergerCount = sheet.getNumMergedRegions();
//        //遍历所有的合并单元格
//        for (int i = 0; i < sheetmergerCount; i++) {
//            //获得合并单元格保存进list中
//            CellRangeAddress ca = sheet.getMergedRegion(i);
//            list.add(ca);
//        }
//        return list;
//    }
//
//    private int getRowNum(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet) {
//        int xr = 0;
//        int firstC = 0;
//        int lastC = 0;
//        int firstR = 0;
//        int lastR = 0;
//        for (CellRangeAddress ca : listCombineCell) {
//            //获得合并单元格的起始行, 结束行, 起始列, 结束列
//            firstC = ca.getFirstColumn();
//            lastC = ca.getLastColumn();
//            firstR = ca.getFirstRow();
//            lastR = ca.getLastRow();
//            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
//                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
//                    xr = lastR;
//                }
//            }
//
//        }
//        return xr;
//
//    }
//
//    /**
//     * 判断单元格是否为合并单元格，是的话则将单元格的值返回
//     *
//     * @param listCombineCell 存放合并单元格的list
//     * @param cell            需要判断的单元格
//     * @param sheet           sheet
//     * @return
//     */
//    public String isCombineCell(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet)
//            throws Exception {
//        int firstC = 0;
//        int lastC = 0;
//        int firstR = 0;
//        int lastR = 0;
//        String cellValue = null;
//        for (CellRangeAddress ca : listCombineCell) {
//            //获得合并单元格的起始行, 结束行, 起始列, 结束列
//            firstC = ca.getFirstColumn();
//            lastC = ca.getLastColumn();
//            firstR = ca.getFirstRow();
//            lastR = ca.getLastRow();
//            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
//                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
//                    Row fRow = sheet.getRow(firstR);
//                    Cell fCell = fRow.getCell(firstC);
//                    cellValue = getCellValue(fCell);
//                    break;
//                }
//            } else {
//                cellValue = "";
//            }
//        }
//        return cellValue;
//    }
//
//    /**
//     * 获取合并单元格的值
//     *
//     * @param sheet
//     * @param row
//     * @param column
//     * @return
//     */
//    public String getMergedRegionValue(Sheet sheet, int row, int column) {
//        int sheetMergeCount = sheet.getNumMergedRegions();
//
//        for (int i = 0; i < sheetMergeCount; i++) {
//            CellRangeAddress ca = sheet.getMergedRegion(i);
//            int firstColumn = ca.getFirstColumn();
//            int lastColumn = ca.getLastColumn();
//            int firstRow = ca.getFirstRow();
//            int lastRow = ca.getLastRow();
//
//            if (row >= firstRow && row <= lastRow) {
//                if (column >= firstColumn && column <= lastColumn) {
//                    Row fRow = sheet.getRow(firstRow);
//                    Cell fCell = fRow.getCell(firstColumn);
//                    return getCellValue(fCell);
//                }
//            }
//        }
//
//        return null;
//    }
//
//
//    /**
//     * 判断指定的单元格是否是合并单元格
//     *
//     * @param sheet
//     * @param row    行下标
//     * @param column 列下标
//     * @return
//     */
//    private boolean isMergedRegion(Sheet sheet, int row, int column) {
//        int sheetMergeCount = sheet.getNumMergedRegions();
//        for (int i = 0; i < sheetMergeCount; i++) {
//            CellRangeAddress range = sheet.getMergedRegion(i);
//            int firstColumn = range.getFirstColumn();
//            int lastColumn = range.getLastColumn();
//            int firstRow = range.getFirstRow();
//            int lastRow = range.getLastRow();
//            if (row >= firstRow && row <= lastRow) {
//                if (column >= firstColumn && column <= lastColumn) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//}
