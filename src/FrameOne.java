import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.Window.Type;

public class FrameOne extends JFrame {

	// Field Variables for Frame One.
	private JPanel contentPane;
	private JButton btnStartGame;
	private static JButton btnAboutUs;
	private JButton btnExit;
	public static String[] saveTable = { "Name", "Role", "Tribe", "Gender", "Weapon" };
	public static DefaultTableModel modelSaveTable = new DefaultTableModel();
	private Font myFontTwo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FrameOne.playMusic("ac.wav"); 
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch (Exception e) {
			
		}
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
		setFont();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 856, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAboutUs = new JButton("ABOUT US");
		setIconToButton(btnAboutUs);
		btnAboutUs.addActionListener(new ActionListener() {
			// Event for btnAboutUs.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				var frameFive = new FrameFive();
				frameFive.setVisible(true);
			}
		});
		
		btnStartGame = new JButton("START");
		setIconToButton(btnStartGame);
		btnStartGame.addActionListener(new ActionListener() {
			// Event for btnStart.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				FrameTwo frameTwo = new FrameTwo();
				frameTwo.setVisible(true);
				close();
			}
		});
		btnStartGame.setBounds(367, 221, 117, 37);
		btnStartGame.setFont(myFontTwo);
		contentPane.add(btnStartGame);
		btnAboutUs.setBounds(367, 274, 117, 37);
		btnAboutUs.setFont(myFontTwo);
		contentPane.add(btnAboutUs);
		
		btnExit = new JButton("EXIT");
		setIconToButton(btnExit);
		btnExit.addActionListener(new ActionListener() {
			// Event for btnExit.
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
				int exit = JOptionPane.showConfirmDialog(null, "Exit Lonely Nights? Any unsaved progress will be lost?");
				if (exit == JOptionPane.YES_OPTION) {
					FrameOne.playSecondSoundFX();
					close();
				}
				else
					FrameOne.playSecondSoundFX();
			}
		});
		btnExit.setBounds(367, 336, 117, 37);
		btnExit.setFont(myFontTwo);
		contentPane.add(btnExit);
		
		JLabel frameOneBackground = new JLabel("");
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("XYZFrameOne.jpg")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameOne = new ImageIcon(img2);
		frameOneBackground.setIcon(imgFrameOne);
		frameOneBackground.setBounds(0, 0, 927, 434);
		contentPane.add(frameOneBackground);
		setLocationRelativeTo(null);
	}
	
	// These are all the user-defined method.
	public void setIconToButton(JButton btn) {
		Image img = new ImageIcon(this.getClass().getResource("ACLogoSmall.png")).getImage();
		btn.setIcon(new ImageIcon(img));
	}
	
	public static void playFirstSoundFX() {
			
		try {
			File sound = new File("buttonClick.wav");
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(sound));
			c.start();
		}
		catch (Exception e) {	
		}
	}
	
	public static void playSecondSoundFX() {
			
		try {
			File sound = new File("complete.wav");
			Clip c = AudioSystem.getClip();
			c.open(AudioSystem.getAudioInputStream(sound));
			c.start();
		}
		catch (Exception e) {
		}
	}
		
	public static void playMusic(String musicLocation) {
		
		try {
			
			File musicPath = new File(musicLocation);
			
			if (musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else 
				JOptionPane.showMessageDialog(null, "Can't find file");
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setFont() {
		
		try {
			myFontTwo = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")));
		}
		catch (IOException | FontFormatException e) {
			
		}
	}
	
	public static void setWidthAutomatic() {
		
		TableColumnModel column = FrameThree.tblSavedCharacters.getColumnModel();
		TableModel model = FrameThree.tblSavedCharacters.getModel();
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
	
	public void close() {
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
}