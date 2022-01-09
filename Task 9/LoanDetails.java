import java.util.*;

import java.sql.*;
public class LoanDetails {
	
	public static Connection connect()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerDB","niketha","nike123");
		     return con;
		 } 
		 catch (Exception ex) { ex.printStackTrace();}
		return null;
	}
	//fetch balance 
	public static void retreive(int id){
		int id_ip=id;
		String sql="select balance from loan where cid="+id_ip;
		try {
			Connection con=connect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			System.out.println("Balance:"+rs.getString(1));
			
		}catch(Exception ex) { ex.printStackTrace();}
		
	}
	//fetch loan details
	public static void details(int id) {
		int id_ip=id;
		System.out.println("cid"+"\t"+"name"+"\t"+"balance"+"\t"+"amount"+"\t"+"pending");
		String sql="select * from loan where cid="+id_ip;
		try {
			Connection con=connect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			for(int i=1;i<=5;i++) {
			System.out.print(rs.getString(i)+"\t");
			}
			System.out.println(" ");
		}catch(Exception ex) { ex.printStackTrace();}
		
	}
	public static boolean validate(String uname,String pwd) {
		int flag=0;
		String password=pwd;
		String username=uname;

		String sql="select * from user";
		try {
			Connection con=connect();
			
			Statement st=con.createStatement();
			ResultSet rs=null;
			rs=st.executeQuery(sql);
			
			while(rs.next()) {

					if((username.equals(rs.getString(2))) && (password.equals(rs.getString(3)))){
						flag=1;
						break;
					}
					else {
						flag=0;
					}
				}
			rs.close();
				if(flag==1) {
					return true;
				}
				else {
					return false;
				}
			}	
		catch(Exception e) {e.printStackTrace();}
		return false;
		
	}
	
	public static void pay(int id,int payamt) {
		int id_ip=id;
		int amt=payamt;
		int db_amt=0;
		int p_amt=0;
		String sql="select balance from loan where cid="+id_ip;
		String sqli="select pending from loan where cid="+id_ip;
		try {
			Connection con=connect();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			rs.next();
			db_amt=rs.getInt(1);
			
			
			
			if((amt<=db_amt)) {
				db_amt-=amt;
				stmt.executeUpdate("update loan set balance="+(db_amt)+"   where cid= "+id_ip);
				rs=stmt.executeQuery(sqli);
				rs.next();
				p_amt=rs.getInt(1);
				p_amt-=amt;
				stmt.executeUpdate("update loan set pending="+(p_amt)+"   where cid= "+id_ip);
				
				System.out.println(" Amount Paid successfully!!");
				details(id_ip);
				
			}
			else {
				System.out.println("Balance insufficient");
			}
		}

		catch(Exception e) {e.printStackTrace();}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int id;
		char ch;
		String uname, pwd;
		do {
			System.out.println("1.balance 2.loan details 3.pay");
			System.out.print("Enter choice:");
			
			int choice=sc.nextInt();
				if(choice==1) {
					System.out.print("Enter id:");
					id=sc.nextInt();
					retreive(id);
				}
				if(choice==2) {
					System.out.print("Enter id:");
					id=sc.nextInt();
					details(id);
				}
				if(choice==3) {
					System.out.print("Enter cid:");
					id=sc.nextInt();
					System.out.print("Enter uname:");
					uname=sc.next();
					System.out.print("Enter password:");
					pwd=sc.next();
					if(validate(uname,pwd)) {
						System.out.println("------Succesfully logged in------ ");
						System.out.print("Enter amount to pay:");
						int payamt=sc.nextInt();
						pay(id,payamt);
					}
					else {
						System.out.println("Invalid login details");
					}
				}
				
			System.out.print("Do u want to continue(y/n):");
			ch=sc.next().charAt(0);
		}while(ch=='y');

}
}