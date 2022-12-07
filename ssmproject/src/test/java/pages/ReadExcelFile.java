package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelFile {
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFSheet sheet1;
    HSSFCell cell;
 // Import excel sheet.
    public ReadExcelFile(String excelFilePath) throws IOException {
    File src = new File(excelFilePath);
 // Load the file.
    FileInputStream fis = new FileInputStream(src);
 // Load he workbook.
    workbook = new HSSFWorkbook(fis);
    }
  
	public int getRowCount(int sheetIndex) {
		// TODO Auto-generated method stub
		int row=workbook.getSheetAt(sheetIndex).getLastRowNum();
		row++;
		return row;
	}
	public Object getData(int sheetNumber, int row,int column,String sheetName) {
		// TODO Auto-generated method stub
		sheet1=workbook.getSheet(sheetName);
		sheet=workbook.getSheetAt(sheetNumber);
		String data=sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	   /* int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	    for(int i=1;i<rowCount;i++) {
	    	Row row1=sheet.getRow(i);
	    	for(int j=1;j<row1.getLastCellNum();j++) {
	    		 System.out.print(row1.getCell(j).getStringCellValue()+"|| ");
	    		  cell=sheet.getRow(i).getCell(2);
	    		  cell.setCellType(cell.CELL_TYPE_STRING);
	   
	    	}

	    }
		return null;*/
	}
	
}
