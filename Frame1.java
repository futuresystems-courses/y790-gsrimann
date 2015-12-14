import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.io.*;
import java.sql.*;
import java.awt.Color;

public class Frame1 {
    static File f1;
	private JFrame frame;
	ButtonGroup bg1=new ButtonGroup();
	ButtonGroup bg2=new ButtonGroup();
	ButtonGroup bg3=new ButtonGroup();
	ButtonGroup bg4=new ButtonGroup();
	ButtonGroup bg5=new ButtonGroup();
	ButtonGroup bg6=new ButtonGroup();
	ButtonGroup bg7=new ButtonGroup();
	ButtonGroup bg8=new ButtonGroup();
	ButtonGroup bg9=new ButtonGroup();
	ButtonGroup bg10=new ButtonGroup();
	ButtonGroup bg11=new ButtonGroup();
	int ptsd=0,anx=0,depr=0,adhd=0,schiz=0;
	double pt=1.0,pf=1.0,ant=1.0,anf=1.0,dt=1.0,df=1.0;
	static String ssn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1(ssn);
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
	public Frame1(String ssn) {
		        this.ssn=ssn;
				initialize();
				c=sqliteConnection.dbconnector(this.getClass().getResource("/Diagnosis.db").toString());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 490);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JLabel lblRecentTraumaLike = new JLabel("Recent combat exposure?");
		lblRecentTraumaLike.setBounds(128, 69, 184, 19);
		frame.getContentPane().add(lblRecentTraumaLike);
		
		JLabel lblExperiences = new JLabel("Experiences");
		lblExperiences.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblExperiences.setBounds(264, 11, 92, 23);
		frame.getContentPane().add(lblExperiences);
		
