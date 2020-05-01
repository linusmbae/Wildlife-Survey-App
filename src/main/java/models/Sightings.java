package models;

public class Sightings {
    private int id;
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

    public int getId() {
        return id;
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
}
