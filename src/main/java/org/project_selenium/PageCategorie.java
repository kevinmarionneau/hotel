package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategorie {
	
	@FindBy (xpath="/html/body/table[3]/tbody/tr[2]/td[1]/b/a/font")
	WebElement poissonAngelfish;
	@FindBy (xpath="//h2")
	WebElement nomCategorie;
	
	public PageAnimal selectionFish(WebDriver driver) {
		poissonAngelfish.click();
		return PageFactory.initElements(driver, PageAnimal.class);
	}
	
	

}
