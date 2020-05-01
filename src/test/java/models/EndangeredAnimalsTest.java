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

    public EndangeredAnimals createAnimal()
    {
        return new EndangeredAnimals("Lion",1);
    }
}