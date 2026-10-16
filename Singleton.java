/**
 * Singleton Pattern Implementation
 * 
 * The Singleton pattern is a creational design pattern that restricts the instantiation
 * of a class to a single object. This is useful when exactly one object of a class is needed
 * to coordinate actions across the system.
 * 
 * This implementation uses the eager initialization approach, where the singleton instance
 * is created when the class is loaded.
 */
public class Singleton {
    
    // Static instance of the Singleton class created at class loading time
    private static final Singleton instance = new Singleton();
    
    /**
     * Private constructor prevents instantiation from outside the class.
     * This ensures that no other class can create instances of Singleton.
     */
    private Singleton() {
    }
    
    /**
     * Public method to get the singleton instance.
     * 
     * @return The single instance of the Singleton class
     */
    public static Singleton getInstance() {
        return instance;
    }
    
    /**
     * Example method demonstrating singleton functionality
     * 
     * @param message The message to display
     */
    public void displayMessage(String message) {
        System.out.println("Singleton: " + message);
    }
    
    /**
     * Main method demonstrating singleton usage
     */
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        
        // Both references point to the same instance
        singleton1.displayMessage("First reference");
        singleton2.displayMessage("Second reference");
        
        // Verify both references are identical
        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
    }
}