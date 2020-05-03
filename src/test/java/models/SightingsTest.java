package models;

import org.junit.Rule;
import org.junit.Test;

import javax.swing.*;

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

    @Test
    public void save_savesSightToTheDatabase() {
        Sightings testSight=createSight();
        testSight.save();
        assertTrue(Sightings.getAll().get(0).equals(testSight));
    }

    @Test
    public void save_assignsIdToSight() {
        Sightings testSight = createSight();
        testSight.save();
        Sightings savedSight = Sightings.getAll().get(0);
        assertEquals(savedSight.getId(),testSight.getId());
    }



    @Test
    public void getAll_returnsAllInstancesOfSight() {
        Sightings testSight = createSight();
        testSight.save();
        Sightings saved1 = Sightings.findById(testSight.getId());
        Sightings secondSight = createSecondSight();
        testSight.save();
        Sightings saved2 = Sightings.findById(secondSight.getId());

        assertEquals(true,Sightings.getAll().get(0).equals(saved1));
//        assertEquals(true,Sightings.getAll().get(1).equals(saved2));
    }

    @Test
    public void findById_returnsAllSightsWithSameId_SecondSight() {
        Sightings testSight = createSight();
        testSight.save();
        Sightings savedSight1 = Sightings.findById(testSight.getId());
        Sightings secondSight =createSecondSight();
        testSight.save();
        Sightings savedSight2 = Sightings.findById(secondSight.getId());

        assertEquals(Sightings.findById(testSight.getId()),savedSight1);
        assertEquals(Sightings.findById(secondSight.getId()),savedSight2);
    }

    @Test
    public void update_updatesSightDetails() {
        Sightings testSight = createSight();
        testSight.save();
        int previousAnimalId=testSight.getAnimalId();
        String previousLocation=testSight.getLocation();
        String previousRangerName=testSight.getRangerName();
        int previousId=testSight.getId();

        testSight.update();
        assertNotEquals(previousAnimalId,testSight.getAnimalId());
        assertNotEquals(previousLocation,testSight.getLocation());
        assertNotEquals(previousRangerName,testSight.getRangerName());
        assertEquals(previousId,testSight.getId());
    }

    @Test
    public void removeById_removesSightById() {
        Sightings testSight=createSight();
        testSight.save();
        testSight.removeById();
        assertEquals(null,Sightings.findById(testSight.getId()));
    }

    @Test
    public void removeAll_clearsSightingsDatabase() {
        Sightings testSight=createSight();
        testSight.save();
        testSight.removeAll();
        assertEquals(null,Sightings.findById(testSight.getId()));
    }

    public Sightings createSight()
{
    return new Sightings(1,"Near The River","James");
}
    public Sightings createSecondSight()
    {
        return new Sightings(1,"Zone A", "Mark");
    }
}