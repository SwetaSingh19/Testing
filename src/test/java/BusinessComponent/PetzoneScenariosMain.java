package BusinessComponent;


import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import PageObject.PetzoneHome;
import PageObject.PetzoneSpecification;
import collect.ExtendReport;
import collect.Setup;



@Listeners(BusinessComponent.Listeners.class)

public class PetzoneScenariosMain extends Setup {
	WebDriver driver;
	WebDriverWait wait;
	static ExtentReports  report;
	static ExtentTest test;
	
	private static Logger log= LogManager.getLogger(PetzoneScenariosMain.class.getName());
	
	@BeforeClass
	public static void startTest()
	{
	report = ExtendReport.getReporter();
	test = report.createTest("PetzoneScenariosMain");   
	 log.info("The site is launched");
	}
	
@BeforeTest
public void browserLaunch() throws IOException
{
	driver=driverSetup();
	driver.get(pop.getProperty("url"));
	//report = ExtendReport.getReporter();
	  //test= report.createTest("PetzoneScenariosMain");
	
	
}

	@Test(priority=1)
	
	
	public void scenarioLegalNotice() throws IOException
	{
		
		
		PetzoneHome ph= new PetzoneHome(driver);
		ph.verifyHome().click();
		 log.info("Home page");
	String titlePet=	driver.getTitle();
	//System.out.println(titlePet);
	Assert.assertEquals(titlePet, "Buy pet food Online Shop for Dog, Cat & Bird Supplies");
		

		
	}
	
@Test(priority=2)
	
	public void CartCat() throws InterruptedException
	{
	
		String desriedProduct = "Cat' Njoy Adult All Breed Ocean Mix Flavour 3kg";
		PetzoneSpecification ps= new PetzoneSpecification(driver);
		PetzoneHome ph = new PetzoneHome(driver);
		Actions action = new Actions(driver);
		action.moveToElement(ph.Hovercat()).build().perform();
		//System.out.println(driver.getWindowHandles());
		ph.ClickDryFruit().click();
		 wait = new WebDriverWait(driver,10);
		 wait.until(ExpectedConditions.visibilityOf((ps.VerifyTitle())));
		 List<WebElement> itemsList =  ps.Selectitem();
		Iterator<WebElement> it = itemsList.iterator();
		while(it.hasNext())
		{
			WebElement itemList =it.next();
		
			if(itemList.getText().equals(desriedProduct))
			{	
				itemList.click();
				 log.info("Item selected");
				//System.out.println("i clicked");
				
				
				
		}
		}
		
		
	
	}

@AfterTest
	
	public void closeBrowser()
	{
		driver.close();
	}
@AfterClass
public static void endTest()
{

report.flush();
}

}
