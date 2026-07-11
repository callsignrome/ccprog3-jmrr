import java.util.ArrayList;

public class TVSeries extends MediaEntry {
    private int totalEpisodes;
    private ArrayList<Episode> episodes;

    public TVSeries(String title, String genre, String status, int totalEpisodes) {
        super(title, genre, status);
        this.totalEpisodes = totalEpisodes;
        this.episodes = new ArrayList<>();
    }

    public int getTotalEpisodes() { 
        return totalEpisodes; 
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes; 
    }

    public ArrayList<Episode> getEpisodes() { 
        return episodes; 
    }

    public void addEpisode(Episode ep) {
        episodes.add(ep);
    }

    public void displayDetails() {
        System.out.println("[TV Series] " + getTitle());
        System.out.println("Genre: " + getGenre() + " | Status: " + getCurrentStatus());
        System.out.println("Episodes Tracked: " + episodes.size() + " / " + totalEpisodes);
    }
}