package mobileWeather.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileWeatherApp.utils.AndroidActions;

public class LandingScreen extends AndroidActions{
   public AndroidDriver driver;
	public LandingScreen(AndroidDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.info.weather.forecast:id/tv_button_done")
	private WebElement doneBTN ;
	
	public void clickingDoneButton() {
		doneBTN.click();
	}

}
