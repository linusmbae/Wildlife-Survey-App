package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangered_instantiatesCorrectly_true() throws Exception {
        EndangeredAnimals testAnimal=createAnimal();
        assertEquals(true,testAnimal instanceof EndangeredAnimals);
    }

    @Test
    public void endangered_instantiatesWithName_String() throws Exception {
        EndangeredAnimals testAnimal=createAnimal();
        assertEquals("Lion", testAnimal.getName());
    }

    @Test
    public void endangered_instantiatesWithRangerId_int() throws Exception {
        EndangeredAnimals testAnimals = createAnimal();
        assertEquals(1,testAnimals.getRangerId());
    }

    @Test
    public void equals_returnsTrueIfNameAndRangerIdAreSame_true() {
        EndangeredAnimals testAnimal = createAnimal();
        EndangeredAnimals anotherAnimal = createAnimal();
        assertTrue(testAnimal.equals(anotherAnimal));
    }

    @Test
    public void save_savesAnimalToTheDatabase() throws Exception {
        EndangeredAnimals testAnimals = createAnimal();
        testAnimals.save();
        assertTrue(EndangeredAnimals.getAll().get(0).equals(testAnimals));
    }

    @Test
    public void save_assignsIdToAnimal() {
        EndangeredAnimals testAnimals = createAnimal();
        testAnimals.save();
        EndangeredAnimals savedAnimal = EndangeredAnimals.getAll().get(0);
        assertEquals(savedAnimal.getId(), testAnimals.getId());
    }

    @Test
    public void getAll_returnsAllInstancesOfAnimal() {
        EndangeredAnimals firstAnimal = createAnimal();
        firstAnimal.save();
        EndangeredAnimals secondAnimal = createSecondAnimal();
        secondAnimal.save();
        assertEquals(true,EndangeredAnimals.getAll().get(0).equals(firstAnimal));
        assertEquals(true,EndangeredAnimals.getAll().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
        EndangeredAnimals firstAnimal = createAnimal();
        firstAnimal.save();
        EndangeredAnimals secondAnimal = createSecondAnimal();
        secondAnimal.save();
        assertEquals(EndangeredAnimals.findById(secondAnimal.getId()), secondAnimal);
    }

//    @Test
//    public void endangeredAnimal_instantiatesWithNewBorn() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.save();
//        assertEquals(testAnimal.getAgeNewBorn(),(EndangeredAnimals.AGE_NEWBORN));
//    }
//
//    @Test
//    public void endangeredAnimal_instantiatesWithYoungAnimal() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.save();
//        assertEquals(testAnimal.getAgeYoung(),(EndangeredAnimals.AGE_YOUNG));
//    }
//
//    @Test
//    public void endangeredAnimal_instantiatesWithAdultAnimal() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.save();
//        assertEquals(testAnimal.getAgeAdult(),(EndangeredAnimals.AGE_ADULT));
//    }
//
//    @Test
//    public void update_updatesEndangeredAnimalEstimatedNewBornAge() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal=EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getAgeNewBorn().equals(savedAnimal.AGE_NEWBORN));
//    }
//
//    @Test
//    public void update_updatesEndangeredAnimalEstimatedYoungAge() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal=EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getAgeYoung().equals(savedAnimal.AGE_YOUNG));
//    }
//
//    @Test
//    public void update_updatesEndangeredAnimalEstimatedAdultAge() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal = EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getAgeAdult().equals(savedAnimal.AGE_ADULT));
//    }
//
//    @Test
//    public void update_updatesHealthyAnimal() {
//        EndangeredAnimals testAnimal= createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal = EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getHealthHealthy().equals(savedAnimal.HEALTH_HEALTHY));
//    }
//
//    @Test
//    public void update_updatesIllAnimal() {
//        EndangeredAnimals testAnimal =createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal =EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getHealthIll().equals(savedAnimal.HEALTH_ILL));
//    }
//
//    @Test
//    public void update_updatesOkayAnimal() {
//        EndangeredAnimals testAnimal = createAnimal();
//        testAnimal.update();
//        EndangeredAnimals savedAnimal = EndangeredAnimals.findById(testAnimal.getId());
//        assertTrue(testAnimal.getHealthOkay().equals(savedAnimal.HEALTH_OKAY));
//    }

    @Test
    public void removeById_removesAnimalById() {
        EndangeredAnimals testAnimals = createAnimal();
        testAnimals.save();

        testAnimals.removeById();
        assertEquals(null,EndangeredAnimals.findById(testAnimals.getId()));
    }

    @Test
    public void removeAll_clearsAnimalDatabase() {
        EndangeredAnimals testAnimal = createAnimal();
        testAnimal.save();
        testAnimal.removeAll();
        assertEquals(null,EndangeredAnimals.findById(testAnimal.getId()));
    }

    public EndangeredAnimals createAnimal()
    {
        return new EndangeredAnimals("Lion",1,"young","ill");
    }
    public EndangeredAnimals createSecondAnimal()
    {
        return new EndangeredAnimals("Elephant",1,"New Born","okay");
    }
}