import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
    public static String getNum(int rownum, int colnum) throws IOException{
        String num;
//        XSSFWorkbook srcBook = new XSSFWorkbook("E:/Appium Demo/io-appium-demo/CalNum.xlsx");
        XSSFWorkbook srcBook = new XSSFWorkbook("E:/Appium Demo/appium-sample-test-master/src/Data/CalNum.xlsx");
        XSSFSheet sourceSheet = srcBook.getSheetAt(0);
        XSSFRow sourceRow = sourceSheet.getRow(rownum);
        XSSFCell cell = sourceRow.getCell(colnum);

        num = cell.getStringCellValue();

        return num;
    }
}
