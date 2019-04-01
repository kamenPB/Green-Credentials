package com.Green.demo;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.html.HTML;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class ConsumptionData {

    final int WASTE = 0;
    final int WATER = 1;
    final int ELECTRICITY = 3;
    final int GAS = 5;


    private static XSSFWorkbook getWorkbookFromExcelFile() {
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream("..//data.xlsx")); // For now, hardcode the filename
        } catch(Exception e) {
            System.out.println("File not found");
        }
        return wb;
    }

    double wasteTotal(int month) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(WASTE).getRow(month).getCell(1);
        return cell.getNumericCellValue();
    }

    double wasteRecycled(int month) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(WASTE).getRow(month).getCell(2);
        return cell.getNumericCellValue();

    }

    double waterConsumed(int month, int year) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(WATER).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }

    double electricityConsumed(int month, int year) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(ELECTRICITY).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }

    double gasConsumed(int month, int year) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        XSSFCell cell = wb.getSheetAt(GAS).getRow(month).getCell(year);
        return cell.getNumericCellValue();
    }

    private int getSheetFromCategory(int category) {
        int sheet;
        switch (category) {
            case WASTE:
            default:
                sheet = WASTE;
                break;
            case WATER:
                sheet = WATER;
                break;
            case ELECTRICITY:
                sheet = ELECTRICITY;
                break;
            case GAS:
                sheet = GAS;
                break;
        }
        return sheet;
    }

    String commentHeader(int category) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int sheet = getSheetFromCategory(category);
        XSSFCell cell = wb.getSheetAt(sheet).getRow(0).getCell(13);
        return cell.getStringCellValue();
    }

    String comment(int category) {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int sheet = getSheetFromCategory(category);
        XSSFCell cell = wb.getSheetAt(sheet).getRow(1).getCell(13);
        return cell.getStringCellValue();
    }

    private Boolean isEmptyCell(XSSFCell c) {
        return c == null || c.getCellType() == XSSFCell.CELL_TYPE_BLANK;
    }

    int getLastMonth() {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int mostRecentMonth = 0;
        for (int sheet = 0; sheet < 6; sheet++) {
            for (int month = 0; month < 12; month++) {
                // Hard-code the column with the latest year's data in each sheet
                int column;
                switch (sheet) {
                    case 1: // water D
                    case 3: // electricity D
                    case 4: // carpark electricity D
                    case 5: // gas D
                    default:
                        column = 3;
                        break;
                    case 0: // waste C
                        column = 2;
                        break;
                    case 2: // landlord water E
                        column = 4;
                        break;
                }

                XSSFCell cell = wb.getSheetAt(sheet).getRow(month).getCell(column);
                if (isEmptyCell(cell)) {
                    break;
                } else {
                    mostRecentMonth = month;
                }
            }
        }
        return mostRecentMonth;
    }

    private String[] monthNames = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    String getLastMonthName() { return monthNames[getLastMonth() - 1];}

    String getCurrentYear() {
        return Integer.toString(LocalDate.now().getYear());
    }

    String getLastYear() {
        return Integer.toString(LocalDate.now().minusYears(1).getYear());
    }

    String getTwoYearsAgo() {
        return Integer.toString(LocalDate.now().minusYears(2).getYear());
    }
}


