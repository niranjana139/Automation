package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingWebElementCommands extends Base{

	public void verifyCommands() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement msgBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		//SendKeys used to give a text to the text boxes via code
		msgBox.sendKeys("Niranjana");
		//Click
		WebElement btn = driver.findElement(By.xpath("//button[@id='button-one']"));
		btn.click();
		
		WebElement msgText = driver.findElement(By.xpath("//div[@id=\'message-one\']"));
		//Prints  message of the textbox
		System.out.println(msgText.getText());
		//Prints the CSS value of element
		System.out.println(msgText.getCssValue("background-color"));
		msgBox.clear();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingWebElementCommands web = new HandlingWebElementCommands();
		web.initializeBrowser();
		web.verifyCommands();
	}

}
