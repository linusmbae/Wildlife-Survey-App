package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredAnimalsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void endangered_instantiatesCorrectly_true() throws Exception {
        EndangeredAnimals testAnimal=new EndangeredAnimals("lion");
        assertEquals(true,testAnimal instanceof EndangeredAnimals);
    }


    //    public void createAnimal()
//    {
//        return new EndangeredAnimals("Lion");
//    }
}