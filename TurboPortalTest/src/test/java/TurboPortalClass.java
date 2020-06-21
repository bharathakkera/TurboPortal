
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TurboPortalClass {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@BeforeTest
	public void createAccount() {
		
		
		

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://portal.turbohire.co");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				
	}	

	@Test(priority = 1)
	 public void LoginTurbo() {
	    
	  
		  driver.findElement(By.xpath("//input[@type = 'email']")).sendKeys("qatest@turbohire.co");
		  driver.findElement(By.xpath("//span[@class = 'MuiButton-label-171']")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		  driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Turbohire01!");
		  driver.findElement(By.xpath("//span[@class = 'MuiButton-label-171']")).click(	  );
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 
	 @Test(priority = 2)
	public void createJob() throws AWTException, InterruptedException {
		
		Actions act = new Actions(driver);
		//Clicking on New Job button	
		  driver.findElement(By.xpath("//span[contains(text(),'New Job')]")).click();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Enter JobName
		  driver.findElement(By.xpath("//input[@id = 'job-name']")).sendKeys("Test_Haritha_TP1");
		  
		//Enter New Department========================= 
		  //
		  String parentWindowHandlerP =  driver.getWindowHandle(); // save ID parent 
		  String subWindowHandlerP = null;
			  
		  driver.findElement(By.xpath("//div[@title='Add new department']")).click();
			  
		  Set<String> handlesP = driver.getWindowHandles(); // get all windows
		  
		  Iterator<String> iteratorP = handlesP.iterator(); 
		  
		  while (iteratorP.hasNext())
		  { subWindowHandlerP = iteratorP.next(); }
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // popup operations //
		  			
		  driver.findElement(By.xpath(
			  "/html[1]/body[1]/div[4]/div[3]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]"
			  )).sendKeys("ComputerScience");
		  driver.findElement(By.xpath("//span[contains(text(),'Add')]")).click();
			  
		  driver.switchTo().window(parentWindowHandlerP); // back to parent window
		  
		  Thread.sleep(3000);
		  act.sendKeys(Keys.TAB).build().perform();	
		  act.sendKeys(Keys.TAB).build().perform();	
		  act.sendKeys(Keys.TAB).build().perform();	
		  act.sendKeys(Keys.TAB).build().perform();	
			  
		//=======================================
		  
		 //Selection of Department - Random value - code has be finetuned to select just created department 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  act.sendKeys(Keys.TAB).build().perform();	
		  act.sendKeys(Keys.TAB).build().perform();	
		  Thread.sleep(1000);
		  act.sendKeys(Keys.ARROW_DOWN).build().perform();
		  act.sendKeys(Keys.ARROW_DOWN).build().perform();
		  act.sendKeys(Keys.RETURN).build().perform();
		  
		 		  
			 			 		  
		//Hide from Job seekers check box 
		driver.findElement(By.xpath("//input[@name='hideClientName']")).click();
		  
		//My job description
		driver.findElement(By.xpath("//div[@class= 'public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).click();
		driver.findElement(By.xpath("//div[@class= 'public-DraftStyleDefault-block public-DraftStyleDefault-ltr']")).
		  				sendKeys("my job description");
		
		
		//Scrolling down to Role and Resp
		WebElement element = driver.findElement(By.xpath("//div[@class= 'demo-editor rdw-editor-main']"));
		  
		((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView();", element);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  
		  
		//My role and Responsibilities
		
		act.sendKeys(Keys.TAB).build().perform();		
		act.sendKeys(Keys.TAB).build().perform();		
		act.sendKeys(Keys.TAB).build().perform();		
		act.sendKeys(Keys.RETURN).build().perform();
		Thread.sleep(2000);
		  
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[2]/div[3]/div[1]/form[1]/"
				+ "div[5]/"
		  		+ "div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).
		  		sendKeys("my roles and Responsibilities");
		 
		//My eligibility
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[2]/div[3]/div[1]/form[1]/"
				+ "div[6]/"
				+ "div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).
		  		sendKeys("my eligibility");
		
		//Enter Location
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Location']")).sendKeys("Vishakha");
		Thread.sleep(4000);		
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();
		
		//Experience
		driver.findElement(By.xpath("//input[@id='minExperience']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='maxExperience']")).sendKeys("2");
		
		//Skills
		driver.findElement(By.xpath("//input[@placeholder='Type and Enter to add, Example: Program Management, Java, C++']"))
		.sendKeys("Selenium Automation");
		Thread.sleep(1000);
		
		//Compensation
		driver.findElement(By.xpath("//input[@id='minCompensation']")).sendKeys("3,50,000");
		driver.findElement(By.xpath("//input[@id='maxCompensation']")).sendKeys("4,00,000");
		driver.findElement(By.xpath("//input[@name='salaryNegotiable']")).click();
		
		//About Company Details
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.RETURN).build().perform();
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/div[2]/div[3]/div[1]/form[1]/div[11]/div[1]"
				+ "/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).
				sendKeys("My previous company - Innocore");
		Thread.sleep(1000);
		
		//Clicking Next
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		  	 
		
	  }
	
	 @Test(priority = 3)
	 public void workflow() throws InterruptedException {
		 
		 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		 Thread.sleep(1000);
	 }
	
	 @Test(priority = 4)
	 public void candidateCalib() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@value = 'Graduate']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@value = 'Tier 1 Institutions']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@value = 'Engineering']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@value = 'Startups and Unicorns']")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//input[@value = 'Software Quality Assurance']")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//button[@id='button-next']")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 @Test(priority = 5)
	 public void Collaborate() throws InterruptedException {
		 
		 driver.findElement(By.xpath("//input[@class='jss1057']")).click();
		 Thread.sleep(500);
		 driver.findElement(By.xpath("//span[contains(text(),'Create Job')]")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	 }
	 
	 @Test(priority = 6)
	 public void PromoteJob() {
	 
		 driver.findElement(By.xpath("//span[contains(text(),'Promote Job')]")).click();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 }
	 
	 

}

