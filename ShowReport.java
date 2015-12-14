import java.awt.EventQueue;

import javax.swing.JFrame;

import java.io.*;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ShowReport {

	private JFrame frame;
    static String ssn;
    File f1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowReport window = new ShowReport(ssn);
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
	public ShowReport(String ssn) {
		this.ssn=ssn;
		try
		{initialize();}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 734, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		String s;
		JTextArea textArea = new JTextArea();
		textArea.setBounds(45, 38, 627, 339);
		frame.getContentPane().add(textArea);
		
		JLabel lblClickToReturn = new JLabel("Click to return to Start");
		lblClickToReturn.setBackground(Color.WHITE);
		lblClickToReturn.setBounds(146, 396, 172, 14);
		frame.getContentPane().add(lblClickToReturn);
		
		
		f1=new File("C:\\Program Files\\Diagnosis\\Reports\\"+ssn+".txt");
		BufferedReader br=new BufferedReader(new FileReader(f1));
		while((s=br.readLine())!=null)
		{
			textArea.append(s);
			textArea.append("\n");
		}
		br.close();
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Start s=new Start();
			frame.dispose();}
		});
		btnBack.setBounds(283, 392, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
