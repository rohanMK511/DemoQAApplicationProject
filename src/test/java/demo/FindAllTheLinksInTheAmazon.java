package demo;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Streams;

import dev.failsafe.internal.util.Durations;

public class FindAllTheLinksInTheAmazon {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		/*
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		
		for(WebElement link : links) {
			System.out.println("Text of the Link : "+link.getText()+" : And URL is : "+ link.getAttribute("href"));
		}
		*/
		
		Set<String> set = new HashSet<String>();
		set.add("Rohan");
		set.add("Priya");
		//set.addAll(set);
		System.out.println(set);
		
		Map<String, String> key = new HashMap<String, String>();
		key.put("Roll Number", "1");
		key.put("Name", "Rohan");
		System.out.println(key);
		
		List<WebElement> navBar = driver.findElements(By.cssSelector("a.nav-a  "));	
		System.out.println(navBar.size());
		/*
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(null));
		*/
		driver.quit();

	}

}
