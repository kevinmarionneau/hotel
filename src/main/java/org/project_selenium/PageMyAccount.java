package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageMyAccount {
	
	@FindBy (xpath= "//h3[contains(.,'Profile Information')]")
	WebElement profileInformation;
	@FindBy (xpath= "//select[@name='account.languagePreference']")
	WebElement MDLanguagePreference;
	@FindBy (xpath= "//select[@name='account.favouriteCategoryId']")
	WebElement MDFavouriteCategory;
	@FindBy (xpath="//input[@name='submit']")
	WebElement bouttonSubmit;
	@FindBy (xpath= "//input[@type='checkbox' and @name='account.listOption']")
	WebElement CBEnableMyList;
	@FindBy (xpath= "//input[@type='checkbox' and @name='account.bannerOption']")
	WebElement CBEnnableMyBanner;

	
	
	public String changerLanguagePreference(String langue) {
		Select MDLP= new Select(MDLanguagePreference);
		MDLP.selectByValue(langue);
		return MDLP.getFirstSelectedOption().getText();
	}
	
	public String changerFavouriteCategory(String category) {
		Select MDFC= new Select(MDFavouriteCategory);
		MDFC.selectByValue(category);
		return MDFC.getFirstSelectedOption().getText();
	}
	
	public void saveChanges (WebDriver driver) {
		bouttonSubmit.click();
	}
	
	public void clickCBEnableMyList() {
		CBEnableMyList.click();
	}

}
