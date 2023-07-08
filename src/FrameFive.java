import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class FrameFive extends JFrame {

	// These are all the field variables for Frame Five.
	private JPanel contentPane;
	private JLabel lblFrameFiveBackground;
	private Font myFont;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//FrameOne.playMusic("ac.wav");
	
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
		
		setFont();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("FrameFive.jpg")));
		Image img3 = myImage.getImage();
		Image img4 = img3.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameFive= new ImageIcon(img4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 162, 683, 241);
		contentPane.add(scrollPane);

		JTextArea txaAboutUs = new JTextArea("\nAbout Us\r\n" + 
				"\n         XYZ Gaming Development Center is a video game company founded in 2017 at Cabuyao, Laguna that aims to provide players a memorable, and enriching gameplay experience which came from the company’s visually enticing, imaginative, and original content and at the same time, the company also promotes the Philippine culture, by creating video games based from Philippine mythologies and folklore.\r\n" + 
				"\r\n" + 
				"Brief Plot of the Game\r\n" + 
				"\n         For several centuries, Hanan (Sun Kingdom) and Mayari (Moon Kingdom) were at peace, until one night, Ibalon, the king of Hanan Kingdom was assassinated. Because of this, Hanan Kingdom suspected the Mayari Kingdom and declared a war. Since then, Hanan and Mayari were broken and imbalanced. Who was behind the murder of Ibalon? Will harmony be regained between the two kingdoms? Save the nations, return the balance, and find out the truth by being a noble human warrior or a brave diwata in Lonely Nights.\r\n" + 
				"\r\n" + 
				"Game Information\r\n" + 
				"\n        Lonely Nights is a role-playing game (RPG) which allows user to experience using different tribes and mythical creatures in the Philippines as their characters. In this game you can create up to 3 characters it is either human or diwata with different weapons. It consists up to six tribes which are composed of Ibaloi, Isneg, Gaddang, Negrito, Mangyan and Manobo. Characters can equip up to 2 weapons. No further modifications can be done once you submitted your chosen characters.\r\n" + 
				"");
		txaAboutUs.setLineWrap(true);
		txaAboutUs.setWrapStyleWord(true);
		txaAboutUs.setTabSize(12);
		txaAboutUs.setFont(myFont);
		txaAboutUs.setEditable(false);
		txaAboutUs.setBackground(Color.LIGHT_GRAY);
		txaAboutUs.setForeground(Color.BLACK);
		scrollPane.setViewportView(txaAboutUs);
		
		lblFrameFiveBackground = new JLabel("");
		lblFrameFiveBackground.setIcon(imgFrameFive);
		lblFrameFiveBackground.setBounds(0, 0, 840, 445);
		contentPane.add(lblFrameFiveBackground);
		setLocationRelativeTo(null);
	}
	
	// This is the user-defined method.
	private void setFont() {
		
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File("Alegreya-MediumItalic.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Alegreya-MediumItalic.ttfr.ttf")));
		}
		catch (IOException | FontFormatException e) {
			
		}
	}
}
