package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFrames extends Base{
	
	public void handleFrames() {
		driver.navigate().to("https://demoqa.com/frames");
		//findElements 
		List<WebElement>totalFrames= driver.findElements(By.tagName("iframe"));
		//Returns total number of frames
		System.out.println(totalFrames.size());
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@id='frame1']"));
		//Takes the control to frameElement
		driver.switchTo().frame(frameElement);
		WebElement heading=driver.findElement(By.id("sampleHeading"));
		System.out.println(heading.getText());
		//takes the control back to the initial point
		driver.switchTo().defaultContent();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HandlingFrames frames =  new HandlingFrames();
		frames.initializeBrowser();
		frames.handleFrames();
	}

}
