import java.util.*;

public class MediaVault {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;
    int choice;

    System.out.println("-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-");
    System.out.println("                  Welcome to MediaVault!                  ");
    System.out.println("-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-+H+-");
    
    System.out.print("Enter your username to begin: ");
    String username = sc.nextLine();
    User currentUser = new User(username);
    Library myLibrary = currentUser.getLibrary();

    while (running) {
      System.out.println("\n--------------------- MAIN MENU ---------------------");
      System.out.println("  1 - Add a New Media Entry");
      System.out.println("  2 - Update Entry Status");
      System.out.println("  3 - Rate & Review a Completed Entry");
      System.out.println("  4 - View Full Details of an Entry");
      System.out.println("  5 - Display Entire Library");
      System.out.println("  6 - Exit");
      System.out.println("-------------------------------------------------------");
      System.out.print("Select an option: ");
      
      choice = sc.nextInt();
      sc.nextLine(); 
      
      switch (choice) {
          case 1:
              
          case 2:
              
          case 3:
              
          case 4:
              
          case 5:
              
          case 6:
              
      }
    }
  
    sc.close(); 
  }
}

