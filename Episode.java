/**
 * Represents an episode in a <code>TVSeries</code> instance.
 *
 * @author Jimlor
 * @version 1.3
 */
public class Episode {
    /** The title of this component */
    private String title;
    /** The chronological number of the episode when watched */
    private int episodeNumber;
    /** The season the episode is in */
    private int season;

    /**
     * Class constructor specifying this instance's title, episode number and season
     *
     * @param title the title of this component
     * @param episodeNumber the episode number designated to this component
     * @param season the season number designated to this component
     */
    public Episode(String title, int episodeNumber, int season) {
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.season = season;
    }

    /**
     * Gets the title of this component.
     *
     * @return the <code>String</code> of the title.
     */
    public String getTitle() { 
        return title; 
    }

    /**
     * Sets the title of this component
     *
     * @param title the title of the episode that will be set as
     */
    public void setTitle(String title) { 
        this.title = title; 
    }

    /**
     * Retrives the episode number of this component
     *
     * @return the <code>int</code> value of the episode number.
     */
    public int getEpisodeNumber() { 
        return episodeNumber; 
    }

    /**
     * Sets the episode number of this component.
     *
     * @param episodeNumber the new episode number that will be set.
     */
    public void setEpisodeNumber(int episodeNumber) { 
        this.episodeNumber = episodeNumber; 
    }

    /**
     * Gets the season number of this component.
     *
     * @return the <code>int</code> value of this component.
     */
    public int getSeason() { 
        return season; 
    }

    /**
     * Sets the value of the season number of this component.
     *
     * @param season the value of the season number that will be set as.
     */
    public void setSeason(int season) { 
        this.season = season; 
    }

    /**
     * Displays the details of the episode (season, episode number, and title) to the console.
     *
     * <p>
     *     <b>Preconditions:</b>
     *     <ul>
     *         <li><code>season</code>, <code>episodeNumber</code>, and <code>title</code> must be
     *         initialized/not null.</li>
     *     </ul>
     * </p>
     */
    public void displayDetails() {
        System.out.println("Season " + season + " Ep " + episodeNumber + ": " + title);
    }
}