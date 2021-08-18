package com.DesignPattern_RG.PageComponents;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.DesignPattern_RG.AbstractComponents.AbstractComponent;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail{
	  public MultiTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		// TODO Auto-generated constructor stub
	}

	private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
	    private By multiCity_rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
	    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	    private By modalPopUp = By.id("MultiCityModelAlert");
	    //private By destination_3= By.id("//a[@value='MAA'])[2]");
	
	    
	    public void makeStateReady(Consumer<MultiTrip> consumer) {
	    	
	    	 findElement(multiCity_rdo).click();
	         findElement(modalPopUp).click();
	         waitforElementtodisappear(modalPopUp);
	         consumer.accept(this);
	         System.out.println("I am Done");
	    }
	 
		@Override
	public void checkAvailability(HashMap<String,String> reservationDetails) {
     System.out.println(" I am in checkAvail() method of MultiTrip class");
     makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
     selectDestinationCity(reservationDetails.get("destination"));
     selectDestinationCity2(reservationDetails.get("destination2"));
	}
    public void selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2)
    {
        findElement(destination_2).click();
        findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }
}
