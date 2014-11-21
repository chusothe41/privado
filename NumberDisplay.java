public class NumberDisplay
{
    private int value;
    
    private int limit;

    public NumberDisplay(int limitValue)
    {
        limit = limitValue;
        value = 0;
    }

    public void setValue(int value)
    {
        if(value < limit)
        {
            value = value;
        }
        else
        {
            value = limit;
        }
    }
    
    public String getDisplayValue()
    {
        if(value < 10)
        {
            String number = "0" + value;
            return number;
        }
        else if(value > 99)
        {
            String number = "" + 99;
            return number;
        }
        else
        {
            String number = "" + value;
            return number;
        }
    }
    
    public int getValue()
    {
        return value;
    }
    
    public void increment()
    {
        if(value < limit)
        {
            value++;
        }
        else
        {
            value = 0;
        }
    }
}
