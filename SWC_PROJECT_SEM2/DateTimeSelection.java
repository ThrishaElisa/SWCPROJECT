/**
 * PROGRAM DESCRIPTION: TO CREATE A DATE TIME SELECTION PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM
 * PROGRAMMER: NURATHRISHA ELISA
 * DATE: 13/4/2024
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;

public class DateTimeSelection extends JFrame 
{

    //Declare GUI components and other variables
    private JFrame dateTimeFrame;
    private JButton nextButton;
    private JPanel panelDate, panelTimeSlot, panelCode, panelButton, panelPayment;
    private JComboBox dayDropBox, monthDropBox;
    private JRadioButton[] timeSlotRadio;
    private JLabel promoLabel;
    private JTextField promoCodeText;
    private JCheckBox payNowCheckBox;
    String haircut, facial, timeDesc;
    boolean washHair, doManicure, doPedicure, validPromoCode;
    double haircutPrice = 0.0, facialPrice = 0.0, nailsPrice = 0.0, totalPrice = 0.0;

    //Assign for promocode to a variable
    String[] availablePromoCode = {"BEAUT011", "BEAUT3201", "BEAUT301", "BEAUT081", "BEAUT901", "BEAUT701"};

    public DateTimeSelection(String haircut, boolean washHair, String facial, boolean doManicure, boolean doPedicure)
    {        
        // Assign the value to the variables
        this.haircut = haircut;
        this.washHair = washHair;
        this.facial = facial;
        this.doManicure = doManicure;
        this.doPedicure = doPedicure;  

        // Get today's date
        LocalDate today = LocalDate.now();        
        // Get the month of today's date
        int currentMonth = today.getMonthValue();
        // Get the day value of today's date
        int currentDay = today.getDayOfMonth();

        //List of 12 months
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        //Create the combo box for month
        monthDropBox = new JComboBox(month);
        // Set the default month to current month
        monthDropBox.setSelectedItem(month[currentMonth-1]);
        //Create a panel for Date
        panelDate = new JPanel();
        //Set the position for date panel
        panelDate.setBounds(0,10,680,50);
        //Set title for the panel border "Choose Date"
        panelDate.setBorder(BorderFactory.createTitledBorder("Choose Date"));
        //Add listener to the button to call for action
        monthDropBox.addActionListener(new ActionListener() 
        
            {
                public void actionPerformed(ActionEvent e) {                
                    // Check if user select month less than current month, show error message
                    if(monthDropBox.getSelectedIndex() < currentMonth-1 ){
                        JOptionPane.showMessageDialog(null,"Do not choose past date.", "Error!", JOptionPane.ERROR_MESSAGE);
                        monthDropBox.setSelectedItem(month[currentMonth-1]);
                        dayDropBox.setSelectedItem(currentDay+1);
                    }else{
                        // Check if selected month is current month auto populate tomorrow's date
                        if(monthDropBox.getSelectedIndex() == currentMonth-1 ){
                            dayDropBox.setSelectedItem(currentDay+1);
                        }else{
                            updateDayDropBox();
                        }
                    }
                }
            });

        // Add month drop box to the panel
        panelDate.add(monthDropBox);
        // Create dropbox for selecting the day
        dayDropBox = new JComboBox();
        // Add drop box for day panel 
        panelDate.add(dayDropBox);
        //Set layout into 1 row 2 column
        panelDate.setLayout(new GridLayout(1,2));
        updateDayDropBox();
        dayDropBox.setSelectedItem(currentDay+1);
        //Add listener to the button to call for action
        dayDropBox.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) { 
                    //Check if user choose previous date or today, show error message 
                    if((monthDropBox.getSelectedIndex() == currentMonth-1 ) && (Integer.valueOf(dayDropBox.getSelectedItem().toString()) <= currentDay)){
                        JOptionPane.showMessageDialog(null, "Do not choose previous date or today", "Error!", JOptionPane.ERROR_MESSAGE);
                        dayDropBox.setSelectedItem(currentDay+1);
                    }
                }
            });
        
        //List time slot available
        String[] timeSlot = { "10:30 AM", "11:30 AM", "12:30 PM", "02:30 PM", "03:30 PM", "04:30 PM"};
        //Create radio button for time slot 
        timeSlotRadio = new JRadioButton[6];
        ButtonGroup groupTimeSlot = new ButtonGroup();    
        //Create a panel for time slot
        panelTimeSlot = new JPanel();
        //Set the position for time slot panel
        panelTimeSlot.setBounds(0,70,680,60);
        
        for(int i = 0; i < 6; i++) {
            timeSlotRadio[i] = new JRadioButton(timeSlot[i]); 
            groupTimeSlot.add(timeSlotRadio[i]); 
            panelTimeSlot.add(timeSlotRadio[i]); 
            timeSlotRadio[i].addActionListener(new ActionListener() 
                {
                    //Get value for the selected time slot
                    public void actionPerformed(ActionEvent e) { 
                        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                        String selectedValue = selectedRadioButton.getText();
                        timeDesc = selectedValue;
                    }
                });
        }
        //Set panel title "Choose Time Slot"
        panelTimeSlot.setBorder(BorderFactory.createTitledBorder("Choose Time Slot"));
        // Create a JPanel for holding components
        panelCode = new JPanel();
        //Set layout panel
        panelCode.setLayout(new FlowLayout()); 
        
        // Create Promo Code section 
        JLabel promoLabel = new JLabel("Promo Code: ");
        //Create new text fileld for promo code
        JTextField promoCodeText = new JTextField(15);
        //Add promo label and promo text into the panel
        panelCode.add(promoLabel);
        panelCode.add(promoCodeText);
        //Set title for promo code panel "Get 15% discount"
        panelCode.setBorder(BorderFactory.createTitledBorder("Get 15% discount"));
        //Set the position for promo code panel
        panelCode.setBounds(0, 140, 680, 60);
        
        //Create new checkbox "Pay Now" if user want to pay in advance
        payNowCheckBox = new JCheckBox("Pay Now");
        //Create new panel for payment
        panelPayment = new JPanel();      
        //Add "Pay Now" checkbox into the payment panel
        panelPayment.add(payNowCheckBox);
        //Set Title for payment panel
        panelPayment.setBorder(BorderFactory.createTitledBorder("Check below checkbox to pay now, otherwise you can pay later at the counter during your visit"));  
        //Set the position for payment panel
        panelPayment.setBounds(0,225,680,50);
        panelButton  = new JPanel();
        //Set the button position 
        panelButton.setBounds(0, 275, 680, 100); 
        // Create a button for customer to proceed
        nextButton = new JButton("Proceed >>");
        //Set the button position
        nextButton.setBounds(0, 300, 680, 25);    
        //Add listener to the button to call for action
        nextButton.addActionListener(new ActionListener() 
            {
                public void actionPerformed(ActionEvent e) {   
                    //If user did not choose any time slot, show error message
                    if (groupTimeSlot.getSelection() == null){
                        JOptionPane.showMessageDialog(null,"Choose a time slot", "Error!", JOptionPane.ERROR_MESSAGE);
                    }else{    
                        boolean payNow = false;
                        //If user check the pay now check box
                        if(payNowCheckBox.isSelected()){
                            payNow = true;
                        }
                        validPromoCode = checkPromoCode(promoCodeText.getText());
                        if(validPromoCode || promoCodeText.getText().isEmpty()){
                            totalPrice = calculateTotalPayment(validPromoCode);  
                            double finalPrice = totalPrice;
                            if(validPromoCode)
                            //Calculate the final price after user enter va;lid promo code
                                finalPrice = totalPrice - (totalPrice * 0.15);
                            dateTimeFrame.dispose();
                            new CustomerInfo(haircut, washHair, facial, doManicure, doPedicure, dayDropBox.getSelectedItem().toString(), monthDropBox.getSelectedItem().toString(), timeDesc, promoCodeText.getText(), totalPrice, payNow, finalPrice);
                        }     
                    }                    
                }
            });

        //Create a new window/frame
        dateTimeFrame = new JFrame();
        //Create a title for the window
        dateTimeFrame.setTitle("Blossom-Beautê Booking System");
        //Set window size
        dateTimeFrame.setSize(700, 370);
        //Set framne layout
        dateTimeFrame.setLayout(null);
        //Exit/ terminate the application when JFrame is close
        dateTimeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the JFrame to appear at the center of the screen 
        dateTimeFrame.setLocationRelativeTo(null);
        //Add the booking button to the panel
        dateTimeFrame.add(nextButton, BorderLayout.SOUTH);
        //Add date, time slot, promo code, payment panel into the the frame
        dateTimeFrame.add(panelDate);
        dateTimeFrame.add(panelTimeSlot);
        dateTimeFrame.add(panelCode);
        dateTimeFrame.add(panelPayment);
    
        //Show the window / frame with all the elements attached
        dateTimeFrame.setVisible(true);
    }
    // Update the day JComboBox based on the selected month
    private void updateDayDropBox() {
        //Get selected month and day for the selected month and day
        int selectedMonthIndex = monthDropBox.getSelectedIndex();
        int daysInMonth = getDaysInMonth(selectedMonthIndex);
        dayDropBox.removeAllItems();
        for (int i = 1; i <= daysInMonth; i++) {
            dayDropBox.addItem(i);
        }
    }
    // Get the number of days in the selected month
    private int getDaysInMonth(int monthIndex) {
        switch (monthIndex) {
            case 1: 
                return 29; 
            case 3: case 5: case 8: case 10: 
                return 30;
            default:
                return 31;
        }
    }
    // Check if promocode is valid or not
    private boolean checkPromoCode(String promoCode){
        boolean containsPromoCode = false;

        if(!promoCode.isEmpty()){
            for(int i=0; i<6; i++){
                if(promoCode.equals(availablePromoCode[i])){
                    containsPromoCode = true;
                    break;
                }
            }

            if(containsPromoCode){
                JOptionPane.showMessageDialog(null, 
                    "Promo Code Accepted!");

            }else{
                JOptionPane.showMessageDialog(null, 
                    "Invalid Promo Code!", "Error!",JOptionPane.ERROR_MESSAGE);
            }

        }
        return containsPromoCode;
    }
    // Assign price for the selected value and calculate the total price
    private double calculateTotalPayment(boolean containsPromoCode) {
        if(haircut.contains("Female")){
            haircutPrice = 60.00;
        }
        else if(haircut.contains("Male")){
            haircutPrice = 40.00;
        }
        else if(haircut.contains("Child")){
            haircutPrice= 30.00;
        }
        else
            haircutPrice=0.0;
        if(washHair && haircutPrice != 0.0){
            haircutPrice = haircutPrice + 18.00;
        }
        if(facial.contains("Normal Facial")){
            facialPrice = 60.00;
        }
        else if(facial.contains("Fruit Facial")){
            facialPrice = 40.00;
        }
        else if(facial.contains("Pearl Facial") || facial.contains("Gold Facial")){
            facialPrice= 30.00;
        }
        else
            facialPrice=0.0;
        if(doManicure){
            nailsPrice = 35.00;
        }
        else
            nailsPrice = 0.0;
        if(doPedicure){
            nailsPrice = nailsPrice + 45.00;
        }
        else
            nailsPrice = nailsPrice;

        //Calculate total price
        totalPrice = haircutPrice + facialPrice + nailsPrice;
        return totalPrice;
    }
}