package wpexam.common;

public class Helper {

    public static void sleepInMillis(long millis){
        try{
            Thread.sleep(millis);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public enum EmploymentStatus{
        EMPLYD, SELF_EMPLYD, NOT_EMPLYD
    }

    public enum KiwiSaverContrib{
        THREE, FOUR, SIX, EIGHT, TEN
    }

    public enum PIRPercentage{
        TENPT5, SEVENTEENPT5, TWENTY8
    }

    public enum RiskProfile{
        LOW, MED, HIGH
    }

    public enum VoluntaryFreq{
        ONEOFF, WEEKLY, FORTNIGHTLY, MONTHLY, ANNUALLY
    }

}
