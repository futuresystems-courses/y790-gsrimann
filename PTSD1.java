import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.*;
import java.awt.Color;
import java.sql.*;
public class PTSD1 {
    static File f1;
    static String ssn;
    GenerateReports g;
	private JFrame frame;
    static boolean ptsd,anx,dep;
    int p,a,d;
    ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    ButtonGroup bg3=new ButtonGroup();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PTSD1 window = new PTSD1(ssn,ptsd,dep,anx);
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
	public PTSD1(String ssn,boolean ptsd,boolean dep,boolean anx) {
		this.ptsd=ptsd;if(ptsd)p=1;else p=0;
		this.anx=anx;if(anx)a=1;else a=0;
		this.dep=dep;if(dep)d=1;else d=0;
		this.ssn=ssn;
		c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 663, 305);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel label = new JLabel("");
		label.setBounds(289, 11, 46, 14);
		frame.getContentPane().add(label);
		 
		JLabel lblRepeatedDisturbingMemoriesimagesdreams = new JLabel("Flashbacks of trauma?");
		lblRepeatedDisturbingMemoriesimagesdreams.setBounds(10, 70, 461, 14);
		frame.getContentPane().add(lblRepeatedDisturbingMemoriesimagesdreams);
		

		JLabel lblBad = new JLabel("Bad Dreams?");
		lblBad.setBounds(10, 95, 102, 14);
		frame.getContentPane().add(lblBad);
		
		JLabel lblFrighteningThoughts = new JLabel("Frightening Thoughts?");
		lblFrighteningThoughts.setBounds(10, 120, 129, 14);
		frame.getContentPane().add(lblFrighteningThoughts);
		
		final JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setBounds(490, 66, 46, 23);
		frame.getContentPane().add(rdbtnYes);
		
		final JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(538, 66, 55, 23);
		frame.getContentPane().add(rdbtnNo);
		
		final JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBackground(Color.WHITE);
		rdbtnYes_1.setBounds(490, 91, 46, 23);
		frame.getContentPane().add(rdbtnYes_1);
		
		final JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBackground(Color.WHITE);
		rdbtnNo_1.setBounds(538, 91, 55, 23);
		frame.getContentPane().add(rdbtnNo_1);
		
		final JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBackground(Color.WHITE);
		rdbtnYes_2.setBounds(490, 116, 46, 23);
		frame.getContentPane().add(rdbtnYes_2);
		
		final JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBackground(Color.WHITE);
		rdbtnNo_2.setBounds(538, 116, 55, 23);
		frame.getContentPane().add(rdbtnNo_2);
		bg1.add(rdbtnYes);
		bg1.add(rdbtnNo);
		bg2.add(rdbtnYes_1);
		bg2.add(rdbtnNo_1);
		bg3.add(rdbtnYes_2);
		bg3.add(rdbtnNo_2);
		
		JLabel lblReexperiencingSymptoms = new JLabel("Re-experiencing symptoms");
		lblReexperiencingSymptoms.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReexperiencingSymptoms.setBounds(244, 11, 209, 23);
		frame.getContentPane().add(lblReexperiencingSymptoms);
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {int score=0;
			public void actionPerformed(ActionEvent e) {
				try
				{   String p1,a1,d1;
			
				if(rdbtnYes.isSelected()) score++;
				if(rdbtnYes_1.isSelected()) score++;
				if(rdbtnYes_2.isSelected()) score++;
				if(score>=1)
					{frame.dispose();
					PTSD2 be=new PTSD2(score,ssn,ptsd,dep,anx);
					}
				else
					{//JOptionPane.showMessageDialog(null,"Unlikely PTSD");
					//bw.write("Unlikely PTSD");
					//ptsd=false;
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
					//s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'No');");
					//s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'Yes');");
					
				//bw.close();
					//rs.close();c.close();
				g=new GenerateReports(ssn,ptsd,anx,dep);
					frame.dispose();}
					}
				  
			
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		
		btnSubmit.setBounds(289, 195, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Answer according to whether you have been experiencing these symptoms over the last few weeks");
		lblNewLabel.setBounds(10, 47, 583, 14);
		frame.getContentPane().add(lblNewLabel);
		
	
}
}
