package Java;

import java.io.FileInputStream;
import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.Files;

public class ExcelEx {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File("C:\\Users\\user\\Documents\\Testing\\Documents\\vehicle_insurance_managment.xlsx"));
		XSSFWorkbook wb = new XSSFWorkbook(fis); //HSSFWorkbook - xls
		XSSFSheet sh = wb.getSheet("scenario");
		
		int rows = sh.getPhysicalNumberOfRows();
		int cols = sh.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println("rows are: " +rows + ", cols are: " +cols);
		
	}

}
