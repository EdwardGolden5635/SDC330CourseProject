import java.util.Scanner;

/**
 * Main application for the Sports Card Database Project.
 *
 * Demonstrates:
 * - Interface usage
 * - Abstract class usage
 * - Inheritance
 * - Composition
 * - Polymorphism
 * - SQLite CRUD operations
 * - Terminal input/output
 */
public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DatabaseManager db = new DatabaseManager();

        int choice;

        System.out.println("-------------------------------------");
        System.out.println("Sports Card Project Week 4");
        System.out.println("Edward Golden");
        System.out.println("-------------------------------------");

        do {

            System.out.println("\n===== SPORTS CARD MENU =====");
            System.out.println("1. Add Sports Card");
            System.out.println("2. Add Graded Card");
            System.out.println("3. Display Database Records");
            System.out.println("4. Update Player Name");
            System.out.println("5. Delete Card");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Player Name: ");
                    String player = scanner.nextLine();

                    System.out.print("Team: ");
                    String team = scanner.nextLine();

                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Manufacturer: ");
                    String manufacturer = scanner.nextLine();

                    SportsCard sportsCard =
                            new SportsCard(
                                    player,
                                    team,
                                    year,
                                    manufacturer);

                    db.saveCard(sportsCard);

                    System.out.println("Sports card saved.");
                    break;

                case 2:

                    System.out.print("Player Name: ");
                    player = scanner.nextLine();

                    System.out.print("Team: ");
                    team = scanner.nextLine();

                    System.out.print("Year: ");
                    year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Grading Company: ");
                    String company = scanner.nextLine();

                    System.out.print("Grade: ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();

                    GradedCard gradedCard =
                            new GradedCard(
                                    player,
                                    team,
                                    year,
                                    company,
                                    grade);

                    db.saveCard(gradedCard);

                    System.out.println("Graded card saved.");
                    break;

                case 3:

                    System.out.println("\nCurrent Database Records:");
                    db.displayCards();
                    break;

                case 4:

                    System.out.print("Enter Card ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Player Name: ");
                    String newName = scanner.nextLine();

                    db.updatePlayer(updateId, newName);

                    System.out.println("Record updated.");
                    break;

                case 5:

                    System.out.print("Enter Card ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    db.deleteCard(deleteId);

                    System.out.println("Record deleted.");
                    break;

                case 6:

                    System.out.println("Exiting program...");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}