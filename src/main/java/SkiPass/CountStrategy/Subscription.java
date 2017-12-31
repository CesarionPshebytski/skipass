package SkiPass.CountStrategy;

import SkiPass.Enums.SubscriptionTimeEnum;
import SkiPass.TimeStrategy.TimeStrategy;
import SkiPass.TimeStrategy.WeekEndPass;

public class Subscription implements CountStrategy {
    private int availableDays;

    private TimeStrategy timeStrategy;

    public TimeStrategy getTimeStrategy() {
        return timeStrategy;
    }

    public Subscription(SubscriptionTimeEnum subscriptionTime, TimeStrategy strategy) {
        this.timeStrategy = strategy;
        this.availableDays = timeStrategy.getClass().equals(WeekEndPass.class)?subscriptionTime.value:0;
    }

    public boolean count() {
        if (timeStrategy.isAvailable() && availableDays > 0) {
            availableDays--;
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
        return "subscription, count by days, unlim rides";
    }
}
