package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders 
{
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\loginTestData.xlsx";
		ExcelUtility xlUtil=new ExcelUtility(path);
		int totalRows= xlUtil.getRowCount("Sheet1");
		int totalCols= xlUtil.getCellCount("Sheet1", 0);
		
		String loginData[][]=new String[totalRows][totalCols];//created 2D array to store the data
		
		for(int i=1; i<=totalRows; i++) //For rows 1st row contains header
		{
			for(int j=0; j<totalCols; j++) //for columns
			{
				loginData[i-1][j]=xlUtil.getCellData("Sheet1", i, j); //Sheet1,1,0
				//why loginData[i-1][j] ? index start from 0 and we are started the loop from 1
			}
		}
		return loginData;
		
	}

}
