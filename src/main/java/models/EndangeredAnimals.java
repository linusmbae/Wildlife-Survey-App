package models;

import org.sql2o.*;

import java.util.List;

public class EndangeredAnimals extends Animals implements Animal{
    private String ageNewBorn;
    private String ageYoung;
    private String ageAdult;

    public static final String AGE_NEWBORN = "newBorn";
    public static final String AGE_YOUNG = "young";
    public static final String AGE_ADULT = "adult";

    private String healthHealthy;
    private String healthIll;
    private String healthOkay;
    public static String HEALTH_HEALTHY = "healthy";
    public static String HEALTH_ILL = "ill";
    public static String HEALTH_OKAY = "okay";

    public EndangeredAnimals(String name, int rangerId) {
        this.name=name;
        this.rangerId=rangerId;
        ageNewBorn=AGE_NEWBORN;
        ageYoung=AGE_YOUNG;
        ageAdult=AGE_ADULT;
        healthHealthy=HEALTH_HEALTHY;
        healthIll=HEALTH_ILL;
        healthOkay=HEALTH_OKAY;
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

    public void update() {
        try(Connection conn=Database.sql2o.open())
        {
            String updateNewBorn = "UPDATE animals SET age=:ageNewBorn WHERE id = :id";
            conn.createQuery(updateNewBorn)
                    .addParameter("ageNewBorn", ageNewBorn)
                    .addParameter("id", id)
                    .executeUpdate();

            String updateYoung = "UPDATE animals SET age = :ageYoung WHERE id= :id";
            conn.createQuery(updateYoung)
                    .addParameter("ageYoung", ageYoung)
                    .addParameter("id", id)
                    .executeUpdate();

            String updateAdult = "UPDATE animals SET age = :ageAdult WHERE id = :id";
            conn.createQuery(updateAdult)
                    .addParameter("ageAdult", ageAdult)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }


    @Override
    public void removeById() {

    }

    @Override
    public void removeAll() {

    }

    public String getAgeNewBorn() {
        return ageNewBorn;
    }

    public String getAgeYoung() {
        return ageYoung;
    }

    public String getAgeAdult() {
        return ageAdult;
    }

    public String getHealthHealthy() {
        return healthHealthy;
    }

    public String getHealthIll() {
        return healthIll;
    }

    public String getHealthOkay() {
        return healthOkay;
    }
}
