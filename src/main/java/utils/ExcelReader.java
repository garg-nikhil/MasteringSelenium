package utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) throws IOException {
        ExcelReader excelReader = new ExcelReader();
        excelReader.readExcel();
    }
    public void readExcel() throws IOException {
        File file = new File("C:\\Automation\\Projects\\AutomationProject\\src\\test\\resources\\Test Data.xlsx");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook workbook = new HSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("Sheet1");

        for(int i=0; i<=sheet.getLastRowNum();i++){
            for(int j=0; j<sheet.getFirstRowNum();j++){
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
    }

    public void writeExcel(){

    }
}
