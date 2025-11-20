package MovieTicketBooking;

import java.io.*;
import java.util.*;

public class UserService {
    private List<User> users;
    private int nextID = 1;
    private final String FILE = "userinfo.txt";

    // Constructor - loads existing users (creates file if absent)
    public UserService() {
        loadUsers();
    }

    // Load users from file into the list and set nextID
    public void loadUsers() {
        users = new ArrayList<>();
        File f = new File(FILE);

        try {
            if (!f.exists()) {
                // create file if it doesn't exist (start fresh)
                f.createNewFile();
                nextID = 1;
            }
        } catch (IOException e) {
            System.out.println("Error while creating file: " + e.getMessage());
            nextID = 1;
            return;
        }

        // Read file (if empty, loop won't add any users)
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|", -1); // keep empty fields
                if (parts.length < 7) continue; // malformed line

                try {
                    int id = Integer.parseInt(parts[0]);
                    String firstname = parts[1];
                    String lastname = parts[2];
                    String email = parts[3];
                    long phonenumber = 0;
                    try {
                        phonenumber = Long.parseLong(parts[4]);
                    } catch (NumberFormatException pnfe) {
                        // leave phone as 0 if invalid in file
                    }
                    String password = parts[5];
                    String status = parts[6];

                    User u = new User( firstname, lastname, email, phonenumber, password, status);
                    u.setId(id);
                    users.add(u);
                } catch (NumberFormatException nfe) {
                    // skip line with invalid id
                }
            }
            updateNextId();
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
            users = new ArrayList<>();
            nextID = 1;
        }
    }

    // Save entire users list to file (overwrite) - try-with-resources auto-closes
    public void saveAllUsers() {
        if (users == null) users = new ArrayList<>();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (User u : users) {
                String line = u.getId() + "|" +
                              safe(u.getFirstname()) + "|" +
                              safe(u.getLastname()) + "|" +
                              safe(u.getEmail()) + "|" +
                              u.getPhonenumber() + "|" +
                              safe(u.getPassword()) + "|" +
                              safe(u.getStatus());
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Helper to avoid null strings in file
    private String safe(String s) {
        return (s == null) ? "" : s;
    }

    // Add a user: assign id, add to list, persist
    public User addUser(User u) {
        if (u == null) return null;
        u.setId(nextID++);
        if (users == null) users = new ArrayList<>();
        users.add(u);
        saveAllUsers();
        System.out.println("User added successfully with id: " + u.getId());
        return u;
    }

    // Find user by id
    public User findById(int keyword) {
        if (users == null) return null;
        return users.stream().filter(u -> u.getId() == keyword).findFirst().orElse(null);
    }

    // Menu-driven updateUser: asks id, which field, new value, updates and saves
    public void updateUser(Scanner sc) {
        System.out.print("Enter the id you want to update: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid id input");
            sc.nextLine();
            return;
        }
        int enteredId = sc.nextInt();
        sc.nextLine(); // consume newline after int

        User u = findById(enteredId);
        if (u == null) {
            System.out.println("User not found");
            return;
        }

        System.out.println("Which field do you want to update?");
        System.out.println("1. Firstname");
        System.out.println("2. Lastname");
        System.out.println("3. Email");
        System.out.println("4. Phone number");
        System.out.println("5. Password");
        System.out.print("Enter your choice: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid choice.");
            sc.nextLine();
            return;
        }
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline after choice

        switch (choice) {
            case 1:
                System.out.print("Enter new firstname: ");
                String fn = sc.nextLine();
                u.setFirstname(fn);
                break;
            case 2:
                System.out.print("Enter new lastname: ");
                String ln = sc.nextLine();
                u.setLastname(ln);
                break;
            case 3:
                System.out.print("Enter new email: ");
                String email = sc.nextLine();
                u.setEmail(email); // setter validates and prints message if invalid
                break;
            case 4:
                System.out.print("Enter new phone number (10 digits): ");
                if (!sc.hasNextLong()) {
                    System.out.println("Invalid phone input.");
                    sc.nextLine();
                    return;
                }
                long ph = sc.nextLong();
                sc.nextLine();
                u.setPhonenumber(ph); // setter validates
                break;
            case 5:
                System.out.print("Enter new password: ");
                String pwd = sc.nextLine();
                u.setPassword(pwd); // setter validates
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        saveAllUsers();
        System.out.println("User updated successfully");
    }

    // "Remove" user by setting status to "inactive"
    public boolean removeUser(int keyword) {
        if (users == null) return false;
        for (User u : users) {
            if (u.getId() == keyword) {
                u.setStatus("inactive");
                saveAllUsers();
                System.out.println("User set to inactive for id: " + keyword);
                return true;
            }
        }
        return false;
    }

    // Utility to set nextID based on existing list
    private void updateNextId() {
        int max = 0;
        if (users == null) {
            nextID = 1;
            return;
        }
        for (User u : users) {
            if (u.getId() > max) max = u.getId();
        }
        nextID = max + 1;
    }

    // Display users (onlyActive true -> show only active users)
    public void displayAllUsers(boolean onlyActive) {
        if (users == null || users.isEmpty()) {
            System.out.println("No users to display.");
            return;
        }
        for (User u : users) {
            if (onlyActive) {
                if ("active".equalsIgnoreCase(u.getStatus())) {
                    System.out.println(u.toString());
                }
            } else {
                System.out.println(u.toString());
            }
        }
    }
}
