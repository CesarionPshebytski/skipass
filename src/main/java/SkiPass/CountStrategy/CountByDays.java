package SkiPass.CountStrategy;

import SkiPass.Enums.DaysCountEnum;
import SkiPass.TimeStrategy.TimeStrategy;
import SkiPass.TimeStrategy.WeekEndPass;

import java.util.Calendar;

public class CountByDays implements CountStrategy {
    private int availableDays;
    private boolean wasUsed = false;
    private TimeStrategy timeStrategy;

    public CountByDays(DaysCountEnum daysCount, TimeStrategy strategy) {
        timeStrategy = strategy;
        availableDays = daysCount.value > 2 && timeStrategy.getClass().equals(WeekEndPass.class) ? 2 : daysCount.value;
    }

    public TimeStrategy getTimeStrategy() {
        return timeStrategy;
    }

    public boolean count() {
        if (timeStrategy.isAvailable() && availableDays > 0 && !wasUsed) {
            availableDays--;
            wasUsed = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) != 0;
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return availableDays > 0;
    }

    public int getAvailableCount() {
        return availableDays;
    }

    @Override
    public String toString() {
        return "count by days, unlim rides";
    }
}
