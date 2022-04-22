	package gameproject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea ChamptextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen frame = new WelcomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public WelcomeScreen() throws FileNotFoundException {
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 146, 279, 279);
		contentPane.add(scrollPane);
		
		ChamptextArea = new JTextArea();
		ChamptextArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ChamptextArea.setEditable(false);				//Set to not editable.
		scrollPane.setViewportView(ChamptextArea);
		
		try {
			ShowChampion();													//Run the method to Show the champion name
		} catch (FileNotFoundException | IndexOutOfBoundsException e) {		//In case file isn't created yet, or file is blank. It'll skip to do the ShowChampion() Method.
			
		}
		
		JButton StartButton = new JButton();
		StartButton.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/Images/Button/StartGameButton.png")));
		StartButton.setContentAreaFilled(false);		//Clear the button Background
		StartButton.setBounds(439, 437, 200, 100);
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
					PackQuestion q = new PackQuestion();
					q.setVisible(true);					//Show the question screen.
					dispose();
			}
				});
		contentPane.add(StartButton);
		
		JLabel Background = new JLabel();
		Background.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/Images/Background/WelcomeScreenBG.png")));
		Background.setBounds(0, 0, 784, 561);
		contentPane.add(Background);
	}
	
	public void ShowChampion() throws FileNotFoundException {
		String ChampName;
		ArrayList<String> ChampNameArray = new ArrayList<String>();
		Scanner scanner = new Scanner(new File("Champboard.txt"));
		try {
			while(scanner.hasNextLine()) {				//Read the file until the last line.
				ChampName = scanner.nextLine();			//Read each line of the file.
				ChampNameArray.add(ChampName);			//Add each line to the ArrayList.
				}		
		} catch(NoSuchElementException e) {				//Read until the last line.					
				scanner.close();
			}
		ChamptextArea.setText(ChampNameArray.get(ChampNameArray.size()-1));		//Set the ChamptextArea to the Last Line of the file (which is new winner). (ChampNameArray.size()-1 means get the last index of the array.)
		
	}
}
