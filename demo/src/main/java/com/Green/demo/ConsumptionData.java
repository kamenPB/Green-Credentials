package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

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
        double total = cell.getNumericCellValue();
        return total;
    }
    public double wasteRecycled(int month, int year) throws IOException {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(0).getRow(month).getCell(2);
        double rec = cell.getNumericCellValue();
        return rec;
    }
    public double waterConsumed(int month, int year) {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        return 8273;
    }
    public double electricityConsumed(int month, int year) {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        return 358709;
    }
    public double gasConsumed(int month, int year) {
        // Fake it til you make it, this only works for January 2018
        // Just get the respective month and year from the Java
        return 41888;
    }
}


