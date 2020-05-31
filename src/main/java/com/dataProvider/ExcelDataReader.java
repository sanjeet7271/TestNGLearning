package com.dataProvider;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
 
public class ExcelDataReader {
   public FileInputStream fis = null;
   public XSSFWorkbook workbook = null;
   public XSSFSheet sheet = null;
   public XSSFRow row = null;
   public XSSFCell cell = null;
   String xlFilePath;
   String sheetName;
   ExcelDataReader excel = null;
    
   
   
   public ExcelDataReader(String xlFilePath) throws Exception
   {
       this.xlFilePath = xlFilePath;
       fis = new FileInputStream(xlFilePath);
       workbook = new XSSFWorkbook(fis);
       fis.close();
   }
   public String getCellData(String sheetName,int colNum,int rowNum)
   {
       try
       {
           sheet = workbook.getSheet(sheetName);
           row = sheet.getRow(rowNum);
           cell = row.getCell(colNum);
           if(cell.getCellTypeEnum() == CellType.STRING)
               return cell.getStringCellValue();
           else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
           {
               String cellValue  = String.valueOf(cell.getNumericCellValue());
               if (HSSFDateUtil.isCellDateFormatted(cell))
               {
                   DateFormat df = new SimpleDateFormat("dd/MM/yy");
                   Date date = cell.getDateCellValue();
                   cellValue = df.format(date);
               }
               return cellValue;
           }else if(cell.getCellTypeEnum() == CellType.BLANK)
               return "";
           else
               return String.valueOf(cell.getBooleanCellValue());
       }
       catch(Exception e)
       {
           e.printStackTrace();
           return "row "+rowNum+" or column "+colNum +" does not exist  in Excel";
       }
   }
   
   public int getRowCount(String sheetName)
   {
       sheet = workbook.getSheet(sheetName);
       int rowCount = sheet.getLastRowNum()+1;
       return rowCount;
   }
 
   public int getColumnCount(String sheetName)
   {
       sheet = workbook.getSheet(sheetName);
       row = sheet.getRow(0);
       int colCount = row.getLastCellNum();
       return colCount;
   }
   
   
}