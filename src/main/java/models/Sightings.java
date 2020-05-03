package models;

import org.sql2o.*;

import java.util.List;

public class Sightings extends Animals{
    private int animalId;
    private String location;
    private String rangerName;

    public Sightings(int animalId, String location, String rangerName) {
        this.animalId = animalId;
        this.location = location;
        this.rangerName = rangerName;
    }

    @Override
    public boolean equals(Object secondSight){
        if (!(secondSight instanceof Sightings)) {
            return false;
        } else {
            Sightings newSight = (Sightings) secondSight;
            return  this.getAnimalId() == newSight.getAnimalId()&&
                    this.getLocation().equals(newSight.getLocation()) &&
                    this.getRangerName().equals(newSight.getRangerName()) ;
        }
    }


    public int getAnimalId() {
        return animalId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getId() {
        return id;
    }

    public void save()
    {
        try(Connection conn=Database.sql2o.open()) {
            String save = "INSERT INTO sightings (animalid,location,rangername) VALUES (:animalId, :location,:rangerName)";
            this.id = (int) conn.createQuery(save, true)
                    .addParameter("animalId", this.animalId)
                    .addParameter("location",this.location)
                    .addParameter("rangerName", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> getAll()
    {
        String getAll = "SELECT * FROM sightings";
        try(Connection conn = Database.sql2o.open())
        {
            return conn.createQuery(getAll)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Sightings.class);
        }
    }

    public static Sightings findById(int id)
    {
        try (Connection conn =Database.sql2o.open())
        {
            String getById = "SELECT * FROM sightings WHERE id = :id";
            Sightings sight=conn.createQuery(getById)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(Sightings.class);
            return sight;
        }
    }

    public void update()
    {
        try (Connection conn = Database.sql2o.open()){
            String sql = "UPDATE sightings SET animalid=:animalId, location=:location,rangername=:rangerName WHERE id=:id";
            conn.createQuery(sql)
                    .addParameter("animalId", animalId)
                    .addParameter("location", location)
                    .addParameter("rangerName", rangerName)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();

        }
    }
    public void removeById()
    {
        try(Connection conn=Database.sql2o.open()) {
            String remove="DELETE FROM sightings WHERE id = :id";
            conn.createQuery(remove)
                    .addParameter("id",id)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }

    public void removeAll()
    {
        try(Connection conn=Database.sql2o.open()) {
            String remove="DELETE FROM sightings";
            conn.createQuery(remove)
                    .throwOnMappingFailure(false)
                    .executeUpdate();
        }
    }
}

