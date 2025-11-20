package MovieTicketBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== USER MANAGEMENT MENU ===");
            System.out.println("1. Add User");
            System.out.println("2. View All Users");
            System.out.println("3. View Active Users");
            System.out.println("4. Search User by ID");
            System.out.println("5. Update User");
            System.out.println("6. Remove User (set inactive)");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = readIntSafe(sc);

            switch (choice) {
                case 1:
                    addUserFlow(sc, userService);
                    break;

                case 2:
                    userService.displayAllUsers(false);
                    break;

                case 3:
                    userService.displayAllUsers(true);
                    break;

                case 4:
                    System.out.print("Enter User ID: ");
                    int idSearch = readIntSafe(sc);
                    User u = userService.findById(idSearch);
                    if (u == null) System.out.println("User not found.");
                    else System.out.println(u);
                    break;

                case 5:
                    userService.updateUser(sc);
                    break;

                case 6:
                    System.out.print("Enter User ID to remove: ");
                    int idRemove = readIntSafe(sc);
                    boolean removed = userService.removeUser(idRemove);
                    if (!removed) System.out.println("User not found.");
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
    }

    /* -------- Helper Methods -------- */

    private static void addUserFlow(Scanner sc, UserService userService) {
        System.out.print("Enter firstname: ");
        String fn = sc.nextLine().trim();

        System.out.print("Enter lastname: ");
        String ln = sc.nextLine().trim();

        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        System.out.print("Enter phone number (10 digits): ");
        long phone = readLongSafe(sc);

        System.out.print("Enter password (min 6 chars, at least 1 uppercase): ");
        String pwd = sc.nextLine();

        String status = "active";

        User newUser = new User(fn, ln, email, phone, pwd, status);
        userService.addUser(newUser);
    }

    private static int readIntSafe(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            sc.nextLine();
        }
        int val = sc.nextInt();
        sc.nextLine(); // clear newline
        return val;
    }

    private static long readLongSafe(Scanner sc) {
        while (!sc.hasNextLong()) {
            System.out.print("Enter valid digits: ");
            sc.nextLine();
        }
        long val = sc.nextLong();
        sc.nextLine(); // clear newline
        return val;
    }
}


