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
public class PTSD3 {
static File f1;
static String ssn;
	private JFrame frame;
    static int score;
    static boolean ptsd,anx,dep;
    int p,a,d;
    GenerateReports g;
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
					PTSD3 window = new PTSD3(score,ssn,ptsd,dep,anx);
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
	public PTSD3(int score, String ssn,boolean ptsd,boolean dep,boolean anx) {
		this.ptsd=ptsd;if(ptsd)p=1;else p=0;
		this.anx=anx;if(anx)a=1;else a=0;
		this.dep=dep;if(dep)d=1;else d=0;
		this.ssn=ssn;
		this.score=score;
		c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 630, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblHyperarousal = new JLabel("Hyperarousal ");
		lblHyperarousal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHyperarousal.setBounds(168, 11, 115, 22);
		frame.getContentPane().add(lblHyperarousal);
		
		JLabel lblEasilyStartled = new JLabel("Easily Startled");
		lblEasilyStartled.setBounds(24, 73, 115, 14);
		frame.getContentPane().add(lblEasilyStartled);
		
		final JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setBounds(225, 69, 50, 23);
		frame.getContentPane().add(rdbtnYes);
		
		final JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(277, 69, 50, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JLabel lblTenseOrOn = new JLabel("Tense");
		lblTenseOrOn.setBounds(24, 98, 146, 14);
		frame.getContentPane().add(lblTenseOrOn);
		
		final JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBackground(Color.WHITE);
		rdbtnYes_1.setBounds(225, 94, 50, 23);
		frame.getContentPane().add(rdbtnYes_1);
		
		final JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBackground(Color.WHITE);
		rdbtnNo_1.setBounds(277, 94, 50, 23);
		frame.getContentPane().add(rdbtnNo_1);
		
		JLabel lblDifficultySleepingIrritability = new JLabel("Difficulty sleeping");
		lblDifficultySleepingIrritability.setBounds(24, 123, 169, 14);
		frame.getContentPane().add(lblDifficultySleepingIrritability);
		
		final JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBackground(Color.WHITE);
		rdbtnYes_2.setBounds(225, 119, 50, 23);
		frame.getContentPane().add(rdbtnYes_2);
		
		final JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBackground(Color.WHITE);
		rdbtnNo_2.setBounds(277, 119, 50, 23);
		frame.getContentPane().add(rdbtnNo_2);
		
		bg1.add(rdbtnYes);
		bg1.add(rdbtnNo);
		bg2.add(rdbtnYes_1);
		bg2.add(rdbtnNo_1);
		bg3.add(rdbtnYes_2);
		bg3.add(rdbtnNo_2);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {int score=0;String p1,a1,d1;
			try
			{ 
	
			if(rdbtnYes_1.isSelected()) score++;
			if(rdbtnYes_2.isSelected()) score++;
			if(score>=2)
				{
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
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'Yes'"+","+"'"+a1+"'"+","+"'"+d1+"'"+");");
				}
				//JOptionPane.showMessageDialog(null,"PTSD is likely");
				else{s=c.createStatement();
				s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
				s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'Yes'"+","+"'NA'"+","+"'NA'"+");");}
				//bw.write("PTSD is likely");
				
				}
			else
				{
				JOptionPane.showMessageDialog(null,"Unlikely PTSD");
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
					s.executeUpdate("insert into FinalDiagnosis("+"'"+ssn+"'"+","+"'No'"+","+"'"+a1+"'"+","+"'"+d1+"'"+");");
				}
				else{s=c.createStatement();
				s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
				s.executeUpdate("insert into FinalDiagnosis("+"'"+ssn+"'"+","+"'No'"+","+"'NA'"+","+"'NA'"+");");}
				//bw.write("Unlikely PTSD");
				//ptsd=false;
				}
			//rs.close();c.close();
			//bw.close();
			frame.dispose();
			g=new GenerateReports(ssn,ptsd,anx,dep);
			}
			catch(Exception e1)
			{
				e1.printStackTrace();}
			}
		});
		btnSubmit.setBounds(165, 161, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Answer according to experience");
		lblNewLabel.setBounds(24, 50, 537, 14);
		frame.getContentPane().add(lblNewLabel);
	}

}
