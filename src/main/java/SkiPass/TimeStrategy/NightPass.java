package SkiPass.TimeStrategy;

import java.util.Calendar;

public class NightPass implements TimeStrategy{
    public boolean isAvailable() {
        int time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return time >= 18 || time <= 7;
    }

    @Override
    public String toString() {
        return "night pass";
    }
}
