package TestNgPkg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.management.relation.Role;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCell;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ExcelUtils 
{
	public static XSSFSheet ExcelWSheet;
	 
	public static XSSFWorkbook ExcelWBook;
	
	public static XSSFSheet sheet;

	public static XSSFCell Cell;

	public static XSSFRow Row;

	public static ArrayList<String> CellData=new ArrayList<String>(); 
	  
	//Get first sheet from the workbook
	//HSSFSheet sheet = workbook.getSheetAt(0);
	  
	//Get iterator to all the rows in current sheet
	//Iterator<Row> rowIterator = sheet.iterator();
	  
	//Get iterator to all cells of current row
	//Iterator<Cell> cellIterator = row.cellIterator();
	
//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

public static void setExcelFile(String Path,String SheetName) throws Exception 
{

		try {

			// Open the Excel file

		FileInputStream ExcelFile = new FileInputStream(Path);

		// Access the required test data sheet

		ExcelWBook = new XSSFWorkbook(ExcelFile);

		ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

}

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

public static String getCellData(int RowNum, int ColNum) throws Exception
{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

			}catch (Exception e){

			return"";

			}

}

//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	
{

		try{

			Row  = ExcelWSheet.getRow(RowNum);

		Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

		if (Cell == null) {

			Cell = Row.createCell(ColNum);

			Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(Config.Path_TestData + Config.File_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}

	}
public static void Setvalue()
{
	String Rowdata;
	int RowNo = ExcelWSheet.getLastRowNum();

	for (int i = 0; i <= RowNo; i++) 
	{

		for (int j = 0; j < i; j++)
		{
			
			Rowdata = ExcelUtils.ExcelWSheet.getRow(i).getCell(j).getStringCellValue();
			
			System.out.println("Rowdata:" + Rowdata);
			CellData.add(Rowdata);
			
		}
	}
}



}
