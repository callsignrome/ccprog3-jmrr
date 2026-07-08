public class Movie extends MediaEntry {
    private String director;
    private int runtimeMinutes;

    public Movie(String title, String genre, String status, String director, int runtimeMinutes) {
        super(title, genre, status);
        this.director = director;
        this.runtimeMinutes = runtimeMinutes;
    }

    public void displayDetails() {

    }
}