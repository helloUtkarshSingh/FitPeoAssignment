package BaseClass;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Revenue_CalculatorPage extends BaseClass {

	public Revenue_CalculatorPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "(//img[@class='MuiBox-root css-imh8r1']/parent::div/child::div/span)[2]")
	WebElement scrollTillVisible;

	@FindBy(xpath = "//input[@aria-orientation='horizontal']")
	WebElement slider;

	@FindBy(xpath = "//input[@type='number']")
	WebElement textbox;

	@FindBy(xpath = "//div[@class='MuiBox-root css-1eynrej']")
	List<WebElement> total_CTP_Codes;

	@FindBy(xpath = "//header//p[starts-with(text(),'Total Recurring')]/p")
	WebElement header;

	//Scrolls the page until the textbox is in view.
	public void Scroll_Untill_Revenue_Calculator_Slider() throws InterruptedException {
		scrollToElement(scrollTillVisible);

	}

	//Adjusts the slider to a specific position.
	public String Adjust_slider_to_set_value() throws InterruptedException {

		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 94, 0).perform();
		String value = textbox.getAttribute("value");
		System.out.println(value);
		return value;

	}

	//Manually sets a value in the textbox and validates it against the slider.
	public String Enter_Value_TextBox(String value) {

		textbox.click();

		Actions actions = new Actions(driver);
		actions.sendKeys("\u0008").sendKeys("\u0008").sendKeys("\u0008").perform();

		textbox.sendKeys(value);

		String actual_value = slider.getAttribute("value");
		System.out.println(actual_value);
		return actual_value;

	}

	
	//Selects valid CPT codes by interacting with their corresponding checkboxes.
	public void Select_CPT_Codes() throws InterruptedException {
		
		List<String> validCPTCodes = Arrays.asList("CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474");

		for (WebElement webElement : total_CTP_Codes) {
			String cptCode = webElement
					.findElement(By.xpath(".//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']"))
					.getText();

			if (validCPTCodes.contains(cptCode)) {
				System.out.println("Found CPT Code: " + cptCode);
				WebElement checkbox = webElement.findElement(By.xpath(".//label//input[@type='checkbox']"));
				checkbox.click(); // Perform the click on the checkbox
				Thread.sleep(2000); 

			}
		}

	}

	// 50-529,60-596,90-796 100-863 94-823
	public String validate_the_header() {
		String ammount = header.getText();
		return ammount;
	}
}
