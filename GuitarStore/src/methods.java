
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.*;

//superclass
class Guitar { //base class for guitar (common for all guitar)
	
	String brand = null; //will have to choose via switch case
	String model; //Can enter whatever
	int StringNum;
	int fretNum;
	String bodyMaterial = null; // also choose from choice
	double price; 
	
	Guitar(String brand,String model,int StringNum,int fretNum,String bodyMaterial,double price){ //constructor to input new guitar for sale
		
		this.brand = brand;
		this.model = model;
		this.StringNum = StringNum;
		this.fretNum = fretNum;
		this.bodyMaterial = bodyMaterial;
		this.price = price;
		
	}
	
	 //passing a bufferedwriter object (so must initialise a filewriter before passing it to this method)
	public void saveToFile(BufferedWriter writer) throws IOException { //temporarily stores data in memory before writing in file, so its good for wanting to write bit by bit into a file instead of in whole
		
        writer.write("Guitar Type: " + getClass().getSimpleName());
        writer.newLine();
        writer.write("Brand: " + brand);
        writer.newLine();
        writer.write("Model: " + model);
        writer.newLine();
        writer.write("Strings: " + StringNum);
        writer.newLine();
        writer.write("Frets: " + fretNum);
        writer.newLine();
        writer.write("Body Material: " + bodyMaterial);
        writer.newLine();
        writer.write("Price: $" + price);
        writer.newLine();
        writer.write("------------------------");
        writer.newLine();
    }
}

//derived classes

class ElectricGuitar extends Guitar { 
	boolean hasWhammyBar;
	int pickupCount;
	
	ElectricGuitar(String brand, String model, int StringNum,int fretNum, String bodyMaterial, double price) {
		super(brand, model, StringNum, fretNum, bodyMaterial, price); //super calls the constructor of the parent class
		
	}
	
	
}

class AccousticGuitar extends Guitar {
	boolean isElectricAccoustic; 
	String woodType;

	AccousticGuitar(String brand, String model, int StringNum,int fretNum, String bodyMaterial, double price) {
		super(brand, model, StringNum, fretNum, bodyMaterial, price);
		
	}
	
}

class BassGuitar extends Guitar {

	BassGuitar(String brand, String model, int StringNum,int fretNum, String bodyMaterial, double price) {
		super(brand, model, StringNum, fretNum, bodyMaterial, price);
		// TODO Auto-generated constructor stub
	}
	
}

class Ukulele extends Guitar {

	Ukulele(String brand, String model, int StringNum,int fretNum, String bodyMaterial, double price) {
		super(brand, model, StringNum, fretNum, bodyMaterial, price);
		// TODO Auto-generated constructor stub
	}
	
}

public class methods {
		
	  static String guitarPage = "None"; //default is none 
	  //USED IN processGuitar METHOD
	  static double price = 0; //PRICE TO BE USED IN CART 
	  //also why must static?
	
	  
	  public static double getPrice() {
	        return price;
	    }
	  
