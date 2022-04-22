package ForDesignPage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Question2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField AnswerTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question2 frame = new Question2();
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
	public Question2() {
		setTitle("Around the Bangkok48");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(800,600);
		setLocationRelativeTo(null);			//Set Position to center of screen.
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		AnswerTextField = new JTextField();
		AnswerTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AnswerTextField.setColumns(10);
		AnswerTextField.setBounds(258, 461, 329, 73);
		contentPane.add(AnswerTextField);
		
		JButton btnSendAnsButton = new JButton();
		btnSendAnsButton.setIcon(new ImageIcon(Question2.class.getResource("/Images/Button/SendAns.png")));
		btnSendAnsButton.setBounds(608, 461, 146, 73);
		btnSendAnsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int Num=0;
				try {
					Num = Integer.parseInt(AnswerTextField.getText());	//Try to get the Integer from the AnswerTextField, If it's not the integer, it'll skip to the catch block.
					if(Num == 16) {									//16 is the correct answer for this question.
						JOptionPane.showMessageDialog(null, "Correct Answer.");
						Question3 q3 = new Question3();								//Run the Next Question Window.
						q3.setVisible(true);
						dispose();													//Close this Question Window.
						} else {									//Thing to do if player answer the wrong answer.
						//YouLose youlose = new YouLose();
						//youlose.setVisible(true); 					//Show the YouLose Window
						}
					}
				catch (NumberFormatException e) { 										//Thing to do if user didn't input a number
					JOptionPane.showMessageDialog(null, "Please enter Only the Number in integer format.");	//Show pop-up to tell the user.
					AnswerTextField.setText("");						//Clear the AnswerTextField to let the player prompt the new answer.
					}
			}
				});
		contentPane.add(btnSendAnsButton);
		
		JLabel qBackground = new JLabel();
		qBackground.setIcon(new ImageIcon(Question2.class.getResource("/Images/Background/Question2 BG.jpg")));
		qBackground.setBounds(-10, 0, 794, 572);
		contentPane.add(qBackground);
	}
}
