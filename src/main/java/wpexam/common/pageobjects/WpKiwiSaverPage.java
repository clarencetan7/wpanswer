package wpexam.common.pageobjects;

import org.openqa.selenium.WebDriver;
import wpexam.common.BasePage;
import wpexam.common.LocatorWrapper;

public class WpKiwiSaverPage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper KIWISAVER_RET_CALC = new LocatorWrapper("KiwiSaver Retirement Calc Link", "KiwiSaver Retirement Calculator", LocatorWrapper.LocatorType.LINKTEXT);

    public WpKiwiSaverPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openKWSRetirementCalc(){
        findElementWhenPresent(KIWISAVER_RET_CALC).click();
    }

}
