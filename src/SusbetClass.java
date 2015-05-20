import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SusbetClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> new_set = new HashSet<Integer>();
		int i = 0, j = 0;
		
		System.out.print("Enter the number for whose subset is required: ");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		int z = Integer.parseInt(string);
		for (int y = 0; y <= z; y++){
			set.add(y);
		}
		
		Set<Set<Integer>> subset_three = new HashSet<Set<Integer>>();
		Set<Set<Integer>> subset = new HashSet<Set<Integer>>();
		subset.add(new HashSet<Integer>());
		Iterator<Integer> iterator = set.iterator();
		
		while (iterator.hasNext()){
			i = iterator.next();
			Set<Set<Integer>> test_set = new HashSet<Set<Integer>>(subset);
			
			for(Set<Integer> view_set: test_set){
				Set<Integer> core_set = new HashSet<Integer>(view_set);
				j = core_set.size();
				j++;
				core_set.add(i);
				subset.add(core_set);
				if(j == 3){
					subset_three.add(core_set);
				}
			}
		}
		
		Iterator<Set<Integer>> iterator_whole = subset.iterator();
		while (iterator_whole.hasNext()){
			new_set = iterator_whole.next();
			System.out.print(new_set+" ");
		}
		System.out.println("");
		System.out.println("The Size of Subset is: "+subset.size());
		
		Iterator<Set<Integer>> iterator_three = subset_three.iterator();
		while (iterator_three.hasNext()){
			new_set = iterator_three.next();
			System.out.print(new_set+" ");
		}
		System.out.println("");
		System.out.println("The Size of Subset is: "+subset_three.size());
		scanner.close();
	}

}
