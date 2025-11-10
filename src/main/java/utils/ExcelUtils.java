package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static Object[][] getSheetData(String filePath, String sheetName) {

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            var sheet = workbook.getSheet(sheetName);
            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows - 1][cols];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {
                var row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
                }
            }
            return data;

        } catch (IOException e) {
            throw new RuntimeException("Excel Read Error → " + e.getMessage());
        }
    }
}
