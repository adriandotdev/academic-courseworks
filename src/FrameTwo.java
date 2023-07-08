import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;

public class FrameTwo extends JFrame {

	// Field variables for Frame Two.
	private JPanel contentPane;
	private JLabel frameTwoBackground;
	private JButton btnCreateCharacters;
	private JButton btnSetFrameFour;
	private JButton btnBackToFrameOne;
	Font myFont;
	Font myFontTwo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//FrameOne.playMusic("ac.wav");
		FrameOne.playMusic("ac.wav"); 
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch (Exception e) {
			
		}
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
		setType(Type.POPUP);
		
		setFont();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateCharacters = new JButton("CREATE CHARACTERS");
		btnCreateCharacters.addActionListener(new ActionListener() {
			// Event for creating characters.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				FrameThree frameThree = new FrameThree();
				close();
				frameThree.setVisible(true);
				
			}
		});
		
		btnBackToFrameOne = new JButton("BACK");
		btnBackToFrameOne.addActionListener(new ActionListener() {
			// Event for returning to frame one.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				var frameOne = new FrameOne();
				close();
				frameOne.setVisible(true);
			}
		});
		btnBackToFrameOne.setBounds(24, 400, 89, 23);
		btnBackToFrameOne.setFont(myFontTwo);
		contentPane.add(btnBackToFrameOne);
		
		btnCreateCharacters.setBounds(330, 270, 212, 45);
		btnCreateCharacters.setFont(myFontTwo);
		contentPane.add(btnCreateCharacters);
		
		btnSetFrameFour = new JButton("YOUR CHARACTERS");
		btnSetFrameFour.addActionListener(new ActionListener() {
			// Event for checking the created characters.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				var frameFour = new FrameFour();
				frameFour.setVisible(true);
			}
		});
		btnSetFrameFour.setFont(myFontTwo);
		btnSetFrameFour.setBounds(330, 330, 212, 45);
		contentPane.add(btnSetFrameFour);
		
		frameTwoBackground = new JLabel("");
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("frameTwoBackground.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameTwo = new ImageIcon(img2);
		frameTwoBackground.setIcon(imgFrameTwo);
		frameTwoBackground.setBounds(0, 0, 840, 478);
		contentPane.add(frameTwoBackground);
		setLocationRelativeTo(null);
	}

	// These are the all user-defined method.
	public void setFont() {
		
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(60f);
			myFontTwo = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")));
		}
		catch (IOException | FontFormatException e) {
			
		}
	}
	
	public void close() {
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
}