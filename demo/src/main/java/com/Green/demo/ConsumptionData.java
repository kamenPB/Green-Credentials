package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.html.HTML;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

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

    private int getSheetFromCategory(String category) {
        int sheet;
        switch (category) {
            case "waste":
            default:
                sheet = 0;
                break;
            case "water":
                sheet = 1;
                break;
            case "electricity":
                sheet = 3;
                break;
            case "gas":
                sheet = 5;
                break;
        }
        return sheet;
    }

    public String commentHeader(String category) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int sheet = getSheetFromCategory(category);
        XSSFCell cell = wb.getSheetAt(sheet).getRow(0).getCell(13);
        return cell.getStringCellValue();
    }

    public String comment(String category) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int sheet = getSheetFromCategory(category);
        XSSFCell cell = wb.getSheetAt(sheet).getRow(1).getCell(13);
        return cell.getStringCellValue();
    }

//    public static String toDisplayCase(String s) {
//
//        final String ACTIONABLE_DELIMITERS = " '-/"; // these cause the character following
//        // to be capitalized
//
//        StringBuilder sb = new StringBuilder();
//        boolean capNext = true;
//
//        for (char c : s.toCharArray()) {
//            c = (capNext)
//                    ? Character.toUpperCase(c)
//                    : Character.toLowerCase(c);
//            sb.append(c);
//            capNext = (ACTIONABLE_DELIMITERS.indexOf((int) c) >= 0); // explicit cast not needed
//        }
//        return sb.toString();
//    }

    // These functions assume the spreadsheet is up-to-date for the dates to match
    // returns {1 - 12}

    //public int getLastMonth() {
    //    return LocalDate.now().minusMonths(1).getMonthValue();
    //}

    public int getLastMonth() throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(3).getRow(0).getCell(12); // cell M
        //casting from double
        return (int) cell.getNumericCellValue() - 1;
    }

    private String[] monthNames = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    // returns "January", "February", etc.
    public String getLastMonthName() throws IOException { return monthNames[getLastMonth()];}

    public String getCurrentYear() {
        return Integer.toString(LocalDate.now().getYear());
    }

    public String getLastYear() {
        return Integer.toString(LocalDate.now().minusYears(1).getYear());
    }

    public String getTwoYearsAgo() {
        return Integer.toString(LocalDate.now().minusYears(2).getYear());
    }
}


