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
        EndangeredAnimals secondAnimal = new EndangeredAnimals("elephant",3);
        secondAnimal.save();
        assertEquals(true,EndangeredAnimals.getAll().get(0).equals(firstAnimal));
        assertEquals(true,EndangeredAnimals.getAll().get(1).equals(secondAnimal));
    }

    public EndangeredAnimals createAnimal()
    {
        return new EndangeredAnimals("Lion",1);
    }
}