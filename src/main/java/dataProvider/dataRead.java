package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataRead {
	String xlFilePath="./src/main/java/dataProvider/data.xlsx";
	String sheetName="BugDetails";
	ExcelSheetReader provideData=new ExcelSheetReader();
	Object[][] data=null;
	@DataProvider(name="test")
	public Object[][] testData() throws IOException{
		data=provideData.testData(xlFilePath, sheetName);
		return data;
	}
	@Test(dataProvider="test")
	public void testCases(String Key, String Summary, String Description) {
		System.out.println("Key :"+Key+" Summary :"+Summary+" Description :"+Description);
		
	}
}
