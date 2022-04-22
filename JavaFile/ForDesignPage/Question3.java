package ForDesignPage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Question3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Question3 frame = new Question3();
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
	public Question3() {
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
		
		JButton LeftChoiceButton = new JButton("");
		LeftChoiceButton.setBackground(SystemColor.control);
		LeftChoiceButton.setIcon(new ImageIcon(Question3.class.getResource("/Images/Button/Q3Choice2.png")));
		LeftChoiceButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {					//Wrong Answer to-do thing.
				//YouLose youlose = new YouLose();							//Show the YouLose window.
				//youlose.setVisible(true);
			}
				});
		contentPane.add(LeftChoiceButton);
		
		JButton RightChoiceButton = new JButton("");
		RightChoiceButton.setIcon(new ImageIcon(Question3.class.getResource("/Images/Button/Q3Choice1.png")));
		RightChoiceButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {					//Correct Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Correct Answer.");
				Question4 q4 = new Question4();								//Run the Next Question Window.
				q4.setVisible(true);
				dispose();													//Close this Question Window.
			}
	});
		contentPane.add(RightChoiceButton);
		
		JLabel qBackground = new JLabel();
		qBackground.setBackground(Color.WHITE);
		qBackground.setIcon(new ImageIcon(Question3.class.getResource("/Images/Background/Question3 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
}
