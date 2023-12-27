package mobileWeatherApp.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import mobileWeather.screens.LandingScreen;
import mobileWeatherApp.utils.AppiumUtils;

public class AndroidBaseTest extends AppiumUtils{

	
		public AndroidDriver driver ;
		public AppiumDriverLocalService service;
		LandingScreen landingScreen ;
		
		@BeforeClass(alwaysRun = true)
		public void setup() throws IOException {
			Properties prop = new Properties();
		    FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\mobileWeatherResources\\data.properties");
			prop.load(stream);
			String ipAddress = System.getProperty("ipAddress")!= null ? System.getProperty("ipAddress"): prop.getProperty("ipAddress");
			String port = System.getProperty("portNumber") ;
			service = startAppiumServer(ipAddress,4723);
			
			UiAutomator2Options options = new UiAutomator2Options();
			options.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PlatformName"));
			options.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("AndroidDeviceName"));
			options.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("AndroidPlatformVersion"));
			options.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.info.weather.forecast");
			options.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.info.weather.forecast.activity.SettingUnitActivity");
			
			
			
			driver = new AndroidDriver(service.getUrl(),options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			landingScreen = new LandingScreen(driver);
			landingScreen.clickingDoneButton();
			
		}
		
		
		@AfterClass(alwaysRun = true)
		public void tearDown() {
			if(driver != null) {
				driver.quit();
				service.close();
			}
		}
	}

