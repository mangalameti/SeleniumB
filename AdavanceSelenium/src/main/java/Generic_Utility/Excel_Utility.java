package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
public String getExcelData(String sheetName,int rowNum,int cellNum ) throws Throwable
{
	FileInputStream fes=new FileInputStream("./src/test/resources/Book1.xlsx");
	
	Workbook book = WorkbookFactory.create(fes);
	Sheet sheet = book.getSheet(sheetName);
	Row row = sheet.getRow(rowNum);
	Cell cel = row.getCell(cellNum);
	String Value = cel.getStringCellValue();
	
	
	
	return sheetName;
	
}
public String getExcelDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
{
	 FileInputStream fes=new FileInputStream("./src/test/resources/ExcelSheetData.xlsx");
        Workbook book = WorkbookFactory.create(fes);
        DataFormatter format=new DataFormatter();
       String data = format.formatCellValue(book.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
        return data;
	
}

public Object[][] readMultipleData(String sheetName) throws Throwable
{
FileInputStream fes1=new FileInputStream("./src/test/resources/Book1.xlsx");
	
	Workbook book = WorkbookFactory.create(fes1);
	Sheet sheet1 = book.getSheet(sheetName);
	int lastrow = sheet1.getLastRowNum();
	int lastcell =sheet1.getRow(0).getLastCellNum();
	
	Object[][]obj=new Object[lastrow][lastcell];
	for(int i=0;i<lastrow;i++)
	{
		for(int j=0;j<lastcell;j++)
		{
			obj[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
			
		}
	}
	
	
	return obj;
	
}



























}
