package SkiPass.Enums;

public enum RidesCountEnum {
    Ten_Rides(10),
    Twenty_Rides(20),
    Fifty_Rides(50),
    Hundred_Rides(100);

    public final int value;

    RidesCountEnum(int value) {
        this.value = value;
    }
}
