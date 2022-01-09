import java.util.*;
public class loop{
	public static void main(String ar[]){
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		System.out.println("For Loop");
		for(int i=0;i<num;i++){
			System.out.print(i +" " );
		}
		System.out.println();
		System.out.println("while loop");
		int j=0;
		while(j<num){
			System.out.print(j+" ");
			j+=1;
		}
		System.out.println();
		System.out.println("Do while");
		int k=0;
		do{
			System.out.print(k+" ");
			k+=1;
		}while(k<num);
	}
}