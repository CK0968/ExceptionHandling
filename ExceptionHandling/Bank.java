package exceptionhandling;
import javax.swing.JOptionPane;
public class Bank{
    public static void main(String[] args) {
        double balance = 1000.0;
        
        try {
            JOptionPane.showMessageDialog(null, "Current balance: " + balance);
            
            String input = JOptionPane.showInputDialog("Enter withdrawal amount:");
            double withdrawalAmount = Double.parseDouble(input);
            
            if (withdrawalAmount > balance) {
                throw new InsufficientBalanceException("Insufficient funds!");
            }
            
            balance -= withdrawalAmount;
            JOptionPane.showMessageDialog(null, "Withdrawal successful!\nNew balance: " + balance);
            
        } catch (InsufficientBalanceException e) {
            JOptionPane.showMessageDialog(null, "Transaction error: " + e.getMessage());
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid amount!");
            
        } finally {
            JOptionPane.showMessageDialog(null, "Transaction completed.");
        }
    }
}