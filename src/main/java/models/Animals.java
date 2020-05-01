package models;

public abstract class Animals {
    public int id;
    public String name;
    public String gender;
    public int rangerId;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getRangerId() {
        return rangerId;
    }
}
