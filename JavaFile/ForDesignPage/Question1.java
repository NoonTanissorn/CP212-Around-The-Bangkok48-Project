import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Question1 extends JFrame {

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
					Question1 frame = new Question1();
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
	public Question1() {
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
		
		JButton LeftChoiceButton = new JButton();
		LeftChoiceButton.setBackground(SystemColor.control);
		LeftChoiceButton.setIcon(new ImageIcon(Question1.class.getResource("/Images/Button/Q1Choice1.png")));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {					//Correct Answer to-do thing.
					JOptionPane.showMessageDialog(null, "Correct Answer.");
					Question2 q2 = new Question2();								//Run the Next Question Window.
					q2.setVisible(true);
					dispose();													//Close this Question Window.
			}
				});
		contentPane.add(LeftChoiceButton);
		
		JButton RightChoiceButton = new JButton();
		RightChoiceButton.setIcon(new ImageIcon(Question1.class.getResource("/Images/Button/Q1Choice2.png")));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {					//Wrong Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
					//JButton buttonName = ((JButton)event.getSource());
					////YouLose youlose = new YouLose();							//Show the YouLose window.
					////youlose.setVisible(true);
					LeftChoiceButton.setEnabled(false);							//Set to not able to click any button after answer the Wrong answer.
					RightChoiceButton.setEnabled(false);
			}
	});
		contentPane.add(RightChoiceButton);
		
		JLabel qBackground = new JLabel();
		qBackground.setBackground(Color.WHITE);
		qBackground.setIcon(new ImageIcon(Question1.class.getResource("/Images/Background/Question1 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
}
