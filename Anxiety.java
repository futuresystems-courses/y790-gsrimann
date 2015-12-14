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
import java.awt.Color;
import java.sql.*;
public class Anxiety {
    static File f1;
    static String ssn;
    GenerateReports g;
    static boolean ptsd,anx,dep;
    int p,a,d;
	private JFrame frame;
	ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    ButtonGroup bg3=new ButtonGroup();
    ButtonGroup bg4=new ButtonGroup();
    ButtonGroup bg5=new ButtonGroup();
    ButtonGroup bg6=new ButtonGroup();
    ButtonGroup bg7=new ButtonGroup();
    static int score=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Anxiety window = new Anxiety(ssn,ptsd,dep,anx);
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
	public Anxiety(String ssn,boolean ptsd,boolean dep,boolean anx) {
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
		frame.setVisible(true);
		frame.setBounds(100, 100, 743, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAnxiety = new JLabel("ANXIETY");
		lblAnxiety.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnxiety.setBounds(256, 26, 71, 27);
		frame.getContentPane().add(lblAnxiety);
		
		JLabel lblNervous = new JLabel("Nervous");
		lblNervous.setBounds(10, 91, 61, 14);
		frame.getContentPane().add(lblNervous);
		
		JLabel lblUnableToStop = new JLabel("Worrying always");
		lblUnableToStop.setBounds(10, 111, 145, 14);
		frame.getContentPane().add(lblUnableToStop);
		
		JLabel lblWorryingAboutDifferent = new JLabel("Negative thoughts");
		lblWorryingAboutDifferent.setBounds(10, 136, 171, 14);
		frame.getContentPane().add(lblWorryingAboutDifferent);
		
		JLabel lblTroubleRelaxing = new JLabel("Trouble relaxing");
		lblTroubleRelaxing.setBounds(10, 161, 145, 14);
		frame.getContentPane().add(lblTroubleRelaxing);
		
		JLabel lblRestless = new JLabel("Restless");
		lblRestless.setBounds(10, 186, 77, 14);
		frame.getContentPane().add(lblRestless);
		
		
		
		JLabel lblIrritable = new JLabel("Irritable");
		lblIrritable.setBounds(10, 211, 77, 14);
		frame.getContentPane().add(lblIrritable);
		
		JLabel lblAfraidOfSomething = new JLabel("Afraid");
		lblAfraidOfSomething.setBounds(10, 236, 157, 14);
		frame.getContentPane().add(lblAfraidOfSomething);
		
		final JRadioButton rdbtnNotAtAll = new JRadioButton("Not at all");
		rdbtnNotAtAll.setBackground(Color.WHITE);
		rdbtnNotAtAll.setBounds(187, 87, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll);
		
		final JRadioButton rdbtnSeveralDays = new JRadioButton("Several Days");
		rdbtnSeveralDays.setBackground(Color.WHITE);
		rdbtnSeveralDays.setBounds(296, 87, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays);
		
		final JRadioButton rdbtnMoreThanHalf = new JRadioButton("Half the days");
		rdbtnMoreThanHalf.setBackground(Color.WHITE);
		rdbtnMoreThanHalf.setBounds(423, 87, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf);
		
		final JRadioButton rdbtnAlmostDaily = new JRadioButton("Almost daily");
		rdbtnAlmostDaily.setBackground(Color.WHITE);
		rdbtnAlmostDaily.setBounds(606, 87, 96, 23);
		frame.getContentPane().add(rdbtnAlmostDaily);
		
		final JRadioButton rdbtnNotAtAll_1 = new JRadioButton("Not at all");
		rdbtnNotAtAll_1.setBackground(Color.WHITE);
		rdbtnNotAtAll_1.setBounds(187, 107, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_1);
		
		final JRadioButton rdbtnSeveralDays_2 = new JRadioButton("Several Days");
		rdbtnSeveralDays_2.setBackground(Color.WHITE);
		rdbtnSeveralDays_2.setBounds(296, 132, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_2);
		
		final JRadioButton rdbtnSeveralDays_1 = new JRadioButton("Several Days");
		rdbtnSeveralDays_1.setBackground(Color.WHITE);
		rdbtnSeveralDays_1.setBounds(296, 107, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_1);
		
		final JRadioButton rdbtnMoreThanHalf_1 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_1.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_1.setBounds(423, 107, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_1);
		
		final JRadioButton rdbtnAlmostDaily_1 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_1.setBackground(Color.WHITE);
		rdbtnAlmostDaily_1.setBounds(606, 107, 96, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_1);
		
		final JRadioButton rdbtnNotAtAll_2 = new JRadioButton("Not at all");
		rdbtnNotAtAll_2.setBackground(Color.WHITE);
		rdbtnNotAtAll_2.setBounds(187, 132, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_2);
		
		final JRadioButton rdbtnMoreThanHalf_2 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_2.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_2.setBounds(423, 132, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_2);
		
		final JRadioButton rdbtnAlmostDaily_2 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_2.setBackground(Color.WHITE);
		rdbtnAlmostDaily_2.setBounds(606, 132, 96, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_2);
		
		final JRadioButton rdbtnNotAtAll_3 = new JRadioButton("Not at all");
		rdbtnNotAtAll_3.setBackground(Color.WHITE);
		rdbtnNotAtAll_3.setBounds(187, 157, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_3);
		
		final JRadioButton rdbtnSeveralDays_3 = new JRadioButton("Several Days");
		rdbtnSeveralDays_3.setBackground(Color.WHITE);
		rdbtnSeveralDays_3.setBounds(296, 157, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_3);
		
		final JRadioButton rdbtnMoreThanHalf_3 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_3.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_3.setBounds(423, 157, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_3);
		
		final JRadioButton rdbtnAlmostDaily_3 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_3.setBackground(Color.WHITE);
		rdbtnAlmostDaily_3.setBounds(606, 157, 109, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_3);
		
		final JRadioButton rdbtnNotAtAll_4 = new JRadioButton("Not at all");
		rdbtnNotAtAll_4.setBackground(Color.WHITE);
		rdbtnNotAtAll_4.setBounds(187, 182, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_4);
		
		final JRadioButton rdbtnSeveralDays_4 = new JRadioButton("Several Days");
		rdbtnSeveralDays_4.setBackground(Color.WHITE);
		rdbtnSeveralDays_4.setBounds(296, 182, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_4);
		
		final JRadioButton rdbtnMoreThanHalf_4 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_4.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_4.setBounds(423, 182, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_4);
		
		final JRadioButton rdbtnAlmostDaily_4 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_4.setBackground(Color.WHITE);
		rdbtnAlmostDaily_4.setBounds(606, 182, 109, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_4);
		
		final JRadioButton rdbtnNotAtAll_5 = new JRadioButton("Not at all");
		rdbtnNotAtAll_5.setBackground(Color.WHITE);
		rdbtnNotAtAll_5.setBounds(187, 207, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_5);
		
		final JRadioButton rdbtnSeveralDays_5 = new JRadioButton("Several Days");
		rdbtnSeveralDays_5.setBackground(Color.WHITE);
		rdbtnSeveralDays_5.setBounds(296, 207, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_5);
		
		final JRadioButton rdbtnMoreThanHalf_5 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_5.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_5.setBounds(423, 207, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_5);
		
		final JRadioButton rdbtnAlmostDaily_5 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_5.setBackground(Color.WHITE);
		rdbtnAlmostDaily_5.setBounds(606, 207, 109, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_5);
		
		final JRadioButton rdbtnNotAtAll_6 = new JRadioButton("Not at all");
		rdbtnNotAtAll_6.setBackground(Color.WHITE);
		rdbtnNotAtAll_6.setBounds(187, 232, 77, 23);
		frame.getContentPane().add(rdbtnNotAtAll_6);
		
		final JRadioButton rdbtnSeveralDays_6 = new JRadioButton("Several Days");
		rdbtnSeveralDays_6.setBackground(Color.WHITE);
		rdbtnSeveralDays_6.setBounds(296, 232, 106, 23);
		frame.getContentPane().add(rdbtnSeveralDays_6);
		
		final JRadioButton rdbtnMoreThanHalf_6 = new JRadioButton("Half the days");
		rdbtnMoreThanHalf_6.setBackground(Color.WHITE);
		rdbtnMoreThanHalf_6.setBounds(423, 232, 165, 23);
		frame.getContentPane().add(rdbtnMoreThanHalf_6);
		
		final JRadioButton rdbtnAlmostDaily_6 = new JRadioButton("Almost daily");
		rdbtnAlmostDaily_6.setBackground(Color.WHITE);
		rdbtnAlmostDaily_6.setBounds(606, 232, 109, 23);
		frame.getContentPane().add(rdbtnAlmostDaily_6);
		bg1.add(rdbtnNotAtAll);
		bg1.add(rdbtnSeveralDays);
		bg1.add(rdbtnMoreThanHalf);
		bg1.add(rdbtnAlmostDaily);
		bg2.add(rdbtnNotAtAll_1);
		bg2.add(rdbtnSeveralDays_1);
		bg2.add(rdbtnMoreThanHalf_1);
		bg2.add(rdbtnAlmostDaily_1);
		bg3.add(rdbtnNotAtAll_2);
		bg3.add(rdbtnSeveralDays_2);
		bg3.add(rdbtnMoreThanHalf_2);
		bg3.add(rdbtnAlmostDaily_2);
		bg4.add(rdbtnNotAtAll_3);
		bg4.add(rdbtnSeveralDays_3);
		bg4.add(rdbtnMoreThanHalf_3);
		bg4.add(rdbtnAlmostDaily_3);
		bg5.add(rdbtnNotAtAll_4);
		bg5.add(rdbtnSeveralDays_4);
		bg5.add(rdbtnMoreThanHalf_4);
		bg5.add(rdbtnAlmostDaily_4);
		bg6.add(rdbtnNotAtAll_5);
		bg6.add(rdbtnSeveralDays_5);
		bg6.add(rdbtnMoreThanHalf_5);
		bg6.add(rdbtnAlmostDaily_5);
		bg7.add(rdbtnNotAtAll_6);
		bg7.add(rdbtnSeveralDays_6);
		bg7.add(rdbtnMoreThanHalf_6);
		bg7.add(rdbtnAlmostDaily_6);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {String d1,a1,p1;
				try
				{ 
				if(rdbtnNotAtAll.isSelected()) score+=0;
				if(rdbtnSeveralDays.isSelected()) score+=1;
				if(rdbtnMoreThanHalf.isSelected())score+=2;
				if(rdbtnAlmostDaily.isSelected()) score+=3;
				if(rdbtnNotAtAll_1.isSelected()) score+=0;
				if(rdbtnSeveralDays_2.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_1.isSelected())score+=2;
				if(rdbtnAlmostDaily_1.isSelected()) score+=3;
				if(rdbtnNotAtAll_2.isSelected()) score+=0;
				if(rdbtnSeveralDays_1.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_2.isSelected())score+=2;
				if(rdbtnAlmostDaily_2.isSelected()) score+=3;
				if(rdbtnNotAtAll_3.isSelected()) score+=0;
				if(rdbtnSeveralDays_3.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_3.isSelected())score+=2;
				if(rdbtnAlmostDaily_3.isSelected()) score+=3;
				if(rdbtnNotAtAll_4.isSelected()) score+=0;
				if(rdbtnSeveralDays_4.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_4.isSelected())score+=2;
				if(rdbtnAlmostDaily_4.isSelected()) score+=3;
				if(rdbtnNotAtAll_5.isSelected()) score+=0;
				if(rdbtnSeveralDays_5.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_5.isSelected())score+=2;
				if(rdbtnAlmostDaily_5.isSelected()) score+=3;
				if(rdbtnNotAtAll_6.isSelected()) score+=0;
				if(rdbtnSeveralDays_6.isSelected()) score+=1;
				if(rdbtnMoreThanHalf_6.isSelected())score+=2;
				if(rdbtnAlmostDaily_6.isSelected()) score+=3;
				if(score>=0 && score<=5)
				{
					if(dep==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'No'"+","+"'"+d1+"'"+");");
					}
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Anxiety is unlikely");
					else{
					s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'No'"+","+"'NA'"+");");}
					//bw.write("Anxiety is unlikely");
					//anx=false;
				}
				else if(score>=6 && score<=9)
				{
					if(dep==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'No'"+","+"'"+d1+"'"+");");
					}
					//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Mild Anxiety is likely");
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'No'"+","+"'NA'"+");");}
					//bw.write("Mild Anxiety is likely");
					//anx=false;
				}
				else if(score>=10 && score<=14)
				{
					
					if(dep==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'Yes'"+","+"'"+d1+"'"+");");
					}//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Moderate Anxiety is likely");
					else{s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'Yes'"+","+"'NA'"+");");}
					//bw.write("Moderate Anxiety is likely");
					//anx=true;
				}
				else if(score>=15)
				{
					if(dep==true||ptsd==true)
					{
						s=c.createStatement();
						rs=s.executeQuery("select * from FinalDiagnosis where id ="+"'"+ssn+"';");
						p1=rs.getString("ptsd");
						a1=rs.getString("anx");
						d1=rs.getString("depr");
						s.executeUpdate("delete from Tests where id="+"'"+ssn+"'");
						s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
						s.executeUpdate("delete from FinalDiagnosis where id ="+"'"+ssn+"';");
						s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'"+p1+"'"+","+"'Yes'"+","+"'"+d1+"'"+");");
					}
					else
						{//JOptionPane.showMessageDialog(null,score);
					//JOptionPane.showMessageDialog(null,"Severe Anxiety is likely");
					s=c.createStatement();
					s.executeUpdate("insert into Tests values("+"'"+ssn+"'"+","+p+","+a+","+d+");");
					s.executeUpdate("insert into FinalDiagnosis values("+"'"+ssn+"'"+","+"'NA'"+","+"'Yes'"+","+"'NA')"+";");}
					//bw.write("Severe Anxiety is likely");
					//anx=true;
				}
				//rs.close();c.close();
				//bw.close();
				g=new GenerateReports(ssn,ptsd,anx,dep);
				frame.dispose();
				
			}
				catch(Exception e1){ 
					e1.printStackTrace();}
				}
			
		});
		btnSubmit.setBounds(256, 312, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblAnswerAccordingTo = new JLabel("Answer according to how regularly you have been experiencing these symptoms over the last few weeks");
		lblAnswerAccordingTo.setBounds(24, 51, 654, 14);
		frame.getContentPane().add(lblAnswerAccordingTo);
	}

}
