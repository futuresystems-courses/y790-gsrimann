import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class Start {
    File f1;
	private JFrame frame;
    Frame1 f;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
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
	public Start() {
		try{
			initialize();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 673, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 frame.setVisible(true);
		JButton btnBeginTests = new JButton("Run tests");
		
		btnBeginTests.setBounds(287, 87, 108, 23);
		frame.getContentPane().add(btnBeginTests);
		btnBeginTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    GetDetails g=new GetDetails();
		    frame.dispose();
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(48, 168, 46, 14);
		frame.getContentPane().add(label);
		
		JButton btnViewPreviousReports = new JButton("View Previous Reports");
		btnViewPreviousReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Details d=new Details();
				frame.dispose();
			}
		});
		btnViewPreviousReports.setBounds(310, 178, 174, 23);
		frame.getContentPane().add(btnViewPreviousReports);
		
		JLabel lblToRunThe = new JLabel("Diagnose: ");
		lblToRunThe.setBounds(277, 62, 261, 14);
		frame.getContentPane().add(lblToRunThe);
		
		JLabel lblToViewThe = new JLabel("View Previous Reports:");
		lblToViewThe.setBounds(277, 150, 297, 14);
		frame.getContentPane().add(lblToViewThe);
		
		JLabel lblIntelligentDiagnosticSystem = new JLabel("Medical Diagnosis");
		lblIntelligentDiagnosticSystem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIntelligentDiagnosticSystem.setBounds(248, 22, 202, 23);
		frame.getContentPane().add(lblIntelligentDiagnosticSystem);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/healthcare-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(10, 51, 172, 172);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
