import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
public class main {
    public static void main(String [] args) throws IOException
    {
        InputStream ExcelFileToRead = new FileInputStream("..\\data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFCell cell = wb.getSheetAt(0).getRow(0).getCell(0);
        //System.out.print(cell.getNumericCellValue() + "");
        System.out.print(cell.getStringCellValue() + "");
    }
}