package dk.harbojohnston;

public class Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private Status status;
    private String description;
    private String shortDescription;
    private float rating;
    private long isbn;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public enum Status {
        TOREAD,
        READING,
        READ,
        DNF

    }

    public void setAllValues(int id, String title, String author, int pages, Status status,
                             String description, String shortDescription, float rating, long isbn){
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.status = status;
        this.description = description;
        this.shortDescription = shortDescription;
        this.rating = rating;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", status=" + status +
                ", description='" + description + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", rating=" + rating +
                ", isbn=" + isbn +
                '}';
    }
}
