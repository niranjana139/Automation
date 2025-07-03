package seleniumBasics;

public class HandlingBrowserCommands extends Base{
	
	
	public void verifyCommands() {
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String handleId = driver.getWindowHandle();
		System.out.println(handleId);
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	public static void main(String[] args) {
		HandlingBrowserCommands commands = new HandlingBrowserCommands();
		commands.initializeBrowser();
		commands.verifyCommands();
	}

}
