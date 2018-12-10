import java.io.*;
import org.apache.poi.xssf.usermodel.*;
import java.awt.*;
import javax.swing.*;

// Slice and GUIComponent classes taken from:
// https://stackoverflow.com/questions/41937664/how-can-we-paint-this-piechart-class

class Slice {
    double value;
    Color color;
    public Slice(double value, Color color) {
        this.value = value;
        this.color = color;
    }
}

class GUIComponent extends JComponent {
    private Slice[] generateSlices() {
        double recycledVal, wastedVal;
        recycledVal = main.getRecycledVal(0);
        wastedVal = main.getWastedVal(0);
        Slice[] slices = {
            new Slice(recycledVal, Color.green), new Slice(wastedVal, Color.red)
        };
        return slices;
    };

    public void paint(Graphics g) {
        Slice[] slices = generateSlices();
        drawPie((Graphics2D) g, getBounds(), slices);
    }

    private void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;

        for (Slice slice : slices) total += slice.value;

        double curValue = 0.0D;
        int startAngle;
        for (Slice slice : slices) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slice.value * 360 / total);
            g.setColor(slice.color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slice.value;
        }
    }
}

public class main {
    // Hardcoded path for the Excel file to read from
    private static final String EXCEL_FILE = "..\\data.xlsx";

    // Easier readability
    private static final int NUM_MONTHS = 12;

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

    public static double getRecycledVal(int month) {
        double recycledVal = percentageRecycled[month] * 100;
        return recycledVal;
    }

    public static double getWastedVal(int month) {
        double wastedVal = 100 - getRecycledVal(month);
        return wastedVal;
    }
    private static double[] percentageRecycled;

    public static void main(String [] args) throws IOException {
        // Take in the Excel file and create a workbook to read from
        // TODO: Let the user specify the path for the Excel file at run-time
        InputStream file = new FileInputStream(EXCEL_FILE);
        XSSFWorkbook wb = new XSSFWorkbook(file);

        printDataCategoryToConsole(wb, DATA_WASTE);

        // Graphically represent the waste recycling
        percentageRecycled = new double[NUM_MONTHS];

        for (int month = 0; month < NUM_MONTHS; month++) {
            XSSFCell cellTonnes = wb.getSheetAt(0).getRow(month+1).getCell(3);
            percentageRecycled[month] = cellTonnes.getNumericCellValue();
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GUIComponent());
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}