package models;
import org.sql2o.*;
public class Database {

    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-34-195-169-25.compute-1.amazonaws.com:5432/d3elr8g0ab9mu8", "eayrbquvvrizmd", "11cdc47f2d2b42fbd67ff82ec73dcef70a5e2d13af20152e2f2c2bb306fd3c53");

//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "postgres", "12345");

}