		JLabel lblNewLabel = new JLabel("Abuse?");
		lblNewLabel.setBounds(128, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Recent Accident?");
		lblNewLabel_1.setBounds(128, 120, 149, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mugging or Threat?");
		lblNewLabel_2.setBounds(128, 145, 149, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" Natural Disaster?");
		lblNewLabel_3.setBounds(128, 174, 149, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Recent Critical Diagnosis?");
		lblNewLabel_4.setBounds(128, 199, 149, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Kidnapping?");
		lblNewLabel_5.setBounds(128, 223, 149, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Torture?");
		lblNewLabel_6.setBounds(128, 248, 149, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Victim of terrorism?");
		lblNewLabel_7.setBounds(128, 273, 167, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Failure at work/exam?");
		lblNewLabel_8.setBounds(128, 298, 184, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Relationship Failure?");
		lblNewLabel_9.setBounds(128, 323, 135, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		final JRadioButton ct = new JRadioButton("Yes");
		ct.setBackground(Color.WHITE);
		ct.setBounds(380, 67, 57, 23);
		frame.getContentPane().add(ct);
		
		JRadioButton cf = new JRadioButton("No");
		cf.setBackground(Color.WHITE);
		cf.setBounds(452, 67, 57, 23);
		frame.getContentPane().add(cf);
		
		final JRadioButton at = new JRadioButton("Yes");
		at.setBackground(Color.WHITE);
		at.setBounds(380, 91, 57, 23);
		frame.getContentPane().add(at);
		
		JRadioButton af = new JRadioButton("No");
		af.setBackground(Color.WHITE);
		af.setBounds(452, 91, 57, 23);
		frame.getContentPane().add(af);
		
		final JRadioButton rat = new JRadioButton("Yes");
		rat.setBackground(Color.WHITE);
		rat.setBounds(380, 116, 57, 23);
		frame.getContentPane().add(rat);
		
		final JRadioButton mtt = new JRadioButton("Yes");
		mtt.setBackground(Color.WHITE);
		mtt.setBounds(380, 141, 57, 23);
		frame.getContentPane().add(mtt);
		
		final JRadioButton ndt = new JRadioButton("Yes");
		ndt.setBackground(Color.WHITE);
		ndt.setBounds(380, 170, 57, 23);
		frame.getContentPane().add(ndt);
		
		final JRadioButton rct = new JRadioButton("Yes");
		rct.setBackground(Color.WHITE);
		rct.setBounds(380, 195, 57, 23);
		frame.getContentPane().add(rct);
		
		final JRadioButton kt = new JRadioButton("Yes");
		kt.setBackground(Color.WHITE);
		kt.setBounds(380, 219, 57, 23);
		frame.getContentPane().add(kt);
		
		final JRadioButton tort = new JRadioButton("Yes");
		tort.setBackground(Color.WHITE);
		tort.setBounds(380, 244, 57, 23);
		frame.getContentPane().add(tort);
		
		final JRadioButton vtt = new JRadioButton("Yes");
		vtt.setBackground(Color.WHITE);
		vtt.setBounds(380, 269, 57, 23);
		frame.getContentPane().add(vtt);
		
		final JRadioButton ft = new JRadioButton("Yes");
		ft.setBackground(Color.WHITE);
		ft.setBounds(380, 294, 57, 23);
		frame.getContentPane().add(ft);
		
		final JRadioButton rft = new JRadioButton("Yes");
		rft.setBackground(Color.WHITE);
		rft.setBounds(380, 319, 57, 23);
		frame.getContentPane().add(rft);
		
		JRadioButton raf = new JRadioButton("No");
		raf.setBackground(Color.WHITE);
		raf.setBounds(452, 116, 57, 23);
		frame.getContentPane().add(raf);
		
		JRadioButton mtf = new JRadioButton("No");
		mtf.setBackground(Color.WHITE);
		mtf.setBounds(452, 141, 57, 23);
		frame.getContentPane().add(mtf);
		
		JRadioButton ndf = new JRadioButton("No");
		ndf.setBackground(Color.WHITE);
		ndf.setBounds(452, 170, 57, 23);
		frame.getContentPane().add(ndf);
		
		JRadioButton rcf = new JRadioButton("No");
		rcf.setBackground(Color.WHITE);
		rcf.setBounds(452, 195, 57, 23);
		frame.getContentPane().add(rcf);
		
		JRadioButton kf = new JRadioButton("No");
		kf.setBackground(Color.WHITE);
		kf.setBounds(452, 219, 57, 23);
		frame.getContentPane().add(kf);
		
		JRadioButton torf = new JRadioButton("No");
		torf.setBackground(Color.WHITE);
		torf.setBounds(452, 244, 57, 23);
		frame.getContentPane().add(torf);
		
		JRadioButton vtf = new JRadioButton("No");
		vtf.setBackground(Color.WHITE);
		vtf.setBounds(452, 269, 57, 23);
		frame.getContentPane().add(vtf);
		
		JRadioButton ff = new JRadioButton("No");
		ff.setBackground(Color.WHITE);
		ff.setBounds(452, 294, 57, 23);
		frame.getContentPane().add(ff);
		
		JRadioButton rff = new JRadioButton("No");
		rff.setBackground(Color.WHITE);
		rff.setBounds(452, 319, 57, 23);
		frame.getContentPane().add(rff);
		JButton btnSubmit = new JButton("Submit");
		bg1.add(ct);
		bg1.add(cf);
		bg2.add(at);
		bg2.add(af);
		bg3.add(rat);
		bg3.add(raf);
		bg4.add(mtt);
		bg4.add(mtf);
		bg5.add(ndt);
		bg5.add(ndf);
		bg6.add(rct);
		bg6.add(rcf);
		bg7.add(kt);
		bg7.add(kf);
		bg8.add(tort);
		bg8.add(torf);
		bg9.add(vtt);
		bg9.add(vtf);
		bg10.add(ft);
		bg10.add(ff);
		bg11.add(rft);
		bg11.add(rff);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double nc=0,tot=0;
				try
				{

				try {
					stmt=c.createStatement();
					String s="insert into Experience values ("+"'"+ssn+"'"+","+(ct.isSelected()?1:0)+","+(at.isSelected()?1:0)+","+(rat.isSelected()?1:0)+","
					+(mtt.isSelected()?1:0)+","+(ndt.isSelected()?1:0)+","+(rct.isSelected()?1:0)+","+(kt.isSelected()?1:0)+","+
							(tort.isSelected()?1:0)+","+(vtt.isSelected()?1:0)+","+(ft.isSelected()?1:0)+","+(rft.isSelected()?1:0)+");";
				    stmt.executeUpdate(s);
		rs=stmt.executeQuery("select count(id) from Experience where combat="+(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
		//while(rs.next()) nc=rs.getRow();
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
		tot=rs.getInt(1);
		//JOptionPane.showMessageDialog(null,"Cases:"+nc+"Total"+tot);
		//while(rs.next()) tot=rs.getRow();
		if(nc!=0 && tot!=0) pt*=(nc/tot);
		//JOptionPane.showMessageDialog(null,"PTSD:"+pt*10+"\nAnxiety:"+ant*10+"\nDepression:"+dt*10);
	    
	   rs=stmt.executeQuery("select count(id) from Experience where combat=" +(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
	   nc=rs.getInt(1);
	   rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
	   tot=rs.getInt(1);
	   if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where abuse="+(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where abuse=" +(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) pt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) pf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where mugging="+(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
			nc=rs.getInt(1);
					rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
					tot=rs.getInt(1);
					if(nc!=0&& tot!=0) pt*=(nc/tot);
					rs=stmt.executeQuery("select count(id) from Experience where mugging=" +(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
					nc=rs.getInt(1);
				 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
				 tot=rs.getInt(1);
				 if(nc!=0&& tot!=0) pf*=nc/tot;
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
				nc=rs.getInt(1);
				rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
				 tot=rs.getInt(1);
				 if(nc!=0&& tot!=0) pt*=(nc/tot);
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
				nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) pt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
			nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where terror="+(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where terror=" +(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pt*=(nc/tot);
		 rs=stmt.executeQuery("select count(id) from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail="+(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='Yes');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='Yes';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) pt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail=" +(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where ptsd='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) pf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where combat="+(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id)from FinalDiagnosis where depr='Yes';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) dt*=(nc/tot);
	   rs=stmt.executeQuery("select count(id) from Experience where combat=" +(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
	   nc=rs.getInt(1);
	   rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
	   tot=rs.getInt(1);
	   if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where abuse="+(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) dt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where abuse=" +(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) dt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) df*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where mugging="+(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
			nc=rs.getInt(1);
					rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
					tot=rs.getInt(1);
					if(nc!=0&& tot!=0) dt*=(nc/tot);
					rs=stmt.executeQuery("select count(id) from Experience where mugging=" +(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
					nc=rs.getInt(1);
				 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
				 tot=rs.getInt(1);
				 if(nc!=0&& tot!=0) df*=nc/tot;
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
				nc=rs.getInt(1);
				rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
				tot=rs.getInt(1);
				if(nc!=0&& tot!=0) dt*=(nc/tot);
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
				nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) df*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) dt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) df*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) dt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where ptsd='No');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) df*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) dt*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
			nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where terror="+(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
		tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) dt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where terror=" +(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) dt*=(nc/tot);
		 rs=stmt.executeQuery("select count(id) from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail="+(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='Yes');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='Yes';");
		tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) dt*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail=" +(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where depr='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where depr='No';");
		tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) df*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where combat="+(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) ant*=(nc/tot);
	   rs=stmt.executeQuery("select count(id) from Experience where combat=" +(ct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
	   nc=rs.getInt(1);
	   rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
	  tot=rs.getInt(1);
	   if(nc!=0&& tot!=0) anf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where abuse="+(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) ant*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where abuse=" +(at.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) anf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) ant*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where accident="+(rat.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) anf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where mugging="+(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
			nc=rs.getInt(1);
					rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
					tot=rs.getInt(1);
					if(nc!=0&& tot!=0) ant*=(nc/tot);
					rs=stmt.executeQuery("select count(id) from Experience where mugging=" +(mtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
					nc=rs.getInt(1);
				 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
				tot=rs.getInt(1);
				 if(nc!=0&& tot!=0) anf*=nc/tot;
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
				nc=rs.getInt(1);
				rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
				tot=rs.getInt(1);
				if(nc!=0&& tot!=0) ant*=(nc/tot);
				rs=stmt.executeQuery("select count(id) from Experience where disaster="+(ndt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
				nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) anf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) ant*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where diagnosis="+(rct.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
			nc=rs.getInt(1);
			rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
			tot=rs.getInt(1);
			if(nc!=0&& tot!=0) anf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) ant*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where kidnap="+(kt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) anf*=nc/tot;
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
			nc=rs.getInt(1);
			 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
			 tot=rs.getInt(1);
			 if(nc!=0&& tot!=0) ant*=(nc/tot);
			rs=stmt.executeQuery("select count(id) from Experience where torture="+(tort.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
			nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) anf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where terror="+(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) ant*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where terror=" +(vtt.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) anf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
		 tot=rs.getInt(1);
		 if(nc!=0&& tot!=0) ant*=(nc/tot);
		 rs=stmt.executeQuery("select count(id)d from Experience where work_fail="+(ft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
		 nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) anf*=nc/tot;
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail="+(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='Yes');");
		nc=rs.getInt(1);
		rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='Yes';");
		tot=rs.getInt(1);
		if(nc!=0&& tot!=0) ant*=(nc/tot);
		rs=stmt.executeQuery("select count(id) from Experience where rel_fail=" +(rft.isSelected()?1:0)+" and id in (select id from FinalDiagnosis where anx='No');");
		nc=rs.getInt(1);
		 rs=stmt.executeQuery("select count(id) from FinalDiagnosis where anx='No';");
		 tot=rs.getInt(1);
		  if(nc!=0&& tot!=0) anf*=nc/tot;
		  rs.close();
		  c.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
				//JOptionPane.showMessageDialog(null,"Scores are: Ptsd:"+ptsd+" Anxiety:"+anx+" Depression:"+depr);
				Environment env=new Environment(ptsd,anx,depr,adhd,schiz,ssn,pt,pf,ant,anf,dt,df);
				
				
				frame.dispose();
				//env.setVisible(true);
			}
		});
		btnSubmit.setBounds(312, 417, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblAnswerAccordingTo = new JLabel("Answer according to whether or not you have experienced any of these events recently");
		lblAnswerAccordingTo.setBounds(20, 40, 555, 14);
		frame.getContentPane().add(lblAnswerAccordingTo);
	}

}
