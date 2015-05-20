import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ClockTimeToWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> integer_to_word = new HashMap<Integer, String>();
		for (int i = 0; i <= 29; i++){
			switch (i) {
			case 0:
				integer_to_word.put(i, "midnight");
				break;
			case 1:
				integer_to_word.put(i, "one");
				break;
			case 2:
				integer_to_word.put(i, "two");
				break;
			case 3:
				integer_to_word.put(i, "three");
				break;
			case 4:
				integer_to_word.put(i, "four");
				break;
			case 5:
				integer_to_word.put(i, "five");
				break;
			case 6:
				integer_to_word.put(i, "six");
				break;
			case 7:
				integer_to_word.put(i, "seven");
				break;
			case 8:
				integer_to_word.put(i, "eight");
				break;
			case 9:
				integer_to_word.put(i, "nine");
				break;
			case 10:
				integer_to_word.put(i, "ten");
				break;
			case 11:
				integer_to_word.put(i, "eleven");
				break;
			case 12:
				integer_to_word.put(i, "twelve");
				break;
			case 13:
				integer_to_word.put(i, "thirteen");
				break;
			case 14:
				integer_to_word.put(i, "fourteen");
				break;
			case 15:
				integer_to_word.put(i, "fifteen");
				break;
			case 16:
				integer_to_word.put(i, "sixteen");
				break;
			case 17:
				integer_to_word.put(i, "seventeen");
				break;
			case 18:
				integer_to_word.put(i, "eighteen");
				break;
			case 19:
				integer_to_word.put(i, "nineteen");
				break;
			case 20:
				integer_to_word.put(i, "twenty");
				break;
			case 21:
				integer_to_word.put(i, "twenty one");
				break;
			case 22:
				integer_to_word.put(i, "twenty two");
				break;
			case 23:
				integer_to_word.put(i, "twenty three");
				break;
			case 24:
				integer_to_word.put(i, "twenty four");
				break;
			case 25:
				integer_to_word.put(i, "twenty five");
				break;
			case 26:
				integer_to_word.put(i, "twenty six");
				break;
			case 27:
				integer_to_word.put(i, "twenty seven");
				break;
			case 28:
				integer_to_word.put(i, "twenty eight");
				break;
			case 29:
				integer_to_word.put(i, "twenty nine");
				break;
			}	
			
		}
		
		String for_zero = "o'";
		String clock = "clock";
		String half = "half";
		String past = "past";
		String to_word = "to";
		String noon = "noon";
		String midnight = "midnight";
		String minute = "minute";
		String minutes = "minutes";
		
		int new_number = 0;
		
		System.out.println("Enter the digits");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String string_two = scanner.nextLine();
		
		System.out.println("");
		
		if (string_two.equals("00") || string_two.equals("0")){
			if (string.equals("00") || string.equals("0")){
				System.out.println(midnight);
			} else if (Integer.parseInt(string) == 12){
				System.out.println(noon);
			} else {
				System.out.println(integer_to_word.get(Integer.parseInt(string)) + " " + for_zero + clock );
			}
		} else {
			if (Integer.parseInt(string_two) == 30){
				System.out.println(half + " " + past + " " +integer_to_word.get(Integer.parseInt(string)));
			} else {
				if (Integer.parseInt(string_two) > 30){
					new_number  = 60 - Integer.parseInt(string_two);
					if (Integer.parseInt(string) == 12){
						string = "0";
					}
					if (new_number == 1){						
						System.out.println(integer_to_word.get(new_number) + " " + minute + " " + to_word + " " + integer_to_word.get(Integer.parseInt(string) + 1));
					} else {
						System.out.println(integer_to_word.get(new_number) + " " + minutes + " " + to_word + " " + integer_to_word.get(Integer.parseInt(string) + 1));
					}
					
				} else {
					if (string_two.equals("01") || string_two.equals("1")){
						System.out.println("one" + " " + minute + " " + past + " " + integer_to_word.get(Integer.parseInt(string)));
					} else {
						new_number = Integer.parseInt(string_two);
						System.out.println(integer_to_word.get(new_number) + " " + minutes + " " + past + " " + integer_to_word.get(Integer.parseInt(string)));
					}
					new_number = Integer.parseInt(string_two);
					
				}
			}
		}
		scanner.close();
	}

}
