package dk.harbojohnston.Database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Database implements AutoCloseable{

    private static final Logger log = LoggerFactory.getLogger(Database.class);

    private static final String BOOKS_TABLE = "books";
    private static final String ID_COLUMN = "id";
    private static final String title_column = "title";


    @Override
    public void close() throws Exception {

    }
}
