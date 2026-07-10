public class Episode {
    private String title;
    private int episodeNumber;
    private int season;

    public Episode(String title, int episodeNumber, int season) {
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.season = season;
    }

    public String getTitle() { 
        return title; 
    }

    public void setTitle(String title) { 
        this.title = title; 
    }

    public int getEpisodeNumber() { 
        return episodeNumber; 
    }

    public void setEpisodeNumber(int episodeNumber) { 
        this.episodeNumber = episodeNumber; 
    }

    public int getSeason() { 
        return season; 
    }

    public void setSeason(int season) { 
        this.season = season; 
    }
    
    public void displayDetails() {
        System.out.println("Season " + season + " Ep " + episodeNumber + ": " + title);
    }
}