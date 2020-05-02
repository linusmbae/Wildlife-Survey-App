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

    public EndangeredAnimals(String name, int rangerId) {
        this.name=name;
        this.rangerId=rangerId;
        age=AGE_NEWBORN;
        age=AGE_YOUNG;
        age=AGE_ADULT;
        health=HEALTH_HEALTHY;
        health=HEALTH_ILL;
        health=HEALTH_OKAY;
    }

    public void save() {
        try(Connection conn=Database.sql2o.open()) {
            String save="INSERT INTO animals (name,rangerid) VALUES (:name, :rangerId)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerId",this.rangerId)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static EndangeredAnimals findById(int id) {
        try(Connection conn = Database.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            EndangeredAnimals animal = conn.createQuery(sql)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(EndangeredAnimals.class);
            return animal;
        }
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
