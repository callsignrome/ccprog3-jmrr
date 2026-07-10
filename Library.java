import java.util.*;

public class Library {
    private ArrayList<MediaEntry> media;

    public Library() {
        this.media = new ArrayList<MediaEntry>();
    }

    public void addEntry(MediaEntry m) {
        this.media.add(m);
    }

    public void rateEntry(MediaEntry m, int rating, String review) {
        if (m.getCurrentStatus().equals(MediaEntry.STATUSES[2])) {
            // input validation for out of bounds rating
            while (rating > 10 || rating < 0) {
                System.out.println("Error: Ratings are only from 0 - 10 stars! Try again.");
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter rating (0-10 stars): ");
                rating = sc1.nextInt();
                sc1.close();
            }
            m.setRating(rating);
            m.setReview(review);
        }
        else
            System.out.println("You haven't finished this yet. Rate it when you do!");

    }

    public void updateProgress(MediaEntry m) {
        System.out.println(m.getTitle() + ": " + m.getCurrentStatus());
        System.out.println("Update status to:");
        for (int i = 0; i < MediaEntry.STATUSES.length; i++)
            System.out.println("["+ i +"] " + MediaEntry.STATUSES[i]);
        System.out.println("Enter: ");

        Scanner sc2 = new Scanner(System.in);
        int status = sc2.nextInt();

        while (status > 3 || status < 1) {
            System.out.println("Error: Input out of bounds. Try again: ");
            status = sc2.nextInt();
            sc2.close();
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

//    public void displayEntry {
//
//    }
//
//    public void displayLibrary {
//
//    }
}