package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FitPeo_HomePage extends BaseClass {
	
	/*
	 * The FitPro_HomePage class represents the homepage of the FitPro application
	 * in a Page Object Model (POM) design. It includes methods to interact with
	 * elements on the homepage and navigate to other pages within the application.
	 */
	
	//The constructor initializes the WebDriver instance for the FitPro_HomePage class.
	public FitPeo_HomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//div[contains(text(),'Revenue')]")
	WebElement revenueCalculatorLink;

	//This method clicks on the "Revenue Calculator" link and navigates to the Revenue Calculator Page.
	public Revenue_CalculatorPage navigate_Revenue_Calculator_Page() {
		revenueCalculatorLink.click();
		return PageFactory.initElements(driver, Revenue_CalculatorPage.class);

	}

}
