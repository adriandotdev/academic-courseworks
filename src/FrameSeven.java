import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameSeven extends JFrame {

	// Field Variables for Frame Seven.
	private JPanel contentPane;
	private JTable tblFrameSeven;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JButton btnDelete;
	private JButton btnDeleteAll;
	private JLabel frameSevenBackground;
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
					FrameSeven frame = new FrameSeven();
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
	public FrameSeven() {
		addWindowListener(new WindowAdapter() {
			@Override
			// (Code Snippet) Center and set the width of the table.
			public void windowOpened(WindowEvent e) {
				if (tblFrameSeven.getRowCount() >= 1) {
					center();
					setWidthAutomatic();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 852, 475);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 826, 301);
		contentPane.add(scrollPane);
		
		tblFrameSeven = new JTable(FrameOne.modelFrameSeven);
		tblFrameSeven.addMouseListener(new MouseAdapter() {
			@Override
			// Set the width.
			public void mouseClicked(MouseEvent e) {
				preferedWidthOfTableHeader();
			}
		});
		tblFrameSeven.setBackground(new Color(255, 255, 240));
		scrollPane.setViewportView(tblFrameSeven);
		
		lblNewLabel = new JLabel("Enrolled Students");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 28));
		lblNewLabel.setBounds(10, 40, 231, 33);
		contentPane.add(lblNewLabel);
		
		btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setBackground(new Color(255, 222, 173));
		btnDeleteAll.addActionListener(new ActionListener() {
			// Delete All The Enrolled Students.
			public void actionPerformed(ActionEvent e) {
				deleteAll();
			}
		});
		btnDeleteAll.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDeleteAll.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnDeleteAll.setBounds(114, 396, 115, 27);
		contentPane.add(btnDeleteAll);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 222, 173));
		btnDelete.addActionListener(new ActionListener() {
			// Delete the selected enrolled students.
			public void actionPerformed(ActionEvent e) {
				deleteStudentInfo();
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDelete.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		btnDelete.setBounds(548, 396, 109, 27);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("A.Y. 2020 - 2021");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
		lblNewLabel_1.setBounds(676, 52, 124, 21);
		contentPane.add(lblNewLabel_1);
		
		// (Code Snippet) Setting up the background.
		frameSevenBackground = new JLabel("");
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameBlank.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameSevenBackground.setIcon(i);
		frameSevenBackground.setBounds(0, 0, 924, 447);
		contentPane.add(frameSevenBackground);
		setLocationRelativeTo(null);
	}
	
	// (Code Snippet) Centering the tbale.
	private  void center() {
		
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 8; i++) {
			tblFrameSeven.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
		
		JTableHeader Theader = tblFrameSeven.getTableHeader();
		Theader.setBackground(Color.LIGHT_GRAY);
		Theader.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 17));
		tblFrameSeven.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 15));
	}
	
	// (Code Snippet) Setting the width.
	private void setWidthAutomatic () {
		
		TableColumnModel column = tblFrameSeven.getColumnModel();
		TableModel model = tblFrameSeven.getModel();
		int total = column.getColumnCount();
		
		for (int i = 0; i < total; i++) {
			
			int tail = 0;
			int total2 = model.getRowCount();
			
			for (int j = 0; j < total2; j++) {
				if (model.getValueAt(j, i) != null) {
					int tail2 = model.getValueAt(j, i).toString().length() * 7;
					if (tail2 > tail) {
						tail = tail2;
					}
				}
				column.getColumn(i).setPreferredWidth(tail);
			}
		}
		
	}
	
	// (Code Snippet) Delete the student information.
	public void deleteStudentInfo() {
		
		int[] selectedStudentInfo = tblFrameSeven.getSelectedRows();
		int value = 1;
		
		if (tblFrameSeven.getSelectedRow() >= 0) {
			
				int response = JOptionPane.showConfirmDialog(null, "Delete the selected student information?");
				
				if(response == JOptionPane.YES_OPTION) {
						
					for (int j = selectedStudentInfo.length - 1; j >= 0; j--) {
						
						FrameOne.modelFrameSeven.removeRow(selectedStudentInfo[j]);
					}
					for (int i = 0; i < tblFrameSeven.getRowCount(); i++) {
						tblFrameSeven.setValueAt(value, i, 0);
						value++;
					}
				}
			else 
				JOptionPane.showMessageDialog(null, "Deletion is cancelled.");
			}
		else 
			JOptionPane.showMessageDialog(null, "There are no enrolled students.");
	}
	
	// (Code Snippet) Delete all the enrolled students.
	public void deleteAll() {
		
		DefaultTableModel delete = (DefaultTableModel) tblFrameSeven.getModel();
		delete.setRowCount(0);
	}
	
	// (Code Snippet) Setting up the prefered width.
	private void preferedWidthOfTableHeader() {
		
		for (int i = 0; i < tblFrameSeven.getColumnCount(); i++) {
			TableColumn column = tblFrameSeven.getColumnModel().getColumn(i);
			column.setPreferredWidth(300);
		}
	}
}
