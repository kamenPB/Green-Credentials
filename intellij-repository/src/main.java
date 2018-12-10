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
        // TODO: Let the user specify the path for the Excel file to read from
        InputStream file = new FileInputStream(EXCEL_FILE);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        // Read the cell at [0,0] of the Waste sheet
        XSSFCell cell = wb.getSheetAt(DATA_WASTE).getRow(0).getCell(0);

        // Print the cell's String value
        // TODO: Allow reading from non-String cell values (e.g. Numeric cells)
        // System.out.print(cell.getNumericCellValue() + "");
        System.out.print(cell.getStringCellValue() + "");
    }
}
