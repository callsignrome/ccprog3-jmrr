import java.util.Scanner;

public class MediaVault {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String username;
    boolean choseExit = false;
    int choice;

    System.out.println("Welcome to your Media Vault!");
    System.out.println("Enter username: ");
    username = sc.nextLine();
    sc.nextLine();
    User user = new User(username);

    System.out.println("Welcome " + user.getUsername() + "!");

    while(!choseExit) {
      System.out.println("What would you like to do, " + user.getUsername() + "?");
      System.out.println("  [1] Open Library");
      System.out.println("  [2] Add media");
      System.out.println("  [3] Rate media");
      System.out.println("  [4] Exit");
      System.out.println("   ");
      choice = sc.nextInt();
      sc.nextLine();

      while (choice < 1 || choice > 4) {
        choice = sc.nextInt();
        sc.nextLine();
      }

      if(choice == 1) {
        user.getLibrary().displayLibrary();
      }
      else if (choice == 2) {
        int mediaType;
        System.out.println("Media Type:");
        System.out.println("  [1] Movie");
        System.out.println("  [2] Book");
        System.out.println("  [3] TV Series");
        mediaType = sc.nextInt();
        sc.nextLine();

        while(mediaType < 1 || mediaType > 3) {
          mediaType = sc.nextInt();
          sc.nextLine();
        }

        switch(mediaType) {
          case 1:
            String title, genre, director, status;
            int runtime, movChoice;

            System.out.println("Enter Movie's Title: ");
            title = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter Movie's Genre: ");
            genre = sc.nextLine();
            sc.nextLine();
            System.out.println("Enter Movie's Director: ");
            director = sc.nextLine();
            sc.nextLine();
            System.out.println("Planned, In Progress, or Completed?");;
            System.out.println("  [1] Planned");
            System.out.println("  [2] In Progress");
            System.out.println("  [3] Completed");
            movChoice = sc.nextInt();
            sc.nextLine();

            while(movChoice < 1 || movChoice > 3) {
              movChoice = sc.nextInt();
              sc.nextLine();
            }

            if (movChoice == 1)
              status = MediaEntry.STATUSES[0];
            else if (movChoice == 2)
              status = MediaEntry.STATUSES[1];
            else
              status = MediaEntry.STATUSES[2];

            System.out.println("Enter Movie's Runtime in Minutes: ");
            runtime = sc.nextInt();
            sc.nextLine();

            user.getLibrary().addEntry(new Movie(title, genre, status, director, runtime));
            break;
          case 2:

        }
      }
    }
  }
}
