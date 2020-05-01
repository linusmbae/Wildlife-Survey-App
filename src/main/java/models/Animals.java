package models;

public abstract class Animals {
    public int id;
    public String name;
    public String gender;
    public String type;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }
}
