package org.Html5Hotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Html5Hotel {
	WebDriver driver;
	
	@After
	public void fermerPage() throws Exception {
		driver.close();
		BddConnexion.deleteAllData("src\\test\\resources\\nettoyage.xml");
	}
	
	@Before
	public void miseEnPlaceBDD() throws Exception {
		BddConnexion.deleteAllData("src\\test\\resources\\nettoyage.xml");
		BddConnexion.insertData("src\\test\\resources\\DataSet.xml");
	}
	
	@Test
	public void iFrames() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost/TutorialHtml5HotelPhp/");
		Html5HotelPageAccueil page_accueil= PageFactory.initElements(driver, Html5HotelPageAccueil.class);
		assertEquals("HTML5 Hotel Room Booking (JavaScript/PHP)", page_accueil.titrePage.getText());
		page_accueil.click(driver, page_accueil.premiereCell);
		driver.switchTo().frame(0);
		assertEquals("New Reservation", page_accueil.titreIFrame.getText());
		page_accueil.nomReservation(driver, "resa 1");
		page_accueil.click(driver, page_accueil.bouttonSaveIFrame);
		driver.switchTo().defaultContent();
		assertTrue(page_accueil.filsPremiereCell.getText().contains("resa 1"));
		page_accueil.bougerResa(driver, page_accueil.celluleResa, page_accueil.deuxiemeCell);
		Thread.sleep(8000);
		page_accueil.annulerResa(driver, page_accueil.celluleResa, page_accueil.deleteResa, page_accueil.premiereCell);
		
		
	}
	
	

}
