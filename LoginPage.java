package com.newtour.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.testBase.TestBase;

public class LoginPage extends TestBase {
 @FindBy(name="userName")
 WebElement Username;
 @FindBy(name="password")
 WebElement Password;
 @FindBy(name="login")
 WebElement ClickOnSignInBtn;
 
 public LoginPage() {
	 PageFactory.initElements(driver, this);
 }
 public String verifyLoginTitle() {
	return driver.getTitle();
 }
 public HomePage verifyLogin(String un,String pwd)
 {
	 Username.sendKeys(un);
	 Password.sendKeys(pwd);
	 ClickOnSignInBtn.click();
	 return new HomePage();
 }

}
