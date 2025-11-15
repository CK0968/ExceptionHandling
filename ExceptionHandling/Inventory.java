package exceptionhandling;

import javax.swing.JOptionPane;

public class Inventory {
    public static void main(String[] args) {
        String[] productNames = {"Laptop", "Mouse", "Keyboard", "Monitor", "Headphones"};
        double[] prices = {899.99, 25.50, 75.00, 299.99, 150.00};
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            try {
                String input = JOptionPane.showInputDialog("Enter product index (0-4):");
                
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Inventory lookup complete.");
                    break;
                }
                
                int index = Integer.parseInt(input);
                
                String productName = productNames[index];
                double price = prices[index];
                
                JOptionPane.showMessageDialog(null, 
                    "Product: " + productName + "\nPrice: $" + price);
                
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error: Invalid index! Please enter a number between 0 and 4.");
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, 
                    "Error: Please enter a numeric index!");
                
            } finally {
                int choice = JOptionPane.showConfirmDialog(null, 
                    "Do you want to look up another product?", 
                    "Continue?", 
                    JOptionPane.YES_NO_OPTION);
                
                if (choice != JOptionPane.YES_OPTION) {
                    continueProgram = false;
                    JOptionPane.showMessageDialog(null, "Inventory lookup complete.");
                }
            }
        }
    }
}