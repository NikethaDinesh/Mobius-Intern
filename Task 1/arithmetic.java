import java.util.*;
public class arithmetic{
	public static void main(String ar[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter num:");
		int num1=sc.nextInt();
		System.out.println("Enter num");
		int num2=sc.nextInt();
		System.out.println("Add:"+ (num1+num2));
		System.out.println("Sub:"+ (num1-num2));
		System.out.println("Mul:"+ (num1*num2));
		System.out.println("Div:"+ (num1/num2));
		System.out.println("Mod:"+ (num1%num2));
		}
}