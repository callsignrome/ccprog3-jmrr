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
            System.out.println("You've rated " + m.getTitle() + " " + rating + " stars!");

            System.out.println("Write a review? (y/n): ");
            char choice = sc.next().toLowerCase().charAt(0);
            sc.nextLine();

            switch (choice) {
                case 'y':
                    System.out.println("What did you think about " + m.getTitle() + "? (Press ENTER to submit)");
                    String review = sc.nextLine();
                    m.setReview(review);
                    System.out.println("Rating and Review successfully added!");
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
        System.out.println("Update status to:");
        for (int i = 0; i < MediaEntry.STATUSES.length; i++)
            System.out.println("["+ (i+1) +"] " + MediaEntry.STATUSES[i]);
        System.out.println("Enter: ");
        int status = sc.nextInt();
        sc.nextLine();

        while (status > 2 || status < 0) {
            System.out.println("Error: Input out of bounds. Try again: ");
            System.out.print("Enter: ");
            status = sc.nextInt();
            sc.nextLine();
        }

        switch (status) {
            case 0:
                m.setCurrentStatus(MediaEntry.STATUSES[0]);
                break;
            case 1:
                m.setCurrentStatus(MediaEntry.STATUSES[1]);
                break;
            case 2:
                m.setCurrentStatus(MediaEntry.STATUSES[2]);
                break;
        }
    }

    public void deleteEntry(int index) {
        this.media.remove(index);
    }

    public MediaEntry getEntry(int index) {
        if (index >= 0 && index < media.size()) {
            return media.get(index);
        }
        return null;
    }

    public int getSize() {
        return media.size();
    }

    public void displayEntry(MediaEntry m) {
        m.displayDetails();
        
        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[2])) {
            System.out.println("Your Rating: " + m.getRating() + "/10");
            if (m.getReview() != null && !m.getReview().trim().isEmpty()) {
                System.out.println("Your Review: " + m.getReview());
            } else {
                System.out.println("Your Review: (No review provided)");
            }
        } else {
            System.out.println("Rating: N/A (Finish it first!)");
            System.out.println("Review: N/A");
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