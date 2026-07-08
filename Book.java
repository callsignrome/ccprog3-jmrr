public class Book extends MediaEntry {
    private String author;
    private int pageCount;

    public Book(String title, String genre, String status, String author, int pageCount) {
        super(title, genre, status);
        this.author = author;
        this.pageCount = pageCount;
    }

    public void displayDetails() {

    }
}