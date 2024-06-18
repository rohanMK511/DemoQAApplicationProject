package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Objects_HomePage {
	
	WebDriver driver;
	
	public void selectElements() {
		driver.findElement(By.className("card mt-4 top-card"));
	}

}
