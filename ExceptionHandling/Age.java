package exceptionhandling;
import javax.swing.JOptionPane;

public class Age {
    public static void main(String[] args) {
        try {
            String input = JOptionPane.showInputDialog("Enter your age:");
            int age = Integer.parseInt(input);
            
            if (age < 18) {
                throw new InvalidAgeException("Access denied - Age must be 18 or older.");
            }
            
            JOptionPane.showMessageDialog(null, "Access granted.");
            
        } catch (InvalidAgeException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid number!");
        }
    }
}