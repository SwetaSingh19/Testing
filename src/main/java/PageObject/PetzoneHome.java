package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetzoneHome {
	
	WebDriver driver;
	public PetzoneHome(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//i[@class='icon fa fa-home cbp-mainlink-icon']")
	WebElement btn_home;
	
	 public WebElement verifyHome()
	 {
		 return btn_home;
	 }
	 
	 @FindBy(xpath="//span[contains(text(),'Cat ')]")
	 WebElement txt_cat;
	 
	 public WebElement Hovercat()
	 {
		 return txt_cat;
	 }
	 
	 @FindBy(xpath="(//a[@href='https://www.marshallspetzone.com/120-dry-food'])[1]")
	 WebElement txt_dryfruit;
	 
	 public WebElement ClickDryFruit()
	 {
		 return txt_dryfruit;
	 }
}
