import java.util.*;

/**
 * Represents a library of media entries.
 * <p>This class manages all operations that will be done on each MediaEntry</p>
 *
 * @author Raphael
 * @version 1.3
 */
public class Library {
    /** The list containing all media entries. */
    private ArrayList<MediaEntry> media;

    /**
     * Creates an empty Library.
     */
    public Library() {
        this.media = new ArrayList<MediaEntry>();
    }

    /**
     * Adds a media entry to this component.
     *
     * @param m the <code>MediaEntry</code> that will be added.
     */
    public void addEntry(MediaEntry m) {
        this.media.add(m);
    }

    /**
     * Rates a media entry from 0-10.
     *
     * <p>
     *     <b>Preconditions: </b>
     *     <ul>
     *         <li> The media entry <code>m</code> must be designated as Completed before it can be rated.</li>
     *         <li> The <code>rating</code> must be between 0-10 inclusive.</li>
     *     </ul>
     * </p>
     *
     * @param m the <code>MediaEntry</code> to be rated.
     * @param rating the numerical rating (0-10) given to the media entry.
     * @param sc the <code>Scanner</code> object used to read and validate user input.
     */
    public void rateEntry(MediaEntry m, int rating, Scanner sc) {
        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[2])) {
            // input validation for out of bounds rating
            while (rating > 10 || rating < 0) {
                System.out.println("Error: Ratings are only from 0 - 10 stars! Try again.");
                System.out.println("Enter rating (0-10 stars): ");
                rating = sc.nextInt();
                sc.nextLine();
            }
            m.setRating(rating);
            System.out.println("You've rated " + m.getTitle() + " " + rating + "stars!");

            System.out.println("Write a review? (y/n): ");
            char choice = sc.next().toLowerCase().charAt(0);
            sc.nextLine();

            switch (choice) {
                case 'y':
                    System.out.println("What did you think about " + m.getTitle() + "? (Press ENTER to submit)");
                    String review = sc.nextLine();
                    sc.nextLine();
                    m.setReview(review);
                    break;
                case 'n':
                    break;
                default:
                    System.out.println("Invalid input. Try putting a review again later!");
                    break;
            }
        }
        else
            System.out.println("You haven't finished this yet. Rate it when you do!");

    }

    /**
     * Advances the status of a media entry to the next progressive stage.
     * <p>
     * The status updates follow a linear progression:
     * <ul>
     *   <li>Planned (STATUSES[0]) &rarr; In Progress (STATUSES[1])</li>
     *   <li>In Progress (STATUSES[1]) &rarr; Completed (STATUSES[2])</li>
     * </ul>
     * If the media entry is already completed, its status remains unchanged.
     * </p>
     *
     * <p>
     *     <b>Precondition:</b>
     *     <ul>
     *         <li>The <code>MediaEntry m</code> must not be null.</li>
     *     </ul>
     * </p>
     *
     * @param m the <code>MediaEntry</code> object whose status is being updated.
     */
    public void updateProgress(MediaEntry m) {
        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[0])) {
            m.setCurrentStatus(MediaEntry.STATUSES[1]);
            System.out.println("Set " + m.getTitle() + " as In Progress.");
        }
        else if (m.getCurrentStatus().equals(MediaEntry.STATUSES[1])) {
            m.setCurrentStatus(MediaEntry.STATUSES[2]);
            System.out.println("Set " + m.getTitle() + " as Completed.");
        }
        else System.out.println("You've already completed " + m.getTitle() + ".");
    }

    /**
     * Deletes a media entry from this component.
     *
     * @param index the index of the media entry.
     */
    public void deleteEntry(int index) {
        this.media.remove(index);
    }

    /**
     * Displays the complete details of a specific media entry to the console.
     * <p>
     * If the media entry is an instance of <code>TVSeries</code>, it will additionally
     * format and display the total episodes, and print a chronological list of episodes
     * sorted by their season numbers.
     * </p>
     * <p>
     * The rating and text review will only be displayed if the status of the
     * media entry is Completed.
     * </p>
     *
     * <p>
     *     <b>Precondition:</b>
     *     <ul>
     *         <li>The parameter <code>m</code> must not be null.</li>
     *     </ul>
     * </p>
     *
     * @param m the <code>MediaEntry</code> object whose information is to be displayed
     */
    public void displayEntry(MediaEntry m) {
        System.out.println(m.getTitle());

        if (m instanceof TVSeries) {
            TVSeries series = (TVSeries) m;

            System.out.println("TV Series");
            System.out.println("No. of episodes: " + series.getTotalEpisodes());
            System.out.println("Episodes:");

            ArrayList<Episode> eps = series.getEpisodes();
            eps.sort(Comparator.comparing(Episode::getSeason));

            for (int i = 0; i < eps.size(); i++) {
                System.out.println((i + 1) + ". " + eps.get(i).getTitle());
            }
        } else {
            System.out.println(m.getClass().getSimpleName());
        }

        System.out.println("Status: " + m.getCurrentStatus());
        System.out.print("Rating: ");

        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[2])) {
            System.out.println(m.getRating());
            if (m.getReview() != null && !m.getReview().isBlank()) {
                System.out.println("Review: ");
                System.out.println(m.getReview());
            }
        } else {
            System.out.println("not completed");
            System.out.println("Review: not completed");
        }
    }

    /**
     * Displays all media entries currently stored in the library.
     * <p>
     * This method iterates through the entire library collection and prints each item's
     * title alongside its current consumption status.
     * </p>
     *
     * <p>
     *     <b>Precondition:</b>
     *     <ul>
     *         <li>The <code>media</code> collection must be initialized (not null).</li>
     *     </ul>
     * </p>
     */
    public void displayLibrary() {
        if (!media.isEmpty())
            for(int i = 0; i < this.media.size(); i++)
                System.out.println("[" + (i+1) + "]" + this.media.get(i).getTitle() + ": " + this.media.get(i).getCurrentStatus());
        else
            System.out.println("Your library is empty!");
    }

    /**
     * Displays a filtered list of media entries matching a specific status.
     * <p>
     * This method checks the status string of every media item in the library and displays
     * only those that match the exact value passed in the <code>status</code> parameter.
     * </p>
     *
     * <p>
     *     <b>Preconditions:</b>
     *     <ul>
     *         <li>The <code>media</code> collection must be initialized (not null).</li>
     *         <li>The <code>status</code> parameter should match one of the predefined
     *             status constants (e.g., <code>MediaEntry.STATUSES</code>).</li>
     *     </ul>
     * </p>
     *
     * @param status the exact status text to filter the library entries by
     */
    public void displayLibrary(String status) {
        if (!media.isEmpty()) {
            ArrayList<MediaEntry> filtered = new ArrayList<>();

            for (MediaEntry mediaEntry : this.media) {
                if (mediaEntry.getCurrentStatus().equals(status)) {
                    filtered.add(mediaEntry);
                }
            }

            System.out.println("Filter by: " + status);
            if(filtered.isEmpty())
                System.out.println("No matching items found.");
            else
                for(int j = 0; j < filtered.size(); j++) {
                    System.out.println((j+1) + ". " + filtered.get(j).getTitle());
            }
        }
        else
            System.out.println("Your library is empty!");
    }

    /**
     * Displays a filtered list of media entries matching the exact class type of the provided object.
     * <p>
     * This method dynamically checks the runtime class of the passed <code>m</code> parameter
     * and prints only the media entries in the library that share the identical subclass type
     * (e.g., only <code>Book</code> objects, or only <code>Movie</code> objects).
     * </p>
     *
     * <p>
     *     <b>Preconditions:</b>
     *     <ul>
     *         <li>The <code>media</code> collection must be initialized (not null).</li>
     *         <li>The parameter <code>m</code> must not be null.</li>
     *     </ul>
     * </p>
     *
     * @param m an instance of a <code>MediaEntry</code> subclass used to determine the class type to filter by
     */
    public void displayLibrary(MediaEntry m) {
        if (!media.isEmpty()) {
            ArrayList<MediaEntry> filtered = new ArrayList<>();

            for (MediaEntry mediaEntry : this.media) {
                if (mediaEntry.getClass() == m.getClass()) {
                    filtered.add(mediaEntry);
                }
            }

            System.out.println("Filter by: " + m.getClass().getSimpleName());
            if(filtered.isEmpty()) {
                System.out.println("No matching items found.");
            }
            else {
                for (int j = 0; j < filtered.size(); j++) {
                    System.out.println((j + 1) + ". " + filtered.get(j).getTitle());
                }
            }
        }
        else
            System.out.println("Your library is empty!");
    }
}