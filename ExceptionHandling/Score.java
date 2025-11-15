package exceptionhandling;
import javax.swing.JOptionPane;
public class Score {
    
    public static void validateScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("Score must be between 0 and 100!");
        }
    }
    
    public static void main(String[] args) {
        int[] scores = new int[5];
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
            boolean validInput = false;
            
            while (!validInput) {
                try {
                    String input = JOptionPane.showInputDialog(
                        null,
                        "Enter score " + (i + 1) + ":",
                        "Score Input",
                        JOptionPane.QUESTION_MESSAGE
                    );
                    
                    if (input == null) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Input cancelled!",
                            "Cancelled",
                            JOptionPane.WARNING_MESSAGE
                        );
                        System.exit(0);
                    }
                    
                    int score = Integer.parseInt(input.trim());
                    
                    validateScore(score);
                    
                    scores[i] = score;
                    sum += score;
                    validInput = true;
                    
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: Please enter a valid number!",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                } catch (ScoreException e) {
                    JOptionPane.showMessageDialog(
                        null,
                        "Error: " + e.getMessage(),
                        "Validation Error",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        }
        
        double average = sum / 5.0;
        
        String result = "Scores entered:\n";
        for (int i = 0; i < 5; i++) {
            result += "Score " + (i + 1) + ": " + scores[i] + "\n";
        }
        result += "\nAverage: " + String.format("%.2f", average);
        
        JOptionPane.showMessageDialog(
            null,
            result,
            "Results",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}