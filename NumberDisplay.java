public class NumberDisplay
{
    private int display;
    
    private int maxDisplay;

    public NumberDisplay(int maxDisplayValue)
    {
        maxDisplay = maxDisplayValue;
        display = 0;
    }

    public void setValue(int value)
    {
        if(value < maxDisplay)
        {
            display = value;
        }
        else
        {
            display = maxDisplay;
        }
    }
    
    public String getDisplayValue()
    {
        if(display < 10)
        {
            String number = "0"+display;
            return number;
        }
        else
        {
            String number = ""+display;
            return number;
        }
    }
    
    public int getValue()
    {
        return display;
    }
    
    public void increment()
    {
        if(display < maxDisplay)
        {
            display++;
        }
        else
        {
            display = 0;
        }
    }
}
