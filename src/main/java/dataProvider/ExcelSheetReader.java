package dataProvider;

import java.io.IOException;

public class ExcelSheetReader {
	ExcelDataReader excel = null;

	public Object[][] testData(String xlFilePath, String sheetName) throws IOException {
		Object[][] excelData = null;
		excel = new ExcelDataReader(xlFilePath);
		int rows = excel.getRowsNum(sheetName);
		int columns = excel.getColumns(sheetName);
		excelData = new Object[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = excel.getCellData(sheetName, j, i);
			}
		}
		return excelData;
	}
}
