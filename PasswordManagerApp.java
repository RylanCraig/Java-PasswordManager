import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;   
import java.io.IOException; 

public class PasswordManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<PasswordEntry> entries = new ArrayList<>();

        System.out.print("How many password entries would you like to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Entry " + (i + 1) + " ---");
            System.out.print("App/Website Name: ");
            String appName = scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Create PasswordEntry object
            PasswordEntry entry = new PasswordEntry(appName, username, password);

            // Add to the list
            entries.add(entry);

            // Save to file immediately after creation
            try {
                FileWriter writer = new FileWriter("passwords.txt", true); // true = append mode
                writer.write("App: " + appName + "\n");
                writer.write("Username: " + username + "\n");
                writer.write("Password: " + password + "\n");
                writer.write("--------------------------\n");
                writer.close();
            } catch (IOException e) {
                System.out.println("Error saving entry to file.");
                e.printStackTrace();
            }
        }

        // Display saved entries
        System.out.println("\n--- Saved Entries ---");
        for (PasswordEntry e : entries) {
            e.displayEntry();
            System.out.println("----------------------");
        }

        scanner.close();
    }
}
