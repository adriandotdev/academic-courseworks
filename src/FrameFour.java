import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameFour extends JFrame {
	
	// Field Variables of Frame Four.
	private JPanel contentPane;
	private JTable tblBasicCourses;
	private JButton btnNewButton;
	private JLabel lblBasicCourse;
	private JLabel lblNewLabel;
	private JLabel frameFourBackground;
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
					FrameFour frame = new FrameFour();
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
	public FrameFour() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				alignment();
			}
		});
		setType(Type.POPUP);
		setTitle("Basic Courses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 56, 514, 170);
		contentPane.add(scrollPane);
		
		tblBasicCourses = new JTable();
		tblBasicCourses.setBackground(new Color(255, 255, 224));
		tblBasicCourses.setShowHorizontalLines(false);
		tblBasicCourses.setShowGrid(false);
		tblBasicCourses.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblBasicCourses.setModel(new DefaultTableModel(
			new Object[][] {
				{"Basics of Javascript", "3", "150.00"},
				{"Introduction to HTML5", "2", "120.00"},
				{"Basics of PHP", "3", "180.00"},
				{"Fundamentals of CSS", "2", "150.00"},
			},
			new String[] {
				"Course", "Credit Units", "Fee Per Unit"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblBasicCourses.getColumnModel().getColumn(0).setPreferredWidth(136);
		tblBasicCourses.getColumnModel().getColumn(2).setPreferredWidth(86);
		scrollPane.setViewportView(tblBasicCourses);
		
		btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			// (Code snippet) Submit the selected courses to frame three.
			public void actionPerformed(ActionEvent e) {

				Object[] rowOfBasicCourses = new Object[5];
				TableModel modelOfBasicCourses = tblBasicCourses.getModel();
				int[] indicesOfSelectedRows = tblBasicCourses.getSelectedRows();
						
				if (!isDuplicate()) {
					
					if (getCredits() <= 12 && !(getCredits() > 12)) {
						
						for(int i = 0; i < indicesOfSelectedRows.length; i++) {
							
								rowOfBasicCourses[0] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 0);
								rowOfBasicCourses[1] = lblBasicCourse.getText();
								rowOfBasicCourses[2] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1);
								rowOfBasicCourses[3] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 2);
								rowOfBasicCourses[4] = Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1).toString()) * Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 2).toString());
								FrameOne.modelSelectedCourses.addRow(rowOfBasicCourses);
						}
						
						FrameThree.lblCreditUnits.setText(String.valueOf(getTotalCredits()));
						FrameThree.lblTotalFees.setText(String.valueOf(getTotalBasicFees()));
					}
					else 
						JOptionPane.showMessageDialog(null, "Credit units must not exceed to 12.");	
				}
				else {
					JOptionPane.showMessageDialog(null, "Duplicate courses are not allowed.");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(225, 242, 132, 29);
		contentPane.add(btnNewButton);
		
		lblBasicCourse = new JLabel("Basic");
		lblBasicCourse.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblBasicCourse.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lblBasicCourse.setBounds(42, 16, 60, 29);
		contentPane.add(lblBasicCourse);
		
		lblNewLabel = new JLabel("Courses");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lblNewLabel.setBounds(102, 18, 115, 25);
		contentPane.add(lblNewLabel);
		
		// (Code snippet) Setting up the background for Frame Four.
		frameFourBackground = new JLabel();
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frame2.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameFourBackground.setIcon(i);
		frameFourBackground.setBounds(0, 0, 596, 316);
		contentPane.add(frameFourBackground);
		setLocationRelativeTo(null);
		
	}
	
	// (Code Snippet) Checks if the selected courses is already submitted.
	private boolean isDuplicate() {
		
		boolean isValid = false;
		int[] indices = tblBasicCourses.getSelectedRows();
		
		for (int i = 0; i < indices.length; i++) { // for the selected rows only.
			for (int j = FrameThree.tblCourses.getRowCount() - 1; j >= 0; j--) {
				if (tblBasicCourses.getValueAt(indices[i], 0).equals(FrameThree.tblCourses.getValueAt(j, 0))) {
					return isValid = true;
				}
			}
		}
		return isValid;
	}
	
	// (Code Snippet) Getting the credit units.
	private double getCredits() {
		
		TableModel modelOfBasicCourses = tblBasicCourses.getModel();
		int[] indicesOfSelectedRows = tblBasicCourses.getSelectedRows();
		double credits = 0d;
		double total = 0d;
		
		for (int i = 0; i < indicesOfSelectedRows.length; i++) {
			total += Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1).toString()); 
		}
		credits = (total +  Double.parseDouble(FrameThree.lblCreditUnits.getText()));
		
		return credits;
	}
	
	// (Code Snippet) Getting the total credit units.
	private double getTotalCredits() {
		
		double totalCredits = 0d;
		
		for (int i = 0; i < FrameThree.tblCourses.getRowCount(); i++) {
			totalCredits += Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 2).toString());
		}
		
		return totalCredits;
	}
	
	// (Code Snippet) Getting the total basic fees.
	private double getTotalBasicFees() {
		
		double totalFeesForBasicCourses = 0d;
		
		for (int i = 0; i < FrameOne.modelSelectedCourses.getRowCount(); i++) { 
			totalFeesForBasicCourses += (Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 4).toString()));
		}
		
		return totalFeesForBasicCourses;
	}
	
	// (Code Snippet) Alignment.
	private void alignment() {
		
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 3; i++) {
			tblBasicCourses.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
		
		JTableHeader Theader = tblBasicCourses.getTableHeader();
		Theader.setBackground(Color.LIGHT_GRAY);
		Theader.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Theader.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		tblBasicCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
	}
}