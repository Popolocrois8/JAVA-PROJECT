import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ElectricGuitarShopPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElectricGuitarShopPage frame = new ElectricGuitarShopPage(null); // here null cuz if ran from THIS FILE (main method, nothing to pass) so this is kinda like a dummy JFrame
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
	public ElectricGuitarShopPage(JFrame previousPage) {
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
		panel.setForeground(new Color(0, 0, 0));
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
		
		JLabel lblNewLabel = new JLabel("SHOP ALL        HOME      BY BRANDS      BY INSTRUMENTS      BY ACCESSORIES");
		lblNewLabel.setBounds(20, 69, 509, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOG IN  |  SIGN IN");
		lblNewLabel_1.setBounds(581, 69, 108, 14);
		panel_1.add(lblNewLabel_1);
	
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
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() { // back button
			public void actionPerformed(ActionEvent e) {
				 previousPage.setVisible(true); // Show the previous page
	             dispose(); // Close the current page
			}
		});
		btnNewButton_2.setBounds(615, 11, 89, 23);
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 93, 730, 423);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		ImageIcon guitarImage = new ImageIcon("C:\\Users\\manqe\\Documents\\BOOKS & MATERIALS\\Java\\img\\Guitar shop.png"); //image
		Image guitarImage_scaled = guitarImage.getImage().getScaledInstance(730, 450, Image.SCALE_SMOOTH); //resized image
		ImageIcon guitarImage_resizedIcon = new ImageIcon(guitarImage_scaled);
		
		JButton btnNewButton = new JButton("");
		
		//to make button transparent
		btnNewButton.setContentAreaFilled(false); //remove the button fill
		btnNewButton.setBorderPainted(false); //remove the button border thing
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods.fileReader();
			}
		});
		
		JButton btnNewButton_1 = new JButton("+ Cart"); //to add up prices into the cart
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 methods.fileReader(); //to read from the file
				 CartSystem.addToCart("Electric Guitar: Fender ",methods.getPrice()); //go get the price somehow
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(115, 354, 70, 23);
		panel_2.add(btnNewButton_1);
		btnNewButton.setBounds(348, 104, 244, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel(guitarImage_resizedIcon);
		lblNewLabel_4.setBounds(0, 0, 730, 423);
		panel_2.add(lblNewLabel_4);
		 
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(354, 147, 227, 194);
		panel_2.add(lblNewLabel_5);
		
	}
}
