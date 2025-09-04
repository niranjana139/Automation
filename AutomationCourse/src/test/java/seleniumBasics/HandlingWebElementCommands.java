package seleniumBasics;

import java.time.Duration;
import java.util.NoSuchElementException;

//import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElementCommands extends Base{

	public void verifyCommands() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement msgBox = driver.findElement(By.xpath("//input[@id='single-input-field']"));
		//SendKeys used to give a text to the text boxes via code
		msgBox.sendKeys("Niranjana");
		//Simulates click action
		WebElement btn = driver.findElement(By.xpath("//button[@id='button-one']"));
		System.out.println(btn.isDisplayed());
		System.out.println(btn.isEnabled());
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		//Fluent Wait
		Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(btn));
		
		btn.click();
		
		WebElement msgText = driver.findElement(By.xpath("//div[@id='message-one']"));
		
		//Prints  message displayed
		System.out.println(msgText.getText());
		//Prints the tag name of the element
		System.out.println(msgText.getTagName());
		//Prints the value of attribute specified.
		System.out.println(msgText.getAttribute("id"));
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
