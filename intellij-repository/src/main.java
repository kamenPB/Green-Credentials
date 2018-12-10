import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class main {
    // Hardcoded path for the Excel file to read from
    public static final String EXCEL_FILE = "..\\data.xlsx";

    // Aliases for the different data categories
    // The Excel workbook must order the sheets in this order
    public static final int DATA_WASTE = 0;
    public static final int DATA_WATER = 1;
    public static final int DATA_WATER_LL = 2;
    public static final int DATA_ELEC = 3;
    public static final int DATA_ELEC_CP = 4;
    public static final int DATA_GAS = 5;

    public static void main(String [] args) throws IOException {
        // Take in the Excel file and create a workbook to read from
        // TODO: Let the user specify the path for the Excel file at run-time
        InputStream file = new FileInputStream(EXCEL_FILE);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        // Read the cell at [0,0] of the Waste sheet
        // TODO: Process and display relevant stats from the table
        // TODO: Generalise and repeat for all data categories
        XSSFCell cell = wb.getSheetAt(DATA_WASTE).getRow(0).getCell(0);

        // Print the cell's value
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:
                System.out.print(cell.getStringCellValue() + "");
                break;
            case XSSFCell.CELL_TYPE_NUMERIC:
                System.out.print(cell.getNumericCellValue() + "");
                break;
            case XSSFCell.CELL_TYPE_BLANK:
            case XSSFCell.CELL_TYPE_BOOLEAN:
            case XSSFCell.CELL_TYPE_ERROR:
            case XSSFCell.CELL_TYPE_FORMULA:
            default:
                System.out.print("Unexpected cell type received.");
                break;
        }
    }
}
