package seleniumBasics;

public class HandlingBrowserCommands extends Base{
	
	
	public void verifyCommands() {
		//Gets the title of webpage in console
		String title = driver.getTitle();
		System.out.println(title);
		//Gets the URL of page in console
		String url = driver.getCurrentUrl();
		System.out.println(url);
		//Gets the Id of window in the session. getWindowHandles() return a set of ID for each windows in the session
		String handleId = driver.getWindowHandle();
		System.out.println(handleId); 
		//Gets the sourcecode of webpage
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	public static void main(String[] args) {
		HandlingBrowserCommands commands = new HandlingBrowserCommands();
		commands.initializeBrowser();
		commands.verifyCommands();
	}

}
