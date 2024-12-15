import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CartSystem {
	
    private static ArrayList<String> cart = new ArrayList<>(); //list of items in the cart
    private static double totalPrice = 0.0; //total price
    
    
    private static JFrame cartPopup = null; // Cart popup window initially does not exist 
    

    public static void addToCart(String item, double price) { //this is used when the cart button is pressed
        cart.add(item); 
        totalPrice += price; // Update total price
        showCart(); //Refresh the cart popup and update content
    }

    public static void showCart() {
    	
        if (cartPopup == null) //to NOT create new JFrame everytime its called, just reuse the same ones
        {
            cartPopup = new JFrame("Shopping Cart");
            cartPopup.setSize(400, 300);
            cartPopup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Keep popup open
            cartPopup.setLayout(new BorderLayout());
        }

        //cart content as a stringbuilder object
        StringBuilder cartContent = new StringBuilder("<html><b>Shopping Cart:</b><br>");
        
        for (String item : cart)  //cuz cart retain its value after method stops
        {
            cartContent.append("- ").append(item).append("<br>"); //break line
        }
        
        cartContent.append("<br><b>Total Price:</b> $").append(String.format("%.2f", totalPrice)).append("<br></html>");

        //update cart content
        JLabel cartLabel = new JLabel(cartContent.toString()); //create a label and put cartContent
        
        cartLabel.setVerticalAlignment(SwingConstants.TOP);
        cartLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add a "Close Cart" button
        JButton closeButton = new JButton("Close Cart");
        
        //make it invisble ONLY
        closeButton.addActionListener(e -> cartPopup.setVisible(false)); // -> is kinda like a lambda expressions to shorten actionlisteners boilerplate codes
        //shortened form of actionlistener
        
        //refresh the popup content
        cartPopup.getContentPane().removeAll(); //clear old content to add new one
        
        cartPopup.getContentPane().add(cartLabel, BorderLayout.CENTER);
        cartPopup.getContentPane().add(closeButton, BorderLayout.SOUTH);
        
        cartPopup.setVisible(true); // make it appear again
    }
}
