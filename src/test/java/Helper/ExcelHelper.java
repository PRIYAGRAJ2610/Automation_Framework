package Helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelHelper {
    public static List<Map<String, String>> getData(String filePath, String sheetName) throws IOException {
        List<Map<String, String>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);
        int numCols = headerRow.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;
            Map<String, String> rowData = new HashMap<>();
            for (int j = 0; j < numCols; j++) {
                Cell headerCell = headerRow.getCell(j);
                Cell valueCell = row.getCell(j);
                String key = headerCell != null ? headerCell.getStringCellValue() : "";
                String value = valueCell != null ? valueCell.toString() : "";
                rowData.put(key, value);
            }
            data.add(rowData);
        }
        workbook.close();
        fis.close();
        return data;
    }
} 