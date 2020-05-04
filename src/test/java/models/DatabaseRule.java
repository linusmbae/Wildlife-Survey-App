package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://ec2-50-17-21-170.compute-1.amazonaws.com:5432/d8jlcrqdig8sdv", "ubehwyfjkxozzy", "4562c56add5e24ff90ef84f6762edeeb5890cd30eeba8478f2e27b2b50bfc26d");

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
