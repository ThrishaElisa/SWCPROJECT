/**
 * PROGRAM DESCRIPTION: TO CREATE A WELCOME PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM
 * PROGRAMMER: NUR KU SAFFIYAH 
 * DATE: 13/4/2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class TreatmentSelection implements ActionListener
{
    //Declare GUI components and other variables
    private JFrame treatmentFrame;
    private JButton nextButton;
    private JPanel panelHaircut, panelFacial, panelNails;
    private JComboBox haircutDropBox, facialDropBox;
    private JCheckBox washCheckBox, manicureCheckBox, pedicureCheckBox;
    boolean washHair, doManicure, doPedicure;

    public TreatmentSelection()
    {   
        //Listdown option for hair treatment combo box
        String[] haircuts = {"---- Not Selected ----","Female (RM 60.00)", "Male (RM 40.00)", "Child (RM 30.00)"};
        //Create the combo box for the hair treatment options
        haircutDropBox = new JComboBox(haircuts);
        //Create a check box with a label "include wash"
        washCheckBox = new JCheckBox("Include Wash ( + RM 18 )");
        //Create a panel for haircut
        panelHaircut = new JPanel();  
        //Set the position for haircut panel
        panelHaircut.setBounds(0,10,680,50);
        //Set title for the panel border "choose hair treatment"
        panelHaircut.setBorder(BorderFactory.createTitledBorder("Choose Hair Treatment"));       
        //Add combobox(dropbox and checkbox) into the haircut panel
        panelHaircut.add(haircutDropBox);
        panelHaircut.add(washCheckBox);
        //Set layout into 1 row 2 column
        panelHaircut.setLayout(new GridLayout(1,2));

        String[] facials = {"---- Not Selected ----", "Normal Facial (RM 60.00)", "Fruit Facial (RM 40.00)", "Pearl Facial (RM 30.00)", "Gold Facial (RM 30.00)"};
        facialDropBox = new JComboBox(facials);

        //Create a panel for faical
        panelFacial = new JPanel();
        //Set the position for faical panel
        panelFacial.setBounds(0,70,680,50);
        //Set title for the panel border "Choose Faical Treatment"
        panelFacial.setBorder(BorderFactory.createTitledBorder("Choose Facial Treatment"));   
        //Add dropbox and checkbox into the haircut panel
        panelFacial.add(facialDropBox);
        //Set layout into 1 row 2 column
        panelFacial.setLayout(new GridLayout(1,0));

        //Add checkbox into the manicure and pedicure panel
        manicureCheckBox = new JCheckBox("Manicure (RM 35.00)");
        pedicureCheckBox = new JCheckBox("Pedicure (RM 45.00)");
        
        //Create a panel for nails
        panelNails = new JPanel();
        //Set the position for nails panel
        panelNails.setBounds(0,130,680,50);
        //Add checkbox into the nails panel
        panelNails.add(manicureCheckBox);
        panelNails.add(pedicureCheckBox);
        //Set layout into 1 row 2 column
        panelNails.setLayout(new GridLayout(1,2));
        //Set title for the panel border "Choose Nails Treatment"
        panelNails.setBorder(BorderFactory.createTitledBorder("Choose Nails Treatment"));       
        
        //Create a button for customer to "Choose Date and Time"
        nextButton = new JButton("Choose Time & Date >>");
        //Set the position for "Choose Date and Time" button
        nextButton.setBounds(0, 210, 680, 30);
        //Add listener to the button to call for action
        nextButton.addActionListener(this);

        //Create a new window/frame
        treatmentFrame = new JFrame();
        
        //Create a title for the window
        treatmentFrame.setTitle("Blossom-Beautê Booking System");
        
        //Set window size
        treatmentFrame.setSize(700, 400);
        //Set the JFrame to appear at the center of the screen 
        treatmentFrame.setLayout(null);
        //Exit/ terminate the application when JFrame is close
        treatmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the JFrame to appear at the center of the screen 
        treatmentFrame.setLocationRelativeTo(null);
        //Add the booking button to the panel
        treatmentFrame.add(nextButton, BorderLayout.SOUTH);
        //Add panel haircut to the frame
        treatmentFrame.add(panelHaircut);
        //Add panel facial to the frame
        treatmentFrame.add(panelFacial);
        //Add panel nails to the frame
        treatmentFrame.add(panelNails);  
       
        //Show the window / frame with all the elements attached
        treatmentFrame.setVisible(true);

    }
    //Method for action when the nextButton is clicked
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == nextButton)
        { 
            //Show error message if user doesn't choose any treatment
            if(haircutDropBox.getSelectedItem().toString().contains("Not Selected") && facialDropBox.getSelectedItem().toString().contains("Not Selected") && !manicureCheckBox.isSelected() && !pedicureCheckBox.isSelected() && !washCheckBox.isSelected()){
                JOptionPane.showMessageDialog(null, "Please choose at least one treatment", "No treatment selected", JOptionPane.ERROR_MESSAGE);
            }
            //Show error message if user click wash checkbox but not selected on hair treatment
            else if(haircutDropBox.getSelectedItem().toString().contains("Not Selected") && washCheckBox.isSelected()){
                JOptionPane.showMessageDialog(null, "Please choose who the hair is for", "Error!", JOptionPane.ERROR_MESSAGE);
            }else{
                //Get all the values and assign to a variable
                if(washCheckBox.isSelected()){
                    washHair = true;
                }else{
                    washHair = false;
                }
                //Get all the values and assign to a variable
                if(manicureCheckBox.isSelected()){
                    doManicure = true;
                }else{
                    doManicure = false;
                }
                //Get all the values and assign to a variable
                if(pedicureCheckBox.isSelected()){
                    doPedicure = true;
                }else{
                    doPedicure = false;
                }
                ///Continue to open new frame on date time selection, pass parameter to the next frame to be processed
                new DateTimeSelection(haircutDropBox.getSelectedItem().toString(), washHair, facialDropBox.getSelectedItem().toString(), doManicure, doPedicure);
                // Close the welcome page window in order to open the new window treatmentselection
                treatmentFrame.dispose();
            }
        }
    }
}