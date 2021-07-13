package com.audit.demo.app;


import com.audit.demo.app.dao.excel.BodyData;
import com.audit.demo.app.dao.excel.TopData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenerateExcelFile {

    private static final short greyBackground =  IndexedColors.GREY_25_PERCENT.index;
    private static final short blueBackground =  IndexedColors.BLUE.index;
    private static final FillPatternType solidBackgroundPattern = FillPatternType.SOLID_FOREGROUND;
    private static final BorderStyle thinBorder = BorderStyle.THIN;
    private static final HorizontalAlignment leftHorizontal = HorizontalAlignment.LEFT;
    private static final HorizontalAlignment centerHorizontal = HorizontalAlignment.CENTER;
    private static final short fontSize10 = 10;
    private static final String fontNameArial = "Arial";

    public void fillCell(Object obj, Cell cell) {
        if (obj instanceof Integer) {
            cell.setCellValue((Integer) obj);
        } else if (obj instanceof Double) {
            cell.setCellValue((Double) obj);
        } else if (obj instanceof Long) {
            cell.setCellValue((Long) obj);
        } else if (obj instanceof Boolean) {
            cell.setCellValue((Boolean) obj);
        } else if (obj instanceof String) {
            cell.setCellValue(obj.toString());
        } else  {
            cell.setCellValue("");
        }
    }
    public void setBorder(BorderStyle borderStyle, XSSFCellStyle cellStyle) {
        cellStyle.setBorderBottom(borderStyle);
        cellStyle.setBorderTop(borderStyle);
        cellStyle.setBorderLeft(borderStyle);
        cellStyle.setBorderRight(borderStyle);
    }
    public void mergeCell(List<CellRangeAddress> cellRangeAddresses, XSSFSheet spreadsheet) {
        for(CellRangeAddress cellAddresses: cellRangeAddresses) {
            spreadsheet.addMergedRegion(cellAddresses);
        }
    }
    public void mergeCellBorder(BorderStyle borderStyle,List<CellRangeAddress> cellRangeAddresses, XSSFSheet spreadsheet) {
        for(CellRangeAddress cellAddresses: cellRangeAddresses) {
            RegionUtil.setBorderBottom(borderStyle, cellAddresses, spreadsheet);
            RegionUtil.setBorderRight(borderStyle, cellAddresses, spreadsheet);
        }
    }
    public void setBackGround(short backgroundColor, FillPatternType backgroundType, XSSFCellStyle cellStyle) {
        cellStyle.setFillForegroundColor(backgroundColor);
        cellStyle.setFillPattern(backgroundType);
    }
    public void setFont(String fontName, short fontSize, Font font, XSSFCellStyle cellStyle) {
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontSize);
        cellStyle.setFont(font);
    }
    public void setFont(String fontName, short fontSize, short fontColor,boolean isBold, Font font,XSSFCellStyle cellStyle) {
        font.setFontName(fontName);
        font.setFontHeightInPoints(fontSize);
        font.setColor(fontColor);
        font.setBold(isBold);
        cellStyle.setFont(font);
    }

    public void generateTopPart(XSSFSheet spreadsheet, TopData topData, XSSFCellStyle topCellStyle, XSSFCellStyle titleCellStyle) {
        // Render the top part
        Set<String> topKeySet = topData.getData().keySet();
        int topRowNumber = 0;
        for(String key: topKeySet) {
            int topCellNumber = 0;
            XSSFRow topTopRow = spreadsheet.createRow(topRowNumber);
            topRowNumber++;
            Object[] topArrayObject = topData.getData().get(key);
            for(Object obj: topArrayObject) {
                XSSFCell cell;

                //  because merge cell
                if(topCellNumber == 2) cell = topTopRow.createCell(6);
                else if(topCellNumber == 3) cell = topTopRow.createCell(8);
                else cell = topTopRow.createCell(topCellNumber);
                fillCell(obj, cell);
                if(topCellNumber % 2 == 0) {
                    cell.setCellStyle(titleCellStyle);
                }
                if(topCellNumber % 2 != 0) {
                    cell.setCellStyle(topCellStyle);
                }
                topCellNumber++;
            }
        }
    }
    public void generateBodyPart(XSSFSheet spreadsheet, BodyData bodyData, XSSFCellStyle headerCellStyle, XSSFCellStyle dataCellStyle) {
        Set<String> keySetDataBody = bodyData.getDataBody().keySet();
        List<String> keySetDataHeader = bodyData.getHeaderBody();

        // render header of body
        int rowHeader = 5;
        int cellHeaderNumber = 0;
        XSSFRow row = spreadsheet.createRow(rowHeader);
        for(String headerData: keySetDataHeader) {
            XSSFCell cell = row.createCell(cellHeaderNumber);
            fillCell(headerData, cell);
            cell.setCellStyle(headerCellStyle);
            cellHeaderNumber += 1;
        }

        // render body data
        int rowStart = 6;
        for(String key: keySetDataBody) {
            int cellDataBodyNumber = 0;
            XSSFRow rowBody = spreadsheet.createRow(rowStart++);
            Object[] objectArray = bodyData.getDataBody().get(key);
            for(Object obj: objectArray) {
                XSSFCell cell = rowBody.createCell(cellDataBodyNumber);
                fillCell(obj, cell);
                cell.setCellStyle(dataCellStyle);
                cellDataBodyNumber += 1;
            }
        }
    }
    public void generate() throws IOException {
        BodyData bodyData = new BodyData();
        TopData topData = new TopData();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Sheet1");

        // Create header CellStyle
        Font headerFont = workbook.createFont();
        XSSFCellStyle headerCellStyle = spreadsheet.getWorkbook().createCellStyle();
        setFont(fontNameArial, fontSize10, headerFont, headerCellStyle);
        setBackGround(greyBackground, solidBackgroundPattern, headerCellStyle);
        headerCellStyle.setAlignment(centerHorizontal);
        setBorder(thinBorder, headerCellStyle);

        // data type style
        Font dataFont = workbook.createFont();
        XSSFCellStyle dataCellStyle = spreadsheet.getWorkbook().createCellStyle();
        setFont(fontNameArial, fontSize10, dataFont, dataCellStyle);
        dataCellStyle.setAlignment(leftHorizontal);
        dataCellStyle.setWrapText(true);

        // Top style
        Font topFont = workbook.createFont();
        XSSFCellStyle topCellStyle = spreadsheet.getWorkbook().createCellStyle();
        setBorder(thinBorder, topCellStyle);
        setFont(fontNameArial, fontSize10, topFont,topCellStyle);
        topCellStyle.setAlignment(leftHorizontal);

        // TitleFont
        Font titleFont = workbook.createFont();
        XSSFCellStyle titleCellStyle = spreadsheet.getWorkbook().createCellStyle();
        setFont(fontNameArial, fontSize10, blueBackground, true, titleFont, titleCellStyle);
        setBorder(thinBorder, titleCellStyle);
        setBackGround(greyBackground, solidBackgroundPattern, titleCellStyle);
        titleCellStyle.setAlignment(leftHorizontal);

        // Render the top part
        generateTopPart(spreadsheet, topData, topCellStyle, titleCellStyle);
        // Render the body part
        generateBodyPart(spreadsheet,bodyData, headerCellStyle, dataCellStyle);

        for(int column = 0; column < 10; column++) {
            spreadsheet.autoSizeColumn(column);
        }


        // merge the cell on top and make border for it
        for(int row = 0; row <= 4; row++) {
            List<CellRangeAddress> cellRangeAddresses = new ArrayList<>();
            cellRangeAddresses.add( new CellRangeAddress(row, row, 1, 5));
            cellRangeAddresses.add( new CellRangeAddress(row, row, 6, 7));
            cellRangeAddresses.add( new CellRangeAddress(row, row, 8, 11));
            mergeCell(cellRangeAddresses, spreadsheet);
            mergeCellBorder(thinBorder, cellRangeAddresses, spreadsheet);
        }

        FileOutputStream out = new FileOutputStream(new File("export.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("export.xlsx written successfully");
    }
}
