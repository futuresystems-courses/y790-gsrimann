import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class GetDetails {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	Connection c=null;
	Statement stmt=null;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetDetails window = new GetDetails();
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
	public GetDetails() {
		initialize();
		c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		textField = new JTextField();
		textField.setBounds(165, 98, 196, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(92, 101, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(165, 129, 196, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(92, 132, 46, 14);
		frame.getContentPane().add(lblAge);
		
		JButton btnBeginTests = new JButton("Begin tests");
		btnBeginTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					stmt=c.createStatement();
					String s="insert into Patient values ("+"'"+textField_2.getText()+"'"+","+"'"+textField.getText()+"'"+","+Integer.parseInt(textField_1.getText())+");";
				    stmt.executeUpdate(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Frame1 f=new Frame1(textField_2.getText());
				frame.dispose();
			}
		});
		btnBeginTests.setBounds(208, 162, 116, 23);
		frame.getContentPane().add(btnBeginTests);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(92, 76, 46, 14);
		frame.getContentPane().add(lblSsn);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 73, 195, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPleaseEnterYour = new JLabel("Enter your details");
		lblPleaseEnterYour.setBounds(65, 35, 273, 14);
		frame.getContentPane().add(lblPleaseEnterYour);
		frame.setBounds(100, 100, 706, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
