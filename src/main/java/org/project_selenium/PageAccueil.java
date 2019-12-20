package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccueil {
	
	@FindBy (xpath="/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/a/img")
	WebElement categorieFish;
	@FindBy (xpath="//font")
	WebElement messageAccueil;
	@FindBy (xpath="//img[@name='img_signout']")
	WebElement bouttonSignout;
	@FindBy (xpath="//img[@name='img_myaccount']")
	WebElement bouttonMyAccount;
	@FindBy (xpath="//input[@name='keyword']")
	WebElement barreRecherche;
	@FindBy (xpath="//input[contains(@src,'search.gif')]")
	WebElement bouttonSearch;
	
	public PageCategorie allerSurFish(WebDriver driver) {
		categorieFish.click();
		return PageFactory.initElements(driver, PageCategorie.class);
	}
	public PageMyAccount allerSurMyAccount(WebDriver driver) {
		bouttonMyAccount.click();
		return PageFactory.initElements(driver, PageMyAccount.class);
	}
	
	public PageSearchProducts recherche(WebDriver driver, String recherche) {
		barreRecherche.sendKeys(recherche);
		bouttonSearch.click();
		return PageFactory.initElements(driver, PageSearchProducts.class);
	}

}
