import java.util.*;
public class condition{
	public static void main(String ar[]){
		Scanner sc= new Scanner (System.in);
		char ch;
		System.out.print("enter choice(y/n):");
		ch=sc.next().charAt(0);
		switch(ch){
			case 'y':
				System.out.println("Enter Percentage");
				
				int marks= sc.nextInt();
				if (marks>=90){
					System.out.println("Pass + Distinction");
				}
				else if (marks>=60){
					System.out.println("Pass");
				}
				else{
					System.out.println("Fail");
				}
				break;
			case 'n':
				System.out.println("exited");
		
		}
	}
}