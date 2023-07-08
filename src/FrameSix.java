import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.NumberFormat;

public class FrameSix extends JFrame {

	// Field Variables for Frame Six.
	private JPanel contentPane;
	public static  JLabel lblNamePreview;
	public static JLabel lblAddress;
	public static JLabel lblContactNo;
	public static JLabel lblDiscountBeneficiary;
	public static JLabel lblAgeOfStudent;
	public static String[] arr = new String[1];
	private JScrollPane scrollPane;
	private JLabel lblTotalUnits;
	private JLabel lblTotalFees;
	private JTable tblPreview;
	private JLabel frameSixBackground;
	
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
					FrameSix frame = new FrameSix();
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
	
	
	public FrameSix() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				alignment();
			}
		});
		
		setTitle("Preview");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PERSONAL INFORMATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 25));
		lblNewLabel.setBounds(239, 11, 329, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_1.setBounds(21, 39, 87, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Address:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_2.setBounds(21, 94, 60, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact No.");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_3.setBounds(21, 123, 78, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Discount Beneficiary:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_5.setBounds(21, 152, 141, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enrolled Courses:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16));
		lblNewLabel_6.setBounds(21, 181, 120, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNamePreview = new JLabel(FrameThree.lblName.getText());
		lblNamePreview.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNamePreview.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNamePreview.setBounds(109, 39, 682, 18);
		contentPane.add(lblNamePreview);
		
		lblAddress = new JLabel(FrameThree.lblAddress.getText());
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAddress.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblAddress.setBounds(91, 94, 689, 18);
		contentPane.add(lblAddress);
		
		lblContactNo = new JLabel(FrameThree.lblContact.getText());
		lblContactNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblContactNo.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblContactNo.setBounds(109, 124, 664, 17);
		contentPane.add(lblContactNo);
		
		lblDiscountBeneficiary = new JLabel(FrameThree.lblIndigency.getText());
		lblDiscountBeneficiary.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDiscountBeneficiary.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblDiscountBeneficiary.setBounds(157, 155, 215, 15);
		contentPane.add(lblDiscountBeneficiary);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 212, 753, 176);
		contentPane.add(scrollPane);
		
		tblPreview = new JTable(FrameOne.modelSelectedCourses);
		scrollPane.setViewportView(tblPreview);
		
		JLabel lblNewLabel_4 = new JLabel("Total Units:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_4.setBounds(484, 182, 78, 18);
		contentPane.add(lblNewLabel_4);
		
		lblTotalUnits = new JLabel(totalUnits());
		lblTotalUnits.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalUnits.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblTotalUnits.setBounds(557, 182, 64, 18);
		contentPane.add(lblTotalUnits);
		
		lblTotalFees = new JLabel(totalFees());
		lblTotalFees.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTotalFees.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblTotalFees.setBounds(710, 182, 64, 18);
		contentPane.add(lblTotalFees);
		
		JLabel lblNewLabel_8 = new JLabel("Total Fees:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_8.setBounds(631, 182, 75, 18);
		contentPane.add(lblNewLabel_8);
		
		DefaultTableModel model = (DefaultTableModel) tblPreview.getModel();
		model.setColumnIdentifiers(FrameOne.columns);
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frame2.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		
		JLabel lblNewLabel_7 = new JLabel("Age:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_7.setBounds(21, 65, 32, 18);
		contentPane.add(lblNewLabel_7);
		
		lblAgeOfStudent = new JLabel(FrameThree.lblAge.getText());
		lblAgeOfStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAgeOfStudent.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblAgeOfStudent.setBounds(63, 69, 231, 14);
		contentPane.add(lblAgeOfStudent);
		
		frameSixBackground = new JLabel("");
		frameSixBackground.setIcon(i);
		frameSixBackground.setBounds(0, -50, 863, 497);
		contentPane.add(frameSixBackground);
		setLocationRelativeTo(null);
		
	}
	// (Code Snippet) Alignment of Table.
	public void alignment() {
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 5; i++) {
			tblPreview.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
		
		JTableHeader Theader = tblPreview.getTableHeader();
		Theader.setBackground(Color.LIGHT_GRAY);
		Theader.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Theader.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		tblPreview.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
	}
	
	// (Code Snippet) Getting the total credit units.
	private String totalUnits() {
		
		double totalUnits = 0d;
		
		for (int i = 0; i < tblPreview.getRowCount(); i++) {
			totalUnits += Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 2).toString());
		}
		return Double.toString(totalUnits);
	}
	
	// (Code Snippet) Getting the total fees.
	private String totalFees () {
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		double totalFees = 0d;
		
		for (int i = 0; i < tblPreview.getRowCount(); i++) {
			totalFees += Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 4).toString());
		}
		return nf.format(totalFees);
	}
}
