package icom.netBanking_V1.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(name="uid")
	@CacheLookup
	 WebElement txt_uid;
	
	@FindBy(name="password")
	@CacheLookup
	 WebElement txt_pass;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	 WebElement btn_Login;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	public void setUsername(String uname) {
		txt_uid.sendKeys(uname);
	}
	public void setPass(String pass) {
		txt_pass.sendKeys(pass);
	}
	public void clickSubmit() {
		btn_Login.click();
	}
	public void clickLogout() {
		logout.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

 
