import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main {
    // A method to print to the console the string contents of cell (0,0) from test.xlsx
    public static void readExcelFile() throws IOException
    {
        InputStream ExcelFileToRead = new FileInputStream("test.xlsx");
        HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
        HSSFCell cell = wb.getSheetAt(0).getRow(0).getCell(0);
        System.out.print(cell.getStringCellValue() + "");
    }
}
