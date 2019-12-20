package org.project_selenium;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePanier {

	@FindBy (xpath="//h2")
	WebElement shoppingCart;
	@FindBy (xpath="//input[@name='EST-1']")
	WebElement champQuantite;
	@FindBy (xpath="//input[@name='update']")
	WebElement updatePanier;
	@FindBy (xpath="//tr[2]/td[6]")
	WebElement PU;
	@FindBy (xpath="//tr[2]/td[7]")
	WebElement PF;
	public double pF;
	public double pU;

	public void verifierPanier(String quantite) {
		champQuantite.clear();
		champQuantite.sendKeys(quantite);
		updatePanier.click();
		String PrixU= PU.getText();
		String S1= PrixU.substring(1);
		double pU = Double.parseDouble(S1.replace(",", "."));
		String PrixF= PF.getText();
		String S2= PrixF.substring(1);
		double pF = Double.parseDouble(S2.replace(",", "."));
	}
}