	  public static void showGuitarInputForm() { //this will be used in AdminPage

	        JFrame inputForm = new JFrame("Guitar Input Form");
	        inputForm.setSize(400, 400);
	        inputForm.setLayout(null);

	        //labels n textfields
	        JLabel brandLabel = new JLabel("Brand:");
	        brandLabel.setBounds(50, 30, 100, 25);
	        
	        String[] brands = {"Fender","Gibson","Ibanez","Yamaha"}; //array of string
	        
	        JComboBox<String> brandChoice = new JComboBox<>(brands); //popup menu of strings, passing the array of string into its constructor
	        brandChoice.setBounds(150, 30, 150, 25);
	        
	        //brand
	        inputForm.add(brandLabel);
	        inputForm.add(brandChoice);

	        JLabel modelLabel = new JLabel("Model:");
	        modelLabel.setBounds(50, 70, 100, 25);
	        JTextField modelField = new JTextField();
	        modelField.setBounds(150, 70, 150, 25);
	        //model
	        inputForm.add(modelLabel);
	        inputForm.add(modelField);

	        JLabel stringLabel = new JLabel("Strings:");
	        stringLabel.setBounds(50, 110, 100, 25);
	        JTextField stringField = new JTextField();
	        stringField.setBounds(150, 110, 150, 25);
	        
	        //strings
	        inputForm.add(stringLabel);
	        inputForm.add(stringField);

	        JLabel fretLabel = new JLabel("Frets:");
	        fretLabel.setBounds(50, 150, 100, 25);
	        JTextField fretField = new JTextField();
	        fretField.setBounds(150, 150, 150, 25);
	        
	        //frets
	        inputForm.add(fretLabel);
	        inputForm.add(fretField);

	        JLabel bodyMaterialLabel = new JLabel("Body Material:");
	        bodyMaterialLabel.setBounds(50, 190, 100, 25);
	        String[] materials = {"Mahogany","Maple", "Rosewood"};
	        JComboBox<String> matsChoice = new JComboBox<>(materials);
	        matsChoice.setBounds(150, 190, 150, 25);
	        
	        //material
	        inputForm.add(bodyMaterialLabel);
	        inputForm.add(matsChoice);

	        JLabel priceLabel = new JLabel("Price:");
	        priceLabel.setBounds(50, 230, 100, 25);
	        JTextField priceField = new JTextField();
	        priceField.setBounds(150, 230, 150, 25);
	        
	        //price
	        inputForm.add(priceLabel);
	        inputForm.add(priceField);

	        JButton saveButton = new JButton("Save");
	        saveButton.setBounds(150, 280, 100, 30);
	        inputForm.add(saveButton);

	        inputForm.setVisible(true);

	        saveButton.addActionListener(new ActionListener() { //save button
	            
	            public void actionPerformed(ActionEvent e) {
	            	
	            	 if (stringField.getText().isEmpty() || fretField.getText().isEmpty() || priceField.getText().isEmpty()) { //if any of these are empty
	            	        JOptionPane.showMessageDialog(inputForm, "Must fill all entries", "ERROR!!", JOptionPane.ERROR_MESSAGE);
	            	        inputForm.dispose();
	            	        return; //to immediately get out from the method
	            	        
	            	    }
	            	
	                String brand = (String) brandChoice.getSelectedItem(); //cast to string
	                String model = modelField.getText();
	                
	                //change var type
	                int stringNum = Integer.parseInt(stringField.getText());
	                int fretNum = Integer.parseInt(fretField.getText());
	                
	                String bodyMaterial = (String) matsChoice.getSelectedItem(); //cast to string
	                
	                double price = Double.parseDouble(priceField.getText());

	                //write information on the file
	                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\manqe\\eclipse-workspace2\\GuitarStore\\src\\guitar_deets.txt", false))) { //false to delete previous entries, true to append
	                    writer.write("Brand: " + brand);
	                    writer.newLine();
	                    writer.write("Model: " + model);
	                    writer.newLine();
	                    writer.write("Strings: " + stringNum);
	                    writer.newLine();
	                    writer.write("Frets: " + fretNum);
	                    writer.newLine();
	                    writer.write("Body Material: " + bodyMaterial);
	                    writer.newLine();
	                    writer.write("Price: $" + price);
	                    writer.newLine();
	                    writer.write("------------------------");
	                    writer.newLine();

	                    JOptionPane.showMessageDialog(inputForm, "Guitar information saved successfully!");
	                } 
	                
	                catch (Exception error) 
	                {
	    
	                	JOptionPane.showMessageDialog(inputForm, "Error: " + error.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                }
	                
	                inputForm.dispose(); //close after button is pressed and everything is done
	            }
	        });
	    }
	  
	  	
	  //read from files and then post it on the shops page
	  public static void readSoldItem() {

	        ArrayList<Guitar> guitars = new ArrayList<>(); //use array list so can expand anytime instead of normal array
	        
	        //use the guitar classes
	        guitars.add(new ElectricGuitar("Fender", "Stratocaster", 6, 22, "Alder", 1500.00));
	        guitars.add(new ElectricGuitar("Gibson", "Les Paul", 6, 22, "Mahogany", 2500.00));
	        
	        guitars.add(new AccousticGuitar("Yamaha", "F310", 6, 20, "Spruce", 200.00));
	        guitars.add(new AccousticGuitar("Taylor", "214CE", 6, 20, "Mahogany", 800.00));
	        
	        guitars.add(new BassGuitar("Ibanez", "SR300", 4, 24, "Maple", 500.00));
	        guitars.add(new BassGuitar("Fender", "Precision Bass", 4, 20, "Alder", 1200.00));
	        
	        guitars.add(new Ukulele("Kala", "KA-T", 4, 12, "Mahogany", 100.00));
	        guitars.add(new Ukulele("Lanikai", "LU-21", 4, 12, "Maple", 150.00));

	 
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\manqe\\eclipse-workspace2\\GuitarStore\\src\\guitar_for_sale.txt", false))) { //false so it will NOT be appended each time it ran
	        	
	            for (Guitar guitar : guitars)
	            {
	                guitar.saveToFile(writer);
	            }
	            
	            System.out.println("Guitar details saved to file successfully!");
	        } 
	        
