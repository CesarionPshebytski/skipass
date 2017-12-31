package Entities;

import SkiPass.CountStrategy.CountStrategy;

public class SkiPass{

    private final int id;
    private boolean isBlocked = false;
    private int wasUsed = 0;
    private int wasBlocked = 0;
    private Customer customer;
    private CountStrategy countStrategy;

    public SkiPass(Customer customer, CountStrategy countStrategy) {
        this.customer = customer;
        this.countStrategy = countStrategy;
        id = hashCode();
        this.customer.addSkiPass(this);
        System.out.println(id + "added");
    }

    public int getId() {
        return id;
    }

    public void block() {
        isBlocked = true;
        wasBlocked++;
    }

    public void unblock() {
        isBlocked = false;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CountStrategy getCountStrategy() {
        return countStrategy;
    }

    public void setCountStrategy(CountStrategy countStrategy) {
        this.countStrategy = countStrategy;
    }

    public int getUsageTimes() {
        return wasUsed;
    }

    protected void wasUsed() {
        this.wasUsed++;
    }

    public int getBlockedTimes() {
        return wasBlocked;
    }

    @Override
    public String toString() {
        String ownerInfo = customer.toString();
        String passInfo = "\nSkiPass id: " + getId() + ", is blocked: " + isBlocked() + ", time type: "
                + getCountStrategy().getTimeStrategy() + ", count type: " + getCountStrategy();
        return ownerInfo + passInfo;
    }

    //TODO: implement equals if needed
}