package SkiPass.Enums;

public enum DaysCountEnum {
    One_Day(1),
    Two_Day(2),
    Five_Days(5);

    public final int value;

    DaysCountEnum(int value) {
        this.value = value;
    }
}
