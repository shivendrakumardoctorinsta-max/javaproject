package solid;

// This class demonstrates the Dependency Inversion Principle (DIP).
// DIP states that high-level modules should not depend on low-level modules. Both should depend on abstractions.
// Abstractions should not depend on details. Details should depend on abstractions.
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        // High-level module
        MessageService emailService = new EmailService();
        MessageService smsService = new SMSService();

        Notification notification1 = new Notification(emailService);
        notification1.sendNotification("Hello via Email!");

        Notification notification2 = new Notification(smsService);
        notification2.sendNotification("Hello via SMS!");
    }
}
// Abstraction
interface MessageService {
    void sendMessage(String message);
}
// Low-level module 1
class EmailService implements MessageService {  
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}       
// Low-level module 2
class SMSService implements MessageService {    
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
// High-level module depending on abstraction
class Notification {
    private final MessageService messageService;

    public Notification(MessageService messageService) {
        this.messageService = messageService;
    }

    public void sendNotification(String message) {
        messageService.sendMessage(message);
    }
}

