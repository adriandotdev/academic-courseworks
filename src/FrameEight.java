import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.JLabel;

public class FrameEight extends JFrame {

	// Field Variables for Frame Eight.
	private JPanel contentPane;
	private JLabel frameEightBackground;
	private JTextArea txtrYgoProgrammingCenter;
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
					FrameEight frame = new FrameEight();
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
	public FrameEight() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 790, 252);
		contentPane.add(scrollPane);
		// (Code Snippet) Setting up the text.
		txtrYgoProgrammingCenter = new JTextArea("  \n" + 
				"         YGO Programming Center is an institution for any individuals who has an interest in the field of programming. YGO Programming Center offers fundamental programming courses that varies from Java, HTML, to PHP that allows students to freely choose a course that they find interesting. Students can enroll from basic to advanced programming courses at a cheaper price, and they can cancel their membership anytime.\r\n" + 
				"\r\n" + 
				"  Brief History\n\r\n" + 
				"         YGO Programming Center Center is founded by four programmers, namely, Mr. Adrian Nads Marcelo, Mr. Lenard G. Opo, Ms. RC Khaye Suelo, and Mr. Jeremy Joshua R. Jaurigue on May 04, 2017 at City of Aurora, Laguna. These programmers noticed the need of a training center in Laguna to keep pace with other cities in the Philippines in terms of digital literacy of the citizens. Thus, they formed an institution to help anyone who has an interest in the programming field at an affordable price.\r\n" + 
				"\r\n" + 
				"  Mission\n\r\n" + 
				"         To inspire and persuade every individual in learning programming courses for the development of the city and to provide inspiring developers/programmers with sufficient and fundamental programming skills at a reasonable cost. \r\n" + 
				"\r\n" + 
				"  Vision\n\r\n" + 
				"         To become an instrument in the digital literacy of individuals in Cabuyao, Laguna\r\n" + 
				"\r\n" + 
				"  Core Values\n\r\n" + 
				"         Y- earning for\r\n" + 
				"         G- aining\r\n" + 
				"         O- utstanding Knowledge\r\n" + 
				"");
		txtrYgoProgrammingCenter.setLineWrap(true);
		txtrYgoProgrammingCenter.setWrapStyleWord(true);
		txtrYgoProgrammingCenter.setTabSize(12);
		txtrYgoProgrammingCenter.setBackground(new Color(255, 222, 173));
		txtrYgoProgrammingCenter.setFont(new Font("Times New Roman", Font.BOLD | Font.ROMAN_BASELINE, 15));
		txtrYgoProgrammingCenter.setEditable(false);
		scrollPane.setViewportView(txtrYgoProgrammingCenter);
		
		// (Code Snippet) Setting up the background.
		frameEightBackground = new JLabel();
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FrameEight.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon i = new ImageIcon(img2);
		frameEightBackground.setIcon(i);
		frameEightBackground.setBounds(-23, -40, 833, 545);
		contentPane.add(frameEightBackground);
		setLocationRelativeTo(null);
		
	}
}
