import java.time.*; 
import java.util.*;

public class datecheck{
	static void
    findDifference(LocalDate test_date, LocalDate end_date) 
    { 
        Period diff = Period .between(test_date, end_date); 
		System.out.print( "Product expires in: "); 
        System.out.printf( "%d years, %d months"+ " and %d days ", diff.getYears(), diff.getMonths(),diff.getDays()); 
    } 
	public static void main(String a[]){
		
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println("-------Check Expiry------");
			System.out.print("Enter product: ");
			String pdt=sc.next();
				System.out.print("Enter date: ");
				String date = sc.next();
				LocalDate testdate = LocalDate.parse(date);
					if (pdt.equals("ketchup")){
						LocalDate start_date = LocalDate.of(2020, 11, 03);
						LocalDate end_date = LocalDate.of(2021, 10, 12);
							if(testdate.isAfter(start_date) && testdate.isBefore(end_date)){
								findDifference(testdate, end_date);
							}
							else{
								System.out.println("Invalid date/Product expired");
							}
					}
					if (pdt.equals("lipbalm")){
						LocalDate start_date = LocalDate.of(2019, 11, 02);
						LocalDate end_date = LocalDate.of(2022, 03, 18);
							if(testdate.isAfter(start_date) && testdate.isBefore(end_date)){
								findDifference(testdate, end_date);
							}
							else{
								System.out.println("Invalid date/Product expired");
							}
				
						
					}
	}
}