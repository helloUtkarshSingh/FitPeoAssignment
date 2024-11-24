package TestClass;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BaseClass.FitPeo_HomePage;
import BaseClass.InvokeBrowser;
import BaseClass.Revenue_CalculatorPage;

public class End2EndFlow {

	InvokeBrowser invokebrowser = new InvokeBrowser();
	FitPeo_HomePage fitPro_homePage;
	Revenue_CalculatorPage revenue_calculatorPage;

	@BeforeSuite
	public void Open_Web_Browser_and_Navigate_To_URL() {
		invokebrowser.Invokebrowser("Chrome");
		fitPro_homePage = invokebrowser.NavigateHomePage("https://www.fitpeo.com");
	}

	@Test(priority = 1)
	public void Navigate_To_Revenue_Calculator_Page() throws InterruptedException {

		revenue_calculatorPage = fitPro_homePage.navigate_Revenue_Calculator_Page();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void Scroll_Untill_Revenue_Calculator_Slider() throws InterruptedException {
		revenue_calculatorPage.Scroll_Untill_Revenue_Calculator_Slider();

	}

	@Test(priority = 3)
	public void Adjust_N_Validated_slider_to_value() throws InterruptedException {
		String actual_Value = revenue_calculatorPage.Adjust_slider_to_set_value();
		Assert.assertEquals(actual_Value, "823");
	}

	@Test(priority = 4)
	public void Enter_N_Validated_value_TextBox() throws InterruptedException {
		String actual_Value = revenue_calculatorPage.Enter_Value_TextBox("560");
		Assert.assertEquals(actual_Value, "560");

	}

	@Test(priority = 5)
	public void Select_CPT_Codes_N_Validate() throws InterruptedException {
		
		revenue_calculatorPage.Select_CPT_Codes();
		//revenue_calculatorPage.Adjust_slider_to_set_value();
		String acutal_value = revenue_calculatorPage.validate_the_header();
		System.out.println(acutal_value);
		Assert.assertEquals(acutal_value, "$75600");
	}
	
	@AfterSuite
	public void CloseBrowser() {
		invokebrowser.CloseTheBrowser();
	}

}
