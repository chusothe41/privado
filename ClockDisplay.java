/**
 * Write a description of class ClockDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockDisplay
{
    //horas
    private NumberDisplay hours;
    //minutos
    private NumberDisplay minutes;
    //dia
    private int day;
    //mes
    private int month;
    //Año
    private int year;
    //hora actual en 5 caracteres
    private String displayString;
    //fecha actual
    private String displayDate;

    /**
     * Constructor fija la hora a 00:00
     */
    public ClockDisplay()
    {
        day = 0;
        month = 0;
        year = 0;
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();       
    }

    /**
     * constructor que fija por parametros la hora
     */
    public ClockDisplay(int newHour, int newMinute)
    {
        day = 0;
        month = 0;
        year = 0;
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        hours.setValue(newHour);
        minutes.setValue(newMinute);
        updateDisplay();
    }

    /**
     * fija la hora a los valores introducidos
     */

    public void setTime(int newHour, int newMinute, int newDay, int newMonth, int newYear)
    {
        if (newDay > 30)
        {
            day = 30;
        }
        else
        {
            day = newDay;
        }
        if(newMonth > 12)
        {
            month = 12;
        }
        else
        {
            month = newMonth;
        }
        if(newYear > 99)
        {
            year = 99;
        }
        else
        {
            year = newYear;
        }
        hours.setValue(newHour);
        minutes.setValue(newMinute);
        updateDisplay();
    }

    /**
     * devuelve en string hora actual en 5 caracteres
     */
    public String getTime()
    {
        String completeDate;
        displayDate = day + "" + month + "" + year;
        completeDate = displayString + " " + displayDate;
        return completeDate;
    }

    /**
     * adelanta el reloj un min
     */
    public void timeTick()
    {
        minutes.increment();
        if (minutes.getValue() == 0)
        {
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public void updateDisplay()
    {
        int actualHour = hours.getValue();
        String displayedHour = "";
        String amPm = "";   
        boolean isMorning = true;

        if (actualHour == 0) 
        {
            displayedHour = "12";
            isMorning = true;
        }
        else if (actualHour < 10)
        {
            displayedHour = "0" + actualHour;
            isMorning = true;            
        }
        else if (actualHour < 12)
        {
            displayedHour = "" + actualHour;
            isMorning = true;            
        }
        else if (actualHour == 12)
        {
            displayedHour = "12";
            isMorning = false;
        }
        else if (actualHour < 22)
        {
            displayedHour = "0" + (actualHour - 12);
            isMorning = false;
        }
        else 
        {
            displayedHour = "" + (actualHour- 12);
            isMorning = false;
        }

        if (isMorning) 
        {
            amPm = "am";
        }
        else 
        {
            amPm = "pm";
        }

        displayString = displayedHour + ":" +  minutes.getDisplayValue() + amPm;
    }
}