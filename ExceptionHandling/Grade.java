package exceptionhandling;

import javax.swing.JOptionPane;

public class Grade{
    public static void main(String[] args) {
        int[] grades = {85, 92, 78, 95, 88};
        
        try {
            String input = JOptionPane.showInputDialog("Enter student index (0-4):");
            int index = Integer.parseInt(input);
            
            int grade = grades[index];
            JOptionPane.showMessageDialog(null, "Student grade: " + grade);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Error: Invalid student index!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Please enter a valid number!");
        }
    }
}