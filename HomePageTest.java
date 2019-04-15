package com.newtour.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.pages.HomePage;
import com.newtour.pages.LoginPage;
import com.newtour.testBase.TestBase;
import com.newtour.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName="Profile";
	public HomePageTest() {
		super();
	}
	@BeforeMethod()
	public void setUp() {
		intialization();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=new HomePage();
		homePage=loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void validateHomePageTitle() {
		String title=homePage.verifyPageTitle();
		Assert.assertEquals(title, "Find a Flight: Mercury Tours:");
	}
	@Test(priority=2)
	public void validateImageLogo() {
		homePage.verifyImageLogo();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
