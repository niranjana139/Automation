package seleniumBasics;

import org.openqa.selenium.By;

public class HandlingLocators extends Base {

	public void verifyLocators() {
		
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		//Locate an element with id, class name, tagname etc
		driver.findElement(By.id("button-one"));
		
		//driver.findElement(By.className("btn btn-primary"));
		
		driver.findElement(By.tagName("button"));
		
		driver.findElement(By.name("viewport"));
		
		driver.findElement(By.linkText("Simple Form Demo"));
		
		driver.findElement(By.partialLinkText("Simple"));
		
		driver.findElement(By.cssSelector("button[id='button-one']"));
		
		driver.findElement(By.xpath("//button[@id='button-one']"));
		driver.findElement(By.xpath("//button[text()='Get Total']"));

		driver.findElement(By.xpath("//button[starts-with(text(),'Show ')]"));
		
		
		//Combine more than 1 attribute to get 1 of 1 for xpath written
		driver.findElement(By.xpath("//button[@id='button-one' and @type='button']"));
		driver.findElement(By.xpath("//button[@id='button-one' or @id='button-one-electronics']"));
		
		//xPath access using parent
		driver.findElement(By.xpath("//div[contains (text(), 'Single Input Field')]//parent::div[@class='card']"));
		//xPath access using child
		driver.findElement(By.xpath("//div[@class='card']//child::button[@id='button-one']"));
		//xPath access using following
		driver.findElement(By.xpath("//button[@id='button-one']//following::div[@class='card']"));
		//xPath access using Preceeding
		driver.findElement(By.xpath("//button[@id='button-one']//preceding:: div[@class='card']"));
		//xPath access using Descendant
		driver.findElement(By.xpath("//div[@class='card']//descendant::div"));
		
		
	}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingLocators locators = new HandlingLocators();
		locators.initializeBrowser();
		locators.verifyLocators();
	}

}
