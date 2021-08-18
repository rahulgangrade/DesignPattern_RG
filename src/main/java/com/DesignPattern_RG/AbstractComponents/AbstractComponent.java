package com.DesignPattern_RG.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
   WebDriver driver;
   WebElement sectionElement;
	
	public AbstractComponent(WebDriver driver, By sectionElement) {

	this.driver=driver;
	this.sectionElement=driver.findElement(sectionElement);
	
	}
	   public void waitforElementtodisappear(By findElementBy) {
              WebDriverWait wait= new WebDriverWait(driver, 3);
              wait.until(ExpectedConditions.invisibilityOfElementLocated(findElementBy));
			}
	public WebElement findElement(By findElementBy) {
		
		
		return sectionElement.findElement(findElementBy);
	}

}
