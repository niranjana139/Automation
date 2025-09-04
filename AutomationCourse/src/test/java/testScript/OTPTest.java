package testScript;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumBasics.TestNgBase;

public class OTPTest extends TestNgBase{

 
    String testEmail = "t6628041@gmail.com";
    String emailPassword = "mjwf lmeu ovox avrh"; // Use Gmail app password
    
   

    @Test
    public void verifyOtpFlow() throws Exception {
        driver.navigate().to("https://testmail.app/");
        // Enter test email and click Send OTP
		/*
		 * WebElement emailTextBox=driver.findElement(By.xpath("//input[@id='email']"));
		 * signupElement.click();
		 */
		WebElement signinSpan=driver.findElement(By.xpath("//span[text()='Signin']"));
		signinSpan.click();
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@id='email']"));
        emailTextBox.sendKeys(testEmail);
        
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit' and @data-cy='continue-signin']"));
        signInButton.click();
        //WebElement otpTextBox=driver.findElement(By.xpath("//input[@id='verificationCode']"));

        // Wait 15 seconds for email to arrive
        Thread.sleep(15000);
		
		  // Fetch OTP from Gmail 
        	String otp = getOtpFromGmail();
        	WebElement otpTextBox = driver.findElement(By.id("code"));
        	otpTextBox.sendKeys(otp);
		    System.out.println("OTP Received: " + otp);
		  
		  // Enter OTP into the field driver.findElement(By.id("otp")).sendKeys(otp);
		  WebElement signinBtn= driver.findElement(By.xpath("//button[@data-cy='signin-button']//child::span[text()='Signin']"));
		  signinBtn.click();
		  
		  // Optional: Add assertion to verify success message Thread.sleep(3000);

		 String expectedURL="https://testmail.app/console/";
		 String actualURL=driver.getCurrentUrl();
		 Assert.assertEquals(actualURL, expectedURL,"Sign in is not success with OTP verification");
		 
    }

//Connects to the provided gmail inbox using imap. "store.connect" would connect to gmail inbox using mail id and app password.
    private String getOtpFromGmail() throws Exception {
        Properties props = new Properties();
        props.put("mail.store.protocol", "imaps");

        Session session = Session.getInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", testEmail, emailPassword);

        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        //Open the inbox in read only mode and get the messages in it
        Message[] messages = inbox.getMessages();
        for (int i = messages.length - 1; i >= 0; i--) {
            Message msg = messages[i];
            //if the message has given text, get its content and verify if given regex is matching the content and return it. 
            if (msg.getSubject().contains("Signin security code")) { // Optional: filter
                String content = getTextFromMessage(msg);
                Matcher matcher = Pattern.compile("\\b[A-Z0-9]{7}\\b").matcher(content);
                if (matcher.find()) return matcher.group();
            }
        }
        throw new Exception("OTP not found in email.");
    }

    
    private String getTextFromMessage(Message message) throws Exception {
		/*
		 * Multipurpose Internet Mail Extensions is a standard that tells email clients how to handle 
		 * different types of content in emails — not just plain text. 
		 * If the message is of text/plain format of MIME, directly get string.
		 * If messsage is multipart, get its plain text format and convert to string. 
		 */
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < mimeMultipart.getCount(); i++) {
                BodyPart part = mimeMultipart.getBodyPart(i);
                if (part.isMimeType("text/plain")) {
                    result.append(part.getContent());
                }
            }
            return result.toString();
        }
        return "";
    }
}
