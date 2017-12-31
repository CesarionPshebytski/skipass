package Entities;

public class TurnStile {
    public boolean pass(SkiPass skiPass) {
        if (!skiPass.isBlocked()) {
            skiPass.getCountStrategy().count();
            skiPass.wasUsed();
            return true;
        }
        return false;
    }
}
