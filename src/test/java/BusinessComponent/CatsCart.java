package BusinessComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PetzoneHome;
import PageObject.PetzoneSpecification;
import collect.Setup;

public class CatsCart extends Setup  {
	WebDriver driver;
	WebDriverWait wait;
	//2nd test
		//login to petzone
		//cats-dryfruits, add to cart "Whiskas Dry Food + Sheba Wet Food, Combo" 
		//proceed to checkout[3rd screen]
		//verify item in cart
		//click logo and home page verify "Buy pet food Online Shop for Dog, Cat & Bird Supplies"
	
	/*@BeforeTest
	public void browserLaunch() throws IOException
	{
		driver=driverSetup();
		driver.get(pop.getProperty("url"));
	}*/
	
	@Test(priority=2)
	
	public void CartCat()
	{
		PetzoneSpecification ps= new PetzoneSpecification(driver);
		PetzoneHome ph = new PetzoneHome(driver);
		Actions action = new Actions(driver);
		action.moveToElement(ph.Hovercat()).build().perform();
		ph.ClickDryFruit().click();
		 wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf((ps.VerifyTitle())));
		
		 /*<test thread-count="5" name="Test2">
		    <classes>
		      <class name="BusinessComponent.CatsCart"/>
		    </classes>
		  </test> <!-- Test -->
		*/
		 
		//Whiskas Dry Food + Sheba Wet Food, Combo
	}
	
/*@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}
		*/
}
