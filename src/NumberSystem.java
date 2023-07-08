import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import com.numbersystem.*;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberSystem extends JFrame {

	private JPanel contentPane;
	// Text fields.
	private JTextField txtFrom;
	
	// Labels
	private JLabel lblEnterFrom;
	private JLabel lblTo;
	private JLabel lblFrom;
	private JLabel lblOutputTo;
	private JLabel noticeLabel;

	// Combo boxes.
	private JComboBox<String> cboTo; 
	private JComboBox<String> cboFrom;

	// Button.
	private JButton btnConvert;
	private JButton btnReset;
	private JButton btnSwap;
	private JTextField txtResult;

	// LIST MODELS
	String[] binary = {"Octal", "Decimal", "Hexadecimal"};
	final DefaultComboBoxModel<String> binaryModel = new DefaultComboBoxModel<>(binary);

	String[] octal = {"Binary", "Decimal", "Hexadecimal"};
	final DefaultComboBoxModel<String> octalModel = new DefaultComboBoxModel<>(octal);

	String[] decimal = {"Binary", "Octal", "Hexadecimal"};
	final DefaultComboBoxModel<String> decimalModel = new DefaultComboBoxModel<>(decimal);

	String[] hexadecimal = {"Binary", "Octal", "Decimal"};
	final DefaultComboBoxModel<String> hexadecimalModel = new DefaultComboBoxModel<>(hexadecimal);

	private boolean isValidInput;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		//"com.jtattoo.plaf.acryl.AcrylLookAndFeel"
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NumberSystem frame = new NumberSystem();
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
	public NumberSystem() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cboFrom.addItem("Binary");
				cboFrom.addItem("Octal");
				cboFrom.addItem("Decimal");
				cboFrom.addItem("Hexadecimal");
				txtFrom.requestFocus();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 489);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		lblFrom = new JLabel("From:");
		lblFrom.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblFrom.setBounds(33, 11, 167, 30);
		contentPane.add(lblFrom);

		lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblTo.setBounds(298, 11, 167, 30);
		contentPane.add(lblTo);

		cboFrom = new JComboBox<>();
		cboFrom.setBackground(SystemColor.control);
		cboFrom.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (cboFrom.getSelectedItem().equals("Binary")) {
					lblEnterFrom.setText("Enter a Binary value: ");
					cboTo.setModel(binaryModel);
				}
				else if (cboFrom.getSelectedItem().equals("Octal")) {
					lblEnterFrom.setText("Enter an Octal value: ");
					cboTo.setModel(octalModel);
				}
				else if (cboFrom.getSelectedItem().equals("Decimal")) {
					lblEnterFrom.setText("Enter a Decimal value: ");
					cboTo.setModel(decimalModel);
				}
				else if (cboFrom.getSelectedItem().equals("Hexadecimal")) {
					lblEnterFrom.setText("Enter a Hexadecimal value: ");
					cboTo.setModel(hexadecimalModel);
				}
				txtFrom.requestFocus();
			}
		});
		cboFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cboFrom.setBounds(33, 52, 232, 47);
		contentPane.add(cboFrom);

		cboTo = new JComboBox<>();
		cboTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFrom.requestFocus();
			}
		});
		cboTo.setBackground(SystemColor.control);
		cboTo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		cboTo.setBounds(298, 51, 232, 47);
		contentPane.add(cboTo);

		lblEnterFrom = new JLabel("Enter a");
		lblEnterFrom.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblEnterFrom.setBounds(33, 114, 290, 30);
		contentPane.add(lblEnterFrom);

		txtFrom = new JTextField();
		txtFrom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				String input = txtFrom.getText(); // input of user.

				if (cboFrom.getSelectedItem().equals("Binary") && Binary.hasInvalidValue(input)) {
					noticeLabel.setText("*Your input has an invalid binary value.");
					txtFrom.setBackground(new Color(255, 204, 203));
					isValidInput = false;
				}
				else if (cboFrom.getSelectedItem().equals("Octal") && Octal.isValidOctal(input)) {
					noticeLabel.setText("*Your input has an invalid octal value.");
					txtFrom.setBackground(new Color(255, 204, 203));
					isValidInput = false;
				}
				else if (cboFrom.getSelectedItem().equals("Decimal") && Decimal.isAllNumber(input)) {
					noticeLabel.setText("*Your input has an invalid decimal value.");
					txtFrom.setBackground(new Color(255, 204, 203));
					isValidInput = false;
				}
				else if (cboFrom.getSelectedItem().equals("Hexadecimal") && Hexadecimal.isValidHexaValue(input)) {
					noticeLabel.setText("*Your input has an invalid hexadecimal value.");
					txtFrom.setBackground(new Color(255, 204, 203));
					isValidInput = false;
				}
				else {
					txtFrom.setBackground(null);
					noticeLabel.setText(null);
					isValidInput = true;
				}

				if (isValidInput && e.getKeyChar() == KeyEvent.VK_ENTER) 
					convert(input);
				
				txtFrom.requestFocus();
			}
		});
		txtFrom.setBackground(SystemColor.control);
		txtFrom.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtFrom.setBounds(33, 155, 497, 47);
		contentPane.add(txtFrom);
		txtFrom.setColumns(10);

		btnConvert = new JButton("CONVERT");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String input = txtFrom.getText();

				if (isValidInput) 
					convert(input);
				
				txtFrom.requestFocus();
			}
		});
		btnConvert.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		btnConvert.setBounds(33, 238, 134, 35);
		contentPane.add(btnConvert);

		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboFrom.setSelectedIndex(0);
				cboTo.setSelectedIndex(0);
				txtFrom.setText(null);
				txtResult.setText(null);
			}
		});
		btnReset.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		btnReset.setBounds(177, 238, 134, 35);
		contentPane.add(btnReset);

		btnSwap = new JButton("SWAP");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// To swap the selected item between cboFrom and cboTo combo box.
				Object temp = cboFrom.getSelectedItem();
				cboFrom.setSelectedItem(cboTo.getSelectedItem());
				cboTo.setSelectedItem(temp);

				// To swap the input to the output.
				txtFrom.setText(txtResult.getText());
				txtResult.setText(null);
				txtFrom.requestFocus();
			}
		});
		btnSwap.setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
		btnSwap.setBounds(321, 238, 134, 35);
		contentPane.add(btnSwap);

		lblOutputTo = new JLabel("RESULT:");
		lblOutputTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblOutputTo.setBounds(33, 280, 497, 35);
		contentPane.add(lblOutputTo);

		txtResult = new JTextField();
		txtResult.setBackground(SystemColor.controlHighlight);
		txtResult.setHorizontalAlignment(SwingConstants.LEFT);
		txtResult.setFont(new Font("Times New Roman", Font.BOLD, 23));
		txtResult.setEditable(false);
		txtResult.setBounds(33, 326, 497, 88);
		contentPane.add(txtResult);
		txtResult.setColumns(10);

		noticeLabel = new JLabel("");
		noticeLabel.setForeground(Color.RED);
		noticeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		noticeLabel.setBounds(33, 205, 497, 22);
		contentPane.add(noticeLabel);
	}

	private void convert(String input) {
		
		// Checks if the input of user is all zero.
		if (isAllInputZero(input)) 

			txtResult.setText("0");
		else {

			if (cboFrom.getSelectedItem().equals("Binary"))
				convertBinary(input);
			else if (cboFrom.getSelectedItem().equals("Octal")) 
				convertOctal(input);
			else if (cboFrom.getSelectedItem().equals("Decimal")) 
				convertDecimal(input);
			else if (cboFrom.getSelectedItem().equals("Hexadecimal")) 
				convertHexadecimal(input);
		}	
	}
	/**
	 * This method finds the first occurrence of a non-zero value
	 * in the string and returns its index. */
	private int getStartingIndex(String binary) {

		int startingIndex = 0;

		for (int index = 0; index < binary.length(); index++) {

			if (binary.charAt(index) != '0') {

				startingIndex = index;
				break;
			}
		}
		return startingIndex;
	}
	/**
	 * This method will display the result. */
	private String display(String input, int index) {

		if (index == input.length())
			return "";
		else
			return input.charAt(index) + display(input, index + 1);
	}

	/**
	 * This will check if the user input is all 0. */
	private boolean isAllInputZero(String input) {

		for (int index = 0; index < input.length(); index++) {

			if (input.charAt(index) != '0')
				return false;
		}
		return true;
	}

	/**
	 * This method will called if the user wants to convert
	 * a binary value into a specific base value.
	 * @param binary
	 * - a binary value to be converted. */
	private void convertBinary(String binary) {

		if (cboTo.getSelectedItem().equals("Decimal")) 
			txtResult.setText(String.valueOf(Binary.toDecimal(binary)));

		else if (cboTo.getSelectedItem().equals("Octal")) 
			txtResult.setText(display(Binary.toOctal(binary), getStartingIndex(Binary.toOctal(binary))));

		else if (cboTo.getSelectedItem().equals("Hexadecimal")) 
			txtResult.setText(display(Binary.toHexadecimal(binary), getStartingIndex(Binary.toHexadecimal(binary))));
	}

	/**
	 * This method will be called if the user wants to
	 * convert an octal value into a specific base value.
	 * @param octal
	 * - An octal value to be converted. */
	private void convertOctal(String octal) {

		if (cboTo.getSelectedItem().equals("Binary")) 
			txtResult.setText(display(Octal.toBinary(octal, 0), getStartingIndex(Octal.toBinary(octal, 0))));

		else if (cboTo.getSelectedItem().equals("Decimal")) 
			txtResult.setText(String.valueOf(Octal.toDecimal(octal, octal.length() - 1, 0)));

		else if (cboTo.getSelectedItem().equals("Hexadecimal")) 
			txtResult.setText(display(Octal.toHexadecimal(octal), getStartingIndex(Octal.toHexadecimal(octal))));
	}

	/**
	 * This method will be called if the user wants 
	 * to convert a decimal value in to a specific base value.
	 * @param decimal
	 * - A decimal value to be converted. */
	private void convertDecimal(String decimal) {

		if (cboTo.getSelectedItem().equals("Binary")) 
			txtResult.setText(display(Decimal.toBinary(Long.parseLong(decimal)), getStartingIndex(Decimal.toBinary(Long.parseLong(decimal)))));

		else if (cboTo.getSelectedItem().equals("Octal")) 
			txtResult.setText(display(Decimal.toOctal(Long.parseLong(decimal)), getStartingIndex(Decimal.toOctal(Long.parseLong(decimal)))));

		else if (cboTo.getSelectedItem().equals("Hexadecimal")) 
			txtResult.setText(Decimal.toHexadecimal(Integer.parseInt(decimal)));
	}

	/**
	 * This method will be called if the user wants to 
	 * convert a hexadecimal value into a specific base value.
	 * @param hexa
	 * - A hexadecimal value to be converted. */
	private void convertHexadecimal(String hexa) {

		if (cboTo.getSelectedItem().equals("Binary")) 
			txtResult.setText(display(Hexadecimal.toBinary(hexa), getStartingIndex(Hexadecimal.toBinary(hexa))));

		else if (cboTo.getSelectedItem().equals("Decimal")) 
			txtResult.setText(String.valueOf(Hexadecimal.toDecimal(hexa)));

		else if (cboTo.getSelectedItem().equals("Octal")) 
			txtResult.setText(display(Hexadecimal.toOctal(hexa), getStartingIndex(Hexadecimal.toOctal(hexa))));
	}
}