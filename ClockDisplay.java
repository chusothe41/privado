public class ClockDisplay
{
    //un objeto NumberDisplay que guarda la hora
    private NumberDisplay hours;
    //un objeto NumberDisplay que guarda los minutos
    private NumberDisplay minutes;
    //un String de 5 caracteres:la hora dos puntos y los minutos
    private String displayString;

    /**
     * Constructor sin parametros que fija la hora actual a 00:00
     */
    public ClockDisplay()
    {  
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor con dos parametros que 
     */
    public ClockDisplay(int newHours,int newMinutes)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
        hours.setValue(newHours);
        minutes.setValue(newMinutes);
    }

    /**
     * Fija una nueva hora a partir de las horas y minutos dados
     */
    public void setTime(int actualHour,int actualMinute)
    {
        hours.setValue(actualHour);
        minutes.setValue(actualMinute);
    }

    /**
     * Devuelve una cadena de 5 caracteres con la hora y los minutos separados por dos puntos
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * metodo que aumenta en 1 la hora actual
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
     * Actualiza el atributo displayString
     */
    private void updateDisplay()
    {
        if(hours.getValue() > 12 )
        {
            int changedValue;
            changedValue = hours.getValue() - 12;
            String changedHour = "" + changedValue;
            displayString = changedValue + ":" + minutes.getDisplayValue() + "am";
        }
        else
        {
            displayString = hours.getDisplayValue() + ":" + minutes.getDisplayValue() + "pm";
        }
    }
}