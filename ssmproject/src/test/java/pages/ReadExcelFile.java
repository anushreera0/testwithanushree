package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	XSSFWorkbook workbook;
	String sheetName;
	XSSFSheet sheet;
    XSSFCell cell;
    public Object[][] data;
    public int i,j;


    public ReadExcelFile(String excelFilePath) throws IOException {
    	
    File src = new File(excelFilePath);
    FileInputStream fis = new FileInputStream(src);
    workbook = new XSSFWorkbook(fis);
    
    }
  
	public int getRowCount() {
		int rowCount=sheet.getPhysicalNumberOfRows();
		return rowCount;
	}
	public XSSFRow getRow() {
		sheet=workbook.getSheetAt(0);
	    sheetName=workbook.getSheetName(0);
	    XSSFRow row=sheet.getRow(0);
	    return row;
	}
	public int getColCount(int rowCount,int column,String sheetNameExpected) {
	
		
		int colCount=0;
		/*if(sheetName==sheetNameexpected) {
		XSSFRow row=sheet1.getRow(0);
		colCount=row.getLastCellNum();
		return colCount;
		}
		
		return colCount=0;*/
		XSSFRow row=getRow();
		colCount=row.getLastCellNum();
		return colCount;
		
	}
	public Object[][] getData() {
		DataFormatter formatter = new DataFormatter();
		XSSFRow row=getRow();
		
		int rowCount=getRowCount();
		int column = 0;
		String sheetNameExpected = null;
		int colCount=getColCount(rowCount,column, sheetNameExpected);
		data=  new Object[rowCount-1][colCount];
		for(i=0;i<rowCount-1;i++){
			row=sheet.getRow(i+1);
			for( j=0;j<colCount;j++){
				data[i][j]=row.getCell(j);
				String value=formatter.formatCellValue(cell);
				data[i][j]=value;
				System.out.println(data[i][j]);
			}
		}
		
		return data;
	}
	public void getEnvironment(String Environment) {
		DataFormatter formatter = new DataFormatter();
		XSSFRow row=getRow();
		int rowCount=getRowCount();
		int column = 0;
		String sheetNameExpected = null;
		int colCount=getColCount(rowCount,column, sheetNameExpected);
		for(i=0;i<rowCount-1;i++) {
			row=sheet.getRow(i+1);
			for(j=0;j<colCount;j++) {
				data[i][j]=row.getCell(j);
				String value=formatter.formatCellValue(cell);
				data[i][j]=value;

					  }
				
		}
		
		
		
			
		}	
}
