package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.hc.client5.http.async.methods.AbstractBinResponseConsumer;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public FileInputStream fI;
	public FileOutputStream fO;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	XSSFRow row;
	String pathString = null;
	String sheetName;

	public ReadExcelFile(String pathString) {
		this.pathString = pathString;
	}

	public void ReadFile() throws IOException {
		fI = new FileInputStream(pathString);
		workbook = new XSSFWorkbook(fI);
	}

	public int getRowCount(String sheetName) throws IOException {
		ReadFile();
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		return rowCount;
	}

	public int getCellCount(String sheetName, int rownum) throws IOException {
		ReadFile();
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}

	public String getCellData(String sheetName, int rownum, int column) throws IOException {
		ReadFile();
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(column);

		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		return data;
	}

	public XSSFRow getRow() {
		sheet = workbook.getSheet(sheetName);
		sheetName = workbook.getSheetName(0);
		XSSFRow row = sheet.getRow(0);
		return row;
	}

	public int getColCount(int rowCount, int column, String sheetName) {

		sheet = workbook.getSheet(sheetName);

		XSSFRow row = getRow();
		int colCount = row.getLastCellNum();
		return colCount;

	}
	/*
	 * public Object[][] getData() { DataFormatter formatter = new DataFormatter();
	 * XSSFRow row=getRow();
	 * 
	 * int rowCount=getRowCount(); int column = 0; String sheetNameExpected = null;
	 * int colCount=getColCount(rowCount,column, sheetNameExpected); data= new
	 * Object[rowCount-1][colCount]; for(i=0;i<rowCount-1;i++){
	 * row=sheet.getRow(i+1); for( j=0;j<colCount;j++){ data[i][j]=row.getCell(j);
	 * String value=formatter.formatCellValue(cell); data[i][j]=value;
	 * System.out.println(data[i][j]); } }
	 * 
	 * return data; } public void getEnvironment(String Environment) { DataFormatter
	 * formatter = new DataFormatter(); XSSFRow row=getRow(); int
	 * rowCount=getRowCount(); int column = 0; String sheetNameExpected = null; int
	 * colCount=getColCount(rowCount,column, sheetNameExpected);
	 * for(i=0;i<rowCount-1;i++) { row=sheet.getRow(i+1); for(j=0;j<colCount;j++) {
	 * data[i][j]=row.getCell(j); String value=formatter.formatCellValue(cell);
	 * data[i][j]=value;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
