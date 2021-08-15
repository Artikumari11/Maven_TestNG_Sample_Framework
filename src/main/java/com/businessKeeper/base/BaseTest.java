package com.businessKeeper.base;

import com.businessKeeper.data.DataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest extends DataProvider {

    public static Logger log= LogManager.getLogger(BaseTest.class.getName());
    public static WebDriver driver;
    public static Properties property;
    private String url;
    private String browser;
    private String implicitTimeout;
    private String pageLoadTimeout;
    public static String userForLogin;
    public static String passwordForLogin;


    public BaseTest( )
    {
        // Loading properties
        try {
            property = new Properties();
            FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/config/config.properties");
            property.load(stream);
            browser = property.getProperty("browser");
            url = property.getProperty("url");
            implicitTimeout = property.getProperty("implicitTimeout");
            pageLoadTimeout = property.getProperty("pageLoadTimeout");
            userForLogin = property.getProperty("userForLogin");
            passwordForLogin = property.getProperty("passwordForLogin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setup()
    {

        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(pageLoadTimeout), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(implicitTimeout), TimeUnit.SECONDS);
        driver.get(url);
        log.info("**************************************************************************************");
        log.info("Opening browser..");

    }

    public void tearDown()
    {
        log.info("Closing browser..");
        driver.quit();
    }
}
