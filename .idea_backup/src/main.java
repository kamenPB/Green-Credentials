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
    public static void readExcelFile() throws IOException
    {
        InputStream xslxfile = new FileInputStream("test.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(xslxfile);
        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFCell cell;

        cell = (XSSFCell) sheet.getRow(9).getCell(4);
        System.out.print(cell.getStringCellValue()+"");
    }
}
