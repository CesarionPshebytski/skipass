package Entities;

import java.util.ArrayList;

public class Customer {
    private String name;
    private String surname;
    private int id;

    private ArrayList<SkiPass> passesList = new ArrayList<SkiPass>();

    public Customer(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = hashCode();
    }

    public void addSkiPass(SkiPass skiPass) {
        if (!passesList.contains(skiPass)){
            passesList.add(skiPass);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<SkiPass> getPassesList() {
        return new ArrayList<SkiPass>(passesList);
    }


    @Override
    public String toString() {
        return "Customer: "+ getName() + " "+ getSurname() + ", id: " + getId();
    }

    //TODO: implement equals if needed
}
