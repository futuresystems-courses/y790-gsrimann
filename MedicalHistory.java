import java.awt.EventQueue;
import java.text.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import java.io.*;
import java.sql.*;
import java.awt.Color;
public class MedicalHistory {
    static File f1,f2;
    String ssn;
	private JFrame frame;
	int ptsd,anx,adhd,schiz,depr;
	double pt,pf,at,af,dt,df;
	boolean p1=false,a1=false,d1=false;
	Menu m;
	PTSD1 p;
	Anxiety a;
	Depression d;
	ButtonGroup bg1=new ButtonGroup();
    ButtonGroup bg2=new ButtonGroup();
    ButtonGroup bg3=new ButtonGroup();
    ButtonGroup bg4=new ButtonGroup();
    ButtonGroup bg5=new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicalHistory window = new MedicalHistory(ptsd,anx,depr,adhd,schiz,ssn,pt,pf,at,af,dt,df);
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
	public MedicalHistory(int ptsd,int anx,int depr,int adhd,int schiz,String ssn,double pt,double pf,double at,double af,double dt,double df) {
		this.ptsd=ptsd;
		this.anx=anx;
		this.depr=depr;
		this.adhd=adhd;
		this.schiz=schiz;
		this.ssn=ssn;
		this.pt=pt; this.pf=pf;
		this.at=at;this.af=af;
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
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 677, 455);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("Medical History");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(284, 11, 101, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSubstanceAbuse = new JLabel("Substance Abuse");
		lblSubstanceAbuse.setBounds(25, 90, 133, 14);
		frame.getContentPane().add(lblSubstanceAbuse);
		
		final JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBackground(Color.WHITE);
		rdbtnYes.setBounds(366, 86, 51, 23);
		frame.getContentPane().add(rdbtnYes);
		
		final JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(419, 86, 51, 23);
		frame.getContentPane().add(rdbtnNo);
		
	    JLabel lblDepression = new JLabel("Depression");
		lblDepression.setBounds(25, 115, 89, 14);
		frame.getContentPane().add(lblDepression);
		
		final JRadioButton rdbtnYes_1 = new JRadioButton("Yes");
		rdbtnYes_1.setBackground(Color.WHITE);
		rdbtnYes_1.setBounds(366, 111, 51, 23);
		frame.getContentPane().add(rdbtnYes_1);
		
		final JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBackground(Color.WHITE);
		rdbtnNo_1.setBounds(419, 111, 51, 23);
		frame.getContentPane().add(rdbtnNo_1);
		
		JLabel lblAnxiety = new JLabel("Anxiety");
		lblAnxiety.setBounds(25, 140, 46, 14);
		frame.getContentPane().add(lblAnxiety);
		
		final JRadioButton rdbtnYes_2 = new JRadioButton("Yes");
		rdbtnYes_2.setBackground(Color.WHITE);
		rdbtnYes_2.setBounds(366, 136, 51, 23);
		frame.getContentPane().add(rdbtnYes_2);
		
		final JRadioButton rdbtnNo_2 = new JRadioButton("No");
		rdbtnNo_2.setBackground(Color.WHITE);
		rdbtnNo_2.setBounds(419, 136, 51, 23);
		frame.getContentPane().add(rdbtnNo_2);
		
		JLabel lblOtherMentalIllness = new JLabel("Other mental illness");
		lblOtherMentalIllness.setBounds(25, 165, 201, 14);
		frame.getContentPane().add(lblOtherMentalIllness);
		
		final JRadioButton rdbtnYes_3 = new JRadioButton("Yes");
		rdbtnYes_3.setBackground(Color.WHITE);
		rdbtnYes_3.setBounds(366, 161, 51, 23);
		frame.getContentPane().add(rdbtnYes_3);
		
		final JRadioButton rdbtnNo_3 = new JRadioButton("No");
		rdbtnNo_3.setBackground(Color.WHITE);
		rdbtnNo_3.setBounds(419, 161, 51, 23);
		frame.getContentPane().add(rdbtnNo_3);
		
		JLabel lblFamilyHistoryOf = new JLabel("Family history of PTSD/Depression");
		lblFamilyHistoryOf.setBounds(25, 190, 230, 14);
		frame.getContentPane().add(lblFamilyHistoryOf);
		
		final JRadioButton rdbtnYes_4 = new JRadioButton("Yes");
		rdbtnYes_4.setBackground(Color.WHITE);
		rdbtnYes_4.setBounds(366, 186, 51, 23);
		frame.getContentPane().add(rdbtnYes_4);
		
		final JRadioButton rdbtnNo_4 = new JRadioButton("No");
		rdbtnNo_4.setBackground(Color.WHITE);
		rdbtnNo_4.setBounds(419, 186, 51, 23);
		frame.getContentPane().add(rdbtnNo_4);
		bg1.add(rdbtnNo);
		bg1.add(rdbtnYes);
		bg2.add(rdbtnNo_1);
		bg2.add(rdbtnYes_1);
		bg3.add(rdbtnNo_2);
		bg3.add(rdbtnYes_2);
		bg4.add(rdbtnNo_3);
		bg4.add(rdbtnYes_3);
		bg5.add(rdbtnNo_4);
		bg5.add(rdbtnYes_4);
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(285, 325, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblAnswerWithRespect = new JLabel("Answer w.r.t. medical history");
		lblAnswerWithRespect.setBounds(127, 45, 258, 14);
		frame.getContentPane().add(lblAnswerWithRespect);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double lp=0,ld=0,la=0;
				try
				{   
                try {double nc=0,tot=0;
                     
					stmt=c.createStatement();
					String s="insert into Medical values ("+"'"+ssn+"'"+","+(rdbtnYes.isSelected()?1:0)+","+(rdbtnYes_1.isSelected()?1:0)+","
					+(rdbtnYes_2.isSelected()?1:0)+","+(rdbtnYes_3.isSelected()?1:0)+","+(rdbtnYes_4.isSelected()?1:0)+");";
				    stmt.executeUpdate(s);
				   rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) pf*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) dt*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) df*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) at*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where substance="+(rdbtnYes.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) af*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) at*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where anx="+(rdbtnYes_1.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) af*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) at*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where depr="+(rdbtnYes_2.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) af*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) at*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where others="+(rdbtnYes_3.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) af*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) at*=nc/tot;
				    rs=stmt.executeQuery("select count(id) from Medical where fam_hist="+(rdbtnYes_4.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				    nc=rs.getInt(1);
				    rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				    tot=rs.getInt(1);
				    if(nc!=0&& tot!=0) af*=nc/tot;
				    rs.close();c.close();
				    lp=(pt/(pt+pf))*100;
				    ld=(dt/(dt+df))*100;
				    la=(at/(at+af))*100;
				    NumberFormat form=new DecimalFormat("#0.00");
				    JOptionPane.showMessageDialog(null,"PTSD:"+form.format(lp)+"\nAnxiety:"+form.format(la)+"\nDepression:"+form.format(ld));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                }
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				if(lp>ld)
				{
					if(lp>la)
						{//bw1.write("PTSD\n");
						p1=true;
						p=new PTSD1(ssn,p1,d1,a1);}
					else
						{//bw1.write("Anxiety\n");
						a1=true;
						a=new Anxiety(ssn,p1,d1,a1);}
					
				}
				else
				{
					if(ld>la)
						{//bw1.write("Depression\n");
						d1=true;
						d=new Depression(ssn,p1,d1,a1);}
					else
						{//bw1.write("Anxiety\n");
						a1=true;
						a=new Anxiety(ssn,p1,d1,a1);}
					
				}
                //JOptionPane.showMessageDialog(null,"Scores are: Ptsd:"+ptsd+" Anxiety:"+anx+" Depression:"+depr);
                frame.dispose();
               
			}
		});
		
	}
}
