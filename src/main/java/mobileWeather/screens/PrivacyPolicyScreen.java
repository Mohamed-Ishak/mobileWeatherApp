package mobileWeather.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileWeatherApp.utils.AndroidActions;

public class PrivacyPolicyScreen extends AndroidActions{

	public AndroidDriver driver;
	public PrivacyPolicyScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}
	
	@AndroidFindBy(id="com.info.weather.forecast:id/ll_got_it")
	private WebElement gotItBTN ;
	
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='While using the app']")
	public WebElement weatherAccessDeviceLocation ;
	
	public void clickOnGotITButton() {
		gotItBTN.click();
	}
	
	public void clickOnWhileUsingTheAppButton() {
		weatherAccessDeviceLocation.click();
	}
	
	

}
