import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameFour extends JFrame {

	// These are all the field variables for Frame Four.
	private JPanel contentPane;
	public static JTable tblTable;
	private Font myFont;
	private Font labelFont;
	public static DefaultTableModel model = new DefaultTableModel();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//FrameOne.playMusic("ac.wav");
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
		FrameFour.model.setColumnIdentifiers(FrameThree.column);
		setFont();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 855, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 207, 789, 193);
		contentPane.add(scrollPane);
		
		tblTable = new JTable(model);
		scrollPane.setViewportView(tblTable);
		
		JLabel lblNewLabel = new JLabel("CHARACTERS");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(labelFont);
		lblNewLabel.setBounds(28, 160, 430, 43);
		contentPane.add(lblNewLabel);
		
		JLabel frameFourBackground = new JLabel("");
		ImageIcon myImageTwo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameFour.jpg")));
		Image img3 = myImageTwo.getImage();
		Image img4 = img3.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameThreePrtTwo= new ImageIcon(img4);
		frameFourBackground.setIcon(imgFrameThreePrtTwo);
		frameFourBackground.setBounds(0, 0, 872, 445);
		contentPane.add(frameFourBackground);
		setLocationRelativeTo(null);
		center();
		
	}
	
	// These are all the user-defined method.
	private void setFont() {
		
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(12f);
			labelFont = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")));
		}
		catch (IOException | FontFormatException e) {
		}
	}
	
	private void center() {
		
		
		JTableHeader Theader = tblTable.getTableHeader();
		Theader.setBackground(Color.DARK_GRAY);
		Theader.setFont(myFont);//
		tblTable.setFont(myFont);//
			
		if(tblTable.getRowCount() > 0) {	
			DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
			centerRend.setHorizontalAlignment(JLabel.CENTER);
			for (int i = 0; i < 5; i++) {
				tblTable.getColumnModel().getColumn(i).setCellRenderer(centerRend);
			}
		}
	}
}
