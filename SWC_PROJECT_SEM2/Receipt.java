/**
 * PROGRAM DESCRIPTION: TO CREATE A RECEIPT PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM
 * PROGRAMMER: NUR FIKRIYAH HAFIEZAH 
 * DATE: 13/4/2024
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Receipt extends JFrame 
{
    private JFrame receiptFrame;
    
    public Receipt(String haircut, boolean washHair, String facial, boolean doManicure, boolean doPedicure, String day, String month, String timeDesc, String promoCodeText, double totalPrice, boolean payNow, double finalPrice, String custName, String custEmail, String custPhoneNumber)
    {
        receiptFrame = new JFrame();

        //Set tittle frame
        receiptFrame.setTitle("Blossom-Beautê Booking System");
        //Set frame size
        receiptFrame.setSize(400, 500);
        //Exit/ terminate the application when JFrame is close
        receiptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the JFrame to appear at the center of the screen 
        receiptFrame.setLocationRelativeTo(null);
        //Add panel for receipt
        JPanel panelReceipt = new JPanel();
        //Set layout receipt
        panelReceipt.setLayout(new BorderLayout());
        //Add receipt frame
        receiptFrame.add(panelReceipt);
        //Add text area
        JTextArea receiptContent = new JTextArea("\n\t   Blossom-Beautê\n\n");
        receiptContent.setEditable(false);
        receiptContent.setBackground(Color.WHITE);
        //Set Font 
        receiptContent.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
        panelReceipt.add(receiptContent);

        // Add additional string of booking details into the receipt
        receiptContent.append("\n Appointment Date: \t"+day+" "+month);
        receiptContent.append("\n Customer Name: \t"+custName);
        receiptContent.append("\n Customer Phone: \t"+custPhoneNumber+"\n");

        //Check if user select or not
        if(!haircut.contains("Not Selected")){
            receiptContent.append("\n Haircut: \t\t"+haircut);
            if(washHair){
                receiptContent.append("\n\t\t(Include Wash)");
            }
        }
        if(!facial.contains("Not Selected")){
            receiptContent.append("\n Facial: \t\t"+facial);
        }
        if(doManicure){
            receiptContent.append("\n Manicure: \t\tYes (RM 45)");
        }
        if(doPedicure){
            receiptContent.append("\n Pedicure: \t\tYes (RM 35)");
        }
        receiptContent.append("\n\n Total Price: \t\tRM "+totalPrice);        
        if(totalPrice!= finalPrice){
            receiptContent.append("\n Applied Promo Code: \t"+promoCodeText);
            receiptContent.append("\n Discounted Price (15% off): \tRM "+finalPrice);
        }        
        if(payNow){
            receiptContent.append("\n Balance Due: \t\tRM 0.00");
        }else{
            receiptContent.append("\n Balance Due: \t\tRM "+ finalPrice);
        }

        receiptContent.append("\n\n*\n\t   Thank You! <3\n*\n");
        // Add done button 
        JButton doneButton = new JButton("Done");
        //Add listener to the button to call for action
        doneButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {                
                    // Close the receipt window
                    receiptFrame.dispose();
                }
            });
        
        //Add the booking button to the panel
        panelReceipt.add(doneButton, BorderLayout.SOUTH);
        receiptFrame.setVisible(true);  
    }//end of constructor
}