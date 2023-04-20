package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWritedata {
	public String getExcelData(String sheetName,int rowNum,int cellNum ) throws Throwable
	{
		FileOutputStream fes=new FileOutputStream("./src/test/resources/data.xlsx");
		//Workbook book = WorkbookFactory.create(fes);
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet1 = book.getSheet(sheetName);
		int lastrow = sheet1.getLastRowNum();
		int lastcell =sheet1.getRow(0).getLastCellNum();


}
