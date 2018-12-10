import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class main {
    // A method to print to the console the string contents of cell (0,0) from test.xlsx
    public static void main(String [] args) throws IOException
    {
        InputStream ExcelFileToRead = new FileInputStream("..\\Consumption Comparison.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFCell cell = wb.getSheetAt(0).getRow(5).getCell(3);
        System.out.print(cell.getStringCellValue() + "");
    }
}