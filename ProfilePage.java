package com.newtour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtour.testBase.TestBase;

public class ProfilePage extends TestBase{
	@FindBy(name="firstName")
	WebElement firstName;
	@FindBy(name="lastName")
	WebElement lastName;
	@FindBy(name="phone")
	WebElement PhoneNumber;
	@FindBy(name="email")
	WebElement emaiId;
	@FindBy(name="address1")
	WebElement address;
	@FindBy(name="city")
	WebElement CityName;
	@FindBy(name="state")
	WebElement StateName;
	@FindBy(name="postalCode")
	WebElement PostalCode;
	@FindBy(xpath="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/table/tbody/tr[14]/td/a/img")
	WebElement ClickOnSmbt;;
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProfileTitle() {
		driver.getTitle();
	}
	public void createNewProfile(String FtName,String LtName,String Phone,String Email,String Address,String City,String State,String pCode, String Country){
		firstName.sendKeys(FtName);
		lastName.sendKeys(LtName);
		PhoneNumber.sendKeys(Phone);
		emaiId.sendKeys(Email);
		address.sendKeys(Address);
		CityName.sendKeys(City);
		StateName.sendKeys(State);
		PostalCode.sendKeys(pCode);
		Select select=new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText(Country);
		//ClickOnSmbt.click();
	}

	
}
