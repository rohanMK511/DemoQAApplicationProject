package RegressionTests;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC001_LaunchTheApplicationAndClickOnAllTheLinks {
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/");
		
		// Step1 : ToolsQA image refreshes the page when clicked.
		//driver.findElement(By.cssSelector("img[src='/images/Toolsqa.jpg']")).click();
		//Thread.sleep(2000);

		//Updated Comments on 22/06/2024
		// Step2 : Click on the Selenium Training image on the HomePage.
		//Store the current window into variable orginalWindow
		String originalWindow = driver.getWindowHandle();
		//Click on the Selenium Training Link image
		WebElement trainingLink = driver.findElement(By.cssSelector("img[alt*='Training']"));
		trainingLink.click();
		//Use Set interface to store all the window elements
		Set<String> SeleniumTraining = driver.getWindowHandles();
		//Iterate through all the Windows opened in the browser
		for (String seleniumTraining : SeleniumTraining)
		{
			//Check the condition for the original window
			if(!seleniumTraining.equals(originalWindow))
			{
				//If original window is not equal to the Set values then switch to the Clicked link
				driver.switchTo().window(seleniumTraining);
				//driver.close();
				//break;
			}
		}
		Thread.sleep(2000);
		//Switch back to the Original window
		driver.switchTo().window(originalWindow);
		
		// Step3 : Click on the Elements option from the Home page
		driver.findElement(By.cssSelector("div.top-card:nth-child(1)")).click();
		String elementsURL = driver.getCurrentUrl();
		System.out.println(elementsURL);
		Assert.assertEquals(elementsURL, "https://demoqa.com/elements");
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		//List all the cards available on the Home page
		List<WebElement> alltheCards = driver.findElements(By.cssSelector("div.card"));
		System.out.println(alltheCards.size());
		
		for(int i = 0 ; i < alltheCards.size() ; i++) {
			alltheCards.get(i).click();
			driver.navigate().back();
			Thread.sleep(2000);
		}
		
		//alltheCards.get(0).click();
			
	
		Thread.sleep(2000);
		driver.quit();
	}

}
