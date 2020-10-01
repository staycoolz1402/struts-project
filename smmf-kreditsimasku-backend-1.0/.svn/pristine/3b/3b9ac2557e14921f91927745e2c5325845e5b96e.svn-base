package com.mpe.common;
 
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
 
public final class DateDifference {
    /**
     * No need for an instance
     */
	//These variable comes to use only if the time difference is less than an hour
	private static int min=0;
	private static Date minutes; // to calculate date in elasped minutes;
	
	
    private DateDifference() {
    }
    
    /**
     * Elapsed minutes based on current time
     *
     * @param date Date
     *
     * @return int number of minutes
     */
    
     public static int getElapsedMinutes(Date date) {
         return elapsed(date, Calendar.MINUTE);
     }
    
    /**
     * Elapsed hours based on current time
     *
     * @param date Date
     *
     * @return int number of hours
     */
    
     public static int getElapsedHours(Date date) {
    	 minutes=new Date();
    	 minutes=date;
         return elapsed(date, Calendar.HOUR_OF_DAY);
     }
     
     /**
      * Elapsed days based on two Date objects
      *
      * @param d1 Date
      * @param d2 Date
      *
      * @return int number of hours
      */
      public static int getElapsedHours(Date d1, Date d2) {
          return elapsed(d1, d2, Calendar.HOUR_OF_DAY);
      }  
   /**
    * Elapsed days based on current time
    *
    * @param date Date
    *
    * @return int number of days
    */
    public static int getElapsedDays(Date date) {
        return elapsed(date, Calendar.DATE);
    }
   /**
    * Elapsed days based on two Date objects
    *
    * @param d1 Date
    * @param d2 Date
    *
    * @return int number of days
    */
    public static int getElapsedDays(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.DATE);
    }
    /**
    * Elapsed months based on current time
    *
    * @param date Date
    *
    * @return int number of months
    */
    public static int getElapsedMonths(Date date) {
        return elapsed(date, Calendar.MONTH);
    }
   /**
    * Elapsed months based on two Date objects
    *
    * @param d1 Date
    * @param d2 Date
    *
    * @return int number of months
    */
    public static int getElapsedMonths(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.MONTH);
    }
     /**
    * Elapsed years based on current time
    *
    * @param date Date
    *
    * @return int number of years
    */
    public static int getElapsedYears(Date date) {
        return elapsed(date, Calendar.YEAR);
    }
   /**
    * Elapsed years based on two Date objects
    *
    * @param d1 Date
    * @param d2 Date
    *
    * @return int number of years
    */
    public static int getElapsedYears(Date d1, Date d2) {
        return elapsed(d1, d2, Calendar.YEAR);
    }
     /**
     * All elaspsed types
     *
     * @param g1 GregorianCalendar
     * @param g2 GregorianCalendar
     * @param type int (Calendar.FIELD_NAME)
     *
     * @return int number of elapsed "type"
     */
    private static int elapsed(GregorianCalendar g1, GregorianCalendar g2, int type) {
        GregorianCalendar gc1, gc2;
        int elapsed = 0;
        
        // Create copies since we will be clearing/adding
        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
        } else  {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }
        
        if (type == Calendar.HOUR_OF_DAY || type == Calendar.DATE || type == Calendar.MONTH || type==Calendar.YEAR){
        	gc1.clear(Calendar.MINUTE);
        	gc2.clear(Calendar.MINUTE);
        }
        if (type == Calendar.DATE || type == Calendar.MONTH || type==Calendar.YEAR){
        	gc1.clear(Calendar.HOUR_OF_DAY);
        	gc2.clear(Calendar.HOUR_OF_DAY);
        }
        if (type == Calendar.MONTH || type == Calendar.YEAR) {
            gc1.clear(Calendar.DATE);
            gc2.clear(Calendar.DATE);
        }
        if (type == Calendar.YEAR) {
            gc1.clear(Calendar.MONTH);
            gc2.clear(Calendar.MONTH);
        }
        while (gc1.before(gc2)) {
            gc1.add(type, 1);
            elapsed++;
        }
        // modif: we want negatif/positif return
        if(g2.before(g1)) return -elapsed;
        return elapsed;
    }
     /**
     * All elaspsed types based on date and current Date
     *
     * @param date Date
     * @param type int (Calendar.FIELD_NAME)
     *
     * @return int number of elapsed "type"
     */
    private static int elapsed(Date date, int type) {
        return elapsed(date, new Date(), type);
    }
     /**
     * All elaspsed types
     *
     * @param d1 Date
     * @param d2 Date
     * @param type int (Calendar.FIELD_NAME)
     *
     * @return int number of elapsed "type"
     */
    private static int elapsed(Date d1, Date d2, int type) {
    	
        Calendar cal = Calendar.getInstance();
        cal.setTime(d1);
        GregorianCalendar g1 = new GregorianCalendar(
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE));
        cal.setTime(d2);
        GregorianCalendar g2 = new GregorianCalendar(
            cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE));
        return elapsed(g1, g2, type);
    }
    
    public static String showDuration(int hour,int day,int month,int year)
    {
    	String Duration="";
    	if((hour>=0)&&(day==0)&&(month==0)&&(year==0))
    	{	if(hour<24)
    		{	if(hour==0)
    			{
    				//Duration="Few minutes ago"; //"A few minutes ago"
    				min=getElapsedMinutes(minutes);
    				if(min<=1){
    					Duration="1 minute ago";
    				}
    				else{
    					Duration=min+" minutes ago";
    				}
    			}
    			else if(hour==1)
    			{
    				Duration="An hour ago";
    			}
    			else
    			{
    				Duration=hour+" hours ago";
    			}
    		}
    		
    	}
    	if((day<7)&&(month==0)&&(year==0))
    	{	if(day>0)
    		{	if(day==1)
    			{
    				Duration="1 day ago";
    			}
    			else
    			{
    				Duration=day+" days ago";
    			}
    		}
    	}
    	else if((day>7)&&(month==0)&&(year==0))
    	{
    		int week=day/7;
    		if(week<4)
    		{
    			if(week==1)
    			{
    				Duration="1 week ago";
    			}
    			else
    			{
    				Duration=week+" weeks ago";
    			}
    		}
    	}
    	if((month>0)&&(year==0))
    	{
    		if(month==1)
    		{
    			Duration="1 month ago";
    		}
    		else
    		{
    			Duration=month+" months ago";
    		}
    	}
    	if(year>0)
    	{
    		if(year==1)
    		{
    			Duration="1 year ago";
    		}
    		else
    		{
    			Duration=year+" years ago";
    		}
    	}
    	return Duration;
    }
}