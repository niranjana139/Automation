package seleniumBasics;



import java.util.HashMap;
import java.util.Map;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNgBase {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() {
		//Create instance of driver as ChromeDriver	
		//driver = new ChromeDriver();
		//Implicit wait
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Access the URL to be tested using get()
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/v1/");
		//Automate the maximizing of window
		driver.manage().window().maximize();
			}
	
	//Automate to close the screen
	@AfterMethod
	public void browserClose() {
		driver.close(); //closes only one window in the session and quit() closes multiple windows in the session.
		//driver.quit(); 
	}
	
	

}
