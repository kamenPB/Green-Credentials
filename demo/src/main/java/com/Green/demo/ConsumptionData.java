package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

public class ConsumptionData {
    private static XSSFWorkbook getWorkbookFromExcelFile() throws IOException {
        return new XSSFWorkbook(new FileInputStream("..//data.xlsx")); // For now, hardcode the filename
    }

    public double wasteTotal(int month, int year) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(0).getRow(month).getCell(1);
        return cell.getNumericCellValue();
    }

    public double wasteRecycled(int month, int year) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(0).getRow(month).getCell(2);
        return cell.getNumericCellValue();

    }

    public double waterConsumed(int month, int year) throws IOException {
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

    // These functions assume the spreadsheet is up-to-date for the dates to match
    // returns {0 - 11}
    public int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1;
    }

    // returns "January", "February", etc.
    public String getCurrentMonthName() {
        return Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
    }

    public String getCurrentYear() {
        return Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
    }

    public String getLastYear() {
        return Integer.toString((Integer.parseInt(getCurrentYear()) - 1));
    }

    public String getTwoYearsAgo() {
        return Integer.toString((Integer.parseInt(getLastYear()) - 1));
    }
}


