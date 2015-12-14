import java.awt.EventQueue;



import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

import javax.swing.JRadioButton;

public class Menu {
    static File f1;
    static String s,ssn;
	private JFrame frame;
    static boolean ptsd,depr,anx;
    PTSD1 p;
    Anxiety a;
    Depression d;
    ButtonGroup bg=new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu(ptsd,depr,anx,ssn);
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
	public Menu(boolean ptsd,boolean anx,boolean depr,String ssn) {
		this.ptsd=ptsd;this.depr=depr;this.anx=anx;this.ssn=ssn;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 581, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		final JRadioButton rdbtnPtsd = new JRadioButton("PTSD");
		rdbtnPtsd.setBounds(61, 87, 109, 23);
		frame.getContentPane().add(rdbtnPtsd);
		
		final JRadioButton rdbtnDepression = new JRadioButton("Depression");
		rdbtnDepression.setBounds(61, 111, 109, 23);
		frame.getContentPane().add(rdbtnDepression);
		
		final JRadioButton rdbtnAnxiety = new JRadioButton("Anxiety");
		rdbtnAnxiety.setBounds(61, 137, 109, 23);
		frame.getContentPane().add(rdbtnAnxiety);
	
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try
				{   f1=new File("C:\\Program Files (x86)\\Diagnosis\\Reports\\5.txt");
			
					BufferedWriter bw=new BufferedWriter(new FileWriter(f1,true));
					
					//bw.write("Diseases Screened for:\n");
					
				if(rdbtnPtsd.isSelected()) {
					//bw.append("PTSD\n");
					ptsd=true;
					p=new PTSD1(ssn,ptsd,depr,anx);
					frame.dispose();
				}
				if(rdbtnAnxiety.isSelected()) {
					//bw.append("Anxiety\n");
					anx=true;
					a=new Anxiety(ssn,ptsd,depr,anx);
					frame.dispose();
				}
				if(rdbtnDepression.isSelected()) {
					//bw.append("Depression\n");
					depr=true;
					d=new Depression(ssn,ptsd,depr,anx);
					frame.dispose();
				}
				bg.add(rdbtnPtsd);
				bg.add(rdbtnDepression);
				bg.add(rdbtnAnxiety);
				bw.close();
			}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
			
		});
		btnSubmit.setBounds(221, 249, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblPleaseChooseThe = new JLabel("Please slect diseases to test");
		lblPleaseChooseThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseChooseThe.setBounds(175, 21, 244, 23);
		frame.getContentPane().add(lblPleaseChooseThe);
		
		

		}
}
