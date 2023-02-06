package excercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	
	static XSSFWorkbook workbook;

	static XSSFSheet sheet;
    static XSSFCell cell;
    public static Object[][] data;
    public static int i;
	public static int j;
	 static String sheetName="Book1";

  
    	    
	public static int getRowCount() {
		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
	}
	public static XSSFRow getRow(String sheetName) {
		//sheet=workbook.getSheetAt(0);
		sheet=workbook.getSheet(sheetName);
		System.out.println(sheet);
	    sheetName=workbook.getSheetName(0);
	    XSSFRow row=sheet.getRow(0);
	    System.out.println(row);
	    return row;
	}
	public static int getColCount(int rowCount,int column,String sheetName) {
	
		
		int colCount=0;
		/*if(sheetName==sheetNameexpected) {
		XSSFRow row=sheet1.getRow(0);
		colCount=row.getLastCellNum();
		return colCount;
		}
		
		return colCount=0;*/
		XSSFRow row=getRow(sheetName);
		colCount=row.getLastCellNum();
		System.out.println(colCount);
		return colCount;
		
	}
	
	public static Object[][] getData() {
		DataFormatter formatter = new DataFormatter();
		XSSFRow row=getRow(sheetName);
		System.out.println(sheet.getSheetName());
		int rowCount=getRowCount();
		int column = 0;
		
		int colCount=getColCount(rowCount,column, sheetName);
	
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
	/*public void getEnvironment(String Environment) {
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
				if(data[i][j]==Environment) {
					data[i][j]=value;
				}
		}
		
		
		
			
		}	
}*/
	public static void main(String[] args) throws IOException {
		 File src = new File("C:\\Users\\anushree\\Documents\\BookForTest.xlsx");
		    FileInputStream fis = new FileInputStream(src);
		    workbook = new XSSFWorkbook(fis);
		   
		  //  getRowCount();
		    getRow(sheetName);
		    
		getData();
	}
}