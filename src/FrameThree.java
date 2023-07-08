import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.event.WindowAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;

public class FrameThree extends JFrame {

	// Field Variables for Frame Three.
	private JPanel contentPane;
	private JScrollPane scrollPane;
	public static JTable tblCourses;
	
	public static JLabel lblName;
	public static JLabel lblAge;
	public static JLabel lblContact;
	public static JLabel lblIndigency;
	public static JLabel lblCreditUnits; 
	public static JLabel lblTotalFees; 
	public static JLabel lblAddress;
	
	public static JButton btnEnroll;
	private JButton btnDelete;
	private JButton btnRemoveAll;
	
	public static JMenu menuCoursesCategory;
	public static JMenuItem itemBasicCourses;
	public static JMenuItem itemAdvancedCourses;
	private JMenuItem itemAboutUs;
	private JMenu menuPreview;
	private JMenuBar menuBar;
	private JMenu menuHome;
	private JMenuItem itemBack;
	private JMenuItem itemPreview;
	
	public static String name = ""; 
	public static String address = "";
	public static String contact = ""; 
	public static String age = ""; 
	public static String email = "";
	public static String discountBeneficiary = ""; 
	public static String numberOfEnrolledCourses = ""; 
	public static String totalUnits = ""; 
	public static String totalFees = ""; 
	
