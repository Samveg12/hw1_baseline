import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      try {
        // Get transaction data from view
        String amountStr = String.valueOf(view.getAmountField());
        String category = view.getCategoryField();
        
        // Validate inputs
        InputValidation.validateAmount(amountStr);
        InputValidation.validateCategory(category);
        
        // If validation passes, create and add transaction
        double amount = Double.parseDouble(amountStr);
        Transaction t = new Transaction(amount, category);

        // Call controller to add transaction
        view.addTransaction(t);
        
      } catch (IllegalArgumentException ex) {
        // Show error message if validation fails
        JOptionPane.showMessageDialog(view, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
      }
    });
  }

}