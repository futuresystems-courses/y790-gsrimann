import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Details {
    String ssn;
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Details window = new Details();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblSsn = new JLabel("SSN:");
		lblSsn.setBounds(60, 88, 46, 14);
		frame.getContentPane().add(lblSsn);
		
		textField = new JTextField();
		textField.setBounds(116, 85, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnViewReport = new JButton("View Report");
		btnViewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ssn=textField.getText();
				ShowReport g=new ShowReport(ssn);
				frame.dispose();
			}
		});
		btnViewReport.setBounds(116, 148, 113, 23);
		frame.getContentPane().add(btnViewReport);
	}
}
