package RegressionTests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC002_NavigateThroughAlltheCards_HomePage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/");
		
		List<WebElement> alltheCards = driver.findElements(By.cssSelector("div.card-up"));
		System.out.println(alltheCards.size());
				
		JavascriptExecutor js = (JavascriptExecutor) driver;
		/*
		for(int i = 0 ; i < alltheCards.size(); i++) {
			js.executeScript("window.scrollBy(0,250)", "");
			alltheCards.get(i).click();
			driver.navigate().back();
			Thread.sleep(2000);
		}
		*/

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
		driver.switchTo().window(parent);
		
		
		js.executeScript("arguments[0].scrollIntoView();", alltheCards);
		
		alltheCards.get(5).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
