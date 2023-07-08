import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;

public class FrameTwo extends JFrame {

	// V
	private JPanel contentPane;
	private final ButtonGroup btnGroupIndigency = new ButtonGroup();
	public static JTextField txtLastName;
	private JTextField txtAddress;
	private JTextField txtAge;
	private JTextField txtContactInformation;
	private JTextField txtFirstName;
	private JTextField txtMiddleName;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;
	private JButton btnNext;
	private JButton btnPrevious;
	private JLabel frameTwoBackground;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}
		catch(Exception e) {}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTwo frame = new FrameTwo();
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
	public FrameTwo() {
		
		setTitle("Personal Information");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 825, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(128, 86, 151, 28);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(128, 139, 472, 28);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(128, 191, 76, 28);
		contentPane.add(txtAge);
		txtAge.setColumns(10);
		
		txtContactInformation = new JTextField();
		txtContactInformation.setBounds(180, 244, 188, 28);
		contentPane.add(txtContactInformation);
		txtContactInformation.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(374, 86, 151, 28);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(626, 80, 151, 28);
		contentPane.add(txtMiddleName);
		txtMiddleName.setColumns(10);
		
		rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(new Color(255, 204, 153));
		rdbtnYes.setSelected(true);
		btnGroupIndigency.add(rdbtnYes);
		rdbtnYes.setBounds(42, 320, 54, 23);
		contentPane.add(rdbtnYes);
		
		rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(new Color(255, 204, 153));
		btnGroupIndigency.add(rdbtnNo);
		rdbtnNo.setBounds(128, 320, 54, 23);
		contentPane.add(rdbtnNo);
		
		JLabel lblNewLabel = new JLabel("Last Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel.setBounds(42, 96, 76, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PERSONAL INFORMATION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lblNewLabel_1.setBounds(42, 32, 294, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_2.setBounds(290, 90, 78, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Middle Name:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_3.setBounds(535, 90, 94, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_4.setBounds(42, 195, 32, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contact Information:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_5.setBounds(42, 248, 136, 18);
		contentPane.add(lblNewLabel_5);
		
		btnNext = new JButton("Next"); 
		btnNext.setBackground(new Color(255, 222, 173));
		btnNext.addActionListener(new ActionListener() {
			// Code for submitting the PERSONAL INFORMATION
			public void actionPerformed(ActionEvent e) {

				String str = txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleName.getText();
				if (allTextFieldsIsEmpty()) 

					JOptionPane.showMessageDialog(null, "All fields are required."); 
				
				else { 
					
					if(!isAlreadyEnrolled()) {
						
						FrameThree frameThree = new FrameThree();
							
						FrameThree.lblName.setText(txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleName.getText());
						FrameThree.lblAddress.setText(txtAddress.getText());
						FrameThree.lblAge.setText(txtAge.getText() + " years old");
						FrameThree.lblContact.setText(txtContactInformation.getText());
							
						if (rdbtnYes.isSelected())  
							FrameThree.lblIndigency.setText(rdbtnYes.getText());
						else
							FrameThree.lblIndigency.setText(rdbtnNo.getText());
							
						JOptionPane.showMessageDialog(null, "Personal information submitted.");
						close();
						frameThree.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, str + " is already enrolled.");
						clearAll();
					}
				}
			}
		});
		btnNext.setBounds(648, 377, 107, 39);
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNext.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		contentPane.add(btnNext);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.setBackground(new Color(255, 222, 173));
		btnPrevious.addActionListener(new ActionListener() {
			// Setting the frame one.
			public void actionPerformed(ActionEvent e) {
				FrameOne frameOne = new FrameOne();
				frameOne.setVisible(true);
				close();
			}
		});
		btnPrevious.setBounds(47, 377, 107, 39);
		btnPrevious.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnPrevious.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		contentPane.add(btnPrevious);
		
		JLabel lblNewLabel_6 = new JLabel("Are you from an indigent family?");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_6.setBounds(42, 295, 220, 18);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Address:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_7.setBounds(42, 143, 60, 18);
		contentPane.add(lblNewLabel_7);
		
		frameTwoBackground = new JLabel("");
		frameTwoBackground.setBackground(new Color(255, 228, 196));
		// Setting the background
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameBlank.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameTwoBackground.setIcon(i);
		frameTwoBackground.setBounds(0, -51, 863, 508);
		contentPane.add(frameTwoBackground);
		setLocationRelativeTo(null);
		
	}
	
	// Checking if all components are not empty.
	private boolean allTextFieldsIsEmpty() { 
		
		boolean isEmpty = false;
		
		if (txtLastName.getText().isEmpty() || txtFirstName.getText().isEmpty() || txtMiddleName.getText().isEmpty() ||
				txtAge.getText().isEmpty() || txtContactInformation.getText().isEmpty() || txtAddress.getText().isEmpty()) {
			return isEmpty = true;
		}
		else 
			return isEmpty;
	}
	
	// Checking if the input name is already enrolled.
	private boolean isAlreadyEnrolled() {
		
		String str = txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleName.getText();
		String studentName = str.replaceAll(" ", "");
		boolean isValid = false;
		for (int i = 0; i < FrameOne.modelFrameSeven.getRowCount(); i++) {
			
			if (FrameOne.modelFrameSeven.getValueAt(i, 1).toString().replaceAll(" ", "").equalsIgnoreCase(studentName)) 
				isValid = true;
		}
		return isValid;
	}

	// Clear all the components.
	private void clearAll() {
		txtLastName.setText(null);
		txtFirstName.setText(null);
		txtMiddleName.setText(null);
		txtAge.setText(null);
		txtContactInformation.setText(null);
		txtAddress.setText(null);
	}
	
	// Close the frame.
	public void close() { // This is for automatic closing ng Frame.
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
}