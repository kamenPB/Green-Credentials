import java.io.*;

import org.apache.poi.xssf.usermodel.*;

public class main {
    // Hardcoded path for the Excel file to read from
    private static final String EXCEL_FILE = "..\\data.xlsx";

    // Aliases for the different data categories
    // The Excel workbook must order the sheets in this order
    private static final int DATA_WASTE = 0;
    private static final int DATA_WATER = 1;
    private static final int DATA_WATER_LL = 2;
    private static final int DATA_ELEC = 3;
    private static final int DATA_ELEC_CP = 4;
    private static final int DATA_GAS = 5;

    // A method which prints the contents of a String or Numeric cell to the console
    // Other cell types are not supported
    private static void printCellToConsole(XSSFCell cell) {
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
            case XSSFCell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case XSSFCell.CELL_TYPE_FORMULA:
                // TODO: Write evaluator so formula cells are displayed properly
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
    // Print the current data category to console
    // This will help us verify the data is being read from the Excel file properly
    private static void printDataCategoryToConsole(XSSFWorkbook wb, int id) {
        for (int row = 0; row < 13; row++) {
            for (int column = 0 ; column < 4; column++) {
                XSSFCell cell = wb.getSheetAt(id).getRow(row).getCell(column);
                printCellToConsole(cell);

                // Padding
                if (row > 0) System.out.print("    ");
                System.out.print("     ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String [] args) throws IOException {
        // Take in the Excel file and create a workbook to read from
        // TODO: Let the user specify the path for the Excel file at run-time
        InputStream file = new FileInputStream(EXCEL_FILE);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        printDataCategoryToConsole(wb, DATA_WASTE);
    }
}