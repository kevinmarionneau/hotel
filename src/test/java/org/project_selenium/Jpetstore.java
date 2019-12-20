package org.project_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class Jpetstore {

	WebDriver driver;
	WebElement messageBienvenue;

	//@After
	public void fermerPage() {
		driver.close();
	}

	//@Test
	public void test() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();	
		//entrer URL
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[2]/a[2]")).click();
		//mettre login
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).clear();;		
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("j2ee");
		//mettre mdp
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).clear();;	
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input")).sendKeys("j2ee");
		//cliquer sur se connecter
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[4]/td[2]/input")).click();
		//vérifier le message de bienvenue
		messageBienvenue= driver.findElement(By.xpath("//font"));
		assertEquals(messageBienvenue.getText(),"Welcome ABC!");
		//vérifier Sign'Out disponible
		assertTrue(driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[2]/a[2]/img")).isEnabled());
		//sélection catégorie fish
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td/a/img")).click();

		//vérifier tableau fish
		assertEquals("Fish",driver.findElement(By.xpath("//h2")).getText());

		//sélectionner produit
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[1]/b/a/font")).click();
		//ajouter panier
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[2]/td[5]/a/img")).click();
		assertEquals(driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/h2")).getText(),"Shopping Cart");
		//doubler quantité
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[2]/td[5]/input")).clear();
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[2]/td[5]/input")).sendKeys("2");
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[3]/td[1]/input")).click();
		//transformer prix unitaire en double
		String prixU = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[2]/td[6]")).getText();
		String S1= prixU.substring(1);
		double pU = Double.parseDouble(S1.replace(",", "."));
		//transformer prix final en double
		String prixF = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/form/table/tbody/tr[2]/td[7]")).getText();
		String S2= prixF.substring(1);
		double pF = Double.parseDouble(S2.replace(",", "."));
		//comparer PrixU et prixF
		assertEquals(pF, pU*2, 0);

	}
	//String quantity="2";
	//String login="j2ee";
	//String password="j2ee";

	/*@Test
	public void testPageObjet() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		PageIndex page_index= PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login= page_index.clickSigninButton(driver);
		PageAccueil page_accueil= page_login.seConnecter(driver, login, password);
		//Vérifier page accueil
		assertEquals("Welcome ABC!",page_accueil.messageAccueil.getText());
		assertTrue(page_accueil.bouttonSignout.isEnabled());
		PageCategorie page_categorie= page_accueil.allerSurFish(driver);
		//Vérifier page catégorie
		assertEquals("Fish",page_categorie.nomCategorie.getText());
		PageAnimal page_animal= page_categorie.selectionFish(driver);
		PagePanier page_panier= page_animal.ajouterPanier(driver);
		//Vérifier page Panier
		assertEquals("Shopping Cart", page_panier.shoppingCart.getText());
		page_panier.verifierPanier(quantity);
		assertEquals(page_panier.pF, page_panier.pU*Integer.parseInt(quantity), 0);

	}*/

	/*String login = "j2ee";
	String password = "j2ee";
	//Langues possible "english" ou "japanese"
	String langue= "japanese";
	//Catégories possible "FISH", "DOGS", "REPTILES", "CATS" ou "BIRDS"
	String category= "REPTILES";



	@Test
	public void testBoutonRadio() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		PageIndex page_index= PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login= page_index.clickSigninButton(driver);
		PageAccueil page_accueil= page_login.seConnecter(driver, login, password);
		assertEquals("Welcome ABC!",page_accueil.messageAccueil.getText());
		assertTrue(page_accueil.bouttonSignout.isEnabled());
		PageMyAccount page_my_account= page_accueil.allerSurMyAccount(driver);
		assertEquals("Profile Information",page_my_account.profileInformation.getText());
		//Changer langue
		String MDLP= page_my_account.changerLanguagePreference(langue);
		//Changer Catégorie
		String MDFC= page_my_account.changerFavouriteCategory(category);
		//Sauvegarder changement
		page_my_account.saveChanges(driver);
		page_accueil.allerSurMyAccount(driver);
		//Vérification changement enregistrer
		assertEquals("japanese", MDLP);
		assertEquals("Reptiles",MDFC);
		//Vérification CB coché
		assertTrue(page_my_account.CBEnableMyList.isSelected());
		assertTrue(page_my_account.CBEnnableMyBanner.isSelected());
		//Déselectionner CB "Enable My List"
		page_my_account.clickCBEnableMyList();
		page_my_account.saveChanges(driver);
		page_accueil.allerSurMyAccount(driver);
		//Vérification CB "Enable My List" Déselectionné
		assertFalse(page_my_account.CBEnableMyList.isSelected());
	}*/


	String login = "j2ee";
	String password = "j2ee";
	String recherche= "dog";
	String animalRecherche= "Dalmation";


	@Test
	public void testTableau() {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8090/jpetstore-1.0.5-env2/");
		PageIndex page_index= PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login= page_index.clickSigninButton(driver);
		PageAccueil page_accueil= page_login.seConnecter(driver, login, password);
		assertEquals("Welcome ABC!",page_accueil.messageAccueil.getText());
		assertTrue(page_accueil.bouttonSignout.isEnabled());
		PageSearchProducts page_search_products= page_accueil.recherche(driver, recherche);
		assertTrue(page_search_products.tableauResultat.isDisplayed());
		int nRow= page_search_products.retournerNumeroDeLigne(driver, animalRecherche);
		PageAnimal page_animal= page_search_products.getCellule(driver, nRow);
		System.out.println(page_animal.nomAnimal.getText());
	}

}
