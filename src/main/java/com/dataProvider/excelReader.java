package com.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelReader {
	String xlFilePath = "./src/main/java/com/dataProvider/data.xlsx";
	String sheetName = "data";
	ExcelSheetReader ProvideData=new ExcelSheetReader();
	Object[][] data;
	@DataProvider(name = "user")
	public Object[][] CredentialtoLogin() throws Exception {
		data = ProvideData.testData(xlFilePath, sheetName);
        return data;
	}
	@Test(dataProvider="user")
	public void userdetails(String username, String password, String city, String pin){
		System.out.println("Username :"+username+"password :"+password+"City :"+city+"Pin :"+pin);
		
	}
}
