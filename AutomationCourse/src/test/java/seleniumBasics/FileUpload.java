package seleniumBasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUpload extends Base{
	
	public void fileUploadUsingSendKeys() {
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement choose = driver.findElement(By.id("uploadfile_0"));
		choose.sendKeys("C:\\Users\\Netcom\\Desktop\\Niranjana Obsqura\\git\\Automation\\AutomationCourse\\src\\test\\resources\\Xyz.pdf");
		WebElement terms = driver.findElement(By.id("terms"));
		terms.click();
		WebElement submit=driver.findElement(By.id("submitbutton"));
		submit.click();
	}
	
	public void fileUploadUsingRobotClass() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement upload = driver.findElement(By.id("pickfiles"));
		upload.click();
		StringSelection selection =  new StringSelection("C:\\Users\\Netcom\\Desktop\\Niranjana Obsqura\\git\\Automation\\AutomationCourse\\src\\test\\resources\\Xyz.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot= new Robot();
		//For handling the operating time and no error occur
		robot.delay(2500);
		robot.keyPress (KeyEvent.VK_ENTER);
		robot.keyRelease (KeyEvent.VK_ENTER);
		robot.keyPress (KeyEvent.VK_CONTROL);
		robot.keyPress (KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress (KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	public static void main(String[] args) {
		FileUpload upload=new FileUpload();
		upload.initializeBrowser();
		upload.fileUploadUsingSendKeys();
		try {
			upload.fileUploadUsingRobotClass();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
