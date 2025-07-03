package seleniumBasics;

import org.openqa.selenium.By;

public class HandlingLocators extends Base {

	public void verifyLocators() {
		//Locate an element with id, class name, tagname
		driver.findElement(By.id("button-one"));
		driver.findElement(By.className("btn btn-primary"));
		driver.findElement(By.tagName("button"));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingLocators locators = new HandlingLocators();
		locators.initializeBrowser();
		locators.verifyLocators();
	}

}
