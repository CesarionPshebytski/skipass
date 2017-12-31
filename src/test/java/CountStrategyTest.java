import SkiPass.CountStrategy.CountByDays;
import SkiPass.CountStrategy.CountByRides;
import SkiPass.CountStrategy.CountStrategy;
import SkiPass.CountStrategy.Subscription;
import SkiPass.Enums.DaysCountEnum;
import SkiPass.Enums.RidesCountEnum;
import SkiPass.Enums.SubscriptionTimeEnum;
import SkiPass.TimeStrategy.NightPass;
import SkiPass.TimeStrategy.WeekEndPass;
import SkiPass.TimeStrategy.WorkWeekPass;
import org.junit.Test;


import static org.junit.Assert.*;


public class CountStrategyTest {
    @Test
    public void daysCountTest() {
        CountStrategy count = new CountByDays(DaysCountEnum.Five_Days, new WeekEndPass());
        assertTrue(count.count());
        assertFalse(4 == count.getAvailableCount());
        assertTrue(1 == count.getAvailableCount());

        count = new CountByDays(DaysCountEnum.Two_Day, new WorkWeekPass());
        count.count();
        assertEquals(2, count.getAvailableCount());
        count.count();
        assertFalse(count.count());

        count = new CountByDays(DaysCountEnum.Two_Day, new NightPass());
        assertTrue(count.isAvailable());
        assertFalse(count.toString().isEmpty());
    }

    @Test
    public void ridesCountTest() {
        CountStrategy count = new CountByRides(RidesCountEnum.Hundred_Rides, new WeekEndPass());
        assertTrue(count.count());
        assertTrue(99 == count.getAvailableCount());

        count = new CountByRides(RidesCountEnum.Ten_Rides, new WeekEndPass());
        count.count();
        assertEquals(9, count.getAvailableCount());
        for (int i = 0; i < 9; i++) {
            count.count();
        }
        assertFalse(count.count());
        assertFalse(count.toString().isEmpty());


        count = new CountByRides(RidesCountEnum.Twenty_Rides, new NightPass());
        assertTrue(count.isAvailable());
        assertTrue(count.getTimeStrategy().isAvailable());
    }

    @Test
    public void SubscriptionTest(){
        CountStrategy count = new Subscription(SubscriptionTimeEnum.This_Month, new WeekEndPass());
        assertFalse(count.count());
        assertFalse(count.isAvailable());
        assertFalse(count.toString().isEmpty());


        count = new Subscription(SubscriptionTimeEnum.December, new WeekEndPass());
        assertTrue(count.count());
        assertEquals(30, count.getAvailableCount());
        for (int i = 0; i < 30; i++) {
            count.count();
        }
        assertFalse(count.count());
    }
}