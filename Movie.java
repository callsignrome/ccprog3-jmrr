public class Movie extends MediaEntry {
    private String director;
    private int runtimeMinutes;

    public Movie(String title, String genre, String status, String director, int runtimeMinutes) {
        super(title, genre, status);
        this.director = director;
        this.runtimeMinutes = runtimeMinutes;
    }

    public String getDirector() { 
        return director; 
    }
    public void setDirector(String director) { 
        this.director = director; 
    }
    
    public int getRuntimeMinutes() { 
        return runtimeMinutes; 
    }

    public void setRuntimeMinutes(int runtimeMinutes) { 
        this.runtimeMinutes = runtimeMinutes; 
    }
    
    public void displayDetails() {
        System.out.println("[Movie] " + getTitle());
        System.out.println("Director: " + director);
        System.out.println("Genre: " + getGenre() + " | Status: " + getStatus());
        System.out.println("Runtime: " + runtimeMinutes + " mins");
        System.out.println("---------------------------------------------------------");
    }
}