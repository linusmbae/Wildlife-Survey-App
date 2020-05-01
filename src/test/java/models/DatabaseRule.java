package models;

import org.junit.rules.ExternalResource;
import org.sql2o.*;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {
    @Override
    protected void before() {
        Database.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "postgres", "12345");
    }

    @Override
    protected void after(){
        try (Connection conn=Database.sql2o.open())
        {
            String removeAnimalQuery="DELETE FROM animals";
            conn.createQuery(removeAnimalQuery)
                    .executeUpdate();
        }

    }
}
