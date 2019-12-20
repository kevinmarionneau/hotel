package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
	
		@FindBy (xpath="//input[@name='username']")
		WebElement champLogin;
		
		@FindBy (xpath="//input[@name='password']")
		WebElement champMdp;
		
		@FindBy (xpath="//input[@name='update']")
		WebElement bouttonSubmit;
		
		public PageAccueil seConnecter (WebDriver driver, String username, String password) {
			champLogin.clear();
			champLogin.sendKeys(username);
			champMdp.clear();
			champMdp.sendKeys(password);
			bouttonSubmit.click();
			return PageFactory.initElements(driver, PageAccueil.class);
		}

}
