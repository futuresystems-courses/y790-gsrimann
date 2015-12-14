import java.net.URL;
import java.sql.*;

import javax.swing.*;
public class sqliteConnection {
Connection c=null;
public static Connection dbconnector(String url)
{
	try
	{Class.forName("org.sqlite.JDBC");
	//Connection c=DriverManager.getConnection("jdbc:sqlite:C:\\Program Files (x86)\\Diagnosis\\Database\\Diagnosis.db");
    Connection c=DriverManager.getConnection("jdbc:sqlite::resource:"+url);
	//JOptionPane.showMessageDialog(null, "Successful Connection");
	return c;		
	}
	catch(Exception e1)
	{
		e1.printStackTrace();return null;
	}
}
}
