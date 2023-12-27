package mobileWeather.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileWeatherApp.utils.AndroidActions;


public class SettingsScreen extends AndroidActions{

	AndroidDriver driver ;
	public SettingsScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(id = "com.info.weather.forecast:id/ll_item_unit_setting")
	private WebElement unitSettingBTN;
	
	@AndroidFindBy(id = "com.info.weather.forecast:id/iv_temp_dropdown")
	private WebElement tempDropDown;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='C']")
	WebElement celsiusOption;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='F']")
	WebElement fehrinhiteOption;
	
	@AndroidFindBy(id = "com.info.weather.forecast:id/iv_timeformat_dropdown")
	private WebElement timeFormatDropDown;
	
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='24 Hour']")
	WebElement twentyFourTimeFormatOption;
	
	@AndroidFindBy(xpath ="//android.widget.TextView[@text='12 Hour']")
	WebElement twelveTimeFormatOption;
	
	public void clickingOnUnitSettingButton() {
		unitSettingBTN.click();
	}
	
	public void clickingOnTempDropDown() {
		tempDropDown.click();
	}
	
	public void clickingOnCelsiusOption() {
		celsiusOption.click();
	}
	
	public void clickingOnFehrinhiteOption() {
		fehrinhiteOption.click();
	}
	
	public void clickingOnTimeFormatDropDown() {
		timeFormatDropDown.click();
	}
	
	public void clickingOnTwentyFourTimeFormatOption() {
		twentyFourTimeFormatOption.click();
	}
	
	public void clickingOnTwelveTimeFormatOption() {
		twelveTimeFormatOption.click();
	}
	
}
