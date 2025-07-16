package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNgBase {
	
	public WebDriver driver;
	@BeforeMethod
	public void initializeBrowser() {
		//Create instance of driver as ChromeDriver
		driver = new ChromeDriver();
		//Access the URL to be tested using get()
		driver.get("https://www.saucedemo.com/v1/");
		//Automate the maximizing of window
		driver.manage().window().maximize();
	
	}
	
	//Automate to close the screen
	@AfterMethod
	public void browserClose() {
		//close() closes only one window in the session and quit() closes multiple windows in the session.
		//driver.quit(); 
	}
	
	

}
