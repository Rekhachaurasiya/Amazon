package com.newtour.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtour.pages.HomePage;
import com.newtour.pages.LoginPage;
import com.newtour.testBase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		login=new LoginPage();
		
	}
	@Test
	public void validateTitle() {
		String title=login.verifyLoginTitle();
	Assert.assertEquals("Welcome: Mercury Tours", title);
	}
	@Test
	public void validateLogin() {
		homepage=login.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
