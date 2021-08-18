package com.DesignPattern_RG.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DesignPattern_RG.AbstractComponents.AbstractComponent;

public class HeaderPage extends AbstractComponent {
	
	By flights = By.cssSelector("[title='Flights']");
	
	
	 public HeaderPage(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
	}


	
	public void getFlightAttribute() {
		 
		   System.out.println(findElement(flights).getAttribute("class"));
			 
			// driver.findElement(flights);
		 }
	
}
