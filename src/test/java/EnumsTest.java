import SkiPass.CountStrategy.Subscription;
import SkiPass.Enums.DaysCountEnum;
import SkiPass.Enums.RidesCountEnum;
import SkiPass.Enums.SubscriptionTimeEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnumsTest {
    @Test
    public void DaysCountEnumTest(){
        assertEquals(2, DaysCountEnum.Two_Day.value);
        assertNotEquals(2, DaysCountEnum.One_Day.value);
        assertTrue(5 == DaysCountEnum.Five_Days.value);
    }

    @Test
    public void RidesCountEnumTest(){
        assertEquals(20, RidesCountEnum.Twenty_Rides.value);
        assertNotEquals(20, RidesCountEnum.Ten_Rides.value);
        assertTrue(100 == RidesCountEnum.Hundred_Rides.value);
    }

    @Test
    public void SubscriptionTimeEnumTest(){
        assertEquals(0, SubscriptionTimeEnum.This_Month.value);
        assertNotEquals(30, SubscriptionTimeEnum.December.value);
        assertTrue(28 == SubscriptionTimeEnum.February.value);
    }
}
