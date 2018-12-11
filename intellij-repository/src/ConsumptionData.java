import org.apache.poi.xssf.usermodel.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

class GUIComponent extends JComponent {
    /* Pie chart code adapted from:
     * https://stackoverflow.com/questions/41937664/how-can-we-paint-this-piechart-class
     * Credits: Paul Schutrups
     */

    // A pie chart is composed of Slices
    class Slice {
        double value;
        Color color;

        public Slice(double value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    // Generate the slices to be used in the pie chart
    private Slice[] generateSlices() {
        int month = ConsumptionData.getCurrentMonth();
        int dataCategory = ConsumptionData.getCurrentDataCategory();
        switch (dataCategory) {
            case ConsumptionData.DATA_WASTE:
                double recycledPieSliceSize = ConsumptionData.getPercentageWasteRecycled(month) * 100;
                double wastedPieSliceSize = 100 - recycledPieSliceSize;
                return new Slice[] { new Slice(recycledPieSliceSize, Color.green), new Slice(wastedPieSliceSize, Color.red)};
            case ConsumptionData.DATA_WATER:
//                double waterUsageCurrentMonth = ConsumptionData.getWaterUsage(month);
//                double waterUsagePreviousMonth = ConsumptionData.getWaterUsage((month - 1)  % 24);
//                double waterPercentageChange = ((waterUsageCurrentMonth / waterUsagePreviousMonth) - 1) * 100;
//                return new Slice[] { new Slice(waterPercentageChange, Color.blue)};
            case ConsumptionData.DATA_WATER_LL:
//                double waterLLUsageCurrentMonth = ConsumptionData.getLLWaterUsage(month);
//                double waterLLUsagePreviousMonth = ConsumptionData.getLLWaterUsage((month - 1)  % 24);
//                double waterLLPercentageChange = ((waterLLUsageCurrentMonth / waterLLUsagePreviousMonth) - 1) * 100;
//                return new Slice[] { new Slice(waterLLPercentageChange, Color.lightGray)};
            case ConsumptionData.DATA_ELEC:
//                double electricityUsageCurrentMonth = ConsumptionData.getElectricityUsage(month);
//                double electricityUsagePreviousMonth = ConsumptionData.getElectricityUsage((month - 1)  % 24);
//                double electricityPercentageChange = ((electricityUsageCurrentMonth / electricityUsagePreviousMonth) - 1) * 100;
//                return new Slice[] { new Slice(electricityPercentageChange, Color.yellow)};
            case ConsumptionData.DATA_ELEC_CP:
//                double electricityCPUsageCurrentMonth = ConsumptionData.getCPElectricityUsage(month);
//                double electricityCPUsagePreviousMonth = ConsumptionData.getCPElectricityUsage((month - 1)  % 24);
//                double electricityCPPercentageChange = ((electricityCPUsageCurrentMonth / electricityCPUsagePreviousMonth) - 1) * 100;
//                return new Slice[] { new Slice(electricityCPPercentageChange, Color.orange)};
            case ConsumptionData.DATA_GAS:
//                double gasUsageCurrentMonth = ConsumptionData.getGasUsage(month);
//                double gasUsagePreviousMonth = ConsumptionData.getGasUsage((month - 1)  % 24);
//                double gasPercentageChange = ((gasUsageCurrentMonth / gasUsagePreviousMonth) - 1) * 100;
//                return new Slice[] { new Slice(gasPercentageChange, Color.magenta)};
            default:
                System.out.print("Unexpected data category.");
                return new Slice[0]; // Return an empty array
        }
    }

    // Draw the pie chart
    private void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;

        for (Slice slice : slices) {
            total += slice.value;
        }

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

    private void drawString(Graphics2D g, String string, int x, int y, int size) {
        g.setColor(Color.black);
        if (g.getFont().getFontName() != "Cabot Font") { // Do not create more than one font
            Font defaultFont = new Font ("Cabot Font", Font.BOLD, size);
            g.setFont(defaultFont);
        }
        g.drawString(string, x, y);
    }

    // Overload paint method
    public void paint(Graphics g) {
        // Display graph
        // TODO: Implement switch for different graphs depending on current data category
        int width = 800;
        int height = 800;
        int x = 1920 / 2 - width / 2; // N.B. These co-ordinates are not cartesian
        int y = 150; //      Instead, they are offsets from the top-left corner of the JFrame
        drawPie((Graphics2D) g, new Rectangle(x,y,width,height), generateSlices());

        // Display text to explain the above graph
        // TODO: Actually implement this
        //       (This is just a mock-up with hardcoded strings, positions, etc.).
        int month = ConsumptionData.getCurrentMonth();
        double recycledPieSliceSize = ConsumptionData.getPercentageWasteRecycled(month) * 100;
        double wastedPieSliceSize = 100 - recycledPieSliceSize;
        drawString((Graphics2D) g, "Where did January's Waste go?", x, y - 40, 56);
        drawString((Graphics2D) g, "Recycled: " + (int) recycledPieSliceSize + "%", x + 220, y + 180, 48);
        drawString((Graphics2D) g, "Sent to landfill: " + (int) wastedPieSliceSize + "%", x + 580, y + 450, 20);
    }
}
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
            case ConsumptionData.DATA_WATER: // TODO: Implement
            case ConsumptionData.DATA_WATER_LL: // TODO: Implement
            case ConsumptionData.DATA_ELEC: // TODO: Implement
            case ConsumptionData.DATA_ELEC_CP: // TODO: Implement
            case ConsumptionData.DATA_GAS: // TODO: Implement
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
        JFrame frame = new JFrame();
        frame.getContentPane().add(new GUIComponent());
        frame.setTitle("Cabot Circus Green Credentials");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080); // Assume the Smart TV display is 1080p, for now
        frame.setVisible(true);
    }

    private static double[] percentageWasteRecycled = new double[12];
    public static double getPercentageWasteRecycled(int month) {
        return percentageWasteRecycled[month];
    }

    // Collate the data for a given data category into its respective memory space
    private static void collateData(XSSFWorkbook wb, int dataCategory) {
        switch (dataCategory) {
            case DATA_WASTE:
                for (int month = 0; month < 12; month++) {
                    percentageWasteRecycled[month] = wb.getSheetAt(0)
                            .getRow(month + 1) // Skip titles in row 1
                            .getCell(3) // Percentage Recycled column is 3
                            .getNumericCellValue();
                }
                break;
            case DATA_WATER: // TODO: Implement
            case DATA_WATER_LL: // TODO: Implement
            case DATA_ELEC: // TODO: Implement
            case DATA_ELEC_CP: // TODO: Implement
            case DATA_GAS: // TODO: Implement
            default:
                System.out.print("Unexpected data category.");
                break;
        }
    }

    // Take in the Excel file and create a workbook to read from
    // TODO: Let the user specify Excel file path at run-time
    private static XSSFWorkbook getWorkbookFromExcelFile() throws IOException {
        return new XSSFWorkbook(new FileInputStream("..\\data.xlsx")); // For now, hardcode the path
    }

    // Main
    public static void main(String [] args) throws IOException {
        XSSFWorkbook wb = getWorkbookFromExcelFile();

        printDataCategoryToConsole(wb, DATA_WASTE);
        collateData(wb, DATA_WASTE); // TODO: Implement for other data categories

        display();
    }
}
