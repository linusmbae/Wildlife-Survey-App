package models;

import org.sql2o.*;

import java.util.List;

public class EndangeredAnimals extends Animals implements Animal{

    public EndangeredAnimals(String name, int rangerId, String age, String health) {
        this.name=name;
        this.rangerId=rangerId;
        this.age=age;
        this.health=health;

    }

    public void save() {
        try(Connection conn=Database.sql2o.open()) {
            String save="INSERT INTO animals (name,rangerid,age,health) VALUES (:name, :rangerId,:age,:health)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("name", this.name)
                    .addParameter("rangerId",this.rangerId)
                    .addParameter("age",this.age)
                    .addParameter("health",this.health)
                    .throwOnMappingFailure(false)
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

    public void update(String name, int rangerId, String age, String health) {
        try(Connection conn=Database.sql2o.open())
        {
//
            String updateNewBorn = "UPDATE animals SET name=:name, rangerid=:rangerId,age=:age, health=:health WHERE id = :id";
            conn.createQuery(updateNewBorn)
                    .addParameter("name", name)
                     .addParameter("rangerId",rangerId)
                    .addParameter("age", age)
                    .addParameter("health",health)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }


    public void removeById() {
        try(Connection conn=Database.sql2o.open())
        {
            String remove = "DELETE FROM animals WHERE id = :id";
            conn.createQuery(remove)
                    .addParameter("id", this.id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }


    public void removeAll() {
        try(Connection conn=Database.sql2o.open())
        {
            String remove = "DELETE FROM animals";
            conn.createQuery(remove)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

}
