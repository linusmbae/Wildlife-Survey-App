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

    @Test
    public void update_updatesAnimalDetails() throws Exception {
        EndangeredAnimals testAnimal=createAnimal();
        testAnimal.save();

        testAnimal.update("Lioness",2,"Old","Okay");
        EndangeredAnimals updatedAnimal=EndangeredAnimals.findById(testAnimal.getId());
        assertEquals(testAnimal.getId(),updatedAnimal.getId());
        assertNotEquals(testAnimal.getName(),updatedAnimal.getName());
        assertNotEquals(testAnimal.getRangerId(),updatedAnimal.getRangerId());
        assertNotEquals(testAnimal.getAge(),updatedAnimal.getAge());
        assertNotEquals(testAnimal.getHealth(),updatedAnimal.getHealth());
    }

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