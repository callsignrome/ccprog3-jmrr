import java.util.*;

public class MediaVault {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    String username;
    int choice;
    int updateIdx;
    int initialRating;
    int filterChoice;
    int statusChoice;
    int mediaChoice;
    int rateIdx;
    int viewIdx;
    int delIdx;

    System.out.println("-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-");
    System.out.println("                  Welcome to MediaVault!                  ");
    System.out.println("-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-");
    
    System.out.print("Enter your username to begin: ");
    username = sc.nextLine();
    User currentUser = new User(username);
    Library myLibrary = currentUser.getLibrary();

    while (running) {
      System.out.println("\n--------------------- MAIN MENU ---------------------");
      System.out.println("  1 - Add a New Media Entry");
      System.out.println("  2 - Update Entry Status");
      System.out.println("  3 - Rate & Review a Completed Entry");
      System.out.println("  4 - View Full Details of an Entry");
      System.out.println("  5 - Display Entire Library");
      System.out.println("  6 - Delete an Entry");
      System.out.println("  7 - Exit");
      System.out.println("-------------------------------------------------------");
      System.out.print("Select an option: ");
      
      choice = sc.nextInt();
      sc.nextLine(); 
      
      switch (choice) {
          case 1:
            addMediaMenu(sc, myLibrary);
            break;
          case 2:
            if (myLibrary.getSize() == 0) {
              System.out.println("Your library is empty!");
              break;
            }
            myLibrary.displayLibrary();
            System.out.print("Enter the number of the entry to update: ");
            updateIdx = sc.nextInt() - 1;
            sc.nextLine();
            
            MediaEntry entryToUpdate = myLibrary.getEntry(updateIdx);
            if (entryToUpdate != null) {
                myLibrary.updateProgress(entryToUpdate, sc);
                System.out.println("Status updated successfully.");
            } else {
                System.out.println("Invalid entry number.");
            }
            break;
          case 3:
            if (myLibrary.getSize() == 0) {
              System.out.println("Your library is empty!");
              break;
            }
            myLibrary.displayLibrary();
            System.out.print("Enter the number of the entry to rate: ");
            rateIdx = sc.nextInt() - 1;
            sc.nextLine();
            
            MediaEntry entryToRate = myLibrary.getEntry(rateIdx);
            if (entryToRate != null) {
                System.out.print("Enter initial rating (0-10 stars): ");
                initialRating = sc.nextInt();
                sc.nextLine();
                
                myLibrary.rateEntry(entryToRate, initialRating, sc);
            } else {
                System.out.println("Invalid entry number.");
            }
            break;
          case 4:
           if (myLibrary.getSize() == 0) {
              System.out.println("Your library is empty!");
              break;
            }

            myLibrary.displayLibrary();
            System.out.print("Enter the number of the entry to view: ");
            viewIdx = sc.nextInt() - 1;
            sc.nextLine();
            
            MediaEntry entryToView = myLibrary.getEntry(viewIdx);
            if (entryToView != null) {
                System.out.println("\n-----------------------------------------");
                System.out.println("              ENTRY DETAILS              ");
                System.out.println("-----------------------------------------");
                myLibrary.displayEntry(entryToView);
                
                if (entryToView instanceof TVSeries) {
                    TVSeries tvs = (TVSeries) entryToView;
                    ArrayList<Episode> eps = tvs.getEpisodes();
                    System.out.println("\n------- Episode List --------");
                    if (!eps.isEmpty()) {
                        for (Episode ep : eps) {
                            ep.displayDetails();
                        }
                    } else {
                        System.out.println("No episodes added.");
                    }
                }
                System.out.println("-----------------------------------------");
            } else {
                System.out.println("Invalid entry number.");
            }
            break;
          case 5:
            System.out.println("\n--- " + currentUser.getUsername() + "'s Library ---");
            if (myLibrary.getSize() == 0) {
                System.out.println("No media in your library yet.");
            } else {
                myLibrary.displayLibrary();
                System.out.println("\nTotal Items: " + myLibrary.getSize());
                System.out.println("Filter by:");
                System.out.println("  1 - Status");
                System.out.println("  2 - Media Type");

                do {
                    filterChoice = sc.nextInt();
                    sc.nextLine();
                } while (filterChoice < 1 || filterChoice > 2);

                if (filterChoice == 1) {
                    System.out.println("Filter by Status:");
                    System.out.println("  1 - Planned");
                    System.out.println("  2 - In Progress");
                    System.out.println("  3 - Completed");

                    do {
                        statusChoice = sc.nextInt();
                        sc.nextLine();
                    } while (statusChoice < 1 || statusChoice > 3);

                    switch (statusChoice) {
                        case 1:
                            myLibrary.displayLibrary(MediaEntry.STATUSES[0]);
                            break;
                        case 2:
                            myLibrary.displayLibrary(MediaEntry.STATUSES[1]);
                            break;
                        case 3:
                            myLibrary.displayLibrary(MediaEntry.STATUSES[2]);
                            break;
                    }
                }
                else {
                    System.out.println("Filter by Media Type:");
                    System.out.println("  1 - Movie");
                    System.out.println("  2 - Book");
                    System.out.println("  3 - TV Series");

                    do {
                        mediaChoice = sc.nextInt();
                        sc.nextLine();
                    } while (mediaChoice < 1 || mediaChoice > 3);

                    switch (mediaChoice) {
                        case 1:
                            myLibrary.displayLibrary(new Movie("","","","",1));
                            break;
                        case 2:
                            myLibrary.displayLibrary(new Book("","","","", 1));
                            break;
                        case 3:
                            myLibrary.displayLibrary(new TVSeries("","","", 1));
                            break;
                    }
                }
            }
            break;
          case 6:
            if (myLibrary.getSize() == 0) {
              System.out.println("Your library is empty!");
              break;
            }
            myLibrary.displayLibrary();
            System.out.print("Enter the number of the entry to DELETE: ");
            delIdx = sc.nextInt() - 1;
            sc.nextLine();
            
            if (myLibrary.getEntry(delIdx) != null) {
                myLibrary.deleteEntry(delIdx);
                System.out.println("Entry successfully deleted.");
            } else {
                System.out.println("Invalid entry number.");
            }
            break;
          case 7:
            running = false;
            System.out.println("Goodbye, " + currentUser.getUsername() + "!");
            break;
          default: 
            System.out.println("Invalid option. Please try again.");
      }
    }
  
