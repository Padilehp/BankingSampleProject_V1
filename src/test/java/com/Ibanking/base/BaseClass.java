package com.Ibanking.base;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ReportConfigurator;
import com.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass   {
	ConfigReader cnf= new ConfigReader();
	
	
	public String baseURL=cnf.getURL();
	public String username=cnf.getUname();
	public String password=cnf.getPass();
	public static WebDriver driver;
	public Logger logger;
	
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		logger=Logger.getLogger("ebanking");
		
		
	}
	
	
	@AfterClass
	public void teardown() {
		
		driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
