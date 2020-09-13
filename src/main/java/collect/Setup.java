package collect;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class Setup {
	public static WebDriver driver;
	public Properties pop;

	
	
	public  WebDriver driverSetup() throws IOException
	{
		pop= new Properties();
		FileInputStream fis= new FileInputStream("F:\\workspace java core\\MarshalPetZone\\Globl.properties");
		pop.load(fis);
		String	browser=pop.getProperty("browserName");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHWETA PC WIN 10\\Desktop\\chromedriver_win32 (4)\\chromedriver.exe");
		 driver= new ChromeDriver();
		}
		
		else
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\SHWETA PC WIN 10\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		 driver= new FirefoxDriver();
		}
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	return driver;
		
	}
	
	public void screenshotCode() throws IOException
	{
		TakesScreenshot sc = (TakesScreenshot)driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File(".\\screenshot\\fullimage.jpg"));
	}
	
	
    
     
}
