import java.util.*;

public class Library {
    private ArrayList<MediaEntry> media;

    public Library() {
        this.media = new ArrayList<MediaEntry>();
    }

    public void addEntry(MediaEntry m) {
        this.media.add(m);
    }

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

    public void updateProgress(MediaEntry m, Scanner sc) {
        System.out.println(m.getTitle() + ": " + m.getCurrentStatus());
        System.out.println("Update status to:");
        for (int i = 0; i < MediaEntry.STATUSES.length; i++)
            System.out.println("["+ (i+1) +"] " + MediaEntry.STATUSES[i]);
        System.out.println("Enter: ");
        int status = sc.nextInt();
        sc.nextLine();

        while (status > 3 || status < 1) {
            System.out.println("Error: Input out of bounds. Try again: ");
            status = sc.nextInt();
            sc.nextLine();
        }

        switch (status) {
            case 1:
                m.setCurrentStatus(MediaEntry.STATUSES[0]);
                break;
            case 2:
                m.setCurrentStatus(MediaEntry.STATUSES[1]);
                break;
            case 3:
                m.setCurrentStatus(MediaEntry.STATUSES[2]);
                break;
        }
    }

    public void deleteEntry(int index) {
        this.media.remove(index);
    }

    public void displayEntry(MediaEntry m) {
        System.out.println(m.getTitle());
        if (m instanceof TVSeries) {
            System.out.println("TV Series");
            System.out.println("No. of episodes: " + ((TVSeries)m).getTotalEpisodes());
            System.out.println("Episodes:");
            ArrayList<Episode> eps = ((TVSeries)m).getEpisodes();
            eps.sort(Comparator.comparing(Episode::getSeason));

            for(int i = 0; i < ((TVSeries)m).getEpisodes().size(); i++)
                System.out.println((i+1) + ". " + eps.get(i).getTitle());
        } else {
            System.out.println(m.getClass().getSimpleName());
        }
        System.out.println("Status: " + m.getCurrentStatus());
        System.out.print("Rating: ");

        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[2])) {
            System.out.println(m.getRating());
            if (m.getReview() != null) {
                System.out.println("Review: ");
                System.out.println(m.getReview());
            }
        } else {
            System.out.println("not completed");
            System.out.println("Review: not completed");
        }
    }

    public void displayLibrary() {
        if (!media.isEmpty())
            for(int i = 0; i < this.media.size(); i++)
                System.out.println("[" + (i+1) + "]" + this.media.get(i).getTitle() + ": " + this.media.get(i).getCurrentStatus());
        else
            System.out.println("Your library is empty!");
    }
}