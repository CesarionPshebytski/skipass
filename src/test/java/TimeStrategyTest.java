import SkiPass.TimeStrategy.NightPass;
import SkiPass.TimeStrategy.TimeStrategy;
import SkiPass.TimeStrategy.WeekEndPass;
import SkiPass.TimeStrategy.WorkWeekPass;
import org.junit.Test;


import static org.junit.Assert.*;

public class TimeStrategyTest {
    @Test
    public void NightPassTest(){
        TimeStrategy strategy = new NightPass();
        assertTrue(strategy.isAvailable());
    }

    @Test
    public void WeekEndPassTest(){
        TimeStrategy strategy = new WeekEndPass();
        assertTrue(strategy.isAvailable());
    }

    @Test
    public void WorkWeekPassTest(){
        TimeStrategy strategy = new WorkWeekPass();
        assertFalse(strategy.isAvailable());
    }
}
