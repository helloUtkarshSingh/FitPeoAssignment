package BaseClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;

public class InvokeBrowser extends BaseClass{

	//The constructor initializes the WebDriver instance for the FitPro_HomePage class.
	public FitPeo_HomePage NavigateHomePage(String URL) {
		if (driver != null) {
			driver.navigate().to(URL);;
		} else {
			throw new IllegalStateException("Driver is not initialized. Call Invokebrowser() first.");
		}
		return PageFactory.initElements(driver, FitPeo_HomePage.class);
	}
	
	public void CloseTheBrowser() {
		driver.close();
	}

}
