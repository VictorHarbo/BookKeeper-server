import dk.harbojohnston.Book;
import dk.harbojohnston.Database.Database;
import dk.harbojohnston.Database.DatabaseActions;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DatabaseTest {

    @Test
    public void testConnection() throws IOException {
        DatabaseActions.connectToDb();
    }

    @Test
    public void testGetBook() throws Exception {
        try (Database db = new Database()) {
            Book result = db.getBookByAuthor("Doe");

            System.out.println(result.toString());
        }

    }
}
