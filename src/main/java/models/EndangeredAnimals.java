package models;

import org.sql2o.*;

public class EndangeredAnimals extends Animals implements Animal{
    private String age;
    private String health;
    public static final String AGE_NEWBORN = "newBorn";
    public static final String AGE_YOUNG = "young";
    public static final String AGE_ADULT = "adult";

    public static String HEALTH_HEALTHY = "healthy";
    public static String HEALTH_ILL = "ill";
    public static String HEALTH_OKAY = "okay";

    public static String GENDER_MALE = "male";
    public static String GENDER_FEMALE = "female";
    public EndangeredAnimals(String name, String type) {
        this.name=name;
        this.type=type;
        gender=GENDER_MALE;
        gender=GENDER_FEMALE;
        age=AGE_NEWBORN;
        age=AGE_YOUNG;
        age=AGE_ADULT;
        health=HEALTH_HEALTHY;
        health=HEALTH_ILL;
        health=HEALTH_OKAY;
    }

    @Override
    public void save() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void findAll() {

    }

    @Override
    public void update() {

    }

    @Override
    public void removeById() {

    }

    @Override
    public void removeAll() {

    }

    public String getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }
}
