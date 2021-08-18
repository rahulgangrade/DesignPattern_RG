package com.api.DesignPattern_RG;

import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DesignPattern_RG.PageComponents.MultiTrip;
import com.DesignPattern_RG.PageComponents.TravelHomePage;

public class DemoTest extends BaseTest{
	static By sectionElement = By.id("flightSearchContainer");
	  static TravelHomePage travelHomePage;
	  WebDriver driver;
//	
//	public DemoTest(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub1
//	}


	    @BeforeTest
	    public void setup()
	    {
	        driver =initializeDriver();
	        travelHomePage = new TravelHomePage(driver);
	    }

	@Test(dataProvider = "getData")
	 public void flightTest(HashMap<String,String> reservationDetails) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\eclipse-workspace\\DesignPattern_RG\\src\\main\\java\\resources\\chromedriver.exe");
//		WebDriver driver= new ChromeDriver();
		
		//TravelHomePage travelHomePage= new TravelHomePage(driver);
		travelHomePage.goTo("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(travelHomePage.getTitle());
		travelHomePage.getFooterNav().getFlightAttribute();
		travelHomePage.getHeaderNav().getFlightAttribute();
		
		//travelHomePage.setBookingStrategy(new MultiTrip(driver, sectionElement));
		travelHomePage.setBookingStrategy("multitrip");
		travelHomePage.checkAvailability(reservationDetails);

//		travelHomePage.setBookingStrategy(new RoundTrip());
//		travelHomePage.checkAvailability("Origin", "Destination");
		
	}
	
	  @AfterTest
	    public void tearDown()
	    {
	        driver.quit();
	    }

	    @DataProvider
	    //hashmaps,dataprovider, json, jackson,list
	    public Object[][] getData() throws IOException {
	        List<HashMap<String, String>> l=getJsonData(System.getProperty("user.dir")+"\\src\\test\\java\\dataLoads\\reservationDetails.json");

	        return new Object[][]
	                {
	                        { l.get(0)},  { l.get(1)}
	                };
	    }


}
