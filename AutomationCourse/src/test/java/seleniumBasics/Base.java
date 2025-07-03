package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
public WebDriver driver;

	public void initializeBrowser() {
		//Create instance of driver as ChromeDriver
		driver = new ChromeDriver();
		//Access the URL to be tested using get()
		driver.get("https://selenium.qabible.in/");
		//Automate the maximizing of window
		driver.manage().window().maximize();
	
	}
	
	//Automate to close the screen
	public void browserClose() {
		//close() closes only one window in the session and quit() closes multiple windows in the session.
		driver.quit(); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base base =new Base();
		base.initializeBrowser();
		//base.browserClose();
	}

}
