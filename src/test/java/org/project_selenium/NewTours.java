package org.project_selenium;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewTours {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@After
	public void fermerPage() {
		driver.close();
	}
	
	//@Test
	public void testimplicit() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//lancer page internet
		driver.get("http://newtours.demoaut.com/");
		//entrer login
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		// entrer mdp
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("mercury");
		// cliquer sur Sign-in
		driver.findElement(By.name("login")).click();
		//vérification page ok
		assertTrue(driver.findElement(By.name("findFlights")).isEnabled());
	}
	
	@Test
	public void testexplicit() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 60);
		//lancer page internet
		driver.get("http://newtours.demoaut.com/");
		//entrer login
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		// entrer mdp
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("mercury");
		// cliquer sur Sign-in
		driver.findElement(By.name("login")).click();
		//attendre que boutton apparaisse
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("findFlights"))));
		//vérification page ok  
		assertTrue(driver.findElement(By.name("findFlights")).isEnabled());
		
	}
}
