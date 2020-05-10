package wpexam.common.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wpexam.common.BasePage;
import wpexam.common.Helper;
import wpexam.common.Helper.*;
import wpexam.common.LocatorWrapper;

import java.util.ArrayList;
import java.util.List;

public class WpKiwiSaverRetirementCalcPage extends BasePage {
    private WebDriver driver = null;

    private static LocatorWrapper INFO_ICONS =
            new LocatorWrapper("Information Icons", "//div[@class='field-group-set-frame']/div[starts-with(@class,'wpnib-field')]/.//button/i", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper CALC_IFRAME =  new LocatorWrapper("Calculator Frame", "div#calculator-embed iframe", LocatorWrapper.LocatorType.CSS);
    private static LocatorWrapper CURRENT_AGE_INFO = new LocatorWrapper("Current age information", "//div[@help-id='CurrentAge']/.//p", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper CURRENT_AGE_IP = new LocatorWrapper("Current age input", "//div[@help-id='CurrentAge']/.//input", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper EMPL_STAT_DD = new LocatorWrapper("Current age input", "//div[@help-id='EmploymentStatus']/.//div[@class='control-well']", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper CURRENT_AGE_LABEL = new LocatorWrapper("Current age label", "//label[text()='Current age']", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper ANNUAL_INC_IP = new LocatorWrapper("Current age input", "//div[@help-id='AnnualIncome']/.//input", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper PIR_DD = new LocatorWrapper("Current age input", "//div[@help-id='PIRRate']/.//div[contains(@class,'well-value')]", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper COMPUTE_BTN = new LocatorWrapper("View your KiwiSaver button", "//button[contains(@class,'btn-has-chevron')]", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper RESULT_TITLE = new LocatorWrapper("KiwiSaver calculation result title", "//div[@class='results-header']/.//span[contains(@class,'result-title')]", LocatorWrapper.LocatorType.XPATH);
    private static LocatorWrapper RESULT_VALUE = new LocatorWrapper("KiwiSaver calculation result value", "//div[@class='results-header']/.//span[contains(@class,'result-value')]", LocatorWrapper.LocatorType.XPATH);

    public WpKiwiSaverRetirementCalcPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void moveToCalculatorContent(){
        driver.switchTo().frame(findElementWhenVisible(CALC_IFRAME));
    }

    public List<WebElement> getInformationIcons(){
        moveToCalculatorContent();
        return findElementsWhenPresent(INFO_ICONS);
    }

    public String openCurrentAgeInformation(){
        getInformationIcons().get(0).click();
        return findElementWhenPresent(CURRENT_AGE_INFO).getText();
    }

    public List<String> setEmployedCalculatorInputs(String age, EmploymentStatus stat, String annualInc, KiwiSaverContrib contrib, PIRPercentage pirOpt, RiskProfile riskPro){
        List<String> resultingCalculation = new ArrayList<String>();
        moveToCalculatorContent();
        Helper.sleepInMillis(1500);
        findElementWhenPresent(CURRENT_AGE_IP).sendKeys(age);
        findElementWhenVisible(CURRENT_AGE_LABEL).click();
        findElementWhenVisible(EMPL_STAT_DD).click();
        setEmploymentStatus(stat);
        findElementWhenVisible(ANNUAL_INC_IP).sendKeys(annualInc);
        findElementWhenVisible(CURRENT_AGE_LABEL).click();
        setKiwiSaverContribution(contrib);
        findElementWhenVisible(PIR_DD).click();
        setPIRPercentageRate(pirOpt);
        findElementWhenVisible(CURRENT_AGE_LABEL).click();
        setRiskProfile(riskPro);
        scrollIntoView(COMPUTE_BTN);
        Helper.sleepInMillis(200);
        findElementWhenPresent(COMPUTE_BTN).click();
        resultingCalculation.add(findElementWhenVisible(RESULT_TITLE).getText());
        resultingCalculation.add(findElementWhenVisible(RESULT_VALUE).getText().replaceAll("\\n", ""));
        return resultingCalculation;
    }

    protected void setEmploymentStatus(EmploymentStatus stat){
        LocatorWrapper employmentStatusSelect = null;
        switch(stat){
            case EMPLYD:
                employmentStatusSelect =
                        new LocatorWrapper("Employed selection", employmentStatusSelect("Employed"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(employmentStatusSelect).click();
                break;
            case SELF_EMPLYD:
                employmentStatusSelect =
                        new LocatorWrapper("Employed selection", employmentStatusSelect("Self-employed"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(employmentStatusSelect).click();
                break;
            default:
                employmentStatusSelect =
                        new LocatorWrapper("Employed selection", employmentStatusSelect("Not employed"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(employmentStatusSelect).click();
        }
    }

    protected void setPIRPercentageRate(PIRPercentage percent){
        LocatorWrapper pirPercentageOption = null;
        switch(percent){
            case TENPT5:
                pirPercentageOption =
                        new LocatorWrapper("10.5% option", pirRateSelect("10.5%"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(pirPercentageOption).click();
                break;
            case SEVENTEENPT5:
                pirPercentageOption =
                        new LocatorWrapper("17.5% option", pirRateSelect("17.5%"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(pirPercentageOption).click();
                break;
            default:
                pirPercentageOption =
                        new LocatorWrapper("28% option", pirRateSelect("28%"),
                                LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(pirPercentageOption).click();
        }
    }

    protected void setKiwiSaverContribution(KiwiSaverContrib contrib){
        LocatorWrapper kiwiSaverContrib = null;
        switch (contrib){
            case THREE:
                kiwiSaverContrib =
                        new LocatorWrapper("3 Percent", "//div[@help-id='KiwiSaverMemberContribution']/.//input[@value=3]", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(kiwiSaverContrib).click();
                break;
            case FOUR:
                kiwiSaverContrib =
                        new LocatorWrapper("4 Percent", "//div[@help-id='KiwiSaverMemberContribution']/.//input[@value=4]", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(kiwiSaverContrib).click();
                break;
            case SIX:
                kiwiSaverContrib =
                        new LocatorWrapper("6 Percent", "//div[@help-id='KiwiSaverMemberContribution']/.//input[@value=6]", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(kiwiSaverContrib).click();
                break;
            case EIGHT:
                kiwiSaverContrib =
                        new LocatorWrapper("8 Percent", "//div[@help-id='KiwiSaverMemberContribution']/.//input[@value=8]", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(kiwiSaverContrib).click();
                break;
            default:
                kiwiSaverContrib =
                        new LocatorWrapper("10 Percent", "//div[@help-id='KiwiSaverMemberContribution']/.//input[@value=10]", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(kiwiSaverContrib).click();
                break;
        }
    }

    protected void setRiskProfile(RiskProfile riskPro){
        LocatorWrapper riskPreference = null;
        switch (riskPro){
            case LOW:
                riskPreference =
                        new LocatorWrapper("Low", "//div[@help-id='RiskProfile']/.//input[@value='low']", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(riskPreference).click();
                break;
            case MED:
                riskPreference =
                        new LocatorWrapper("Medium", "//div[@help-id='RiskProfile']/.//input[@value='medium']", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(riskPreference).click();
                break;
            default:
                riskPreference =
                        new LocatorWrapper("High", "//div[@help-id='RiskProfile']/.//input[@value='high']", LocatorWrapper.LocatorType.XPATH);
                findElementWhenPresent(riskPreference).click();
                break;
        }
    }

    private String employmentStatusSelect(String status){ return "//div[@help-id='EmploymentStatus']/.//span[text()='" + status + "']";}
    private String pirRateSelect(String percentage){ return "//div[@help-id='PIRRate']/.//span[text()='" + percentage + "']";}

}
