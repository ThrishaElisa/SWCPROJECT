/**
 * PROGRAM DESCRIPTION: TO CREATE A WELCOME PAGE FOR BLOSSOM BEAUTE ONLINE BOOKING SYSTEM SPA ONLINE BOOKING SYSTEM
 * PROGRAMMER: THRISHA & HANA & FIEZAH & SAFFIYAH
 * DATE: 13/4/2024
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class WelcomePage extends JFrame implements ActionListener
{
    //declare a frame for welcome page
    private JFrame welcomeFrame;
    //declare a button for book button in order to continue to next frame
    private JButton bookButton;
    
    public WelcomePage()
    {  
        //Create the frame / window
        welcomeFrame = new JFrame();
        
        //Create a title for the window
        welcomeFrame.setTitle("Blossom-Beautê Booking System");
        //Set window size, height 700 width 700
        welcomeFrame.setSize(700, 700);
        //exit/ terminate the application when JFrame is close
        welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set the JFrame to appear at the center of the screen 
        welcomeFrame.setLocationRelativeTo(null);

        //Create a layout/panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Add custom image on the welcome page
        ImageIcon introImage = new ImageIcon("IntroPage.png");
        JLabel introLabel = new JLabel(introImage);
        panel.add(introLabel);

        // Create a button for customer to book now
        bookButton = new JButton("Book with us now!!");
        
        //Add listener to the button to call for action
        bookButton.addActionListener(this);
        
        //Add the booking button to the panel
        panel.add(bookButton, BorderLayout.SOUTH);
        welcomeFrame.add(panel);
        
        //Show the window / frame with all the elements attached
        welcomeFrame.setVisible(true);
        
    }    
    
    //Method for action when the bookButton is clicked
    public void actionPerformed(ActionEvent e)
    {   //If book now button is clicked
        if (e.getSource() == bookButton) {
            // Close the welcome page window in order to open the new window treatmentselection
            welcomeFrame.dispose();
            //Continue to open new frame on treatment selection
            new TreatmentSelection();
        }
    }
    
    //Method for the class driver/main
    public static void main(String[] args)
    {
        //Start the booking system
        WelcomePage startWelcomePage = new WelcomePage();
    }
}