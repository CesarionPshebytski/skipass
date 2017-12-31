package SkiPass.CountStrategy;

import SkiPass.Enums.RidesCountEnum;
import SkiPass.TimeStrategy.TimeStrategy;

public class CountByRides implements CountStrategy {
    private int availableRides;

    private TimeStrategy timeStrategy;

    public TimeStrategy getTimeStrategy() {
        return timeStrategy;
    }

    public CountByRides(RidesCountEnum ridesCount, TimeStrategy strategy) {
        availableRides = ridesCount.value;
        timeStrategy = strategy;
    }

    public boolean count() {
        if (timeStrategy.isAvailable() && availableRides > 0) {
            availableRides--;
            return true;
        }
        return false;
    }

    public boolean isAvailable() {
        return availableRides > 0;
    }

    public int getAvailableCount() {
        return availableRides;
    }

    @Override
    public String toString() {
        return "count by rides, unlim days";
    }
}
