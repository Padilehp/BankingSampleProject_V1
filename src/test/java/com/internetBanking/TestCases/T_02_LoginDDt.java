package com.internetBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ibanking.base.BaseClass;
import com.utility.XLUtils;

import icom.netBanking_V1.pageobjects.LoginPage;

public class T_02_LoginDDt extends BaseClass {

	@Test(dataProvider="LoginData")
	public void LoginDDt(String username,String password) {
		LoginPage login=new LoginPage(driver);
		driver.get(baseURL);
		System.out.println(username+password);
		
		login.setUsername(username);
		
		logger.info("usernanme provided");
		login.setPass(password);
		login.clickSubmit();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warning("logging failesd");
		}
		else {
			Assert.assertTrue(true);
			login.clickLogout();
			driver.switchTo().alert().accept();//closes logout alert
			driver.switchTo().defaultContent();
			logger.warning("logging passed");
		}
		
	}
	
	
	//user defined method to check alert is present or not
	public boolean isAlertPresent() {
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path="E:\\taxregine\\BankingProject\\inetBanking_V1\\src\\test\\java\\com\\internetBanking\\testdata\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=1;j<=colcount;j++) {
				loginData[i][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
		
		
	}
}
