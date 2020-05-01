package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sightingsInstantiatesCorrectly_true() {
    Sightings testSite=createSight();
    assertEquals(true, testSite instanceof Sightings);
    }

    @Test
    public void sighting_instantiatesWithAnimalId_int() {
        Sightings testSight = createSight();
        assertEquals(1,testSight.getAnimalId());
    }

    @Test
    public void sighting_instantiatesWithLocation_string() {
        Sightings testSight = createSight();
        assertEquals("Near The River", testSight.getLocation());
    }

    @Test
    public void sighting_instantiatesWithRangerName_String() {
        Sightings testSight = createSight();
        assertEquals("James", testSight.getRangerName());
    }

    @Test
    public void equals_returnsTrueIfSightDetailsAreEqual_true() {
        Sightings firstSight=createSight();
        Sightings secondSight=createSight();
        assertTrue(firstSight.equals(secondSight));
    }

    public Sightings createSight()
{
    return new Sightings(1,"Near The River","James");
}
}