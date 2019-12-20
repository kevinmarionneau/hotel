package org.Html5Hotel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Html5HotelPageAccueil {


	@FindBy (xpath="//h1/a")
	WebElement titrePage;
	@FindBy (xpath="//h1")
	WebElement titreIFrame;
	@FindBy (xpath="//div[contains(@style,'left: 0px; top: 0px; width: 40px; height: 50px')]")
	WebElement premiereCell;
	@FindBy (xpath="//div[contains(@style,'left: 40px; top: 50px; width: 40px; height: 50px')]")
	WebElement deuxiemeCell;
	@FindBy (xpath="//div[contains(@style,'left: 0px; top: 0px; width: 40px; height: 50px')]/child::*")
	WebElement filsPremiereCell;
	@FindBy (xpath="//div[contains(@class,'left: 0px; top: 50px; width: 40px; height: 50px')]/child::*")
	WebElement filsDeuxiemeCell;
	@FindBy (xpath="//input[@id='name']")
	WebElement champNameFrame;
	@FindBy (xpath="//input[@type='submit']")
	WebElement bouttonSaveIFrame;
	@FindBy (xpath="//div[contains(@style,'left: 241px; right: 1px; top: 41px')]")
	WebElement messageUpdateSuccessful;
	@FindBy (xpath="//div[@class='scheduler_default_event_delete']")
	WebElement deleteResa;
	@FindBy (xpath="//div[contains(@class,'scheduler_default_event_inner')]")
	WebElement celluleResa;

	public void click(WebDriver driver, WebElement webelement) {
		webelement.click();
	}

	public void nomReservation(WebDriver driver, String nom) {
		champNameFrame.clear();
		champNameFrame.sendKeys(nom);
	}
	
	public void bougerResa (WebDriver driver, WebElement element1, WebElement element2) {
		Actions a = new Actions(driver);
		a.clickAndHold(element1).moveToElement(element2).release(element2).build().perform();
	}
	
	public void annulerResa (WebDriver driver, WebElement element1, WebElement element2, WebElement element3) {
		Actions a = new Actions(driver);
		a.moveToElement(element3).build().perform();
		a.moveToElement(element1).build().perform();
		a.moveToElement(element2).build().perform();
		element2.click();;

	}

}

