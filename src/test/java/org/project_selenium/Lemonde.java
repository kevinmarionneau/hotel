package org.project_selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Lemonde {
	
	WebDriver DF; 
	
	@After
	public void fermerFenetre() {
		DF.close();
	}
	
	@Test
	public void leMonde() {
	System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
	DF = new FirefoxDriver();
	DF.get("https:lemonde.fr");
	DF.getTitle();
	assertEquals("Le titre est faux", "Le Monde.fr - Actualités et Infos en France et dans le monde", DF.getTitle());

	}
	
}