	private JLabel frameThreeBackground;
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
					FrameThree frame = new FrameThree();
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
	public FrameThree() {
		
		FrameOne.modelFrameSeven.setColumnIdentifiers(FrameOne.frameSevenColumns);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				center();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setType(Type.POPUP);
		setBounds(100, 100, 820, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(8, 0, 8, 0));
		menuBar.setBackground(new Color(255, 222, 173));
		menuBar.setBounds(0, 0, 810, 26);
		contentPane.add(menuBar);
		
		menuHome = new JMenu("HOME");
		menuHome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuHome.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 12));
		menuBar.add(menuHome);
		
		itemAboutUs = new JMenuItem("About Us");
		itemAboutUs.setBackground(new Color(255, 222, 173));
		itemAboutUs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemAboutUs.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		menuHome.add(itemAboutUs);
		
		itemBack = new JMenuItem("Back");
		itemBack.setBackground(new Color(255, 222, 173));
		itemBack.addActionListener(new ActionListener() {
			// Setting the frame one.
			public void actionPerformed(ActionEvent e) {
				FrameOne frameOne = new FrameOne();
				clearAll();
				deleteAllCourses();
				close();
				frameOne.setVisible(true);
			}
		});
		itemBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemBack.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		menuHome.add(itemBack);
		
		menuCoursesCategory = new JMenu("COURSES CATEGORY");
		menuCoursesCategory.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuCoursesCategory.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 12));
		menuBar.add(menuCoursesCategory);
		
		itemBasicCourses = new JMenuItem("Basic Courses");
		itemBasicCourses.setBackground(new Color(255, 222, 173));
		itemBasicCourses.addActionListener(new ActionListener() {
			// Setting the frame four.
			public void actionPerformed(ActionEvent e) {
				var frameFour = new FrameFour();
				frameFour.setVisible(true);
			}
		});
		itemBasicCourses.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemBasicCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		menuCoursesCategory.add(itemBasicCourses);
		
		itemAdvancedCourses = new JMenuItem("Advanced Courses");
		itemAdvancedCourses.setBackground(new Color(255, 222, 173));
		itemAdvancedCourses.addActionListener(new ActionListener() {
			// Setting the frame five.
			public void actionPerformed(ActionEvent e) {
				FrameFive frameFive = new FrameFive();
				frameFive.setVisible(true);
			}
		});
		itemAdvancedCourses.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemAdvancedCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		menuCoursesCategory.add(itemAdvancedCourses);
		
		menuPreview = new JMenu("PREVIEW");
		menuPreview.setBackground(new Color(255, 255, 240));
		menuPreview.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuPreview.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 12));
		menuBar.add(menuPreview);
		
		itemPreview = new JMenuItem("Print Preview");
		itemPreview.setBackground(new Color(255, 222, 173));
		itemPreview.addActionListener(new ActionListener() {
			// Setting the frame six.
			public void actionPerformed(ActionEvent e) {
				FrameSix frameSix = new FrameSix();
				frameSix.setVisible(true);
			}
		});
		itemPreview.setFont(new Font("Times New Roman", Font.BOLD, 15));
		itemPreview.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		menuPreview.add(itemPreview);
		
		JLabel lblNewLabel = new JLabel("Credit Units:"); // declare it
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel.setBounds(487, 166, 86, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Fees:"); // declare it
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(635, 166, 76, 20);
		contentPane.add(lblNewLabel_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 197, 758, 177);
		contentPane.add(scrollPane);
		
		tblCourses = new JTable(FrameOne.modelSelectedCourses);
		tblCourses.setBackground(new Color(255, 255, 224));
		tblCourses.addMouseListener(new MouseAdapter() {
			@Override
			// Change the width of the cell when clicked.
			public void mouseClicked(MouseEvent e) {
				setWidthAutomatic();
			}
		});
		scrollPane.setViewportView(tblCourses);
		FrameOne.modelSelectedCourses.setColumnIdentifiers(FrameOne.columns);
		
		btnEnroll = new JButton("Enroll"); // ENROLL BUTTON
		btnEnroll.setBackground(new Color(255, 222, 173));
		btnEnroll.addActionListener(new ActionListener() {
			// Set the information to frame six and frame seven.
			public void actionPerformed(ActionEvent e) {
				
				if (tblCourses.getRowCount() > 0) {
					
					if (!(isAlreadyEnrolled())) {
						
						setToFrameSix();
						setToFrameSeven();
					}
					else
						JOptionPane.showMessageDialog(null, "You are already enrolled.");
				}
				else
					JOptionPane.showMessageDialog(null, "You don't have select a course.");
			}
		});
		btnEnroll.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnEnroll.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		btnEnroll.setBounds(664, 396, 114, 29);
		contentPane.add(btnEnroll);
		
		btnDelete = new JButton("Delete"); // DELETE BUTTON
		btnDelete.setBackground(new Color(255, 222, 173));
		btnDelete.addActionListener(new ActionListener() {
			// Delete the selected courses.
			public void actionPerformed(ActionEvent e) {
				deleteSelectedCourses(); // delete the specific selected rows.
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnDelete.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		btnDelete.setBounds(355, 396, 103, 29);
		contentPane.add(btnDelete);
		
		btnRemoveAll = new JButton("Delete All"); // DELETE ALL
		btnRemoveAll.setBackground(new Color(255, 222, 173));
		btnRemoveAll.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRemoveAll.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		btnRemoveAll.addActionListener(new ActionListener() {
			// Delete all the courses.
			public void actionPerformed(ActionEvent e) {
				deleteAllCourses(); 
			}
		});
		btnRemoveAll.setBounds(20, 396, 121, 29);
		contentPane.add(btnRemoveAll);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_2.setBounds(20, 49, 90, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_3.setBounds(20, 106, 33, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_4.setBounds(20, 137, 56, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Indigency:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_5.setBounds(20, 166, 70, 20);
		contentPane.add(lblNewLabel_5);
		
		lblName = new JLabel();
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblName.setBounds(120, 49, 665, 23);
		contentPane.add(lblName);
		
		lblAge = new JLabel();
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAge.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblAge.setBounds(91, 108, 114, 18);
		contentPane.add(lblAge);
		
		lblContact = new JLabel("");
		lblContact.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContact.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblContact.setBounds(91, 135, 687, 20);
		contentPane.add(lblContact);
		
		lblIndigency = new JLabel("");
		lblIndigency.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIndigency.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblIndigency.setBounds(91, 168, 64, 18);
		contentPane.add(lblIndigency);
		
		lblCreditUnits = new JLabel("0.00");
		lblCreditUnits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCreditUnits.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblCreditUnits.setBounds(583, 167, 42, 18);
		contentPane.add(lblCreditUnits);
		
		lblTotalFees = new JLabel("0.00");
		lblTotalFees.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalFees.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblTotalFees.setBounds(721, 167, 64, 18);
		contentPane.add(lblTotalFees);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_6.setBounds(20, 75, 60, 20);
		contentPane.add(lblNewLabel_6);
		
		lblAddress = new JLabel("");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblAddress.setBounds(91, 77, 687, 20);
		contentPane.add(lblAddress);
		
		frameThreeBackground = new JLabel();
		// Setting up the background.
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameBlank.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameThreeBackground.setIcon(i);
		frameThreeBackground.setBounds(0, -45, 810, 492);
		contentPane.add(frameThreeBackground);
		setLocationRelativeTo(null);
	}
	
	// (Code snippet) Center the cell of the table.
	private  void center() {
		
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 5; i++) {
			tblCourses.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
		
		JTableHeader Theader = tblCourses.getTableHeader();
		Theader.setBackground(Color.LIGHT_GRAY);
		Theader.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		tblCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
	}
	
	// (Code snippet) Closing the frame.
	private void close() {
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
	
	// (Code snippet) Delete the selected courses.
	private void deleteSelectedCourses() {
		
	int[] selectedRowsToDelete = tblCourses.getSelectedRows();
			
	if(FrameOne.modelSelectedCourses.getRowCount() == 0) 
			
			JOptionPane.showMessageDialog(null, "No existing courses!");
	else {
				
		if(tblCourses.getSelectedRow() >= 0) { // because the index is starting in 0.
					
			int response = JOptionPane.showConfirmDialog(null, "Delete the selected courses?");
				
				if(response == JOptionPane.YES_OPTION) {
							
					for (int j = selectedRowsToDelete.length - 1; j >= 0; j--) {
						lblCreditUnits.setText(String.valueOf((Double.parseDouble(lblCreditUnits.getText()) - Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(selectedRowsToDelete[j], 2).toString()))));
						lblTotalFees.setText(String.valueOf((Double.parseDouble(lblTotalFees.getText()) - (Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(selectedRowsToDelete[j], 4).toString())))));
						FrameOne.modelSelectedCourses.removeRow(selectedRowsToDelete[j]);
					}
				}
				else 
					JOptionPane.showMessageDialog(null, "Courses deletion is cancelled.");
			}
		else 
			JOptionPane.showMessageDialog(null, "No selected courses.");
		}
	}
	
	// (Code snippet) Delete all courses.
	private void deleteAllCourses() {
		
		DefaultTableModel delete = (DefaultTableModel) tblCourses.getModel();
		delete.setRowCount(0);
		lblCreditUnits.setText("0.00");
		lblTotalFees.setText("0.00");
	}
	
	// (Code snippet) set the PERSONAL INFORMATION to Frame Six.
	private void setToFrameSix() {
		
		name = lblName.getText();
		address = lblAddress.getText();
		age = lblAge.getText();
		contact = lblContact.getText();
		discountBeneficiary = lblIndigency.getText();
		JOptionPane.showMessageDialog(null, "You are enrolled in YGO Programming Center. \n" + "If you want to check your submitted information, kindly go to the Preview section.");
		
	}
	
	// (Code snippet) set the PERSONAL INFORMATION to Frame Seven.
	private void setToFrameSeven() {
	
		Object[] frameSeven = new Object[8];
		
		frameSeven[0] = FrameOne.modelFrameSeven.getRowCount() + 1;
		frameSeven[1] = lblName.getText();
		frameSeven[2] = lblAge.getText();
		frameSeven[3] = lblContact.getText();
		frameSeven[4] = lblIndigency.getText();
		frameSeven[5] =	tblCourses.getRowCount();
		frameSeven[6] = lblCreditUnits.getText();
		frameSeven[7] = lblTotalFees.getText();
		FrameOne.modelFrameSeven.addRow(frameSeven);
		
	}
	
	// (Code snippet) setting the variables to empty.
	private void clearAll() {

		name = "";
		address = "";
		age = "";
		contact = "";
		discountBeneficiary = "";
	}
	
	// (Code snippet) Checks if the student is already enrolled.
	private boolean isAlreadyEnrolled() {
		
		boolean isValid = false;
		String fullName = lblName.getText();
		
		for (int i = 0; i < FrameOne.modelFrameSeven.getRowCount(); i++) {
			
			if (FrameOne.modelFrameSeven.getValueAt(i, 1).toString().equalsIgnoreCase(fullName)) 
				isValid = true;
		}
		return isValid;
	}
	
	// (Code snippet) Setting the width.
	private void setWidthAutomatic() {
		
		TableColumnModel column = tblCourses.getColumnModel();
		TableModel model = tblCourses.getModel();
		int total = column.getColumnCount();
		
		for (int i = 0; i < total; i++) {
			
			int tail = 0;
			int total2 = model.getRowCount();
			
			for (int j = 0; j < total2; j++) {
				if (model.getValueAt(j, i) != null) {
					int tail2 = model.getValueAt(j, i).toString().length() * 7;
						if (tail2 > tail) 
							tail = tail2;
				}
				column.getColumn(i).setPreferredWidth(tail);
			}
		}
	}
}