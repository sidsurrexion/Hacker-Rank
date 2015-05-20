import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class DetermineFibonacci {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Boolean bool = false;
		int a = 0;
		System.out.print("Enter the number of integers: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		int[] array_numbers = new int[Integer.parseInt(string)];
		System.out.println("");
		System.out.println("Enter the numbers: ");
		for (int z = 0; z < Integer.parseInt(string); z++){
			Scanner new_scanner = new Scanner(System.in);
			String new_string = new_scanner.nextLine();
			if ( bool == false){
				a = Integer.parseInt(new_string);
				bool = true;
			} else {
				if (a <= Integer.parseInt(new_string)){
					a = Integer.parseInt(new_string);
				}
			}
			array_numbers[z] = Integer.parseInt(new_string);
		}
		
		int length = String.valueOf(a).length();
		String prime = null;
		
		for (int c = 0; c < length + 1; c++){
			if ( c == 0){
				prime = "1";
			} else {
				prime = prime + "0";
			}			
		}
		
		int number = Integer.parseInt(prime);
		
		int i = 0, aa = 0, b = 0, temp = 0;
		Map<Integer, Integer> fibonacci_numbers = new HashMap<Integer,Integer>();
		
		while ( i < number){
			if ( i == 0 || i == 1){
				
				fibonacci_numbers.put(i, i);
				
				if ( i == 1){
					b = i;
				} else {
					aa = i;
				}
				
			} else {
				
				if ( aa + b > a){
					break;
				}
				
				fibonacci_numbers.put( aa + b, i);
				temp = b;
				b = aa + b;
				aa = temp;
				temp = 0;	
				
			}
			
			i++;
		}
		System.out.println("");
		for ( int k = 0; k < array_numbers.length; k++){
			if (fibonacci_numbers.containsKey(array_numbers[k])){
				System.out.println("IsFibo");
			} else {
				System.out.println("IsNotFibo");
			}
		}
		scanner.close();
	}

}
