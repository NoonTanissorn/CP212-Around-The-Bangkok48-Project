package gameproject;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PackQuestion extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton LeftChoiceButton, RightChoiceButton, btnSendAnsButton;
	private JPanel contentPane;
	private JLabel qBackground;
	private JTextField AnswerTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PackQuestion window = new PackQuestion();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PackQuestion() {
		initialize();
		question1();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setTitle("Around the Bangkok48");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);						//Set the Window size to 800x600.
		setLocationRelativeTo(null);			//Set Position to center of screen.
		setResizable(false);					//Set to not resizable.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	/*
	 * Question Detail method.
	 * */
	
	public void question1() {
		LeftChoiceButton = new JButton();
		LeftChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q1Choice1.png")));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {					//Correct Answer to-do thing.
					JOptionPane.showMessageDialog(null, "It's a Correct Answer!!");		//Show the YouLose window.
					question2();												//Run the Next Question Window.
			}
				});
		contentPane.add(LeftChoiceButton);
		
		RightChoiceButton = new JButton();
		RightChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q1Choice2.png")));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {		//Wrong Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
					ShowLost();								//Call the ShowLost Method to Display Lost Screen.
					LeftChoiceButton.setEnabled(false);		//Set to not able to click any button after answer the Wrong answer.
					RightChoiceButton.setEnabled(false);
			}
	});
		contentPane.add(RightChoiceButton);
		
		qBackground = new JLabel();
		qBackground.setBackground(Color.WHITE);
		qBackground.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Background/Question1 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
	
	public void question2() {
		contentPane.remove(LeftChoiceButton);				//These 2-lines clear all the previous Choice Question Button.
		contentPane.remove(RightChoiceButton);
		
		AnswerTextField = new JTextField();
		AnswerTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AnswerTextField.setBounds(270, 431, 310, 73);
		contentPane.add(AnswerTextField);
		
		btnSendAnsButton = new JButton();
		btnSendAnsButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/SendAns.png")));
		btnSendAnsButton.setBounds(607, 431, 146, 73);
		btnSendAnsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					int NumPrompt = Integer.parseInt(AnswerTextField.getText());	//Try to get the Integer from the AnswerTextField, If it's not the integer, it'll skip to the catch block.
					if(NumPrompt <= 0 || NumPrompt > 48) {							//Possible answer is between 1 to 48.
						throw new Exception("It's out of hint range.");				//Throw Exception message to the catch block.
					}
					else if(NumPrompt == 16) {												//16 is the correct answer for this question.
						JOptionPane.showMessageDialog(null, "It's a Correct Answer!!");	//Show the pop-up message that it's the correct answer.
						Question3(); 														//Show the next Question Screen
					} else {					//Thing to do if player answer the wrong answer.
						ShowLost(); 							//Call the ShowLost Method to Display Lost Screen.
						AnswerTextField.setEditable(false);		//Set to not editable after answer the wrong answer.
						btnSendAnsButton.setEnabled(false);		//Set to not able to click any button after answer the Wrong answer.
						}
					}
				catch (NumberFormatException e) { 															//Thing to do if user didn't input a number
					JOptionPane.showMessageDialog(null, "Please enter Only the Number in integer format.");	//Show pop-up to tell the user.
					AnswerTextField.setText("");															//Clear the AnswerTextField to let the player prompt the new answer.
					}
				catch (Exception e) { 										//Thing to do if user input a number that out of hint range.
					JOptionPane.showMessageDialog(null, e.getMessage());	//Show pop-up to tell the user.
					AnswerTextField.setText("");							//Clear the AnswerTextField to let the player prompt the new answer.
					}
			}
				});
		contentPane.add(btnSendAnsButton);
		
		qBackground.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Background/Question2 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
	
	public void Question3() {
		contentPane.remove(AnswerTextField);		//These 2-lines clear all the previous Choice Question Button.
		contentPane.remove(btnSendAnsButton);
		
		LeftChoiceButton = new JButton();
		LeftChoiceButton.setBackground(SystemColor.control);
		LeftChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q3Choice2.png")));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {		//Wrong Answer to-do thing.
				ShowLost();									//Call the ShowLost Method to Display Lost Screen.
				LeftChoiceButton.setEnabled(false);			//Set to not able to click any button after answer the Wrong answer.
				RightChoiceButton.setEnabled(false);
			}
				});
		contentPane.add(LeftChoiceButton);
		
		RightChoiceButton = new JButton();
		RightChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q3Choice1.png")));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {			//Correct Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "It's a Correct Answer!!");		//Show the pop-up message that it's the correct answer.
				Question4(); 												//Show the next Question Screen
			}
	});
		contentPane.add(RightChoiceButton);
		
		qBackground.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Background/Question3 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
	
	public void Question4() {
		contentPane.remove(LeftChoiceButton);				//These 2-lines clear all the previous Choice Question Button.
		contentPane.remove(RightChoiceButton);
		
		AnswerTextField = new JTextField();
		AnswerTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AnswerTextField.setColumns(10);
		AnswerTextField.setBounds(270, 431, 310, 73);
		contentPane.add(AnswerTextField);
		
		btnSendAnsButton = new JButton();
		btnSendAnsButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/SendAns.png")));
		btnSendAnsButton.setBounds(607, 431, 146, 73);
		btnSendAnsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					int NumPrompt = Integer.parseInt(AnswerTextField.getText());				//Try to get the Integer from the AnswerTextField, If it's not the integer, it'll skip to the catch block.
					if(NumPrompt <= 0) {										//Possible answer any positive integer.
						throw new Exception("The single can't be 0 or negative number.");		//Throw Exception message to the catch block.
					}
					if(NumPrompt == 11) {													//11 is the correct answer for this question.
						JOptionPane.showMessageDialog(null, "It's a Correct Answer!!");	//Show the pop-up message that it's the correct answer.
						Question5(); 												//Show the next Question Screen
						} else {						//Thing to do if player answer the wrong answer.
						ShowLost(); 					//Call the ShowLost Method to Display Lost Screen.
						AnswerTextField.setEditable(false);		//Set to not editable after answer the wrong answer.
						btnSendAnsButton.setEnabled(false);		//Set to not able to click any button after answer the Wrong answer.
						}
					}
				catch (NumberFormatException e) { 															//Thing to do if user didn't input a number
					JOptionPane.showMessageDialog(null, "Please enter Only the Number in integer format.");	//Show pop-up to tell the user.
					AnswerTextField.setText("");															//Clear the AnswerTextField to let the player prompt the new answer.
					}
				catch (Exception e) { 										//Thing to do if user input a number that out of hint range.
					JOptionPane.showMessageDialog(null, e.getMessage());	//Show pop-up to tell the user.
					AnswerTextField.setText("");							//Clear the AnswerTextField to let the player prompt the new answer.
					}
			}
				});
		contentPane.add(btnSendAnsButton);
		
		qBackground.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Background/Question4 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
	
	public void Question5() {
		contentPane.remove(btnSendAnsButton);
		contentPane.remove(AnswerTextField);				//These 2-lines clear all the previous Choice Question Button.
		
		LeftChoiceButton = new JButton();
		LeftChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q5Choice1.png")));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {	//Wrong Answer to-do thing.
					ShowLost();									//Show the YouLose window.
					LeftChoiceButton.setEnabled(false);			//Set to not able to click any button after answer the Wrong answer.
					RightChoiceButton.setEnabled(false);
			}
				});
		contentPane.add(LeftChoiceButton);
		
		RightChoiceButton = new JButton();
		RightChoiceButton.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Button/Q5Choice2.png")));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {					//Correct Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "It's a Correct Answer!!");		//Show the pop-up message that it's the correct answer.
				ShowCongrats sc = new ShowCongrats();
				sc.setVisible(true); 												//Show the Congrats Screen
				dispose();
			}
	});
		contentPane.add(RightChoiceButton);
		
		qBackground.setIcon(new ImageIcon(PackQuestion.class.getResource("/Images/Background/Question5 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
	
	public void ShowLost() {
		YouLose youlose = new YouLose();							
		youlose.setVisible(true);			//Show the YouLose window is this method is called.
	}

}