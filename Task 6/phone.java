import java.util.*;
public class phone{
	public static void main(String ar[]){
		System.out.println("-----STD CODE-----");
		System.out.println(" ");
		System.out.print("Enter Phone Number:");
		Scanner sc=new Scanner(System.in);
		String phone=sc.next();
		String code_extract=phone.substring(0,3);
		
		
		String key;
		Hashtable<String ,String> ht=new Hashtable<String,String>();
		ht.put("044","Chennai");
		ht.put("011","Delhi");
		ht.put("022","Mumbai");
		ht.put("033","Kolkata");
		Enumeration code=ht.keys();
		while(code.hasMoreElements()){
			key=(String)code.nextElement();
			if(code_extract.equals(key)){
				System.out.println("Code:"+key+" "+"Area:"+ht.get(key));
			}}
	}
}