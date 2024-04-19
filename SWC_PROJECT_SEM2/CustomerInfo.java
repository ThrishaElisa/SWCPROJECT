/**
 * PROGRAM DESCRIPTION: TO CREATE A CUSTOMER INFO PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM
 * PROGRAMMER: NUR FARHANA FAUZI
 * DATE: 13/4/2024
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

//creates a frame for collecting customer information
public class CustomerInfo extends JFrame {
    private JFrame custInfoFrame;
    private JTextField custNameText, custEmailText, custRetypeEmailText, custPhoneNoText;

    public CustomerInfo(String haircut, boolean washHair, String facial, boolean doManicure, boolean doPedicure, String day, String month, String timeDesc, String promoCodeText, double totalPrice, boolean payNow, double finalPrice) {
        // Create the frame for customer info
        custInfoFrame = new JFrame();
        // Set title for the frame "Blossom-Beautê Booking System"
        custInfoFrame.setTitle("Blossom-Beautê Booking System");
        // Set customer info frame size
        custInfoFrame.setSize(500, 250);
        // Exit/terminate the application when JFrame is closed
        custInfoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the JFrame to appear at the center of the screen
        custInfoFrame.setLocationRelativeTo(null);
        // Create a panel for customer info
        JPanel panelCustInfo = new JPanel();
        // Create labels and text fields for customer information
        //Label and text field for Full Name
        JLabel custNameLabel = new JLabel("    Full Name: ");
        custNameText = new JTextField(35);
        //Label and text field for Email
        JLabel custEmailLabel = new JLabel("            Email: ");
        custEmailText = new JTextField(35);
        //Label and text field for Retype Email
        JLabel custRetypeEmailLabel = new JLabel("Retype Email: ");
        custRetypeEmailText = new JTextField(35);
        //Label and text field for Phone Number
        JLabel custPhoneNoLabel = new JLabel("Phone Number (optional): ");
        custPhoneNoText = new JTextField(20);
        // Add labels and text fields to the customer info panel
        panelCustInfo.add(custNameLabel);
        panelCustInfo.add(custNameText);
        panelCustInfo.add(custEmailLabel);
        panelCustInfo.add(custEmailText);
        panelCustInfo.add(custRetypeEmailLabel);
        panelCustInfo.add(custRetypeEmailText);
        panelCustInfo.add(custPhoneNoLabel);
        panelCustInfo.add(custPhoneNoText);
        // Set border title to "Customer Information"
        panelCustInfo.setBorder(BorderFactory.createTitledBorder("Customer Information"));
        // Set the position for customer info panel
        panelCustInfo.setBounds(0, 20, 680, 120);
        // Create new button "Next" to redirect to the next frame
        JButton doneButton = new JButton("Next");
        // Add listener to the button to call for action
        doneButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Check if required fields are empty
                if (custNameText.getText().isEmpty() || custEmailText.getText().isEmpty() || custRetypeEmailText.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all required fields", "Customer Information Missing!", JOptionPane.ERROR_MESSAGE);
                } else if (!custEmailText.getText().equals(custRetypeEmailText.getText())) {
                    JOptionPane.showMessageDialog(null, "Emails do not match", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    custInfoFrame.dispose();
                    new Receipt(haircut, washHair, facial, doManicure, doPedicure, day, month, timeDesc, promoCodeText, totalPrice, payNow, finalPrice, custNameText.getText(), custEmailText.getText(), custPhoneNoText.getText());
                }
            }
        });

        // Add the booking button to the panel
        custInfoFrame.add(doneButton, BorderLayout.SOUTH);
        // Add customer info into the panel
        custInfoFrame.add(panelCustInfo);
        // Show frame on the screen
        custInfoFrame.setVisible(true);
    }
}