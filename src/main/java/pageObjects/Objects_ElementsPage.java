package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Objects_ElementsPage {

	@FindBy(xpath="//li[@id='item-0']")
	WebElement textBox;
	
	public void textBoxClick() {
		textBox.click();
	}
}
