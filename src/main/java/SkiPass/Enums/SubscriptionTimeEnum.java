package SkiPass.Enums;

import java.util.Calendar;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DECEMBER;

public enum SubscriptionTimeEnum {
    This_Month(Calendar.getInstance().getActualMaximum(DAY_OF_MONTH) - Calendar.getInstance().get(DAY_OF_MONTH)),
    December(31),
    January(31),
    February(Calendar.getInstance().get(Calendar.YEAR)%4==0?28:29);

    public final int value;

    SubscriptionTimeEnum(int value) {
        this.value = value;
    }

    //TODO: implement pass subscription year
}
