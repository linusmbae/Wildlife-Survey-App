package models;

public interface Animal {
//    CREATE ANIMAL
    void save();

////    READ ANIMAL
//    void findById();
//    void findAll();

//    UPDATE ANIMAL
    void updateNewBorn();
    void updateYoung();
    void updateAdult();

//    DESTROY ANIMAL
    void  removeById();
    void removeAll();
}
