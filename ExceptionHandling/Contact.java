package exceptionhandling;
import javax.swing.JOptionPane;
public class Contact {
   
    public static void validateContactNumber(String contactNumber) throws ContactException {
        if (contactNumber.length() != 11) {
            throw new ContactException("Invalid contact number format!");
        }
        if (!contactNumber.startsWith("09")) {
            throw new ContactException("Invalid contact number format!");
        }
        for (char c : contactNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new ContactException("Invalid contact number format!");
            }
        }
    }
    public static void main(String[] args) {
        String contactNumber = JOptionPane.showInputDialog(
            null,
            "Enter contact number:",
            "Contact Number Input",
            JOptionPane.QUESTION_MESSAGE
        );
        
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                null,
                "No contact number entered!",
                "Input Error",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        try {
            validateContactNumber(contactNumber.trim());
            JOptionPane.showMessageDialog(
                null,
                "Contact number is valid: " + contactNumber,
                "Success",
                JOptionPane.INFORMATION_MESSAGE
            );
        } catch (ContactException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error: " + e.getMessage(),
                "Validation Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}