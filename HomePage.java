package com.newtour.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtour.testBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	WebElement image;
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[3]/a")
	WebElement Profile;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	public void verifyImageLogo()
	{
		image.isDisplayed();
	}
	public ProfilePage clickOnProfile()
	{
		Profile.click();
		return new ProfilePage();
	}
	
	
	
	
}
