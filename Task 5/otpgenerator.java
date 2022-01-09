import java.util.*;
import java.security.*;
public class otpgenerator{
	public static String generateotp(final int len ){
		SecureRandom sr=new SecureRandom();
		
		StringBuilder sb=new StringBuilder();
		try{
			sr=SecureRandom.getInstance(sr.getAlgorithm());
			for(int i=0;i<len;i++){
				sb.append(sr.nextInt(9));
			}
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static void main(String ar[]){
		System.out.println("--------SEND OTP----------");
		System.out.println(" ");
		System.out.print("Do u want us to Send OTP (Y/N):");
		Scanner sc=new Scanner(System.in);
		char choice=sc.next().charAt(0);
		if(choice=='y' || choice=='Y'){
			
			System.out.println(generateotp(6));
		}
		else{
			System.out.println("--EXIT--");
		}
	}
}