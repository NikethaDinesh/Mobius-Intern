import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.*;

public class validatecred{
	public static void main(String ar[])throws Exception{
		
		String hashpwd="6009d9281d6d03f3ae6910da535937b2";
		Scanner sc=new Scanner(System.in);
		System.out.println("---------VALIDATE CREDENTIALS--------");
		System.out.print("Enter Username:");
		String uname=sc.next();
		//username is checked
		if(uname.equals("sehun")){
			
			System.out.print("Enter Password:");
			String pwd=sc.next();
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pwd.getBytes());
			
			byte[] bytepwd = md.digest();
			
			StringBuilder sb=new StringBuilder();
			
			for(int i=0;i<bytepwd.length;i++){
				sb.append(Integer.toString((bytepwd[i] & 0xff) + 0x100, 16).substring(1));
			}	
			//stores hashed password
			String mypwd=sb.toString();
			
			//checks if hashed password is equal to hash value
			if( hashpwd.equals(mypwd)){
				System.out.println("User authentication Passed");
			}
			else{
				System.out.println("Invalid  password");
			}
		}
		else{
			System.out.println("Username invalid");
		}
	}
}