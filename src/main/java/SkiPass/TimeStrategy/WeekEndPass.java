package SkiPass.TimeStrategy;

import java.util.Calendar;

public class WeekEndPass implements TimeStrategy{

    public boolean isAvailable(){
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == 7 || dayOfWeek == 1;
    }

    @Override
    public String toString() {
        return "weekend pass";
    }
}
