import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrameOne extends JFrame {
	
	private JPanel contentPane;
	private JButton btnEnrollNow;
	private JButton btnNewButton;
	private JButton btnAboutUs;
	private JLabel backgroundFrameOne;
	private JMenuItem itemEnrolledStudents;
	private JMenuItem itemExit;
	public static String[] columns = { "Course", "Category", "Credit Units", "Fee Per Unit", "Total"};
	public static DefaultTableModel modelSelectedCourses = new DefaultTableModel();
	public static Object[] frameSevenColumns = { "Student No.", "Name", "Age", "Contact Information", "Indigency", "Courses", "Total Units", "Total Fees" };
	public static DefaultTableModel modelFrameSeven = new DefaultTableModel();
	
	
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
					FrameOne frame = new FrameOne();
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

	public FrameOne() {
		
		setTitle("YGO Programming Center");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 826, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEnrollNow = new JButton("ENROLL NOW");
		btnEnrollNow.setBackground(new Color(255, 222, 173));
		btnEnrollNow.setForeground(Color.DARK_GRAY);
		btnEnrollNow.addActionListener(new ActionListener() {
			// Setting the frame two
			public void actionPerformed(ActionEvent e) {
				FrameTwo frameTwo = new FrameTwo();
				close();
				frameTwo.setVisible(true);
			}
		});
		btnEnrollNow.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnEnrollNow.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnEnrollNow.setBounds(318, 255, 164, 27);
		contentPane.add(btnEnrollNow);
		
		btnAboutUs = new JButton("ABOUT US");
		btnAboutUs.addActionListener(new ActionListener() {
			// Setting the frame eight
			public void actionPerformed(ActionEvent e) {
				FrameEight frameEight = new FrameEight();
				frameEight.setVisible(true);
			}
		});
		btnAboutUs.setBackground(new Color(255, 222, 173));
		btnAboutUs.setForeground(Color.DARK_GRAY);
		btnAboutUs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAboutUs.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnAboutUs.setBounds(318, 311, 164, 27);
		contentPane.add(btnAboutUs);
		
		// Setting the image
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frame1.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameOne = new ImageIcon(img2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 222, 173));
		menuBar.setBounds(0, 0, 866, 23);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setBackground(new Color(255, 222, 173));
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		mnNewMenu.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 14));
		menuBar.add(mnNewMenu);
		
		itemEnrolledStudents = new JMenuItem("Enrolled Students");
		itemEnrolledStudents.setBackground(new Color(255, 222, 173));
		itemEnrolledStudents.addActionListener(new ActionListener() {
			// Setting the frame seven
			public void actionPerformed(ActionEvent e) {
				FrameSeven frameSeven = new FrameSeven();
				frameSeven.setVisible(true);
			}
		});
		itemEnrolledStudents.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemEnrolledStudents.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		mnNewMenu.add(itemEnrolledStudents);
		
		itemExit = new JMenuItem("Exit");
		itemExit.setBackground(new Color(255, 222, 173));
		itemExit.addActionListener(new ActionListener() {
			// Close the frame one
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		itemExit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemExit.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		mnNewMenu.add(itemExit);
		
		btnNewButton = new JButton("EXIT");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			// Close the frame one
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnNewButton.setBounds(318, 371, 164, 27);
		contentPane.add(btnNewButton);
		
		backgroundFrameOne = new JLabel("");
		backgroundFrameOne.setIcon(imgFrameOne);
		backgroundFrameOne.setBounds(-25, 0, 855, 505);
		contentPane.add(backgroundFrameOne);
		setLocationRelativeTo(null);
	}
	
	// Method for dispose closing
	public void close() {
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
}