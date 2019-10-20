package webdriver;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class WebDriverSetup {
	
	private static final String LIB_DIR = System.getProperty("user.dir")
			+ File.separator + "lib" + File.separator;

	public static WebDriver setWebDriver(String browserName) {
		WebDriver driver;
		if ("CH".equals(browserName)) {
			driver = getChromeDriver();
		} else if ("FF".equals( browserName )) {
			driver = getFirefoxDriver();
		} else if ("IE".equals( browserName )) {
			driver = getInternetExplorerDriver();
		} else
			return null;
		return driver;
	}

	private static WebDriver getChromeDriver() {

		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", LIB_DIR + "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		ChromeOptions co = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put( "profile.default_content_setting_values.notifications", 2 );
		co.setExperimentalOption( "prefs", prefs );
		co.addArguments( "--start-maximized" );
		return new ChromeDriver( co );
	}
	
	private static WebDriver getFirefoxDriver() {
		if (PlatformUtil.isWindows()) {
			System.setProperty( "webdriver.gecko.driver", LIB_DIR + "geckodriver.exe" );
		}
		return new FirefoxDriver();
	}

	private static WebDriver getInternetExplorerDriver() {
		try {
			if (PlatformUtil.isWindows()) {
				System.setProperty( "webdriver.ie.driver", LIB_DIR + "IEDriverServer.exe" );
			}
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("nativeEvents", false);
			capabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//capabilities.setCapability("Ignore",InternetExplorerUnexpectedAlertBehavior.Ignore);
			capabilities.setCapability( CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			return new InternetExplorerDriver();
                    //InternetExplorerDriver(capabilities);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}
	
}
