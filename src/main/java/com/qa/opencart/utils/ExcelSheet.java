package com.qa.opencart.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelSheet {

    public List<Map<String, String>> getExelData(String fileName, String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        switch (extension) {
            case "xlsx", "xls", "csv":
                dataList = getData(fileName, sheetName);
                break;
            default:
                System.out.println("File extension Name is not correct ... " + extension);
        }
        return dataList;
    }


    private String getFilePath(String fileName) {
        if (fileName==null || fileName.isBlank()) {
            throw new NullPointerException("FileName can not be null or empty ..." + fileName);
        }
        return System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\" + fileName;
    }

    private List<Map<String, String>> getData(String fileName, String sheetName) {
        List<Map<String, String>> dataList = new ArrayList<>();
        Map<String, String> rowData = new LinkedHashMap<String, String>();
        FileInputStream fileInputStream = null;
        Workbook workbook = null;
        try {
            fileInputStream = new FileInputStream(getFilePath(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (sheetName==null || sheetName.isBlank()) {
            throw new RuntimeException("Sheet can not found .. " + sheetName);
        }
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);


        DataFormatter dataFormatter = new DataFormatter();

        int rowCount = sheet.getLastRowNum();
        int cellCount = headerRow.getLastCellNum();

        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row == null) {
                continue;
            }

            for (int j = 0; j < cellCount; j++) {
                String key = dataFormatter.formatCellValue(headerRow.getCell(j));
                String value = dataFormatter.formatCellValue(row.getCell(j));
                rowData.put(key, value);
            }

            dataList.add(new LinkedHashMap<>(rowData));
        }


        return dataList;


    }


}
