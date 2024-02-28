package dk.harbojohnston.Database;

import dk.harbojohnston.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database implements AutoCloseable{

    private static final Logger log = LoggerFactory.getLogger(Database.class);

    private Connection connection;

    /* Columns in the database */
    private static final String BOOKS_TABLE = "books";
    private static final String ID_COLUMN = "id";
    private static final String TITLE_COLUMN = "title";
    private static final String AUTHOR_COLUMN = "author";
    private static final String PAGES_COLUMN = "pages";
    private static final String STATUS_COLUMN = "status";
    private static final String DESCRIPTION_COLUMN = "description";
    private static final String SHORT_DESCRIPTION_COLUMN = "short_description";
    private static final String RATING_COLUMN = "rating";
    private static final String ISBN_COLUMN = "isbn";

    public Database() throws SQLException, IOException {
        String propertiesPath =  "conf/database.properties";

        Properties databaseProperties = new Properties();
        databaseProperties.load(new FileInputStream(propertiesPath));


        String jdbcUrl = databaseProperties.getProperty("database.url");
        String username = databaseProperties.getProperty("database.username");
        String password = databaseProperties.getProperty("database.password");

        connection = DriverManager.getConnection(jdbcUrl, username, password);
    }

    /* SQL STATEMENTS */
    private static String clearTableStatement = "DELETE FROM " + BOOKS_TABLE;

    private static String createBookStatement = "INSERT INTO " + BOOKS_TABLE +
            " (" + ID_COLUMN + ", " + TITLE_COLUMN + ", " +AUTHOR_COLUMN + ","+ PAGES_COLUMN +"," + STATUS_COLUMN +","+ DESCRIPTION_COLUMN + ", " + SHORT_DESCRIPTION_COLUMN + ", " + RATING_COLUMN + ", " + ISBN_COLUMN + ")"+
            " VALUES (?,?,?,?,?,?,?,?,?)";
    private static String getBookByAuthor = "SELECT * FROM " + BOOKS_TABLE + " WHERE " + AUTHOR_COLUMN + " LIKE ?";
    private static String getBookByTitle = "SELECT * FROM " + BOOKS_TABLE + " WHERE " + TITLE_COLUMN +" LIKE ?";

    /* Methods */
    public void createBook(Book book){
        try(PreparedStatement statement = connection.prepareStatement(createBookStatement)){
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setInt(4, book.getPages());
            statement.setString(5, String.valueOf(book.getStatus()));
            statement.setString(6, book.getDescription());
            statement.setString(7, book.getShortDescription());
            statement.setFloat(8, book.getRating());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Book getBookByAuthor(String author){
        try (PreparedStatement statement = connection.prepareStatement(getBookByAuthor)){
            statement.setString(1, "%"+author+"%");

            ResultSet resultSet = statement.executeQuery();
            Book book = new Book();

            while (resultSet.next()) {
                int bookId = resultSet.getInt(ID_COLUMN);
                String bookTitle = resultSet.getString(TITLE_COLUMN);
                String bookAuthor = resultSet.getString(AUTHOR_COLUMN);
                int bookPages = resultSet.getInt(PAGES_COLUMN);
                Book.Status bookStatus = Book.Status.valueOf(resultSet.getString(STATUS_COLUMN));
                String bookDescription = resultSet.getString(DESCRIPTION_COLUMN);
                String bookShortDescription = resultSet.getString(SHORT_DESCRIPTION_COLUMN);
                float bookRating = resultSet.getFloat(RATING_COLUMN);
                long bookISBN = resultSet.getLong(ISBN_COLUMN);
                // You can retrieve other attributes of the book here if needed

                book.setAllValues(bookId, bookTitle, bookAuthor,bookPages, bookStatus, bookDescription,
                        bookShortDescription, bookRating, bookISBN);
                //System.out.println("Title: " + title + ", Author: " + bookAuthor);
            }

            return book;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookByTitle(String title){
        try (PreparedStatement statement = connection.prepareStatement(getBookByTitle)){
            statement.setString(1, "%"+title+"%");

            ResultSet resultSet = statement.executeQuery();
            Book book = new Book();

            while (resultSet.next()) {
                int bookId = resultSet.getInt(ID_COLUMN);
                String bookTitle = resultSet.getString(TITLE_COLUMN);
                String bookAuthor = resultSet.getString(AUTHOR_COLUMN);
                int bookPages = resultSet.getInt(PAGES_COLUMN);
                Book.Status bookStatus = Book.Status.valueOf(resultSet.getString(STATUS_COLUMN));
                String bookDescription = resultSet.getString(DESCRIPTION_COLUMN);
                String bookShortDescription = resultSet.getString(SHORT_DESCRIPTION_COLUMN);
                float bookRating = resultSet.getFloat(RATING_COLUMN);
                long bookISBN = resultSet.getLong(ISBN_COLUMN);
                // You can retrieve other attributes of the book here if needed

                book.setAllValues(bookId, bookTitle, bookAuthor,bookPages, bookStatus, bookDescription,
                        bookShortDescription, bookRating, bookISBN);
                //System.out.println("Title: " + title + ", Author: " + bookAuthor);
            }

            return book;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void close() throws Exception {

    }
}
