package com.dataProvider;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class UpdateExcelSheet {
	 public FileInputStream fis = null;
	    public FileOutputStream fos = null;
	    public XSSFWorkbook workbook = null;
	    public XSSFSheet sheet = null;
	    public XSSFRow row = null;
	    public XSSFCell cell = null;
	    String xlFilePath;
	 
	    public UpdateExcelSheet(String xlFilePath) throws Exception
	    {
	        this.xlFilePath = xlFilePath;
	        fis = new FileInputStream(xlFilePath);
	        workbook = new XSSFWorkbook(fis);
	        fis.close();
	    }
	 
	    public boolean setCellData(String sheetName, String colName, int rowNum, String value)
	    {
	        try
	        {
	            int colNum = -1;
	            sheet = workbook.getSheet(sheetName);
	 
	            row = sheet.getRow(0);
	            for (int i = 0; i < row.getLastCellNum(); i++) {
	                if (row.getCell(i).getStringCellValue().trim().equals(colName))
	                {
	                    colNum = i;
	                }
	            }
	 
	            sheet.autoSizeColumn(colNum);
	            row = sheet.getRow(rowNum - 1);
	            if(row==null){
	                row = sheet.createRow(rowNum - 1);
	            }
	            cell = row.getCell(colNum);
	            if(cell == null){
	                cell = row.createCell(colNum);
	            }
	            cell.setCellValue(value);
	 
	            fos = new FileOutputStream(xlFilePath);
	            workbook.write(fos);
	            fos.close();
	        }
	        catch (Exception ex)
	        {
	            ex.printStackTrace();
	            return  false;
	        }
	        return true;
	    }

}
