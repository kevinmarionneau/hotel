package org.project_selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSearchProducts {

	@FindBy (xpath="//tbody")
	WebElement tableauResultat;

	public int retournerNumeroDeLigne(WebDriver driver, String animalRecherche){ 
		int ligneCourante = 1;
		List<WebElement> l_lignes = driver.findElements(By.xpath("//table[3]/tbody/tr"));
		for(WebElement ligne : l_lignes){
			List<WebElement> l_cases = ligne.findElements(By.xpath("td"));
			for(WebElement colonne:l_cases){
				if(colonne.getText().equals(animalRecherche)){
					return ligneCourante;	
				}
			}
			ligneCourante++;
		}
		return -1;
	}


	public PageAnimal getCellule(WebDriver driver, int row){ 
		WebElement element = driver.findElement(By.xpath("//table[3]/tbody/tr["+row+"]/td[2]"));
		element.click();;
		return PageFactory.initElements(driver, PageAnimal.class);
	}


}
