package wpexam.common.pageobjects;

import org.openqa.selenium.WebDriver;
import wpexam.common.BasePage;
import wpexam.common.LocatorWrapper;

public class HomePage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper KIWISAVER_LINK = new LocatorWrapper("KiwiSaver Link", "KiwiSaver", LocatorWrapper.LocatorType.LINKTEXT);
    private static LocatorWrapper KIWISAVER_CALC = new LocatorWrapper("KiwiSaver Calculators", "KiwiSaver calculators", LocatorWrapper.LocatorType.LINKTEXT);

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openKiwiSaverRetirementCalculator(){
        hoverToElement(KIWISAVER_LINK);
        findElementWhenPresent(KIWISAVER_CALC).click();
        new WpKiwiSaverPage(driver).openKWSRetirementCalc();
    }
}
