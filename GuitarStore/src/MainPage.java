import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.*;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
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
		
		JButton btnNewButton_3 = new JButton("Admin Control\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				AdminPage adminPage = new AdminPage(MainPage.this); //try to pass the current page reference
				adminPage.setVisible(true);
				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton_3)).dispose(); //cast to JFrame cuz dispose is a method for JFrames but windowAncestor returns window
			}
		});
		btnNewButton_3.setBounds(576, 11, 144, 23);
		panel_1.add(btnNewButton_3);
		
		//HEADER
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(246, 234, 220));
		panel_2.setBounds(0, 93, 730, 423);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Electric Guitar\r\n");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //send reference of the current page to go back to previous page
				
				methods.readSoldItem();
				ElectricGuitarShopPage electricPage = new ElectricGuitarShopPage(MainPage.this); //cannot use "this" because then it will refer to the action listener instance 
				electricPage.setVisible(true);
				methods.guitarPage = "ElectricGuitar";
				
				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose(); 

			}
		});
		btnNewButton.setBounds(72, 148, 121, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Bass Guitar\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				methods.readSoldItem();
				BassGuitarShopPage BassPage = new BassGuitarShopPage(MainPage.this); 
				BassPage.setVisible(true);
				methods.guitarPage = "BassGuitar";
				
				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose(); 
			}
		});
		btnNewButton_1.setBounds(305, 148, 114, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Accoustic Guitar\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				methods.readSoldItem();
				AccousticGuitarShopPage AccousticPage = new AccousticGuitarShopPage(MainPage.this);
				AccousticPage.setVisible(true);
				methods.guitarPage = "AccousticGuitar"; 
				
				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose(); 
				
			}
		});
		btnNewButton_2.setBounds(520, 148, 145, 23);
		panel_2.add(btnNewButton_2);
		
		JButton button = new JButton("Ukulele\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				methods.readSoldItem();
				UkuleleShopPage UkulelePage = new UkuleleShopPage(MainPage.this);
				UkulelePage.setVisible(true);
				methods.guitarPage = "Ukulele"; 
				
				((JFrame) SwingUtilities.getWindowAncestor(btnNewButton)).dispose(); 
				
			}
		});
		button.setBounds(82, 336, 121, 23);
		panel_2.add(button);
		
	}
}
