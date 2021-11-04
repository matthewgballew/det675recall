package det675recall;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber; 
import java.net.URI; 
import java.math.BigDecimal;

public class SalaryCalcButtonFrame extends JFrame implements ActionListener {
   private JLabel messageLabel;     // Label for hourly salary
   private JLabel validityLabel;
   private JTextField messageField;  // Displays hourly salary 
   private JTextField validityField;
   private JButton sendButton;   // Triggers salary calculation
   public static final String ACCOUNT_SID = "AC61739450a3f87beb25967a6a2a1f4059"; 
   public static final String AUTH_TOKEN = "e88558ab2b56435cce3a931900f5174a"; 
   public static final String from = "+14054448434";

   /* Constructor creates GUI components and adds GUI components
      using a GridBagLayout. */
   SalaryCalcButtonFrame() {
      // Used to specify GUI component layout
      GridBagConstraints positionConst = null;

      // Set frame's title
      setTitle("REAL WORLD - Detachment Recall");

      // Set hourly and yearly salary labels
      messageLabel = new JLabel("Message:");
      validityLabel = new JLabel("Validation:");

      messageField = new JTextField(70);
      messageField.setEditable(true);
      messageField.setText("REAL WORLD: Detachment Recall. Respond Y if you are okay.");
      
      validityField = new JTextField(70);
      validityField.setEditable(false);

      // Create a "Calculate" button
      sendButton = new JButton("INITIATE RECALL");
      
      // Use "this" class to handle button presses
      sendButton.addActionListener(this);

      // Use a GridBagLayout
      setLayout(new GridBagLayout());
      positionConst = new GridBagConstraints();

      // Specify component's grid location
      positionConst.gridx = 0;
      positionConst.gridy = 0;
      
      // 10 pixels of padding around component
      positionConst.insets = new Insets(10, 10, 10, 10);
      
      // Add component using the specified constraints
      add(messageLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 0;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(messageField, positionConst);
      
      positionConst.gridx = 0;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(validityLabel, positionConst);

      positionConst.gridx = 1;
      positionConst.gridy = 1;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(validityField, positionConst);

      positionConst.gridx = 0;
      positionConst.gridy = 2;
      positionConst.insets = new Insets(10, 10, 10, 10);
      add(sendButton, positionConst);
   }

   /* Method is automatically called when an event 
      occurs (e.g, button is pressed) */
   public void actionPerformed(ActionEvent event) {
      String userInput;      // User specified hourly wage

      // Get user's wage input
      userInput = messageField.getText();
      
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
      Message message = Message.creator( 
              new com.twilio.type.PhoneNumber("+19186933278"),   
              new com.twilio.type.PhoneNumber(from),
              userInput)      
          .create();  

      validityField.setText(message.getSid()); 

      // Display calculated salary
      // salField.setText(Integer.toString(hourlyWage * 40 * 50));
   }

   /* Creates a SalaryCalculatorFrame and makes it visible */
   public static void main(String[] args) {
      // Creates SalaryLabelFrame and its components
      SalaryCalcButtonFrame myFrame = new SalaryCalcButtonFrame();

      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myFrame.pack();
      myFrame.setVisible(true);
   }
}
