import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
class loform1 extends Frame implements ActionListener
{
Button ins,del,vie,upd,signup;
TextField tfun,tfuln,tfdob,tfp,tfrp,tfg;
Label use,las,dob,gen,pas,rpa;
public loform1()
{
use=new Label("First Name");
use.setBounds(20,30,100,30);
tfun=new TextField(20);
tfun.setBounds(140,30,100,30);
las=new Label("Last Name");
las.setBounds(260,30,100,30);
tfuln=new TextField(20);
tfuln.setBounds(380,30,100,30);
dob=new Label("Date Of Birth");
dob.setBounds(20,60,100,30);
tfdob=new TextField(20);
tfdob.setBounds(140,60,100,30);
gen=new Label("Gender");
gen.setBounds(20,90,100,30);
tfg=new TextField(20);
tfg.setBounds(140,90,100,30);
pas=new Label("Eneter Password");
pas.setBounds(20,120,100,30);
tfp=new TextField(20);
tfp.setBounds(140,120,100,30);
rpa=new Label("Re-Enter Password");
rpa.setBounds(20,150,100,30);
tfrp=new TextField(20);
tfrp.setBounds(140,150,100,30);
del=new Button("delete");
del.setBounds(150,300,100,30);
vie=new Button("view");
vie.setBounds(250,300,100,30);
upd=new Button("update");
upd.setBounds(150,330,100,30);
ins=new Button("insert");
ins.setBounds(250,330,100,30);
signup=new Button("Sign-up");
signup.setBounds(100,185,60,30);
setLayout(null);
add(use);
add(tfun);
add(las);
add(tfuln);
add(dob);
add(tfdob);
add(gen);
add(tfg);
add(pas);
add(tfp);
add(rpa);
add(tfrp);
add(signup);
add(ins);
add(del);
add(vie);
add(upd);
setSize(500,500);
setVisible(true);
ins.addActionListener(this);
del.addActionListener(this);
vie.addActionListener(this);
upd.addActionListener(this);
signup.addActionListener(this);
}
public void actionPerformed(ActionEvent a)
{
String as=a.getActionCommand();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:srb","","");

	if(as.equals("insert"))
	{
				String str="insert into up1(user_name,name,password,dob,last_name,gender) values (?,?,?,?,?,?)";
				PreparedStatement stmt=con.prepareStatement(str);
				stmt.setString(1,tfun.getText());
				stmt.setString(2,tfun.getText());
				stmt.setInt(3,Integer.parseInt(tfp.getText()));
				stmt.setString(4,tfdob.getText());
				stmt.setString(5,tfuln.getText());
				stmt.setString(6,tfg.getText());
				int x=stmt.executeUpdate();
					System.out.print("Record added sucessfuly");
				
				con.close();
			
	}

		if(as.equals("Sign-up"))
	{
				String str="insert into up1(user_name,name,password,dob,last_name,gender) values (?,?,?,?,?,?)";
				PreparedStatement stmt=con.prepareStatement(str);
				stmt.setString(1,tfun.getText());
				stmt.setString(2,tfun.getText());
				stmt.setInt(3,Integer.parseInt(tfp.getText()));
				stmt.setString(4,tfdob.getText());
				stmt.setString(5,tfuln.getText());
				stmt.setString(6,tfg.getText());
				int x=stmt.executeUpdate();
					System.out.print("You signed-up sucessfuly");
				
				con.close();
			
	}


		if(as.equals("delete"))
	{			int i;
				String s;
				String str="delete from up1 where user_name=? and password=?";
				PreparedStatement stmt=con.prepareStatement(str);
				stmt.setString(1,tfun.getText());
				stmt.setInt(2,Integer.parseInt(tfp.getText()));
				//tf.getTexst();
				//stmt.setInt(2,Integer.parseInt(tfp.getText()));
				int x=stmt.executeUpdate();
					System.out.print("Record deleted sucessfuly");
				
				con.close();
			
	}

		if(as.equals("view"))
	{
				String str="select *from up1 where user_name=?";
				PreparedStatement stmt=con.prepareStatement(str);
				stmt.setString(1,tfun.getText());
				ResultSet rs =stmt.executeQuery();
				while(rs.next())
				{
					tfuln.setText(rs.getString("last_name"));
					tfun.setText(rs.getString("name"));
					tfg.setText(rs.getString("gender"));
					int p=rs.getInt("password");
					tfp.setText((Integer.toString(p)));
					tfdob.setText(rs.getString("dob"));
					System.out.print("Record viewed sucessfuly");
				}
				con.close();
			
	}
			if(as.equals("update"))
	{			int i;
				String s;
				String str="update up1 set user_name=? where password=?";
				PreparedStatement stmt=con.prepareStatement(str);
				stmt.setString(1,tfun.getText());
				stmt.setInt(2,Integer.parseInt(tfp.getText()));
				int x=stmt.executeUpdate();
				System.out.print("Record updated sucessfuly");
				
				con.close();
			
	}

}
catch(Exception ex)	{
				System.out.println("Error occured");
				System.out.println("Error:"+ex);
			}


}
public static void main(String s[])
{
loform1 o=new loform1();
}
}					
	
				
