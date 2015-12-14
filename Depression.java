import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.*;
public class Depression {
    static File f1;
    static String ssn;
    static boolean anx,dep,ptsd;
    int p,a,d;
    GenerateReports g;
	private JFrame frame;
	ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    ButtonGroup bg3=new ButtonGroup();
    ButtonGroup bg4=new ButtonGroup();
    ButtonGroup bg5=new ButtonGroup();
    ButtonGroup bg6=new ButtonGroup();
    ButtonGroup bg7=new ButtonGroup();
    ButtonGroup bg8=new ButtonGroup();
    static int score=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Depression window = new Depression(ssn,ptsd,dep,anx);
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
	public Depression(String ssn,boolean ptsd,boolean dep,boolean anx) {
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
		frame.setVisible(true);
		frame.setBounds(100, 100, 728, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDepression = new JLabel("Depression");
		lblDepression.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepression.setBounds(291, 11, 89, 23);
		frame.getContentPane().add(lblDepression);
		
		JLabel lblHopelessness = new JLabel("Hopelessness");
		lblHopelessness.setBounds(10, 95, 95, 14);
		frame.getContentPane().add(lblHopelessness);
		
		JLabel lblDifficultyConcentrating = new JLabel("Difficulty Concentrating");
		lblDifficultyConcentrating.setBounds(10, 120, 145, 14);
		frame.getContentPane().add(lblDifficultyConcentrating);
		
		JLabel lblNoInterest = new JLabel("No Interest");
		lblNoInterest.setBounds(10, 145, 82, 14);
		frame.getContentPane().add(lblNoInterest);
		
		JLabel lblSadness = new JLabel("Sadness");
		lblSadness.setBounds(10, 170, 61, 14);
		frame.getContentPane().add(lblSadness);
		
		JLabel lblFeelLikeA = new JLabel("'Failure'");
		lblFeelLikeA.setBounds(10, 195, 132, 14);
		frame.getContentPane().add(lblFeelLikeA);
		
		JLabel lblFeelMoreDead = new JLabel("Feel dead");
		lblFeelMoreDead.setBounds(10, 220, 154, 14);
		frame.getContentPane().add(lblFeelMoreDead);
		
		JLabel lblThoughtsAboutDeath = new JLabel("Think of death");
		lblThoughtsAboutDeath.setBounds(10, 245, 154, 14);
		frame.getContentPane().add(lblThoughtsAboutDeath);
		
		final JRadioButton rdbtnNotAtAll = new JRadioButton("Not at all");
		rdbtnNotAtAll.setBounds(170, 241, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll);
		
		final JRadioButton rdbtnLittleBit = new JRadioButton("Little bit");
		rdbtnLittleBit.setBounds(255, 241, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit);
		
		final JRadioButton rdbtnSomewhat = new JRadioButton("Somewhat");
		rdbtnSomewhat.setBounds(333, 241, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat);
		
		final JRadioButton rdbtnQuiteALot = new JRadioButton("Quite a lot");
		rdbtnQuiteALot.setBounds(515, 241, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot);
		
		final JRadioButton rdbtnAlways = new JRadioButton("Always");
		rdbtnAlways.setBounds(606, 241, 82, 23);
		frame.getContentPane().add(rdbtnAlways);
		
		final JRadioButton rdbtnNotAtAll_1 = new JRadioButton("Not at all");
		rdbtnNotAtAll_1.setBounds(170, 91, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll_1);
		
		final JRadioButton rdbtnNotAtAll_3 = new JRadioButton("Not at all");
		rdbtnNotAtAll_3.setBounds(170, 116, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll_3);
		
		final JRadioButton rdbtnNotAtAll_4 = new JRadioButton("Not at all");
		rdbtnNotAtAll_4.setBounds(170, 141, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll_4);
		
		final JRadioButton rdbtnNotAtAll_5 = new JRadioButton("Not at all");
		rdbtnNotAtAll_5.setBounds(170, 166, 76, 23);
		frame.getContentPane().add(rdbtnNotAtAll_5);
		
		final JRadioButton rdbtnNotAtAll_6 = new JRadioButton("Not at all");
		rdbtnNotAtAll_6.setBounds(170, 191, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll_6);
		
		final JRadioButton rdbtnNotAtAll_7 = new JRadioButton("Not at all");
		rdbtnNotAtAll_7.setBounds(170, 216, 82, 23);
		frame.getContentPane().add(rdbtnNotAtAll_7);
		
		final JRadioButton rdbtnLittleBit_1 = new JRadioButton("Little bit");
		rdbtnLittleBit_1.setBounds(255, 91, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_1);
		
		final JRadioButton rdbtnLittleBit_3 = new JRadioButton("Little bit");
		rdbtnLittleBit_3.setBounds(255, 116, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_3);
		
		final JRadioButton rdbtnLittleBit_4 = new JRadioButton("Little bit");
		rdbtnLittleBit_4.setBounds(255, 141, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_4);
		
		final JRadioButton rdbtnLittleBit_5 = new JRadioButton("Little bit");
		rdbtnLittleBit_5.setBounds(255, 166, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_5);
		
		final JRadioButton rdbtnLittleBit_6 = new JRadioButton("Little bit");
		rdbtnLittleBit_6.setBounds(255, 191, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_6);
		
		final JRadioButton rdbtnLittleBit_7 = new JRadioButton("Little bit");
		rdbtnLittleBit_7.setBounds(255, 216, 76, 23);
		frame.getContentPane().add(rdbtnLittleBit_7);
		
		final JRadioButton rdbtnSomewhat_1 = new JRadioButton("Somewhat");
		rdbtnSomewhat_1.setBounds(333, 91, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_1);
		
		final JRadioButton rdbtnSomewhat_3 = new JRadioButton("Somewhat");
		rdbtnSomewhat_3.setBounds(333, 116, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_3);
		
		final JRadioButton rdbtnSomewhat_4 = new JRadioButton("Somewhat");
		rdbtnSomewhat_4.setBounds(333, 141, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_4);
		
		final JRadioButton rdbtnSomewhat_5 = new JRadioButton("Somewhat");
		rdbtnSomewhat_5.setBounds(333, 166, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_5);
		
		final JRadioButton rdbtnSomewhat_6 = new JRadioButton("Somewhat");
		rdbtnSomewhat_6.setBounds(333, 191, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_6);
		
		final JRadioButton rdbtnSomewhat_7 = new JRadioButton("Somewhat");
		rdbtnSomewhat_7.setBounds(333, 216, 89, 23);
		frame.getContentPane().add(rdbtnSomewhat_7);
		
		final JRadioButton rdbtnQuiteALot_1 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_1.setBounds(515, 91, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_1);
		
		final JRadioButton rdbtnQuiteALot_3 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_3.setBounds(515, 116, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_3);
		
		final JRadioButton rdbtnQuiteALot_4 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_4.setBounds(515, 141, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_4);
		
		final JRadioButton rdbtnQuiteALot_5 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_5.setBounds(515, 166, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_5);
		
		final JRadioButton rdbtnQuiteALot_6 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_6.setBounds(515, 191, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_6);
		
		final JRadioButton rdbtnQuiteALot_7 = new JRadioButton("Quite a lot");
		rdbtnQuiteALot_7.setBounds(515, 216, 89, 23);
		frame.getContentPane().add(rdbtnQuiteALot_7);
		
		final JRadioButton rdbtnAlways_1 = new JRadioButton("Always");
		rdbtnAlways_1.setBounds(606, 91, 82, 23);
		frame.getContentPane().add(rdbtnAlways_1);
		
		final JRadioButton rdbtnAlways_3 = new JRadioButton("Always");
		rdbtnAlways_3.setBounds(606, 116, 82, 23);
		frame.getContentPane().add(rdbtnAlways_3);
		
		final JRadioButton rdbtnAlways_4 = new JRadioButton("Always");
		rdbtnAlways_4.setBounds(606, 141, 82, 23);
		frame.getContentPane().add(rdbtnAlways_4);
		
		final JRadioButton rdbtnAlways_5 = new JRadioButton("Always");
		rdbtnAlways_5.setBounds(606, 166, 82, 23);
		frame.getContentPane().add(rdbtnAlways_5);
		
		final JRadioButton rdbtnAlways_6 = new JRadioButton("Always");
		rdbtnAlways_6.setBounds(606, 191, 82, 23);
		frame.getContentPane().add(rdbtnAlways_6);
		
		final JRadioButton rdbtnAlways_7 = new JRadioButton("Always");
		rdbtnAlways_7.setBounds(606, 216, 82, 23);
		frame.getContentPane().add(rdbtnAlways_7);
				
		final JRadioButton rdbtnModerately = new JRadioButton("Moderately");
		rdbtnModerately.setBounds(424, 241, 89, 23);
		frame.getContentPane().add(rdbtnModerately);
		
		final JRadioButton rdbtnModerately_1 = new JRadioButton("Moderately");
		rdbtnModerately_1.setBounds(424, 91, 89, 23);
		frame.getContentPane().add(rdbtnModerately_1);
		
		final JRadioButton rdbtnModerately_3 = new JRadioButton("Moderately");
		rdbtnModerately_3.setBounds(424, 116, 89, 23);
		frame.getContentPane().add(rdbtnModerately_3);
		
		final JRadioButton rdbtnModerately_4 = new JRadioButton("Moderately");
		rdbtnModerately_4.setBounds(424, 141, 91, 23);
		frame.getContentPane().add(rdbtnModerately_4);
		
		final JRadioButton rdbtnModerately_5 = new JRadioButton("Moderately");
		rdbtnModerately_5.setBounds(424, 166, 89, 23);
		frame.getContentPane().add(rdbtnModerately_5);
		
		final JRadioButton rdbtnModerately_6 = new JRadioButton("Moderately");
		rdbtnModerately_6.setBounds(424, 191, 89, 23);
		frame.getContentPane().add(rdbtnModerately_6);
		
		final JRadioButton rdbtnModerately_7 = new JRadioButton("Moderately");
		rdbtnModerately_7.setBounds(424, 216, 89, 23);
		frame.getContentPane().add(rdbtnModerately_7);
		
		bg1.add(rdbtnNotAtAll);
		bg1.add(rdbtnLittleBit);
		bg1.add(rdbtnModerately);
		bg1.add(rdbtnSomewhat);
		bg1.add(rdbtnQuiteALot);
		bg1.add(rdbtnAlways);
		bg2.add(rdbtnNotAtAll_1);
		bg2.add(rdbtnLittleBit_1);
		bg2.add(rdbtnModerately_1);
		bg2.add(rdbtnSomewhat_1);
		bg2.add(rdbtnQuiteALot_1);
		bg2.add(rdbtnAlways_1);
		bg4.add(rdbtnNotAtAll_3);
		bg4.add(rdbtnLittleBit_3);
		bg4.add(rdbtnModerately_3);
		bg4.add(rdbtnSomewhat_3);
		bg4.add(rdbtnQuiteALot_3);
		bg4.add(rdbtnAlways_3);
		bg5.add(rdbtnNotAtAll_4);
		bg5.add(rdbtnLittleBit_4);
		bg5.add(rdbtnModerately_4);
		bg5.add(rdbtnSomewhat_4);
		bg5.add(rdbtnQuiteALot_4);
		bg5.add(rdbtnAlways_4);
		bg6.add(rdbtnNotAtAll_5);
		bg6.add(rdbtnLittleBit_5);
		bg6.add(rdbtnModerately_5);
		bg6.add(rdbtnSomewhat_5);
		bg6.add(rdbtnQuiteALot_5);
		bg6.add(rdbtnAlways_5);
		bg7.add(rdbtnNotAtAll_6);
		bg7.add(rdbtnLittleBit_6);
		bg7.add(rdbtnModerately_6);
		bg7.add(rdbtnSomewhat_6);
		bg7.add(rdbtnQuiteALot_6);
		bg7.add(rdbtnAlways_6);
		bg8.add(rdbtnNotAtAll_7);
		bg8.add(rdbtnLittleBit_7);
		bg8.add(rdbtnModerately_7);
		bg8.add(rdbtnSomewhat_7);
		bg8.add(rdbtnQuiteALot_7);
		bg8.add(rdbtnAlways_7);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {String p1,a1,d1;
				try
				{   
				if(rdbtnNotAtAll.isSelected()) score+=0;
				if(rdbtnLittleBit.isSelected()) score+=1;
				if(rdbtnSomewhat.isSelected()) score+=2;
				if(rdbtnModerately.isSelected()) score+=3;
				if(rdbtnQuiteALot.isSelected()) score+=4;
				if(rdbtnAlways.isSelected()) score+=5;
				if(rdbtnNotAtAll_1.isSelected()) score+=0;
				if(rdbtnLittleBit_1.isSelected()) score+=1;
				if(rdbtnSomewhat_1.isSelected()) score+=2;
				if(rdbtnModerately_1.isSelected()) score+=3;
				if(rdbtnQuiteALot_1.isSelected()) score+=4;
				if(rdbtnAlways_1.isSelected()) score+=5;
				if(rdbtnNotAtAll_3.isSelected()) score+=0;
				if(rdbtnLittleBit_3.isSelected()) score+=1;
				if(rdbtnSomewhat_3.isSelected()) score+=2;
				if(rdbtnModerately_3.isSelected()) score+=3;
				if(rdbtnQuiteALot_3.isSelected()) score+=4;
				if(rdbtnAlways_3.isSelected()) score+=5;
				if(rdbtnNotAtAll_4.isSelected()) score+=0;
				if(rdbtnLittleBit_4.isSelected()) score+=1;
				if(rdbtnSomewhat_4.isSelected()) score+=2;
				if(rdbtnModerately_4.isSelected()) score+=3;
				if(rdbtnQuiteALot_4.isSelected()) score+=4;
				if(rdbtnAlways_4.isSelected()) score+=5;
				if(rdbtnNotAtAll_5.isSelected()) score+=0;
				if(rdbtnLittleBit_5.isSelected()) score+=1;
				if(rdbtnSomewhat_5.isSelected()) score+=2;
				if(rdbtnModerately_5.isSelected()) score+=3;
				if(rdbtnQuiteALot_5.isSelected()) score+=4;
				if(rdbtnAlways_5.isSelected()) score+=5;
				if(rdbtnNotAtAll_6.isSelected()) score+=0;
				if(rdbtnLittleBit_6.isSelected()) score+=1;
				if(rdbtnSomewhat_6.isSelected()) score+=2;
				if(rdbtnModerately_6.isSelected()) score+=3;
				if(rdbtnQuiteALot_6.isSelected()) score+=4;
				if(rdbtnAlways_6.isSelected()) score+=5;
				if(rdbtnNotAtAll_7.isSelected()) score+=0;
				if(rdbtnLittleBit_7.isSelected()) score+=1;
				if(rdbtnSomewhat_7.isSelected()) score+=2;
				if(rdbtnModerately_7.isSelected()) score+=3;
				if(rdbtnQuiteALot_7.isSelected()) score+=4;
				if(rdbtnAlways_7.isSelected()) score+=5;
				if(score>=0 && score<=9)
				{
					if(anx==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'"+a1+"'"+","+"'No'"+");");
					}
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"None to mild depression likely");
					//bw.write("None to mild depression likely");
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'No'"+");");}
				}
				else if(score>=10 && score<=19)
				{
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Mild to moderate depression likely");
					//bw.write("Mild to moderate depression likely");
					if(anx==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'"+a1+"'"+","+"'No'"+");");
					}
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'No'"+");");}
					
				}
				else if(score>=20 && score<=29)
				{
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Moderate to severe depression likely");
					//bw.write("Moderate to severe depression likely");
					if(anx==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'"+a1+"'"+","+"'Yes'"+");");
					}
					else{
					s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'Yes'"+");");}
				}
				else if(score>=30)
				{
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Severe depression likely");
					//bw.write("Severe depression likely");
					if(anx==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'"+a1+"'"+","+"'Yes'"+");");
					}
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'NA'"+","+"'Yes'"+");");}
					
				}
				//bw.close();
				//rs.close();c.close();
				g=new GenerateReports(ssn,ptsd,anx,dep);
				frame.dispose();}
				catch(Exception e1)
				{
					e1.printStackTrace();}
				}
		});
		btnSubmit.setBounds(291, 308, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("Answer according to how regularly you have been experiencing these symptoms over the last few weeks");
		lblNewLabel.setBounds(58, 55, 572, 14);
		frame.getContentPane().add(lblNewLabel);
	}

}
