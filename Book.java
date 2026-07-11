public class Book extends MediaEntry {
    private String author;
    private int pageCount;

    public Book(String title, String genre, String status, String author, int pageCount) {
        super(title, genre, status);
        this.author = author;
        this.pageCount = pageCount;
    }

    public String getAuthor() { 
        return author; 
    }

    public void setAuthor(String author) {
        this.author = author; 
    }

    public int getPageCount() { 
        return pageCount; 
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount; 
    }

    public void displayDetails() {
        System.out.println("[Book] " + getTitle());
        System.out.println("Author: " + author);
        System.out.println("Genre: " + getGenre() + " | Status: " + getCurrentStatus());
        System.out.println("Length: " + pageCount + " pages");
    }
}