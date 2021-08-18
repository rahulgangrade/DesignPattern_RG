package com.DesignPattern_RG.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DesignPattern_RG.AbstractComponents.AbstractComponent;

public class FooterPage extends AbstractComponent {
	 WebDriver driver;
	 By footersectionElement = By.id("traveller-home");
	 By flights = By.cssSelector("[title='Flights']");
	 
	 
	 public FooterPage(WebDriver driver, By footersectionElement) {
		 super(driver,footersectionElement);
	 
	 
	 }


	public void getFlightAttribute() {
		 
	  System.out.println(findElement(flights).getAttribute("class"));
		 
		// driver.findElement(flights);
	 }

}
