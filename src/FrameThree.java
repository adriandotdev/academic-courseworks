import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrameThree extends JFrame {

	// These are all the field variables for Frame Three.
	private JPanel contentPane;
	public static JTable tblSavedCharacters;
	private JTextField txtCharacterName;
	private JRadioButton rdbtnGenderMale;
	private JRadioButton rdbtnGenderFemale;
	private JButton btnCreateCharacter;
	private JButton btnSaveCharacter;
	private JButton btnClearCharacterCreation;
	private JButton btnDeleteCharacter;
	private JButton btnCancelUpdatingCharacter;	
	private JButton btnUpdateCharacter;
	private JComboBox <String> cboCharacterRole;
	private JComboBox <String> cboTribe;
	private JComboBox <String> cboWeapon;
	private JRadioButton rdbtnAllWeapons;
	private JRadioButton rdbtnOneHandedWeapons;
	private JRadioButton rdbtnTwoHandedWeapons;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JMenu menuCreatedCharacters;
	private JMenuItem itemCreatedCharacters;
	private JMenuItem itemBackToFrameTwo;
	private Font myFont;
	private JLabel frameThreeBackground;
	public static String[] column = {"Name", "Role", "Tribe", "Gender", "Weapon" };
	final DefaultComboBoxModel <String> roles = new DefaultComboBoxModel <String> (new String[] {"Select a Role--", "Human", "Diwata"});
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//FrameOne.playMusic("ac.wav");
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}
		catch (Exception e) {
			
		}
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
		setFont();
		FrameFour.model.setColumnIdentifiers(column);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				txtCharacterName.requestFocus();
				setTribe();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 958, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(350, 46, 557, 252);
		contentPane.add(scrollPane);
		
		tblSavedCharacters = new JTable(FrameOne.modelSaveTable);
		tblSavedCharacters.setForeground(Color.DARK_GRAY);
		tblSavedCharacters.setShowGrid(false);
		tblSavedCharacters.setBackground(Color.LIGHT_GRAY);
		tblSavedCharacters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int[] rows = tblSavedCharacters.getSelectedRows();
				if(rows.length == 1)
					getValue();
				else
					clearAll();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				FrameOne.setWidthAutomatic();
			}
		});
		scrollPane.setViewportView(tblSavedCharacters);
		FrameOne.modelSaveTable.setColumnIdentifiers(FrameOne.saveTable);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(new Color(76, 76, 76, 76));
		desktopPane.setBounds(10, 44, 330, 379);
		contentPane.add(desktopPane);
		
		txtCharacterName = new JTextField();
		txtCharacterName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (txtCharacterName.getText().length() > 8) {
					JOptionPane.showMessageDialog(null, "Character name length must not exceed 8.");
					e.consume();
				}
			}
		});
		txtCharacterName.setColumns(10);
		txtCharacterName.setBounds(155, 39, 154, 28);
		txtCharacterName.setFont(myFont); //
		desktopPane.add(txtCharacterName);
		
		JLabel lblCharacterName = new JLabel("Character Name:");
		lblCharacterName.setBackground(Color.WHITE);
		lblCharacterName.setForeground(Color.WHITE);
		lblCharacterName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCharacterName.setBounds(15, 45, 106, 17);
		lblCharacterName.setFont(myFont);//
		desktopPane.add(lblCharacterName);
		
		cboCharacterRole = new JComboBox <String> (roles);
		cboCharacterRole.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		cboCharacterRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
			}
		});
		cboCharacterRole.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setTribe();
				setWeapon();
			}
		});
		cboCharacterRole.setBounds(106, 136, 203, 23);
		cboCharacterRole.setFont(myFont);//
		desktopPane.add(cboCharacterRole);
		
		cboTribe = new JComboBox <String>();
		cboTribe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		cboTribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
			}
		});
		cboTribe.setBounds(106, 182, 203, 23);
		cboTribe.setFont(myFont);//
		desktopPane.add(cboTribe);
		
		cboWeapon = new JComboBox<String>();
		cboWeapon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOne.playSecondSoundFX();
			}
		});
		cboWeapon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setTooltips();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		cboWeapon.setBounds(106, 304, 203, 23);
		cboWeapon.setFont(myFont);//
		desktopPane.add(cboWeapon);
		
		btnCreateCharacter = new JButton("CREATE");
		btnCreateCharacter.setForeground(Color.DARK_GRAY);
		btnCreateCharacter.setBackground(Color.LIGHT_GRAY);
		btnCreateCharacter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		btnCreateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOne.playFirstSoundFX();
				if(allFieldsAreComplete()) {
					if(!characterNameIsAlreadyCreated()) {
						if(tblSavedCharacters.getRowCount() <= 2) {
							createCharacter();
							clearAll();
							txtCharacterName.requestFocus();
						}
						else
							JOptionPane.showMessageDialog(null, "Only three characters must be created.");
					}
					else
						JOptionPane.showMessageDialog(null, "Character name already existed.");
				}
				else
					JOptionPane.showMessageDialog(null, "Character creation is incomplete.");
			}
		});
		btnCreateCharacter.setBounds(220, 345, 89, 23);
		btnCreateCharacter.setFont(myFont);//
		desktopPane.add(btnCreateCharacter);
		
		btnUpdateCharacter = new JButton("UPDATE");
		btnUpdateCharacter.setForeground(Color.DARK_GRAY);
		btnUpdateCharacter.setBackground(Color.LIGHT_GRAY);
		btnUpdateCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameOne.playFirstSoundFX();
				if (tblSavedCharacters.getRowCount() > 0) {
					if(tblSavedCharacters.getSelectedRow() >= 0) {
						if(!isExistingInTable()) {
							if (allFieldsAreComplete()) {
								setValue();
								clearAll();
								tblSavedCharacters.getSelectionModel().clearSelection();
							}
							else
								JOptionPane.showMessageDialog(null, "Updating character is incomplete.");
						}
						else
							JOptionPane.showMessageDialog(null, "Character name already existing.");
					}
					else
						JOptionPane.showMessageDialog(null, "You don't have any selected character.");
				}
				else
					JOptionPane.showMessageDialog(null, "No existing characters.");
			}
		});
		btnUpdateCharacter.setBounds(499, 400, 89, 23);
		btnUpdateCharacter.setFont(myFont);//
		contentPane.add(btnUpdateCharacter);
		
		btnClearCharacterCreation = new JButton("CLEAR");
		btnClearCharacterCreation.setForeground(Color.DARK_GRAY);
		btnClearCharacterCreation.setBackground(Color.LIGHT_GRAY);
		btnClearCharacterCreation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		btnClearCharacterCreation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					clearAll();
			}
		});
		btnClearCharacterCreation.setBounds(15, 345, 89, 23);
		btnClearCharacterCreation.setFont(myFont);//
		desktopPane.add(btnClearCharacterCreation);
		
		btnCancelUpdatingCharacter = new JButton("CANCEL");
		btnCancelUpdatingCharacter.setForeground(Color.DARK_GRAY);
		btnCancelUpdatingCharacter.setBackground(Color.LIGHT_GRAY);
		btnCancelUpdatingCharacter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		btnCancelUpdatingCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblSavedCharacters.getSelectionModel().clearSelection();
				clearAll();
			}
		});
		btnCancelUpdatingCharacter.setFont(myFont);
		btnCancelUpdatingCharacter.setBounds(838, 400, 89, 23);
		contentPane.add(btnCancelUpdatingCharacter);
		
		btnSaveCharacter = new JButton("SAVE");
		btnSaveCharacter.setForeground(Color.DARK_GRAY);
		btnSaveCharacter.setBackground(Color.LIGHT_GRAY);
		btnSaveCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameOne.playFirstSoundFX();
				if (FrameOne.modelSaveTable.getRowCount() > 0) 
					if (FrameFour.model.getRowCount() != 3) 
						if (FrameOne.modelSaveTable.getRowCount() == 3) {
							int choice = JOptionPane.showConfirmDialog(null, "Save created characters? No further modifications after it.");
							if(choice == JOptionPane.YES_OPTION) {
								save();
								FrameOne.modelSaveTable.setRowCount(0);
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Create three characters first");
					else
						JOptionPane.showMessageDialog(null, "Only three characters must be saved.");
				else
					JOptionPane.showMessageDialog(null, "No existing characters.");
			}
		});
		btnSaveCharacter.setBounds(350, 400, 89, 23);
		btnSaveCharacter.setFont(myFont);
		contentPane.add(btnSaveCharacter);
		
		btnDeleteCharacter = new JButton("DELETE");
		btnDeleteCharacter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		btnDeleteCharacter.setForeground(Color.DARK_GRAY);
		btnDeleteCharacter.setBackground(Color.LIGHT_GRAY);
		btnDeleteCharacter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCharacter();
				clearAll();
			}
		});
		btnDeleteCharacter.setBounds(674, 400, 89, 23);
		btnDeleteCharacter.setFont(myFont);
		
		rdbtnAllWeapons = new JRadioButton("All Weapons");
		rdbtnAllWeapons.setForeground(Color.DARK_GRAY);
		rdbtnAllWeapons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		rdbtnAllWeapons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWeapon();
			}
		});
		rdbtnAllWeapons.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnAllWeapons);
		rdbtnAllWeapons.setSelected(true);
		rdbtnAllWeapons.setBounds(106, 222, 98, 23);
		rdbtnAllWeapons.setFont(myFont);//
		desktopPane.add(rdbtnAllWeapons);
		
		rdbtnOneHandedWeapons = new JRadioButton("One Handed Weapons");
		rdbtnOneHandedWeapons.setForeground(Color.DARK_GRAY);
		rdbtnOneHandedWeapons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		rdbtnOneHandedWeapons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWeapon();
			}
		});
		rdbtnOneHandedWeapons.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnOneHandedWeapons);
		rdbtnOneHandedWeapons.setBounds(106, 274, 166, 23);
		rdbtnOneHandedWeapons.setFont(myFont);//
		desktopPane.add(rdbtnOneHandedWeapons);
		
		rdbtnTwoHandedWeapons = new JRadioButton("Two Handed Weapons");
		rdbtnTwoHandedWeapons.setForeground(Color.DARK_GRAY);
		rdbtnTwoHandedWeapons.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		rdbtnTwoHandedWeapons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setWeapon();
			}
		});
		rdbtnTwoHandedWeapons.setBackground(Color.LIGHT_GRAY);
		buttonGroup.add(rdbtnTwoHandedWeapons);
		rdbtnTwoHandedWeapons.setBounds(106, 248, 166, 23);
		rdbtnTwoHandedWeapons.setFont(myFont);//
		desktopPane.add(rdbtnTwoHandedWeapons);
		
		rdbtnGenderMale = new JRadioButton("Male");
		desktopPane.setLayer(rdbtnGenderMale, 0);
		rdbtnGenderMale.setForeground(new Color(0, 0, 0));
		rdbtnGenderMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		buttonGroup_1.add(rdbtnGenderMale);
		rdbtnGenderMale.setSelected(true);
		rdbtnGenderMale.setBounds(131, 90, 72, 23);
		rdbtnGenderMale.setFont(myFont);//
		rdbtnGenderMale.setBackground(Color.LIGHT_GRAY);
		desktopPane.add(rdbtnGenderMale);
		
		rdbtnGenderFemale = new JRadioButton("Female");
		rdbtnGenderFemale.setForeground(new Color(0, 0, 0));
		rdbtnGenderFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		rdbtnGenderFemale.setBackground(Color.LIGHT_GRAY);
		buttonGroup_1.add(rdbtnGenderFemale);
		rdbtnGenderFemale.setBounds(237, 90, 72, 23);
		rdbtnGenderFemale.setFont(myFont);//
		desktopPane.add(rdbtnGenderFemale);
		
		JLabel lblNewLabel = new JLabel("Gender:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(15, 93, 50, 17);
		lblNewLabel.setFont(myFont);//
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Role:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(15, 139, 33, 17);
		lblNewLabel_1.setFont(myFont);//
		desktopPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tribe:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(15, 185, 37, 17);
		lblNewLabel_2.setFont(myFont);//
		desktopPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Weapons:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 225, 61, 17);
		lblNewLabel_3.setFont(myFont);//
		desktopPane.add(lblNewLabel_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(25, 65, 65, 25));
		menuBar.setBounds(0, 0, 952, 22);
		contentPane.add(menuBar);
		
		menuCreatedCharacters = new JMenu("Menu");
		menuCreatedCharacters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrameOne.playFirstSoundFX();
			}
		});
		menuCreatedCharacters.setHorizontalAlignment(SwingConstants.CENTER);
		menuCreatedCharacters.setFont(myFont);
		menuBar.add(menuCreatedCharacters);
		
		itemCreatedCharacters = new JMenuItem("View Created Characters");
		itemCreatedCharacters.setBackground(Color.DARK_GRAY);
		itemCreatedCharacters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameFour frameFour = new FrameFour();
				FrameOne.playFirstSoundFX();
				frameFour.setVisible(true);
			}
		});
		itemCreatedCharacters.setHorizontalAlignment(SwingConstants.CENTER);
		itemCreatedCharacters.setFont(myFont);
		menuCreatedCharacters.add(itemCreatedCharacters);
		
		itemBackToFrameTwo = new JMenuItem("Back");
		itemBackToFrameTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var frameTwo = new FrameTwo();
				FrameOne.playFirstSoundFX();
				FrameOne.modelSaveTable.setRowCount(0);
				close();
				frameTwo.setVisible(true);
			}
		});
		itemBackToFrameTwo.setBackground(Color.DARK_GRAY);
		itemBackToFrameTwo.setFont(myFont);
		menuCreatedCharacters.add(itemBackToFrameTwo);
		contentPane.add(btnDeleteCharacter);
		
		frameThreeBackground = new JLabel("");
		ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("resized.png")));
		Image img1 = myImage.getImage();
		Image img2 = img1.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameThree = new ImageIcon(img2);
		frameThreeBackground.setIcon(imgFrameThree);
		frameThreeBackground.setBounds(0, 22, 845, 412);
		contentPane.add(frameThreeBackground);
		
		JLabel frameThreeBackgroundTwo = new JLabel("");
		ImageIcon myImageTwo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("resized.png")));
		Image img3 = myImageTwo.getImage();
		Image img4 = img3.getScaledInstance(845, 495, Image.SCALE_SMOOTH);
		ImageIcon imgFrameThreePrtTwo= new ImageIcon(img4);
		frameThreeBackgroundTwo.setIcon(imgFrameThreePrtTwo);
		frameThreeBackgroundTwo.setBounds(292, 21, 660, 413);
		contentPane.add(frameThreeBackgroundTwo);
		center();
		setLocationRelativeTo(null);
	}
	
	// This is the all user-defined method.
	
	private void createCharacter() { 
		
		Object[] saveCharacter = new Object[5];
		saveCharacter[0] = txtCharacterName.getText();
		saveCharacter[1] = cboCharacterRole.getSelectedItem();
		saveCharacter[2] = cboTribe.getSelectedItem();
		
		if(rdbtnGenderMale.isSelected())
			saveCharacter[3] = rdbtnGenderMale.getText();
		else
			saveCharacter[3] = rdbtnGenderFemale.getText();
		
		saveCharacter[4] = cboWeapon.getSelectedItem();
	
		FrameOne.modelSaveTable.addRow(saveCharacter);
	}
	
	private void clearAll() {
		if(!txtCharacterName.getText().isBlank())
			txtCharacterName.setText(null);
		if(cboWeapon.getSelectedIndex() >= 1)
			cboWeapon.setSelectedIndex(0);
		if(cboTribe.getSelectedIndex() >= 1)
			cboTribe.setSelectedIndex(0);
		if(cboCharacterRole.getSelectedIndex() >= 1)
			cboCharacterRole.setSelectedIndex(0);
		tblSavedCharacters.clearSelection();
	}
	private void setTribe() {

		final DefaultComboBoxModel <String> empty = new DefaultComboBoxModel <String> (new String[] {"N/A"});
		final DefaultComboBoxModel <String> tribe = new DefaultComboBoxModel <String> (new String[] {"Select a Tribe--", "Ibaloi", "Isneg", "Gaddang", "Negrito", "Mangyan", "Manobo"});
		
		if("Human".equals(cboCharacterRole.getSelectedItem()))
			cboTribe.setModel(tribe);
		else
			cboTribe.setModel(empty);
	}
	
	private void setWeapon() {
		// Combo Box Model
		final DefaultComboBoxModel <String> allWeaponForHuman = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Kambantuli", "Kali", "Ginunting", "Pinunting", "Panabas", "Minasbad", "Kambantuli and Panabas", "Kambantuli and Minasbad", "Minasbad and Panabas"});
		final DefaultComboBoxModel <String> oneHandedWeaponForHuman = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Kambantuli",  "Panabas", "Minasbad"});
		final DefaultComboBoxModel <String> twoHandedWeaponForHuman = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Kali",  "Ginunting", "Pinunting"});
		final DefaultComboBoxModel <String> allWeaponsForDiwata = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Tagabulag", "Tagalinlang", "Kislap", "Dalisdis", "Tagabulag and Tagalinlang", "Tagabulag and Dalisdis", "Tagalinlang and Dalisdis"});
		final DefaultComboBoxModel <String> oneHandedWeaponsForDiwata = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Tagabulag", "Tagalinlang", "Dalisdis"});
		final DefaultComboBoxModel <String> twoHandedWeaponsForDiwata = new DefaultComboBoxModel <String> (new String[] {"Select a Weapon--", "Kislap"});
		final DefaultComboBoxModel <String> empty = new DefaultComboBoxModel <String> (new String[] {" "});
		
		if(cboCharacterRole.getSelectedIndex() == 0 && rdbtnAllWeapons.isSelected() || rdbtnOneHandedWeapons.isSelected() || rdbtnTwoHandedWeapons.isSelected()) 
			cboWeapon.setModel(empty);
		if ("Human".equals(cboCharacterRole.getSelectedItem()) && rdbtnAllWeapons.isSelected()) 
			cboWeapon.setModel(allWeaponForHuman);
		if ("Human".equals(cboCharacterRole.getSelectedItem()) && rdbtnOneHandedWeapons.isSelected()) 
			cboWeapon.setModel(oneHandedWeaponForHuman);
		if ("Human".equals(cboCharacterRole.getSelectedItem()) && rdbtnTwoHandedWeapons.isSelected())
			cboWeapon.setModel(twoHandedWeaponForHuman);
		if ("Diwata".equals(cboCharacterRole.getSelectedItem()) && rdbtnAllWeapons.isSelected())
			cboWeapon.setModel(allWeaponsForDiwata);
		if ("Diwata".equals(cboCharacterRole.getSelectedItem()) && rdbtnTwoHandedWeapons.isSelected())
			cboWeapon.setModel(twoHandedWeaponsForDiwata);
		if ("Diwata".equals(cboCharacterRole.getSelectedItem()) && rdbtnOneHandedWeapons.isSelected())
			cboWeapon.setModel(oneHandedWeaponsForDiwata);
	}
	
	private boolean allFieldsAreComplete() {
		
		boolean isComplete = true;
		if (cboCharacterRole.getSelectedItem().equals("Diwata") && !(txtCharacterName.getText().isEmpty() || cboCharacterRole.getSelectedIndex() == 0 || cboWeapon.getSelectedIndex() == 0))
			return isComplete;
		else if(!(txtCharacterName.getText().isEmpty() || cboCharacterRole.getSelectedIndex() == 0 || cboTribe.getSelectedIndex() == 0 || cboWeapon.getSelectedIndex() == 0))
			return isComplete;
		else
			return isComplete = false;	
	}
	
	private void getValue() {
	
		txtCharacterName.setText(FrameOne.modelSaveTable.getValueAt(tblSavedCharacters.getSelectedRow(), 0).toString());
		cboCharacterRole.setSelectedItem(FrameOne.modelSaveTable.getValueAt(tblSavedCharacters.getSelectedRow(), 1));
		cboTribe.setSelectedItem(FrameOne.modelSaveTable.getValueAt(tblSavedCharacters.getSelectedRow(), 2));
		cboWeapon.setSelectedItem(FrameOne.modelSaveTable.getValueAt(tblSavedCharacters.getSelectedRow(), 4));
	}
	
	private void setValue() {
		
		FrameOne.modelSaveTable.setValueAt(txtCharacterName.getText(), tblSavedCharacters.getSelectedRow(), 0);
		FrameOne.modelSaveTable.setValueAt(cboCharacterRole.getSelectedItem(), tblSavedCharacters.getSelectedRow(), 1);
		FrameOne.modelSaveTable.setValueAt(cboTribe.getSelectedItem(), tblSavedCharacters.getSelectedRow(), 2);
		
		if(rdbtnGenderMale.isSelected())
			FrameOne.modelSaveTable.setValueAt(rdbtnGenderMale.getText(), tblSavedCharacters.getSelectedRow(), 3);
		else
			FrameOne.modelSaveTable.setValueAt(rdbtnGenderFemale.getText(), tblSavedCharacters.getSelectedRow(), 3);
		
		FrameOne.modelSaveTable.setValueAt(cboWeapon.getSelectedItem(), tblSavedCharacters.getSelectedRow(), 4);
	}
	
	private boolean characterNameIsAlreadyCreated() {
		
		boolean isCreated = true;
		for(int i = 0; i < tblSavedCharacters.getRowCount(); i++) {
			
			if(txtCharacterName.getText().toString().equalsIgnoreCase((FrameOne.modelSaveTable.getValueAt(i, 0).toString())))
				return isCreated;
		}
		return isCreated = false;
	}

	private boolean isExistingInTable() {
		
		boolean isCreated = true;
		
		for(int i = 0; i < tblSavedCharacters.getRowCount(); i++) {
			
			if (i == tblSavedCharacters.getSelectedRow()) 
				continue;
			else if(txtCharacterName.getText().toString().equalsIgnoreCase((FrameOne.modelSaveTable.getValueAt(i, 0).toString())))
				return isCreated;
		}
		return isCreated = false;
	}
	
	private void deleteCharacter() {
		
		int[] selectedRows = tblSavedCharacters.getSelectedRows();
		
		if (tblSavedCharacters.getSelectedRow() >= 0) {
			
			int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected character?");
			if (choice == JOptionPane.YES_OPTION) {
				for (int i = selectedRows.length - 1; i >= 0; i--) {
					FrameOne.modelSaveTable.removeRow(selectedRows[i]);
				}
			}
			else
				tblSavedCharacters.clearSelection();
		}
	}
	
	private void save() {
		
		Object[] obj = new Object[5];
		for(int i = 0; i < FrameOne.modelSaveTable.getRowCount(); i++) {
			
			obj[0] = FrameOne.modelSaveTable.getValueAt(i, 0);
			obj[1] =  FrameOne.modelSaveTable.getValueAt(i, 1);
			obj[2] =  FrameOne.modelSaveTable.getValueAt(i, 2);
			obj[3] = FrameOne.modelSaveTable.getValueAt(i, 3);
			obj[4] =  FrameOne.modelSaveTable.getValueAt(i, 4);
			FrameFour.model.addRow(obj);		
		}
	}

	private void setFont() {
		
		try {
			myFont = Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")).deriveFont(12f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("GloriaHallelujah-Regular.ttf")));
		}
		catch (IOException | FontFormatException e) {}
	}
	
	private void center() {
		
		JTableHeader Theader = tblSavedCharacters.getTableHeader();
		Theader.setBackground(Color.darkGray);
		Theader.setFont(myFont);
		tblSavedCharacters.setFont(myFont);
		
		DefaultTableCellRenderer centerRend = new DefaultTableCellRenderer();
		centerRend.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 5; i++) {
			tblSavedCharacters.getColumnModel().getColumn(i).setCellRenderer(centerRend);
		}
	}
	
	private void setTooltips() {
		// for humans - "Kambantuli and Panabas", "Kambantuli and Minasbad", "Minasbad and Panabas"
		// for diwata - "Tagabulag and Tagalinlang", "Tagabulag and Dalisdis", "Tagalinlang and Dalisdis"
		if("Kambantuli".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Kambantuli </hr></center></em></h3>" + "<h4> A chopping blade favored by the Moros. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 3.5 attack per second </em></h4>" + "<h4><em> Damage: 250 DPS </em></h4>" + "</html>");
		
		if("Kali".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Kambantuli </hr></center></em></h3>" + " <h4> A weapon made from bamboo sticks.</h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 3.0 attack per second </em></h4>" + "<h4><em> Damage: 200 DPS </em></h4>" + "</html>");
		
		if("Ginunting".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Ginunting </hr></center></em></h3>" +  "<h4> A short blade used by Filipinos against Japanese invaders. <br> Must be partnered with Pinunting. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 3.7 attack per second </em></h4>" + "<h4><em> Damage: 240 DPS </em></h4>" + "</html>");
		
		if("Pinunting".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Pinunting </hr></center></em></h3>" + "<h4> A short blade used by Filipinos against Japanese invaders. <br> Must be partnered with Ginunting. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: </em></h4>" + "<h4><em> Attack Speed: 4.3 attack per second </em></h4>" + "<h4><em> Damage: 300 DPS  </em></h4>" + "</html>");
		
		if("Panabas".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Panabas </hr></center></em></h3>" + "<h4> A large, forward-curved sword of the ethnic groups in <br> southern Philippines. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 2.0 attack per second </em></h4>" + "<h4><em> Damage: 150 DPS </em></h4>" + "</html>");
		
		if("Minasbad".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Minasbad </hr></center></em></h3>" + "<h4> A sword popular in the Bicol region. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 2.3 attack per second </em></h4>" + "<h4><em> Damage: 150 DPS </em></h4>" + "</html>");
		
		if("Tagabulag".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Tagabulag </hr></center></em></h3>" + "<h4> A luminous stone which makes the holder invisible. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 2.5 attack per second </em></h4>" + "<h4><em> Damage: 120 DPS </em></h4>" + "</html>");
		
		if("Tagalinlang".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Tagalinlang </hr></center></em></h3>"  + "<h4> A pitch-black stone which allows the holder to create illusions. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 2.5 attack per second </em></h4>" + "<h4><em> Damage: 180 DPS </em></h4>" + "</html>");
		
		if("Kislap".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Kislap </hr></center></em></h3>" + "<h4> A bow that can release lightning-fast arrows.</h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 3.0 attack per second </em></h4>" + "<h4><em> Damage: 195 DPS </em></h4>" + "</html>");
		
		if("Dalisdis".equals(cboWeapon.getSelectedItem())) 
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Dalisdis </hr></center></em></h3>" + "<h4> A shiny blade forged by the wee folks. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 2.5 attack per second </em></h4>" + "<em><h4> Damage: 150 DPS </em></h4>" + "</html>");
		
		if("Kambantuli and Panabas".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Kambantuli and Panabas </hr></center></em></h3>" + "<h4> Wield for great speed. Anyone who use this weapon will have the power <br> of Apple of Eden that used after the Assassination " 
		+ "of King Ibalon.<h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 5.5 attack per second </em></h4>" + "<h4><em> Damage: 400 DPS </em></h4>" + "</html>");
		
		if("Kambantuli and Minasbad".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Kambantuli and Minasbad </hr></center></em></h3>" + "<h4> Wield for great power. "
		+ "A weapon that once used by the Templars against Hanan <br> and Mayari Kingdom. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 5.8 attack per second </em></h4>" + "<h4><em> Damage: 400 DPS </em></h4>" + "</html>");
		
		if("Minasbad and Panabas".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Minasbad and Panabas </hr></center></em></h3>" + "<h4> Wield for great intelligence. One of the pieces of Apple of Eden that used by the Assassins of Hanan Kingdom <br> against to the Templars of Masyaf. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Melee </em></h4>" + "<h4><em> Attack Speed: 4.3 attack per second </em></h4>" + "<h4><em> Damage: 300 DPS </em></h4>" 
					+ "</html>");
		if("Tagabulag and Tagalinlang".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Tagabulag and Tagalinlang </hr></center></em></h3>" + "<h4> Wield for the power of Blindness and Deceiving. One of the Altair's swords during the war between Hanan and Mayari <br> kingdom" + " when Juno, King of the Diwata ask him to join the fight against the Templars.</h4> <hr></hr>"  
		+ "<h4><em> Type Of Weapon: Range </em></h4>" + "<h4><em> Attack Range: 450 range </em></h4>" + "<h4><em> Attack Speed: 5.0 attack per second </em></h4>" + "<h4><em> Damage: 300 DPS </em></h4>" + "</html>");
		if("Tagabulag and Dalisdis".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Tagabulag and Dalisdis </hr></center></em></h3>" + "<h4> Wield for the power of Blindness and Declension. Diwatas of the first civilization used these weapon for peace and <br> to prevent Al Mualim, leader "
		+ " of the Templars of Masyaf to his demonic proposition. </h4><hr></hr>" 
		+ "<h4><em> Type of Weapon: Range and Melee </em></h4>" + "<h4><em> Attack Range: (for ranged weapon): 450 range </em></h4>" + "<h4><em> Attack Speed: 5.0 attack per second </em></h4>" + "<h4><em> Damage: 280 DPS </em></h4>" + "</html>");
		if("Tagalinlang and Dalisdis".equals(cboWeapon.getSelectedItem()))
			cboWeapon.setToolTipText("<html>" + "<h3><em><center><hr> Tagalinlang and Dalisdis </hr></center></em></h3>" + "<h4> Wield for the power of Deceiving and Declension. Six human tribes of different regions travel around the world <br> to find these weapon to stop Al Mualim, "
		+ "and for the completion to the pieces of the Apple of Eden.<h4><hr></hr>" 
		+ "<h4><em> Type Of Weapon: Range and Melee </em></h4>" + "<h4><em> Attack Range: 450 range </em></h4>" + "<h4><em> Attack Speed: 5.0 attack per second </em></h4>" + "<h4><em> Damage: 330 DPS </em></h4>" + "</html>");
	} 
	
	public void close() {
		WindowEvent closingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closingEvent);;
	}
} 