    sc.close(); 
  }

  private static void addMediaMenu(Scanner sc, Library library) {
        int type;
        String title;
        String genre;
        int statusChoice;
        String status;
        String author;
        int pages;
        String director;
        int runtime;
        int episodes;

        System.out.println("\nWhat type of media are you adding?");
        System.out.println("  1 - Book");
        System.out.println("  2 - Movie");
        System.out.println("  3 - TV Series");
        System.out.print("Choice: ");

        type = sc.nextInt();
        sc.nextLine(); 
        while (type != 1 && type != 2 && type != 3) {
          System.out.println("Invalid choice. Please try again.");
          System.out.print("Choice: ");
          type = sc.nextInt();
          sc.nextLine();
        }

        System.out.print("Enter Title: ");
        title = sc.nextLine();
        
        System.out.print("Enter Genre: ");
        genre = sc.nextLine();
        
        System.out.println("Select Status:");
        System.out.println("  1 - Planned");
        System.out.println("  2 - In Progress");
        System.out.print("Choice (Completed items must be updated later): ");
        statusChoice = sc.nextInt();
        sc.nextLine();

        while (statusChoice != 1 && statusChoice != 2) {
          System.out.println("Invalid choice. Please try again.");
          System.out.print("Choice (Completed items must be updated later): ");
          statusChoice = sc.nextInt();
          sc.nextLine();
        }

        status = statusChoice == 2 ? MediaEntry.STATUSES[1] : MediaEntry.STATUSES[0];

        switch (type) {
            case 1:
                System.out.print("Enter Author: ");
                author = sc.nextLine();
                System.out.print("Enter Page Count: ");
                pages = sc.nextInt();
                sc.nextLine();
                library.addEntry(new Book(title, genre, status, author, pages));
                System.out.println("Book added successfully!");
                break;
            case 2:
                System.out.print("Enter Director: ");
                director = sc.nextLine();
                System.out.print("Enter Runtime (in minutes): ");
                runtime = sc.nextInt();
                sc.nextLine();
                library.addEntry(new Movie(title, genre, status, director, runtime));
                System.out.println("Movie added successfully!");
                break;
            case 3:
                System.out.print("Enter Total Number of Episodes: ");
                episodes = sc.nextInt();
                sc.nextLine();
                TVSeries newSeries = new TVSeries(title, genre, status, episodes);
                
                System.out.println("Let's add the episode titles for this series.");
                for (int i = 1; i <= episodes; i++) {
                    System.out.print("Enter title for Episode " + i + ": ");
                    String epTitle = sc.nextLine();
                    newSeries.addEpisode(new Episode(epTitle, i, 1)); 
                }
                
                library.addEntry(newSeries);
                System.out.println("TV Series and episodes added successfully!");
                break;
            default:
                System.out.println("Invalid media type. Cancelled.");
        }
    }
}

