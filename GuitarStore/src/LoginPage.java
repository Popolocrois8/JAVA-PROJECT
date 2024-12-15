import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.io.*;
import javax.swing.*;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setFont(null);
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 555);
		
		setTitle("Harmony Haven - Guitar Store"); //to set Frame name
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 246, 227));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 730, 516);
		panel.setBorder(null);
		panel.setForeground(new Color(246, 234, 220));
		panel.setPreferredSize(new Dimension(700, 500));
		panel.setBackground(new Color(255, 246, 227));
		contentPane.add(panel);
		panel.setLayout(null);
		
		//HEADER
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 730, 94);
		panel.add(panel_1);
		panel_1.setBackground(new Color(191, 236, 255));
		panel_1.setLayout(null);
	
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\manqe\\Documents\\BOOKS & MATERIALS\\Java\\img\\logo.png"); //image
		
		Image scaled = imageIcon.getImage().getScaledInstance(40, 60, Image.SCALE_SMOOTH); //resized image
		ImageIcon resizedIcon = new ImageIcon(scaled);

		JLabel lblNewLabel_2 = new JLabel(resizedIcon);
		
		lblNewLabel_2.setBounds(31, 0, 39, 70);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Harmony Haven");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_3.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(88, 21, 225, 37);
		panel_1.add(lblNewLabel_3);
		
		nameField = new JTextField(); 
        nameField.setForeground(Color.GRAY); //placeholder color
		nameField.setBounds(220, 247, 267, 20);
		panel.add(nameField);
		nameField.setColumns(10);
		
		nameField.addFocusListener(new FocusListener() { 
			
	            public void focusGained(FocusEvent e) { //when we press the textfield
	                if (nameField.getText().equals("Enter your username")) { //when u focus, it becomes empty
	                    nameField.setText("");
	                    nameField.setForeground(Color.BLACK); //how it is normally
	                }
	            }

	            public void focusLost(FocusEvent e) { //when textfield is not focused
	                if (nameField.getText().isEmpty()) {
	                    nameField.setText("Enter your username");
	                    nameField.setForeground(Color.GRAY); //as a placeholder
	                }
	            }
	        });
		
		passwordField = new JPasswordField(); //password field
		passwordField.setBounds(220, 278, 267, 20);
		panel.add(passwordField);
		
		passwordField.addFocusListener(new FocusListener() { 
			
            public void focusGained(FocusEvent e) { 
            	
            	 String passwordText = new String(passwordField.getPassword());
            	 
                 if (passwordText.equals("Enter your password")) { 
                     passwordField.setText(""); 
                     passwordField.setForeground(Color.BLACK); 
                 }
            }

            public void focusLost(FocusEvent e) { //passwordField does NOT return string but char []
            	
            	String passwordText = new String(passwordField.getPassword()); //to convert char to string
            	
                if (passwordText.isEmpty()) {
                	passwordField.setText("Enter your password"); 
                	passwordField.setForeground(Color.GRAY); 
                }
            }
        });
		
		JButton btnNewButton = new JButton("Login\r\n"); //set something here -> If login successful, go to main page
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) { //when button is pressed, this happens
				 	
				String userName = nameField.getText();
				String pw = new String(passwordField.getPassword()); //convert char to string
				
				
				//BufferedWriters, 
				 try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\manqe\\eclipse-workspace2\\GuitarStore\\src\\user_data.txt", false))) //true to append, false to delete previous content
				 { 
	                    writer.write("Username: " + userName); //write a string into the output stream
	                    writer.newLine(); //add a newline to output stream
	                    writer.write("Password: " + pw);
	                    writer.newLine();
	                    writer.write("------------------------");
	                    writer.newLine();
	                    JOptionPane.showMessageDialog(null, "Data saved successfully!");
	             } 
				 
				 catch (IOException ex) 
				 {
	                    JOptionPane.showMessageDialog(null, "Error saving data: " + ex.getMessage());
	             }
	            
				
				 MainPage mainPage = new MainPage(); //creating an instance of the MainPage class
			     mainPage.setVisible(true); //make the page appear
			        
			   
			     SwingUtilities.getWindowAncestor(btnNewButton).dispose(); //getwindowancestor is to get the TOP LEVEL window which contains the button component. and then close it using dispose()
			     
			}
			
		});
		
		btnNewButton.setBounds(312, 342, 89, 23);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Save login info\r\n"); //set something here
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setBackground(new Color(255, 246, 227));
		rdbtnNewRadioButton.setBounds(220, 305, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
	}
}
