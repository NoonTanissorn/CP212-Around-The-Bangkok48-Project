package ForDesignPage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class Question5 extends JFrame {

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
					Question5 frame = new Question5();
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
	public Question5() {
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
		LeftChoiceButton.setIcon(new ImageIcon(Question5.class.getResource("/Images/Button/Q5Choice1.png")));
		LeftChoiceButton.setBounds(266, 428, 163, 85);
		LeftChoiceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {					//Wrong Answer to-do thing.
					//YouLose youlose = new YouLose();							//Show the YouLose window.
					//youlose.setVisible(true);
			}
				});
		contentPane.add(LeftChoiceButton);
		
		JButton RightChoiceButton = new JButton("");
		RightChoiceButton.setIcon(new ImageIcon(Question5.class.getResource("/Images/Button/Q5Choice2.png")));
		RightChoiceButton.setBounds(582, 428, 163, 85);
		RightChoiceButton.addActionListener(new ActionListener() {					//Correct Answer to-do thing.
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, "Correct Answer.");
				//ShowCongrats sc = new ShowCongrats();
				//sc.setVisible(true); 						//Show the next Congrats Screen
				dispose();
			}
	});
		contentPane.add(RightChoiceButton);
		
		JLabel qBackground = new JLabel();
		qBackground.setIcon(new ImageIcon(Question5.class.getResource("/Images/Background/Question5 BG.jpg")));
		qBackground.setBounds(0, 0, 784, 583);
		contentPane.add(qBackground);
	}
}
