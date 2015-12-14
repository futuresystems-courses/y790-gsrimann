import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.Color;
import java.sql.*;
public class PTSD2 {
static File f1;
GenerateReports g;
	private JFrame frame;
   static int score1;
   static String ssn;
   static boolean ptsd,anx,dep;
   int p,a,d;
   ButtonGroup bg1=new ButtonGroup();
   ButtonGroup bg2=new ButtonGroup(); 
   ButtonGroup bg3=new ButtonGroup();
   ButtonGroup bg4=new ButtonGroup();
   ButtonGroup bg5=new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTSD2 window = new PTSD2(score1,ssn,ptsd,dep,anx);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  Connection c=null;
  Statement s=null;
  ResultSet rs=null;
	/**
	 * Create the application.
	 */
	public PTSD2(int score1,String ssn,boolean ptsd,boolean dep,boolean anx) {
		this.ptsd=ptsd;if(ptsd)p=1;else p=0;
		this.anx=anx;if(anx)a=1;else a=0;
		this.dep=dep;if(dep)d=1;else d=0;
		this.ssn=ssn;
		this.score1=score1;
		c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 614, 316);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblAvoidanceSymptoms = new JLabel("Avoidance symptoms");
		lblAvoidanceSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAvoidanceSymptoms.setBounds(209, 11, 159, 17);
		frame.getContentPane().add(lblAvoidanceSymptoms);
		
		JLabel lblStayingAwayFrom = new JLabel("Staying away from reminders");
		lblStayingAwayFrom.setBounds(69, 58, 196, 14);
		frame.getContentPane().add(lblStayingAwayFrom);
		
		final JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setBounds(352, 54, 51, 23);
		frame.getContentPane().add(rdbtnYes);
		
		final JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(405, 54, 51, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblEmotionallyNumb = new JLabel("Emotionally numb");
		lblEmotionallyNumb.setBounds(69, 83, 139, 14);
		frame.getContentPane().add(lblEmotionallyNumb);
		
		final JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBackground(Color.WHITE);
		rdbtnYes_1.setBounds(352, 79, 51, 23);
		frame.getContentPane().add(rdbtnYes_1);
		
		final JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBackground(Color.WHITE);
		rdbtnNo_1.setBounds(405, 79, 51, 23);
		frame.getContentPane().add(rdbtnNo_1);
		
		JLabel lblStrongGuilt = new JLabel("Strong guilt");
		lblStrongGuilt.setBounds(69, 108, 139, 14);
		frame.getContentPane().add(lblStrongGuilt);
		
		final JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBackground(Color.WHITE);
		rdbtnYes_2.setBounds(352, 104, 51, 23);
		frame.getContentPane().add(rdbtnYes_2);
		
		final JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBackground(Color.WHITE);
		rdbtnNo_2.setBounds(405, 104, 51, 23);
		frame.getContentPane().add(rdbtnNo_2);
		
		JLabel lblLosingInterestIn = new JLabel("Losing interest in activities");
		lblLosingInterestIn.setBounds(69, 133, 267, 14);
		frame.getContentPane().add(lblLosingInterestIn);
		
		final JRadioButton rdbtnYes_3 = new JRadioButton("Yes");
		rdbtnYes_3.setBackground(Color.WHITE);
		rdbtnYes_3.setBounds(352, 129, 51, 23);
		frame.getContentPane().add(rdbtnYes_3);
		
		final JRadioButton rdbtnNo_3 = new JRadioButton("No");
		rdbtnNo_3.setBackground(Color.WHITE);
		rdbtnNo_3.setBounds(405, 129, 51, 23);
		frame.getContentPane().add(rdbtnNo_3);
		
		JLabel lblTroubleRememberingThe = new JLabel("Trouble remembering");
		lblTroubleRememberingThe.setBounds(69, 158, 207, 14);
		frame.getContentPane().add(lblTroubleRememberingThe);
		
		final JRadioButton rdbtnYes_4 = new JRadioButton("Yes");
		rdbtnYes_4.setBackground(Color.WHITE);
		rdbtnYes_4.setBounds(352, 154, 51, 23);
		frame.getContentPane().add(rdbtnYes_4);
		
		final JRadioButton rdbtnNo_4 = new JRadioButton("No");
		rdbtnNo_4.setBackground(Color.WHITE);
		rdbtnNo_4.setBounds(405, 155, 51, 23);
		frame.getContentPane().add(rdbtnNo_4);
		
		bg1.add(rdbtnYes);
		bg1.add(rdbtnNo);
		bg2.add(rdbtnYes_1);
		bg2.add(rdbtnNo_1);
		bg3.add(rdbtnYes_2);
		bg3.add(rdbtnNo_2);
		bg4.add(rdbtnYes_3);
		bg4.add(rdbtnNo_3);
		bg5.add(rdbtnYes_4);
		bg5.add(rdbtnNo_4);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{ 
				int score=0;
				String p1,a1,d1;
				if(rdbtnYes.isSelected()) score++;
				if(rdbtnYes_1.isSelected()) score++;
				if(rdbtnYes_2.isSelected()) score++;
				if(rdbtnYes_3.isSelected()) score++;
				if(rdbtnYes_4.isSelected()) score++;
				if(score>=3)
					{frame.dispose();
					PTSD3 be=new PTSD3(score,ssn,ptsd,anx,dep);
					}
				else
					{JOptionPane.showMessageDialog(null,"Unlikely PTSD");
					//bw.write("Unlikely PTSD");
					//bw.close();
					if(dep==true||anx==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'No'"+","+"'"+a1+"'"+","+"'"+d1+"'"+");");
					}
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'No'"+","+"'NA'"+","+"'NA'"+");");}
					g=new GenerateReports(ssn,ptsd,anx,dep);
					frame.dispose();
					}
				//rs.close();c.close();
				  
			}
				
				catch(Exception e1)
				{e1.printStackTrace();
					}
				}
		});
		btnSubmit.setBounds(253, 224, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Answer according to recent experience");
		lblNewLabel.setBounds(10, 38, 566, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
