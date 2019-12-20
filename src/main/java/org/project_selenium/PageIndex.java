package org.project_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageIndex {

		@FindBy (xpath="//img[@name = 'img_signin']")
		WebElement bouton_signin;
		
		public PageLogin clickSigninButton(WebDriver driver) {
			bouton_signin.click();
			return PageFactory.initElements(driver, PageLogin.class);
		}
}
