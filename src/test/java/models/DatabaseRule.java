package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://aoizczhjwnjwso:4dd97d27fc56f55ec91001a254fc9be4e9205d50e84c4548c03036ca81bbee2d@ec2-52-202-22-140.compute-1.amazonaws.com:5432/d7jjinba7c9cui", "aoizczhjwnjwso", "4dd97d27fc56f55ec91001a254fc9be4e9205d50e84c4548c03036ca81bbee2d");

//        Database.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "12345");
    }

    @Override
    protected void after(){
        try (Connection conn=Database.sql2o.open())
        {
            String removeAnimalsQuery="DELETE FROM animals";
            conn.createQuery(removeAnimalsQuery)
                    .executeUpdate();

            String removeAnimalQuery="DELETE FROM animals";
            conn.createQuery(removeAnimalQuery)
                    .executeUpdate();

            String removeSightingQuery = "DELETE FROM sightings";
            conn.createQuery(removeSightingQuery)
                    .executeUpdate();
        }

    }
}
