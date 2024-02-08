import dk.harbojohnston.Database.DatabaseActions;
import org.junit.Test;

import java.io.IOException;

public class DatabaseTest {

    @Test
    public void testConnection() throws IOException {
        DatabaseActions.connectToDb();
    }
}
