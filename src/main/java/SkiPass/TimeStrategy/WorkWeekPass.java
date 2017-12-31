package SkiPass.TimeStrategy;

import java.util.Calendar;

public class WorkWeekPass implements TimeStrategy{

    public boolean isAvailable(){
        int dayOfWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != 1 && dayOfWeek != 7;
    }

    @Override
    public String toString() {
        return "workweek pass";
    }
}
