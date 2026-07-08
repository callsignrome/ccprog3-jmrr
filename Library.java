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
        if (m.getCurrentStatus().equals("Completed") == true) {
            // input validation for out of bounds rating
            while (rating > 5 || rating < 0) {
                System.out.println("Error: Ratings are only from 0 - 5 stars! Try again.");
                Scanner sc1 = new Scanner(System.in);
                System.out.println("Enter rating (0-5 stars): ");
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
        System.out.println("[1] Planned");
        System.out.println("[2] In Progress");
        System.out.println("[3] Completed");
        System.out.println("Enter: ");
        Scanner sc2 = new Scanner(System.in);
        int status = sc2.nextInt();

        while (status > 3 || status < 1) {
            System.out.println("Error: Input out of bounds. Try again: ");
            sc2.nextInt();
            sc2.close();
        }

        switch (status) {
            case 1:
                m.setCurrentStatus("Planned");
                break;
            case 2:
                m.setCurrentStatus("In Progress");
                break;
            case 3:
                m.setCurrentStatus("Completed");
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