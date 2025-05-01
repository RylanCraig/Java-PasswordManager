public class PasswordEntry {
    private String appName;
    private String username;
    private String password;

    //Constructor
    public PasswordEntry(String appName, String username, String password){
        this.appName = appName;
        this.username = username;
        this.password = password;
    }
    
    // Method to display the entry
    public void displayEntry() {
        System.out.println("App: " + appName);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }
}
