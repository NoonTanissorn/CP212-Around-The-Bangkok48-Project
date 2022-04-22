package gameproject;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class ShowCongrats extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField NametextField;
	private String Winnername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ShowCongrats dialog = new ShowCongrats();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ShowCongrats() {
		setBounds(100, 100, 450, 300);
		setSize(400,300);
		setLocationRelativeTo(null);			//Set Position to center of screen.
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		NametextField = new JTextField();
		NametextField.setFont(new Font("Tahoma", Font.PLAIN, 28));
		NametextField.setBounds(20, 202, 225, 40);
		contentPanel.add(NametextField);
		NametextField.setColumns(10);
		
		JButton SendNameButton = new JButton();
		SendNameButton.setIcon(new ImageIcon(ShowCongrats.class.getResource("/Images/Button/SignNameButton.png")));
		SendNameButton.setBounds(255, 202, 100, 40);
		SendNameButton.addActionListener(this);
		contentPanel.add(SendNameButton);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(ShowCongrats.class.getResource("/Images/Background/ShowCongratsBG.jpg")));
		lblNewLabel.setBounds(0, 0, 384, 283);
		contentPanel.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof JButton) {
			Winnername = NametextField.getText();							//Get the name from JTextField NametextField to use it later, Save the name into Winnername.
			NametextField.setText("");
			try {
				SaveGameLog();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			dispose();
		}
		
	}
	
	public void SaveGameLog() throws FileNotFoundException {
		File file = new File("Champboard.txt");								//Create a new file.
		FileOutputStream output = new FileOutputStream(file,true);			//Argument "true" is to continue last position, not to write from the first position.
    	PrintWriter outStream = new PrintWriter(output);
    	outStream.println(Winnername);    									//Write the Winner Name from the Winnername to the file.
    	outStream.close();
	}
}
