package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

public class ConsumptionData {
    double waste;

    private static XSSFWorkbook getWorkbookFromExcelFile() throws IOException {
        return new XSSFWorkbook(new FileInputStream("..//data.xlsx")); // For now, hardcode the path
    }


    public double wasteTotal(int month, int year) throws IOException {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(0).getRow(month).getCell(1);
        return cell.getNumericCellValue();
    }
    public double wasteRecycled(int month, int year) throws IOException {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(0).getRow(month).getCell(2);
        return cell.getNumericCellValue();

    }
    public double waterConsumed(int month, int year) throws IOException {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(1).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }
    public double electricityConsumed(int month, int year) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(3).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }
    public double gasConsumed(int month, int year) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(5).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }

    // returns {0 - 11}
    public int getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }
}


