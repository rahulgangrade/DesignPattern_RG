package com.DesignPattern_RG.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DesignPattern_RG.PageComponents.MultiTrip;
import com.DesignPattern_RG.PageComponents.MultiTrip.*;
import com.DesignPattern_RG.PageComponents.SearchFlightAvail;

public class StrategyFactor {
	
	
	By sectionElement=By.id("flightSearchContainer");
	WebDriver driver;
	public StrategyFactor(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public SearchFlightAvail createStrategy(String strategyType) {
		
		if(strategyType.equalsIgnoreCase("multitrip"))
		{
			return new MultiTrip(driver, sectionElement);
		}
		
//		if(strategyType.equalsIgnoreCase("roundtrip"))
//		{
//			return new RoundTrip(driver, sectionElement);
//		}
		return null;
		

	}

}
