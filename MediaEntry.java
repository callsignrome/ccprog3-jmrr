public abstract class MediaEntry {
    private String title;
    private String genre;
    private String currentStatus;
    private int rating;
    private String review;
    public static final String[] STATUSES = {"Planned","In Progress","Completed"};

    public MediaEntry(String title, String genre, String currentStatus) {
        this.title = title;
        this.genre = genre;
        this.currentStatus = currentStatus;
    }

    public String getTitle() {
        return this.title;
    }

    public int getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    public String getGenre() {
        return genre;
    }

    public String getCurrentStatus() {
        return this.currentStatus;
    }

    public void setCurrentStatus(String newStatus) {
        this.currentStatus = newStatus;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public abstract void displayDetails();
}