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
    public boolean equals(Object otherSight){
        if (!(otherSight instanceof Sightings)) {
            return false;
        } else {
            Sightings newSight = (Sightings) otherSight;
            return this.getLocation().equals(newSight.getLocation()) &&
                    this.getRangerName().equals(newSight.getRangerName()) &&
                    this.getAnimalId() == newSight.getAnimalId();
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
}

