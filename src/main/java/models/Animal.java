package models;

public interface Animal {
//    CREATE ANIMAL
    void save();

//////    READ ANIMAL
//    void findById();
//    void getAll();

//    UPDATE ANIMAL
    void update(String name, int rangerId, String age, String health);


//    DESTROY ANIMAL
    void  removeById();
    void removeAll();
}
