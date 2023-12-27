package mobileWeather.screens;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import mobileWeatherApp.utils.AndroidActions;


public class HomeScreen extends AndroidActions{

	
	public AndroidDriver driver;
	public HomeScreen(AndroidDriver driver) {
     super(driver);
     this.driver =driver;
     PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	

	
    @AndroidFindBy(id = "com.info.weather.forecast:id/iv_bt_navigation_setting")
    private WebElement settingBTN ;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='°C']")
	private WebElement celsiusSign;

	@AndroidFindBy(id = "com.info.weather.forecast:id/tv_date")
	private WebElement timeAndDateTxt ;
	
	
	@AndroidFindBy(id="com.info.weather.forecast:id/ll_hourly_info_list")
	private WebElement housrsInfoList ;
	
	@AndroidFindBy(id="com.info.weather.forecast:id/ll_hour_root_container")
	private List<WebElement> housrsContainer ;
	
	
    @AndroidFindBy(xpath ="//android.widget.LinearLayout[@index='2']")
    private WebElement swipRainAndHumidityIcon; 
	
	@AndroidFindBy(id="com.info.weather.forecast:id/iv_rain_chance")
	private List<WebElement> rainChanceIcon;
	
	@AndroidFindBy(id="com.info.weather.forecast:id/ll_humidity")
	private WebElement humidityIcon;
	
	
	//
	
	@AndroidFindBy(className = "android.widget.LinearLayout")
	private List<WebElement> classNameIcons ;
	
	
	@AndroidFindBy(id = "com.info.weather.forecast:id/iv_rain_chance")
	private WebElement rainChanceIcons ;
	
	@AndroidFindBy(xpath = "(//android.widget.LinearLayout)[10]")
	private WebElement tste ;
	
	
	
	
	@AndroidFindBy(id = "com.info.weather.forecast:id/scroll_view24_hour")
	private WebElement view24Hours;
	
	public void clickingSettingButton() {
		waitForMobileElementToAppear(settingBTN, driver);
		settingBTN.click();
	}
	
    public boolean checkThatCelsiusSignIsDisplayed() {
    	return celsiusSign.isDisplayed();
    }
    
    public String getCurrentDisplayedTime() {
    	String timeAndDate = timeAndDateTxt.getText();
    	String time =timeAndDate.substring(0, 5);
    	
    	return time ;
    }
    
    public int gethoursContainer() {
    	
    	for (int i = 0; i < housrsContainer.size(); i++) {
    		waitForMobileElementToAppear(housrsContainer.get(i), driver);
    		if(housrsContainer.get(4).isDisplayed()) { 
    		swipeAction(housrsContainer.get(5), "left");
    		break;
    		}
		}
    
    	return housrsContainer.size();
    }
    
    
    
    public void scrollToLeft() {
    	scrollToEndAction("left");
    }
    
    public void swipeToLeft() {
    	waitForMobileElementToAppear(housrsInfoList, driver);
    	swipeAction(housrsInfoList,"left" );
    }
    
    public int scrollAndGetIconsListSize() {
    	if(rainChanceIcon.size()==5) {
    		scrollByGoogleEngin(rainChanceIcon.get(5));
    	}
    		
    	return classNameIcons.size();
    }
    
//    public void getIndex() {
//    	for (WebElement element : rainChanceIcon) {
//		   
//		}
// }
    
    
//    public void swipe() {
//    	swipeAction(housrsContainer., "left");
//    }
    
    
    public boolean nextOneIsDisplayed() {
    	return tste.isDisplayed();
    }

}
