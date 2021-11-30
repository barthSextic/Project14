package edu.mtc.egr281.project14;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CipherGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = -5065611731709902005L;
	private Container contentPane;
	private JLabel buttonLabel, inputText, outputText;
	private JTextField input, output, parameter;
	private JTextArea instructions;
	int argument;
	private JButton subButton;
	private JButton transButton;
	private JButton clearButton, encode, decode, set;
	
	private static SubstitutionCipher sc;
	private static TranspositionCipher tc;
	
	private static boolean sCheck, tCheck;
	public CipherGUI() {
		super(); // why is this here...?
		this.setTitle("Rick Howell ::: Project 14");
		this.setSize(950, 440);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = this.getContentPane();
		this.setLayout(new FlowLayout());
		this.contentPane.setBackground(Color.WHITE);
		
		this.buttonLabel = new JLabel("Pick one: ");
		//this.contentPane.add(this.buttonLabel);
		
		this.parameter = new JTextField(3);
		this.add(this.parameter);
		this.set = new JButton("Set Argument");
		this.set.addActionListener(this);
		this.contentPane.add(this.set);

		this.subButton = new JButton("Substitution");
		this.subButton.addActionListener(this);
		this.contentPane.add(this.subButton);
		
		this.transButton = new JButton("Transposition");
		this.transButton.addActionListener(this);
		this.contentPane.add(this.transButton);
		
		this.encode = new JButton("Encode");
		this.encode.addActionListener(this);
		this.contentPane.add(this.encode);
		
		this.decode = new JButton("Decode");
		this.decode.addActionListener(this);
		this.contentPane.add(this.decode);
		
		this.clearButton = new JButton("Clear");
		this.clearButton.addActionListener(this);
		this.contentPane.add(this.clearButton);
		
		this.inputText = new JLabel("Input:");
		//this.contentPane.add(this.inputText);
		this.input = new JTextField(31);
		this.add(this.input);
		
		this.outputText = new JLabel("Output:");
		//this.contentPane.add(this.outputText);
		this.output = new JTextField(31);
		this.add(this.output);
		
		this.instructions = new JTextArea();
		this.instructions.setText("ENTER A NUMBER IN THE FIRST TEXT BOX AND HIT 'SET ARGUMENT'.\nTHIS WILL CORRESPOND TO "
				+ "THE SHIFT BY AMOUNT FOR SUBSTITUTION, OR SHUFFLE AMOUNT FOR TRANSPOSITION.\n"
				+ "YOU SHOULD THEN ENTER THE TEXT TO BE PROCESSED INTO THE FIRST LARGE TEXT FIELD\n"
				+ "THEN SELECT THE TYPE OF CIPHER TO BE USED\n"
				+ "NEXT, SELECT EITHER ENCODE, DECODE, OR CLEAR, TO GET THE CORRESPONSING OUTPUTS IN THE RIGHT TEXT FIELD");
		this.add(this.instructions);
		
	} // end constructor

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if ("Set Argument".equals(ac)) {
			int arg = Integer.parseInt(this.parameter.getText());
			//System.out.println(arg);
			sc = new SubstitutionCipher(arg);
			tc = new TranspositionCipher(arg);
		} // end set if
		if ("Substitution".equals(ac)) {
			//System.out.println("x");
			sCheck = true;
			tCheck = false;
		} // end sub if
		if ("Transposition".equals(ac)) {
			//System.out.println("x");
			sCheck = false;
			tCheck = true;
		} // end transposition if
		if ("Decode".equals(ac)) {
			if(sCheck) {
				this.output.setText(sc.decode(this.input.getText()));
				//System.out.println("x");
			} // end if
			if(tCheck) {
				this.output.setText(tc.decode(this.input.getText()));
			} // end if
		} // end decode
		if ("Encode".equals(ac)) {
			if(sCheck) {
				this.output.setText(sc.encode(this.input.getText()));
				//System.out.println("x");
			} // end if
			if(tCheck) {
				this.output.setText(tc.encode(this.input.getText()));
				//System.out.println("x");
			} // end if
		} // end encode
		if ("Clear".equals(ac)) {
			this.output.setText("");
		} // end clear
	} // end actions method

} // end class
