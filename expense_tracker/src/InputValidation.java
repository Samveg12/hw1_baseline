/**
 * The InputValidation class provides methods to validate input fields
 * for the Expense Tracker application.
 */
public class InputValidation {
    
    /**
     * Validates the amount input.
     * 
     * @param amount The amount to validate
     * @throws IllegalArgumentException If the amount is invalid
     */
    public static void validateAmount(String amount) throws IllegalArgumentException {
        try {
            double amountValue = Double.parseDouble(amount);
            if (amountValue <= 0 || amountValue >= 1000) {
                throw new IllegalArgumentException("Amount must be greater than 0 and less than 1000");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Amount must be a valid number");
        }
    }
    
    /**
     * Validates the category input.
     * 
     * @param category The category to validate
     * @throws IllegalArgumentException If the category is invalid
     */
    public static void validateCategory(String category) throws IllegalArgumentException {
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be empty");
        }
        
        String lowerCategory = category.toLowerCase().trim();
        if (!lowerCategory.equals("food") && 
            !lowerCategory.equals("travel") && 
            !lowerCategory.equals("bills") && 
            !lowerCategory.equals("entertainment") && 
            !lowerCategory.equals("other")) {
            throw new IllegalArgumentException("Category must be one of: food, travel, bills, entertainment, other");
        }
    }
} 