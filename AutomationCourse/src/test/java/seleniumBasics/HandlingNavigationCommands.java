package seleniumBasics;

public class HandlingNavigationCommands extends Base {
	
	public void verifyNavigationCommands() {
		driver.navigate().to("https://www.amazon.in/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingNavigationCommands navigation = new HandlingNavigationCommands();
		navigation.initializeBrowser();
		navigation.verifyNavigationCommands();
	}

}
