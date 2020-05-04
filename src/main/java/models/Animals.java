package models;

public abstract class Animals {
    public int id;
    public String name;
    public int rangerId;
    public String age;
    public String health;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getRangerId() {
        return rangerId;
    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }
}
