package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAnimal {
	
	@FindBy (xpath="/html/body/table[3]/tbody/tr[2]/td[5]/a/img")
	WebElement bouttonAddtoCart;
	@FindBy (xpath="//font")
	WebElement nomAnimal;
	
	public PagePanier ajouterPanier(WebDriver driver) {
		bouttonAddtoCart.click();
		return PageFactory.initElements(driver, PagePanier.class);
	}
	
	

}
