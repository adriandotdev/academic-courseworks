import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameFive extends JFrame {

	// Field Variables for Frame Five.
	private JPanel contentPane;
	private JTable tblAdvancedCourses;
	private JLabel lblAdvancedCourse;
	private JLabel frameFiveBackground;
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
					FrameFive frame = new FrameFive();
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
	public FrameFive() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				alignment();
			}
		});
	
		setTitle("Advanced Courses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 62, 539, 174);
		contentPane.add(scrollPane);
		
		tblAdvancedCourses = new JTable();
		tblAdvancedCourses.setBackground(new Color(255, 255, 240));
		tblAdvancedCourses.setShowHorizontalLines(false);
		tblAdvancedCourses.setShowGrid(false);
		tblAdvancedCourses.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tblAdvancedCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		tblAdvancedCourses.setModel(new DefaultTableModel(
			new Object[][] {
				{"Javascript Frameworks", "4", "180.00"},
				{"CMS Development Using PHP", "4", "250.50"},
				{"CSS Frameworks", "4", "200.00"},
			},
			new String[] {
				"Courses", "Credit Units", "Fee Per Unit"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblAdvancedCourses.getColumnModel().getColumn(0).setPreferredWidth(141);
		scrollPane.setViewportView(tblAdvancedCourses);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(255, 222, 173));
		btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSubmit.addActionListener(new ActionListener() {
			// (Code Snippet) Submitting the selected courses to Frame Three.
			public void actionPerformed(ActionEvent e) {
				
				Object[] rowOfBasicCourses = new Object[5];
				TableModel modelOfBasicCourses = tblAdvancedCourses.getModel();
				int[] indicesOfSelectedRows = tblAdvancedCourses.getSelectedRows();
				final double DISCOUNT = 0.50;
				
				if (!(tblAdvancedCourses.getSelectedRowCount() > 2) && (getAdvancedCoursesCount() < 2)) { 
					
					if (!isDuplicate()) { 
						
						if (getCredits() <= 12 && !(getCredits() > 12)) {
							
							for(int i = 0; i < indicesOfSelectedRows.length; i++) {
								
								rowOfBasicCourses[0] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 0);
								rowOfBasicCourses[1] = lblAdvancedCourse.getText();
								rowOfBasicCourses[2] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1);
								rowOfBasicCourses[3] = modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 2);
								
								if (FrameThree.lblIndigency.getText().equals("Yes")) {
									rowOfBasicCourses[4] = (DISCOUNT * (Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1).toString()) *
											Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 2).toString())));
								}
								else {
									rowOfBasicCourses[4] = Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1).toString()) * 
											Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 2).toString());
								}
								FrameOne.modelSelectedCourses.addRow(rowOfBasicCourses);
							}
							
							FrameThree.lblCreditUnits.setText(String.valueOf(getTotalCredits()));
							FrameThree.lblTotalFees.setText(String.valueOf(getTotalAdvancedFees()));
						}
						else
							JOptionPane.showMessageDialog(null, "Credit units must not exceed to 12");
					}
					else 
						JOptionPane.showMessageDialog(null, "Duplicate courses are not allowed.");
				}
				else
					JOptionPane.showMessageDialog(null, "Advanced Courses must not exceed to 2.");
			}
		});
		btnSubmit.setBounds(231, 249, 129, 33);
		contentPane.add(btnSubmit);
		
		lblAdvancedCourse = new JLabel("Advanced");
		lblAdvancedCourse.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblAdvancedCourse.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lblAdvancedCourse.setBounds(26, 11, 110, 33);
		contentPane.add(lblAdvancedCourse);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 24));
		lblNewLabel.setBounds(134, 13, 82, 29);
		contentPane.add(lblNewLabel);
		
		// (Code Snippet) Setting up the background for Frame Five.
		frameFiveBackground = new JLabel("");
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frame2.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameFiveBackground.setIcon(i);
		frameFiveBackground.setBounds(0, 0, 596, 316);
		contentPane.add(frameFiveBackground);
		setLocationRelativeTo(null);
		
	}
	// (Code Snippet) Checks if the selected courses are already submitted.
	public boolean isDuplicate() {
		
		boolean isValid = false;
		int[] indices = tblAdvancedCourses.getSelectedRows();
		
		for (int i = 0; i < indices.length; i++) { // for the selected rows only.
			for (int j = FrameThree.tblCourses.getRowCount() - 1; j >= 0; j--) {
				if (tblAdvancedCourses.getValueAt(indices[i], 0).equals(FrameThree.tblCourses.getValueAt(j, 0))) {
					return isValid = true;
				}
			}
		}
		return isValid;
	}
	
	// (Code Snippet) Getting the total credits.
	private double getTotalCredits() {
		
		double totalCredits = 0d;
		for (int i = 0; i < FrameThree.tblCourses.getRowCount(); i++) { 
			totalCredits += Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 2).toString());
		}
		
		return totalCredits;
	}
	
	// (Code Snippet) Getting the total advanced fees.
	private double getTotalAdvancedFees() {
		
		double totalAdvancedFees = 0d;
		for (int i = 0; i < FrameOne.modelSelectedCourses.getRowCount(); i++) {
			totalAdvancedFees += (Double.parseDouble(FrameOne.modelSelectedCourses.getValueAt(i, 4).toString()));
		}
		
		return totalAdvancedFees;
	}
	
	// (Code Snippet) Count the submitted advanced courses.
	private int getAdvancedCoursesCount() {
		
		int advancedCoursesCount = 0;
		for (int j = FrameThree.tblCourses.getRowCount() - 1; j >= 0; j--) {
			if (FrameOne.modelSelectedCourses.getValueAt(j, 1).equals("Advanced")) {
				++advancedCoursesCount;
			}
		}
		return advancedCoursesCount;
	}
	
	// (Code Snippet) Getting the credits.
	private double getCredits() {
		
		double total = 0d;
		double credits = 0d;
		TableModel modelOfBasicCourses = tblAdvancedCourses.getModel();
		int[] indicesOfSelectedRows = tblAdvancedCourses.getSelectedRows();
		
		for (int i = 0; i < indicesOfSelectedRows.length; i++) {
			total += Double.parseDouble(modelOfBasicCourses.getValueAt(indicesOfSelectedRows[i], 1).toString());
		}
		credits = (total  + Double.parseDouble(FrameThree.lblCreditUnits.getText()));
		
		return credits;
	}
	
	// (Code Snippet) Alignment for the cell.
	public void alignment() {
		
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 3; i++) {
			tblAdvancedCourses.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
		
		JTableHeader Theader = tblAdvancedCourses.getTableHeader();
		Theader.setBackground(Color.LIGHT_GRAY);
		Theader.setFont(new Font("Times New Roman", Font.BOLD, 17));
		Theader.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		tblAdvancedCourses.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
	}
}