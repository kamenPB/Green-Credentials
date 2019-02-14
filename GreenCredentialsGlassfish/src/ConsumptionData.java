import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ConsumptionData {
    // N.B. The Excel workbook's sheets MUST be in this order!
    public static final int DATA_WASTE = 0;
    public static final int DATA_WATER = 1;
    public static final int DATA_WATER_LL = 2; // Landlord-only water usage
    public static final int DATA_ELEC = 3;
    public static final int DATA_ELEC_CP = 4; // Car park electricity
    public static final int DATA_GAS = 5;

    // DEBUG METHOD: Print the contents of a cell to the console
    private static void printCellToConsole(XSSFCell cell) {
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                // TODO: Implement evaluation of formula cells
                System.out.print("[FRMLA]");
                break;
            case XSSFCell.CELL_TYPE_BLANK:
                System.out.print("[BLANK]");
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
                System.out.print(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_ERROR:
            default:
                System.out.print("[ERROR]");
                break;
        }
    }

    // DEBUG METHOD: Print the current data category to console
    private static void printDataCategoryToConsole(XSSFWorkbook wb, int dataCategory) {
        switch (dataCategory) {
            case DATA_WASTE:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 4; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        // Padding
                        if (row > 0) System.out.print("    ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            case ConsumptionData.DATA_WATER:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 6; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        if (row > 0) System.out.print("         ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            case ConsumptionData.DATA_WATER_LL:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 7; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        if (row > 0) System.out.print("         ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            case ConsumptionData.DATA_ELEC:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 6; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        if (row > 0) System.out.print("         ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            case ConsumptionData.DATA_ELEC_CP:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 6; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        if (row > 0) System.out.print("         ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            case ConsumptionData.DATA_GAS:
                for (int row = 0; row < 13; row++) {
                    for (int column = 0; column < 6; column++) {
                        XSSFCell cell = wb.getSheetAt(dataCategory).getRow(row).getCell(column);
                        printCellToConsole(cell);

                        if (row > 0) System.out.print("         ");
                        System.out.print("     ");
                    }
                    System.out.print("\n");
                }
                break;
            default:
                System.out.print("Unexpected data category.");
        }
    }

    // Return the current month for which data is currently being displayed
    public static int getCurrentMonth() {
        // TODO: Implement
        return 0; // 0 = January, 1 = February, etc.
    }



    // Return the data category currently being displayed
    public static int getCurrentDataCategory() {
        // TODO: Implement
        return DATA_WASTE;
    }

    // Initialize and display the GUI
    private static void display() {
        // TODO: Interface with frontend here
    }

    private static double[] percentageWasteRecycledCY = new double[12];
    public static double getPercentageWasteRecycledCY(int month) {
        return percentageWasteRecycledCY[month];
    }

    private static double[] waterUsagePY = new double[12];
    public static double getWaterUsagePY(int month) { return waterUsagePY[month];}
    private static double[] waterUsageCY = new double[12];
    public static double getWaterUsageCY(int month) { return waterUsageCY[month];}

    private static double[] landlordWaterPY = new double[12];
    public static double getLandlordWaterPY(int month) { return landlordWaterPY[month];}
    private static double[] landlordWaterCY = new double[12];
    public static double getLandlordWaterCY(int month) { return landlordWaterCY[month];}

    private static double[] elecUsagePY = new double[12];
    public static double getElectricityUsagePY(int month) { return elecUsagePY[month];}
    private static double[] elecUsageCY = new double[12];
    public static double getElectricityUsageCY(int month) { return elecUsageCY[month];}

    private static double[] carparkElecUsagePY = new double[12];
    public static double getCarparkElecUsagePY(int month) {return carparkElecUsagePY[month];}
    private static double[] carparkElecUsageCY = new double[12];
    public static double getCarparkElecUsageCY(int month) {return carparkElecUsageCY[month];}

    private static double[] gasUsagePY = new double[12];
    public static double getGasUsagePY(int month) {return gasUsagePY[month];}
    private static double[] gasUsageCY = new double[12];
    public static double getGasUsageCY(int month) {return gasUsageCY[month];}


    // Collate the data for a given data category into its respective memory space
    private static void collateData(XSSFWorkbook wb, int dataCategory) {
        switch (dataCategory) {
            case DATA_WASTE:
                for (int month = 0; month < 12; month++) {
                    percentageWasteRecycledCY[month] = wb.getSheetAt(DATA_WASTE)
                            .getRow(month + 1)
                            .getCell(3) // Percentage Recycled column is 3
                            .getNumericCellValue();
                }
                break;

            case DATA_WATER:
                for (int month = 0; month < 12; month++){
                    waterUsagePY[month] = wb.getSheetAt(DATA_WATER)
                            .getRow(month + 1)
                            .getCell(2)
                            .getNumericCellValue();
                }

                for (int month = 0; month < 12; month++) {
                    waterUsageCY[month] = wb.getSheetAt(DATA_WATER)
                            .getRow(month + 1)
                            .getCell(4)
                            .getNumericCellValue();
                }
                break;

            case DATA_WATER_LL:
                for (int month = 0; month < 12; month++){
                    landlordWaterPY[month] = wb.getSheetAt(DATA_WATER_LL)
                            .getRow(month + 1)
                            .getCell(2)
                            .getNumericCellValue();
                }

                for (int month = 0; month < 12; month++){
                    landlordWaterCY[month] = wb.getSheetAt(DATA_WATER_LL)
                            .getRow(month + 1)
                            .getCell(4)
                            .getNumericCellValue();
                }
                break;

            case DATA_ELEC:
                for (int month = 0; month < 12; month++){
                    elecUsagePY[month] = wb.getSheetAt(DATA_ELEC)
                            .getRow(month + 1)
                            .getCell(2)
                            .getNumericCellValue();
                }

                for (int month = 0; month < 12; month++){
                    elecUsageCY[month] = wb.getSheetAt(DATA_ELEC)
                            .getRow(month + 1)
                            .getCell(4)
                            .getNumericCellValue();
                }
                break;

            case DATA_ELEC_CP:
                for (int month = 0; month < 12; month++){
                    carparkElecUsagePY[month] = wb.getSheetAt(DATA_ELEC_CP)
                            .getRow(month + 1)
                            .getCell(2)
                            .getNumericCellValue();
                }

                for (int month = 0; month < 12; month++){
                    carparkElecUsageCY[month] = wb.getSheetAt(DATA_ELEC_CP)
                            .getRow(month + 1)
                            .getCell(4)
                            .getNumericCellValue();
                }
                break;

            case DATA_GAS:
                for (int month = 0; month < 12; month++){
                    gasUsagePY[month] = wb.getSheetAt(DATA_GAS)
                            .getRow(month + 1)
                            .getCell(2)
                            .getNumericCellValue();
                }

                for (int month = 0; month < 12; month++){
                    gasUsageCY[month] = wb.getSheetAt(DATA_GAS)
                            .getRow(month + 1)
                            .getCell(4)
                            .getNumericCellValue();
                }
                break;

            default:
                System.out.print("Unexpected data category.");
                break;
        }
    }

    // Take in the Excel file and create a workbook to read from
    // TODO: Let the user specify Excel file path at run-time
    private static XSSFWorkbook getWorkbookFromExcelFile() throws IOException {
        return new XSSFWorkbook(new FileInputStream("..//data.xlsx")); // For now, hardcode the path
    }

    // Main
    public static void main(String [] args) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();
        int eighty = 80;
        printDataCategoryToConsole(wb, DATA_GAS);
        collateData(wb, DATA_WASTE); // TODO: Implement for other data categories

        display();
    }
}