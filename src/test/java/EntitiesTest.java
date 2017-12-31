import Entities.Customer;
import Entities.SkiPass;
import Entities.SkiPassSystem;
import Entities.TurnStile;
import SkiPass.CountStrategy.CountByDays;
import SkiPass.Enums.DaysCountEnum;
import SkiPass.TimeStrategy.WeekEndPass;
import org.junit.Test;


import static org.junit.Assert.*;

public class EntitiesTest {
    @Test
    public void EntityTest(){
        Customer customer = new Customer("John","Smith");
        assertTrue(customer.getName().equals("John"));
        assertEquals("Smith", customer.getSurname());
        customer.setName("Ivan");
        customer.setSurname("Stereotipoff");
        assertFalse(customer.getName().equals("John"));
        assertNotEquals("Smith", customer.getSurname());
        assertTrue(customer.getId()>0);
        assertFalse(customer.toString().isEmpty());

        Customer fakeCustomer = new Customer("Definitely", "Not Fake");

        SkiPass skiPass = new SkiPass(fakeCustomer, new CountByDays(DaysCountEnum.Two_Day, new WeekEndPass()));
        assertTrue(skiPass.isBlocked());
        assertTrue(skiPass.getId()>0);
        skiPass.unblock();
        assertFalse(skiPass.isBlocked());
        assertEquals("Not Fake", skiPass.getCustomer().getSurname());
        assertTrue(skiPass.getCountStrategy().isAvailable());
        assertEquals(0 ,skiPass.getBlockedTimes());
        assertEquals(0 ,skiPass.getUsageTimes());
        assertFalse(skiPass.toString().isEmpty());
        skiPass.setCustomer(customer);
        assertEquals("Stereotipoff", skiPass.getCustomer().getSurname());
        assertFalse(customer.getPassesList().size() == 0);

        TurnStile turnStile = new TurnStile();
        turnStile.pass(skiPass);
        assertEquals(1 ,skiPass.getUsageTimes());
        skiPass.block();
        assertFalse(turnStile.pass(skiPass));
        assertEquals(1 ,skiPass.getUsageTimes());

        SkiPassSystem system = new SkiPassSystem();
        skiPass = new SkiPass(customer, new CountByDays(DaysCountEnum.Two_Day, new WeekEndPass()));
        assertFalse(turnStile.pass(skiPass));
        system.add(skiPass);
        assertTrue(turnStile.pass(skiPass));
        assertEquals(1 ,skiPass.getUsageTimes());

        system.blockSkiPass(skiPass);
        assertFalse(turnStile.pass(skiPass));
        system.unblockSkiPass(skiPass);
        assertTrue(turnStile.pass(skiPass));

        system.blockSkiPass(skiPass.getId());
        assertFalse(turnStile.pass(skiPass));
        system.unblockSkiPass(skiPass.getId());
        assertTrue(turnStile.pass(skiPass));

        assertFalse(system.toString().isEmpty());
    }
}
