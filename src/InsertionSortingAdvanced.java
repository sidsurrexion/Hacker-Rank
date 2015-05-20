import java.util.Scanner;


public class InsertionSortingAdvanced {

	// Main function 
	public static void main(String[] args) {
		
		// To collect the total number of test cases
		System.out.print("Enter the total number of test cases to execute: ");		
		Scanner scanner = new Scanner(System.in);		
		String string = scanner.nextLine();
		System.out.println("");
		int x = Integer.parseInt(string);
		System.out.println("Enter the test case length and the respective numbers: ");
		int counter = 0;
		
		// To collect the length of the test case and the numbers of the test case to sort
		for ( int j = 0; j < x ; j++){
			
			String new_string = scanner.nextLine();
			int number_values = Integer.parseInt(new_string);
			int[] number_holder = new int[number_values];
			
			// Collecting the number of elements in the test case
			for ( int k = 0; k < number_values; k++){
				String sub_string = scanner.nextLine();
				number_holder[k] = Integer.parseInt(sub_string);
			}
			
			System.out.println("");
			// Calling insertion sorting method to compute the number of inversion to have taken place
			counter = insertion_sorting(number_holder);
			System.out.println("Number of inversions: "+counter);
			
			for (int i = 0; i < number_values; i++){
				System.out.print(number_holder[i]+" ");
			}
			
			System.out.println("\n");
			
		}
		
		// Closing the scanner to avoid anymore user input
		scanner.close();
	}

	// Method to perform Insertion Sorting
	public static int insertion_sorting(int[] number_holder){
		
		int current_entry = 0;
		
		int x = 0;
		
		int count = 0;
		
		for (int y = 1 ; y <= number_holder.length -1 ; y++){
			
			current_entry = number_holder[y];
			
			x = y - 1;
			
			while (x >= 0 && number_holder[x] > current_entry){
				number_holder[x + 1] = number_holder[x];
				x = x - 1;
				count++;
			}
			
			number_holder[x + 1] = current_entry;
		}
		
		return count;
		
	}
}
