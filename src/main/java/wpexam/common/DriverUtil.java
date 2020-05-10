package wpexam.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class DriverUtil {
    public static WebDriver driver = null;

    public static void initializeDriver(){
        File chromeDrvr = new File(System.getProperty("user.dir"), "./browserdrv");
        File browserApp = new File(chromeDrvr, "chromedriver");
        System.setProperty("webdriver.chrome.driver", browserApp.getAbsolutePath());

        DriverUtil.driver = new ChromeDriver();
    }

    public static WebDriver getDriver(){
        return DriverUtil.driver;
    }

    public static void openApplicationUrl(){
        DriverUtil.driver.get(System.getProperty("appUrl"));
    }

    public static void quitTest(){
        DriverUtil.driver.quit();
        DriverUtil.driver = null;
    }

}
