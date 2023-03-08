package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//body")
	private WebElement url;

	public String getBody() {
		return url.getText();
	}
	

}
