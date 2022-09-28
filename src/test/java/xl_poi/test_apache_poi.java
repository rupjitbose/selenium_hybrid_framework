package xl_poi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class test_apache_poi {
		
	
	@Test
	public void readXl() throws Exception {
	FileInputStream fis=new FileInputStream("path");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase("sheet1"))
		{
			XSSFSheet sheet=workbook.getSheetAt(i);
			Iterator<Row> row=sheet.iterator();
			Row fstRow=row.next();
			Iterator<Cell> cell=fstRow.iterator();
			while(cell.hasNext()) {
				Cell value=cell.next();
				try {
				if(value.getStringCellValue().equalsIgnoreCase("")) {
				
				//code
				}
				}
				catch(Exception e) {
					if(value.getNumericCellValue()==0) {
						//code
						
					}
				}
			}
			
			
		}
	}
	
	}
}
