import java.util.ArrayList;

public class TVSeries extends MediaEntry {
    private int totalEpisodes;
    private ArrayList<Episode> episodes;

    public TVSeries(String title, String genre, String status, int totalEpisodes, ArrayList<Episode> episodes) {
        super(title, genre, status);
        this.totalEpisodes = totalEpisodes;
        this.episodes = new ArrayList<>(episodes);
    }

    public void addEpisode(Episode ep) {
        episodes.add(ep);
    }

    public void displayDetails() {

    }
}