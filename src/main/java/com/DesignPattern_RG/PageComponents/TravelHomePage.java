package com.DesignPattern_RG.PageComponents;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DesignPattern_RG.AbstractComponents.StrategyFactor;


public class TravelHomePage implements SearchFlightAvail{
	 By flights = By.cssSelector("[title='Flights']");
	 By footersectionElement = By.id("traveller-home");
	 By headersectionElement = By.id("buttons");
	 HeaderPage headerPage; 
	 FooterPage footerPage;
	 WebDriver driver;
	 SearchFlightAvail searchflightAvail;
	 
	 
	 public TravelHomePage(WebDriver driver) {
		 this.driver=driver;
	}

	public void goTo(String URL) {

		 driver.get(URL);
	 }  
	 
	 public  HeaderPage getHeaderNav() {
		 
		 return new HeaderPage(driver, headersectionElement);
	 }
	 
	 
	 
	 public  FooterPage getFooterNav() {
		 

			return new FooterPage(driver, footersectionElement );
		
	 }
	 
	 public String getTitle() {
		 System.out.println(" Hello----------->JFROG");
		 System.out.println(" Hello2---------->JFROG2");
		 return driver.getTitle();
	 }

	public void checkAvailability(HashMap<String,String> reservationDetails) {
		searchflightAvail.checkAvailability(reservationDetails);
	}

//	public void setBookingStrategy(SearchFlightAvail searchflightAvail) {
//		
//		this.searchflightAvail=searchflightAvail;
//	}

	public void setBookingStrategy(String strategyType) {
		
		StrategyFactor strategyFactor= new StrategyFactor(driver);
		SearchFlightAvail searchFlightAvail= strategyFactor.createStrategy(strategyType); 
		this.searchflightAvail=searchFlightAvail;
	}
	 
	 
	 
}