	        catch (IOException e) 
	        {
	            System.err.println("Error saving guitar details to file: " + e.getMessage());
	        }

	        
	        System.out.println("\nReading Guitar Details from File:");
	        
	        //like bufferedwriter but for reading
	        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\manqe\\eclipse-workspace2\\GuitarStore\\src\\guitar_for_sale.txt")))
	        {
	        	
	            String line;
	            while ((line = reader.readLine()) != null)
	            {
	                System.out.println(line); //print the file content line by line
	            }
	        } 
	        
	        catch (IOException e) 
	        {
	            System.err.println("Error reading guitar details from file: " + e.getMessage());
	        }
	  }
	  
	  //read from file to post on shop page
	  //
	  public static void fileReader() //when press the details button
	  {

	        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\manqe\\eclipse-workspace2\\GuitarStore\\src\\guitar_for_sale.txt"))) 
	        {
	        	
	            String line;
	            ArrayList<String> guitarDetails = new ArrayList<>();  //array list to hold guitar details

	            while ((line = reader.readLine()) != null)  //as long as an entry exists
	            {
	                if (line.equals("------------------------")) //while it is NOT dashes, keep adding the lines into guitar Details
	                {
	                   
	                	boolean isProcessed = processGuitar(guitarDetails); //at this point only one guitar details are passed
	                    guitarDetails.clear(); 
	                    
	                    if (isProcessed) { //break out of loop if done
	                        break;
	                    }
	                    
	                }
	                
	                else 
	                {
	                	//this has an array list of Strings
	                    guitarDetails.add(line); //as long as not dashes, guitar deetail lines will be added here
	                }
	            }

	        } 
	        
	        catch (Exception e) 
	        {
	            System.out.println("Error reading file: " + e.getMessage()); //check again??
	        }
	  }
	  
	  //process the details of ONE GUITAR
	  private static boolean processGuitar(ArrayList<String> details) //MUST RETURN TRUE OR FALSE
	  {
		  
	        Map<String, String> guitarMap = new HashMap<>(); //like python dict (key : value pairs)

	        for (String detail : details) //details is an array list of guitar details
	        {
	        	
	            String[] parts = detail.split(": ", 2); //split using :  as separator
	            
	            if (parts.length == 2) 
	            {	        
	                guitarMap.put(parts[0].trim(), parts[1].trim()); //put function adds a new key - value pair
	            }
	        }
	         //at this point that one guitar detail is already put into the hasmap GuitarMap
	        
	        try //this is where we get the price (global variable)
	        {
	        	
	            String priceString = guitarMap.get("Price"); // Retrieve the price value of that one particular guitar
	            
	            if (priceString != null) 
	            {
	                //Remove dollar sign and parse to double
	                price = Double.parseDouble(priceString.replace("$", "").trim()); //replace dollar with nothing and trim, so only numbers are left and then covert to double
	            }
	        } 
	        
	        catch (NumberFormatException e)
	        {
	            System.out.println("Error parsing price: " + e.getMessage());
	        }
	        
	        System.out.println("Processed Price: $" + price); //DEBUG ONLY REMOVE LATER
	       
	        //guitarPage is given a value from the main page buttons (guitar page buttons)
	        //use equals to compare two strings and == is used to compare two string's memory location
	        if  ("ElectricGuitar".equals(guitarMap.get("Guitar Type")) && "ElectricGuitar".equals(guitarPage)) //if the guitar AT THE TIME is an electric guitar of choice, return true, and get out of the method, with the price get
	        {
	            
	        		        	
	            StringBuilder detailsBuilder = new StringBuilder(); //STRINGBUILDER is basically a mutable string
	            
	            detailsBuilder.append("<html><b>Electric Guitar Details:</b><br>"); //br is a break (newline)
	            
	            //entrySet() gives a set of all key-value pairs in the hashmap
	            for (Map.Entry<String, String> entry : guitarMap.entrySet()) //for every entry in the guitarMap hashmap (whole detail for one guitar)
	            {
	                detailsBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");  //keep appending on the stringbuilder instance
	            }
	            
	            detailsBuilder.append("</html>"); //the ending for the html 

	            showGuitarDetails(detailsBuilder.toString()); //convert Stringbuilder into normal, unmutable string
	            return true; //cuz its a boolean method
	        }
	        
	        else if ("AccousticGuitar".equals(guitarMap.get("Guitar Type")) && "AccousticGuitar".equals(guitarPage))
	        {
	            
	            StringBuilder detailsBuilder = new StringBuilder(); //STRINGBUILDER
	            
	            detailsBuilder.append("<html><b>Accoustic Guitar Details:</b><br>");
	            
	            for (Map.Entry<String, String> entry : guitarMap.entrySet())
	            {
	                detailsBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
	            }
	            
	            detailsBuilder.append("</html>");

	            showGuitarDetails(detailsBuilder.toString());
	            return true; 
	        }
	        
	        else if ("BassGuitar".equals(guitarMap.get("Guitar Type")) && "BassGuitar".equals(guitarPage)) 
	        {
	            
	            StringBuilder detailsBuilder = new StringBuilder(); //STRINGBUILDER
	            
	            detailsBuilder.append("<html><b>Bass Guitar Details:</b><br>");
	            
	            for (Map.Entry<String, String> entry : guitarMap.entrySet())
	            {
	                detailsBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
	            }
	            
	            detailsBuilder.append("</html>");

	            showGuitarDetails(detailsBuilder.toString());
	            return true; 
	        }
	        
	        else if ("Ukulele".equals(guitarMap.get("Guitar Type")) && "Ukulele".equals(guitarPage))
	        {
	            
	            StringBuilder detailsBuilder = new StringBuilder(); //STRINGBUILDER
	            
	            detailsBuilder.append("<html><b>Ukulele Details:</b><br>");
	            
	            for (Map.Entry<String, String> entry : guitarMap.entrySet())
	            {
	                detailsBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("<br>");
	            }
	            
	            detailsBuilder.append("</html>");

	            showGuitarDetails(detailsBuilder.toString());
	            return true; 
	        }
	        
	        
	        
	        return false; //nothing 
	    }
	  
	  
	  private static void showGuitarDetails(String details) 
	  {
	        // Create a new JFrame to display the guitar details
	        JFrame frame = new JFrame("Guitar Details");
	        frame.setSize(400, 300);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	        JLabel label = new JLabel(details); //put all the details in the frame
	        label.setVerticalAlignment(SwingConstants.TOP);
	        label.setHorizontalAlignment(SwingConstants.LEFT);
	        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	        JScrollPane scrollPane = new JScrollPane(label);
	        frame.add(scrollPane);

	        frame.setVisible(true);
	    }
	  
}

