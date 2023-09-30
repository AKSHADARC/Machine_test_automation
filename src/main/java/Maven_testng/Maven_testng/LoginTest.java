package Maven_testng.Maven_testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

import javax.swing.JOptionPane;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	private WebDriver driver;
	int waitDurationInSeconds = 10;
	@BeforeMethod
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sonpari\\Desktop\\sejar\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	      driver  = new FirefoxDriver();
	      
	      driver.manage().window().maximize();
   }
	@Test
	
	@Parameters({"Email_id","password"})
	
	public void login(String Email_id , String password) throws InterruptedException{  //String Email_id , String password
	// Navigate to the login page
    driver.get("https://testffc.nimapinfotech.com/auth/login");
    
 // Perform login actions (e.g., enter email id and password)
    WebElement usernameField = driver.findElement(By.xpath("//input[@id='mat-input-0']")); // Locate the username input field
    WebElement passwordField = driver.findElement(By.xpath("//input[@id='mat-input-1']")); // Locate the password input field
   

    usernameField.sendKeys(Email_id); // Enter the provided eMAILID
    passwordField.sendKeys(password); // Enter the provided password
 
 
    
 // Show the JOptionPane dialog
    Thread t = new Thread(() -> {
        JOptionPane.showMessageDialog(null, "Please solve the CAPTCHA manually and click OK to continue...");
    });
    
 // Add a delay to give time to enter CAPTCHA manually
    try {
        Thread.sleep(30000); // Wait for 30 seconds (adjust as needed)
    } 
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }

 
      // Find the Sign In button and click it
     WebElement signInButton = driver.findElement(By.id("kt_login_signin_submit"));
      signInButton.click();
	
	
		WebDriverWait dashboardWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement dashboardElement = dashboardWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dashboard-element-id")));
		

      // Perform actions on the dashboard
//      WebElement PunchIn = driver.findElement(By.cssSelector(".buttonData > div:nth-child(2)"));
//      PunchIn.click();
      
   // Wait for the Toast/Popup message to appear
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//      WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='toast-message']")));
//  
//	// Get the text of the Toast/Popup message
//      String message = toastMessage.getText();
//
//      // Assert or verify the message as needed
//      if (message.equals("Expected Toast Message")) {
//          System.out.println("Toast Message is Correct: " + message);
//      } else {
//          System.out.println("Toast Message is Incorrect: " + message);
//      }

   

//  FIND A CUSTOMER
      WebElement customer = driver.findElement(By.cssSelector(".kt-menu__item--active > a:nth-child(1) > span:nth-child(2)"));
      customer.click();
      
//      Add new customer
	WebElement addCustomer = driver.findElement(By.xpath("//button[@mattooltip='Create new customer']"));
	addCustomer.click();
	
// enter customer name
	WebElement customerName = driver.findElement(By.id("mat-input-36"));
	customerName.sendKeys("abc");
	 customerName.click();

//	 click on save
	 WebElement savebt = driver.findElement(By.cssSelector("div.text-right:nth-child(1) > div:nth-child(1) > button:nth-child(2) > div:nth-child(2)"));
	 savebt.click();
}
	
	

	@AfterMethod
	@AfterTest
      public void tearDown() {
    	driver.quit();
      }
   
	
}
     



