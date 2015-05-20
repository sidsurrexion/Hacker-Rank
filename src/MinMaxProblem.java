import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class MinMaxProblem {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter the integer size: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		
		System.out.println("");
		Map<Integer, Integer> integer_data = new HashMap<Integer,Integer>();
		
		System.out.print("The subset of integer size for minimum and maximum problem: ");
		Scanner new_scanner = new Scanner(System.in);
		String new_string = new_scanner.nextLine();
		int subset = Integer.parseInt(new_string);
		Set<Integer> input_set = new HashSet<Integer>();
		
		System.out.println("");
		System.out.println("Please enter the integers: ");
		for (int i = 0; i < Integer.parseInt(string); i++){
			Scanner scan_future = new Scanner(System.in);
			String strings = scan_future.nextLine();
			integer_data.put(i, Integer.parseInt(strings));	
			input_set.add(i);
		}
		
		Set<Set<Integer>> subset_ofset = new HashSet<Set<Integer>>();
		subset_ofset = createsubset(subset,input_set);
		int a = 0, b = 0, c = 0, d = 0, e = 0;
		Boolean bool = false, bool_final = false;
		
		for (Set<Integer> set: subset_ofset){
			bool = false;
			for (int j : set){
				if (bool == false){
					a  = integer_data.get(j);
					b = integer_data.get(j);
					bool = true;
				} else {
					c  = integer_data.get(j);
					d = integer_data.get(j);
					if ( c >= a ){
						a = c;
					}
					if (b >= d){
						b = d;
					}
				}								
			}
			if ( bool_final == false){
				e = a - b;
				bool_final = true;
			} else {
				if ( e >= a - b){
					e = a - b;
				}
			}
			a = 0;
			b = 0;
			c = 0;
			d = 0;
		}
		System.out.println("");
		System.out.println("The minimum amount is: "+e);
		scanner.close();
		new_scanner.close();
		
	}
	
	private static HashSet<Set<Integer>> createsubset(int subset, Set<Integer> input_set){
		
		int i = 0, j = 0;
				
		Set<Set<Integer>> subset_ofset = new HashSet<Set<Integer>>();
		
		Set<Set<Integer>> dummy_subset = new HashSet<Set<Integer>>();
		
		dummy_subset.add(new HashSet<Integer>());
		
		Iterator<Integer> iterator = input_set.iterator();
		
		while (iterator.hasNext()){
			i = iterator.next();
			Set<Set<Integer>> test_set = new HashSet<Set<Integer>>(dummy_subset);
			
			for(Set<Integer> view_set: test_set){
				Set<Integer> core_set = new HashSet<Integer>(view_set);
				j = core_set.size();
				j++;
				core_set.add(i);
				dummy_subset.add(core_set);
				if (j == 3){
					subset_ofset.add(core_set);
				}
			}
		}
		return (HashSet<Set<Integer>>) subset_ofset;
	}

}
