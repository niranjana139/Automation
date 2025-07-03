package seleniumBasics;

public class HandlingNavigationCommands extends Base {
	
	public void verifyNavigationCommands() {
		//Helps to navigate to another site or another page within the site
		driver.navigate().to("https://www.amazon.in/");
		//Helps to navigate back to the base URL
		driver.navigate().back();
		//Helps to move to the same site initially navigated
		driver.navigate().forward();
		//Helps to refresh the site
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingNavigationCommands navigation = new HandlingNavigationCommands();
		navigation.initializeBrowser();
		navigation.verifyNavigationCommands();
	}

}
