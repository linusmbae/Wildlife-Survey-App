package models;

import org.sql2o.*;

import java.util.List;

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
    public EndangeredAnimals(String name, int rangerId) {
        this.name=name;
        this.rangerId=rangerId;
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
        try(Connection conn=Database.sql2o.open()) {
            String save="INSERT INTO animals (name) VALUES (:name)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("name", this.name)
                    .executeUpdate()
                    .getKey();
        }
    }

    public void findById() {

    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof EndangeredAnimals)) {
            return false;
        } else {
            EndangeredAnimals newAnimal = (EndangeredAnimals) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getRangerId() == newAnimal.getRangerId();
        }
    }

    public static List<EndangeredAnimals> getAll() {
    String getAll="SELECT * FROM animals";
    try(Connection conn = Database.sql2o.open())
    {
        return conn.createQuery(getAll)
                .throwOnMappingFailure(false)
                .executeAndFetch(EndangeredAnimals.class);
    }
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
