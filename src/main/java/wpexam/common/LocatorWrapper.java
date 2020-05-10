package wpexam.common;

public class LocatorWrapper {
    public enum LocatorType{
        XPATH, ID, LINKTEXT, CSS
    }

    public String elementName;
    public String elementValue;
    public LocatorType elementType;

    public LocatorWrapper(String elementName, String elementValue, LocatorType elementType){
        this.elementName = elementName;
        this.elementValue = elementValue;
        this.elementType = elementType;
    }
}
