package com.dataProvider;
	 
	public class ExcelSheetReader {
	     
	    String xlFilePath;
	    String sheetName;
	    ExcelDataReader excel = null;
	    
	    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
	    {
	        Object[][] excelData = null;
	        excel = new ExcelDataReader(xlFilePath);
	        int rows = excel.getRowCount(sheetName);
	        int columns = excel.getColumnCount(sheetName);
	        
	                 
	        excelData = new Object[rows-1][columns];
	         
	        for(int i=1; i<rows; i++)
	        {
	            for(int j=0; j<columns; j++)
	            {
	                excelData[i-1][j] = excel.getCellData(sheetName, j, i);
	            }
	             
	        }
	        return excelData;
	    }
	    
}
