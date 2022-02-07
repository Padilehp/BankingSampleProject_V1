package com.internetBanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ibanking.base.BaseClass;

import icom.netBanking_V1.pageobjects.LoginPage;

public class T_01_LoginTest extends BaseClass{
	
	
	@Test
	public void LoginTest() {
		LoginPage login=new LoginPage(driver);
		driver.get(baseURL);
		
		login.setUsername(username);
		logger.info("Entered Username");
		login.setPass(password);
		login.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			try {
				CaptureScreen(driver, "LoginTest");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
