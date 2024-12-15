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

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage frame = new AdminPage(null);
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
	public AdminPage(JFrame PreviousPage) { //previous JFrame reference 
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
		
		JLabel lblNewLabel = new JLabel("Customer Logs | Receipt History | \r\n"); //\r to bring cursor to beggning of line , can also be used to overwrite console
		lblNewLabel.setBounds(20, 69, 195, 14);
		panel_1.add(lblNewLabel);
	
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
		
		JButton btnNewButton = new JButton("Add New Entry\r\n\r\n");
		btnNewButton.setBorder(null);   
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods.showGuitarInputForm(); //can directly call (no need for an object instance) cuz static method
			}
		});
		btnNewButton.setBounds(214, 65, 88, 23);
		panel_1.add(btnNewButton);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreviousPage.setVisible(true); // Show the previous page
	            dispose(); 
	            
			}
		});
		button.setBounds(612, 11, 89, 23);
		panel_1.add(button);
		
	}
}
