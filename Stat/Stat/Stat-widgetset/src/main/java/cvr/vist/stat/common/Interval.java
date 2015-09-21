package cvr.vist.stat.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public enum Interval {

    Со_вчерашнего_дня,
    С_начала_недели,
    С_начала_месяца,
    С_начала_года;

    public static Date getStartDate(Interval interval) {
        Date ret = new Date();
        Calendar calendar = new GregorianCalendar(Locale.US);
        int year, month, day;
        year = Calendar.getInstance().get(Calendar.YEAR);
        switch (interval) {
            case С_начала_года:
                month = 0;
                day = 1;
                calendar.set(year, month, day);
                ret = calendar.getTime();
                break;
            case С_начала_месяца:
                month = Calendar.getInstance().get(Calendar.MONTH);
                day = 1;
                calendar.set(year, month, day);
                ret = calendar.getTime();
                break;
            case С_начала_недели:
                month = Calendar.getInstance().get(Calendar.MONTH);
                day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - Calendar.getInstance().get(Calendar.DAY_OF_WEEK) + 2;
                calendar.set(year, month, day);
                ret = calendar.getTime();
                break;
            case Со_вчерашнего_дня:
                month = Calendar.getInstance().get(Calendar.MONTH);
                day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - 1;
                calendar.set(year, month, day);
                ret = calendar.getTime();
                break;
        }
        System.out.println(" interval =  " + interval);
        System.out.println(" getStartDate " + ret);
        return ret;
    }
}
