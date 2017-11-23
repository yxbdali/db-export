package com.autonavi.test.poi.dbexport.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author xiangbin.yang
 * @since 2017/11/23
 */
public final class FileUtils {
    /**
     *
     * @param dataMapList
     * @param outFile
     * @param sheetName
     * @throws IOException
     */
    public static void createExcelFile(List<Map<String, Object>> dataMapList, String outFile, String sheetName)
        throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet(sheetName);

        // write header
        int row = 0;
        Map<String, Object> map = dataMapList.get(0);
        Row headerRow = sheet.createRow(row++);
        int col = 0;
        List<String> headerList = new ArrayList<>();
        for (String header : map.keySet()) {
            Cell cell = headerRow.createCell(col++);
            cell.setCellValue(header);
        }

        for (Map<String, Object> item : dataMapList) {
            Row dataRow = sheet.createRow(row++);
            col = 0;
            for (Object value : item.values()) {
                Cell cell = dataRow.createCell(col++);
                cell.setCellValue(value == null ? "" : value.toString());
            }
        }

        try (FileOutputStream out = new FileOutputStream(outFile)) {
            wb.write(out);
        }
    }
}
