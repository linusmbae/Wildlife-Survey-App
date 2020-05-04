package models;
import org.sql2o.*;
public class Database {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://aoizczhjwnjwso:4dd97d27fc56f55ec91001a254fc9be4e9205d50e84c4548c03036ca81bbee2d@ec2-52-202-22-140.compute-1.amazonaws.com:5432/d7jjinba7c9cui", "aoizczhjwnjwso", "4dd97d27fc56f55ec91001a254fc9be4e9205d50e84c4548c03036ca81bbee2d");

//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "12345");

}
