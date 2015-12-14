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
import java.sql.*;
import java.awt.Color;
public class Environment {
    static File f1;
    String ssn;
	private JFrame frame;
    ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    ButtonGroup bg3=new ButtonGroup();
    ButtonGroup bg4=new ButtonGroup();
    ButtonGroup bg5=new ButtonGroup();
    ButtonGroup bg6=new ButtonGroup();
    int ptsd,anx,adhd,schiz,depr;
    double pt,pf,ant,anf,dt,df;
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Environment window = new Environment(ptsd,anx,depr,adhd,schiz,ssn,pt,pf,ant,anf,dt,df);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
  Connection c=null;
  Statement stmt=null;
  ResultSet rs=null;
	/**
	 * Create the application.
	 */
	public Environment(int ptsd,int anx,int depr,int adhd,int schiz,String ssn, double pt,double pf,double ant, double anf,double dt,double df) {
		this.ptsd=ptsd;
		this.anx=anx;
		this.depr=depr;
		this.adhd=adhd;
		this.schiz=schiz;
		this.ssn=ssn;
		this.pt=pt;this.pf=pf;
		this.ant=ant; this.anf=anf;
		this.dt=dt;this.df=df;
		c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 624, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
        frame.setVisible(true);		
		JLabel lblEnvironmentalFactors = new JLabel("Environment");
		lblEnvironmentalFactors.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnvironmentalFactors.setBounds(239, 11, 144, 14);
		frame.getContentPane().add(lblEnvironmentalFactors);
		
		JLabel lblNewLabel = new JLabel("Constant trauma?");
		lblNewLabel.setBounds(64, 71, 219, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblRecentDeathOf = new JLabel("Death of relative?");
		lblRecentDeathOf.setBounds(65, 96, 200, 14);
		frame.getContentPane().add(lblRecentDeathOf);
		
		
		
		JLabel lblChildhoodNeglect = new JLabel("Childhood Neglect?");
		lblChildhoodNeglect.setBounds(65, 121, 188, 14);
		frame.getContentPane().add(lblChildhoodNeglect);
		
		JLabel lblProblemsAtHome = new JLabel("Problems at Home?");
		lblProblemsAtHome.setBounds(65, 146, 176, 14);
		frame.getContentPane().add(lblProblemsAtHome);
		
		
		
		JLabel lblStressfulWorkConditions = new JLabel("Stressful Work?");
		lblStressfulWorkConditions.setBounds(65, 171, 188, 14);
		frame.getContentPane().add(lblStressfulWorkConditions);
		
		
		
		
		final JRadioButton b1 = new JRadioButton("Yes");
		b1.setBackground(Color.WHITE);
		b1.setBounds(308, 67, 56, 23);
		frame.getContentPane().add(b1);
		
		final JRadioButton b2 = new JRadioButton("No");
		b2.setBackground(Color.WHITE);
		b2.setBounds(366, 67, 56, 23);
		frame.getContentPane().add(b2);
		
		final JRadioButton b3 = new JRadioButton("Yes");
		b3.setBackground(Color.WHITE);
		b3.setBounds(308, 92, 56, 23);
		frame.getContentPane().add(b3);
		
		final JRadioButton b4 = new JRadioButton("No");
		b4.setBackground(Color.WHITE);
		b4.setBounds(366, 92, 56, 23);
		frame.getContentPane().add(b4);
		
		final JRadioButton b5 = new JRadioButton("Yes");
		b5.setBackground(Color.WHITE);
		b5.setBounds(308, 117, 56, 23);
		frame.getContentPane().add(b5);
		
		final JRadioButton b6 = new JRadioButton("No");
		b6.setBackground(Color.WHITE);
		b6.setBounds(366, 117, 56, 23);
		frame.getContentPane().add(b6);
		
		final JRadioButton b7 = new JRadioButton("Yes");
		b7.setBackground(Color.WHITE);
		b7.setBounds(308, 142, 56, 23);
		frame.getContentPane().add(b7);
		
		final JRadioButton b8 = new JRadioButton("No");
		b8.setBackground(Color.WHITE);
		b8.setBounds(366, 142, 56, 23);
		frame.getContentPane().add(b8);
		
		final JRadioButton b9 = new JRadioButton("Yes");
		b9.setBackground(Color.WHITE);
		b9.setBounds(308, 167, 56, 23);
		frame.getContentPane().add(b9);
		
		final JRadioButton b10 = new JRadioButton("No");
		b10.setBackground(Color.WHITE);
		b10.setBounds(366, 167, 56, 23);
		frame.getContentPane().add(b10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {double nc=0,tot=0;

				try {
					stmt=c.createStatement();
					String s="insert into Environment values ("+"'"+ssn+"'"+","+(b1.isSelected()?1:0)+","+(b3.isSelected()?1:0)+","
					+(b5.isSelected()?1:0)+","+(b7.isSelected()?1:0)+","+(b9.isSelected()?1:0)+");";
				    stmt.executeUpdate(s);
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id)d from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id)d from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id)d from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id)d from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id)d from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) ant*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) anf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) ant*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) anf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) ant*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) anf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) ant*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) anf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) ant*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) anf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where trauma="+(b1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id)d from Environment where death="+(b3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id)d from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where neglect="+(b5.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id)d from Environment where prob_home="+(b7.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Environment where work_stress="+(b9.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs.close();
				    c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(null,"Scores are: Ptsd:"+ptsd+" Anxiety:"+anx+" Depression:"+depr);
				frame.dispose();
				MedicalHistory med=new MedicalHistory(ptsd,anx,depr,adhd,schiz,ssn,pt,pf,ant,anf,dt,df);
				
			}
		});
		btnSubmit.setBounds(239, 280, 89, 23);
		frame.getContentPane().add(btnSubmit);
		bg1.add(b1);
		bg1.add(b2);
		bg2.add(b3);
		bg2.add(b4);
		bg3.add(b5);
		bg3.add(b6);
		bg4.add(b7);
		bg4.add(b8);
		bg5.add(b9);
		bg5.add(b10);
		
		JLabel lblAnswerWithRespect = new JLabel("Answer with respect to your environment at home/work");
		lblAnswerWithRespect.setBounds(64, 36, 404, 14);
		frame.getContentPane().add(lblAnswerWithRespect);
		
	}
}
