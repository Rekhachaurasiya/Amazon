package com.newtour.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtour.pages.HomePage;
import com.newtour.pages.LoginPage;
import com.newtour.pages.ProfilePage;
import com.newtour.testBase.TestBase;
import com.newtour.util.TestUtil;

public class ProfilePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ProfilePage profilePage;
	
	String sheetName="profile";
	
	public ProfilePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		intialization();
		profilePage=new ProfilePage();
		testUtil=new TestUtil();
		loginPage=new LoginPage();
		homePage=new HomePage();
		homePage=loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void clickingProfile() {
		homePage.clickOnProfile();
	}
	@Test(priority=2)
	public void validateProfilePageTitle() {
		profilePage.verifyProfileTitle();
	}
	@DataProvider
	public Object[][] getNewTourTestData() throws InvalidFormatException, org.openxml4j.exceptions.InvalidFormatException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3,dataProvider="getNewTourTestData")
	public void validateCreateNewProfile(String FirstName,String LastName,String Phone,String Email,String Address,String City,String State,String postalCode, String Country) {
//		WebDriverWait w = new WebDriverWait(driver,20);
//		w.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/a")));
		homePage.clickOnProfile();
		profilePage.createNewProfile(FirstName,LastName,Phone,Email,Address,City,State,postalCode,Country);
	}
   @AfterMethod
   public void tearDown() {
	   driver.quit();
   }
}
