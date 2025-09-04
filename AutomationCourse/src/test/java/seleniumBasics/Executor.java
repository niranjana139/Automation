package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Executor extends Base{
	
	public void verifyJavascriptExecutor() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", showMessageButton);
		js.executeScript("window.scrollBy(0,200)", "");
		//js.executeScript("window.scrollBy(0,0)", "");		//System.out.println(js.executeScript("return window.pageYOffset"));
		//js.executeScript("window.scrollBy(200,300)", "");
		js.executeScript("window.scrollTo(0,0)", "");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)", "");
		//js.executeScript("window.scrollTo(200,300)", "");
		System.out.println(js.executeScript("return window.pageYOffset"));
	
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Executor executor=new Executor();
		executor.initializeBrowser();
		executor.verifyJavascriptExecutor();
	}

}
