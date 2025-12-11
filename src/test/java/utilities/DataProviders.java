package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path=".\\testData\\Opencart_login data.xlsx";
		ExcelUtility Excelutil=new ExcelUtility(path);
		
		int rowCount=Excelutil.getRowCount("Sheet1");
		int cellCount=Excelutil.getCellCount("Sheet1", 1);
		
		String[][] Data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<=cellCount;j++) {
				Data[i-1][j]=Excelutil.getCellData("Sheet1", i, j);
			}
		}
		return Data;
	}
}
