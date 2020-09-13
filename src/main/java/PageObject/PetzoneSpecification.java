package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PetzoneSpecification {

	WebDriver driver;
	
	public PetzoneSpecification(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll(@FindBy(xpath="//h3[@class='h3 product-title']"))
	List<WebElement> txt_items;
	
	public List<WebElement> Selectitem()
	{
		return txt_items;
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg add-to-cart']")
	WebElement btn_addToCart;
	
	public WebElement addToCart()
	{
		return btn_addToCart;
	}
	@FindBy(xpath="//h1[@class='h1 page-title'] //span[contains(text(),'Dry Food')]")
	WebElement txt_DryFruitTitle;
	
	public WebElement VerifyTitle()
	{
		return txt_DryFruitTitle;
	}
	
}
