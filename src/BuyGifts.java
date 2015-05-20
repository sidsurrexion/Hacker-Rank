import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BuyGifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the number of entries: ");		
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String set = null;
		System.out.println("");
		
		StringTokenizer stringtokenizer;
		
		int black_gift_quantity = 0;
		int white_gift_quantity = 0;
		int black_price = 0;
		int white_price = 0;
		int added_price = 0;
		int count = 0;
		int j = 0;
		
		Boolean used = false;
		
		Map<Integer, BuyGiftDataItem> dataset = new HashMap<Integer, BuyGiftDataItem>();
		
		for (int i = 0; i < 2 * Integer.parseInt(string); i++ ){
			
			if ( i % 2 == 0 ){
				black_gift_quantity = 0;
				white_gift_quantity = 0;
				black_price = 0;
				white_price = 0;
				added_price = 0;
				count = 0;
			}
			
			set = scanner.nextLine();
			stringtokenizer = new StringTokenizer(set, " ");
			
			while (stringtokenizer.hasMoreElements()){				
				
				
				if (!(i % 2 == 0)){
										
					set = stringtokenizer.nextToken();
					count++;					
					if (count == 1){
						black_price = Integer.parseInt(set); 
					} else if (count == 2){
						white_price = Integer.parseInt(set);
					} else {
						added_price = Integer.parseInt(set);
						used = true;
					}
					
					if ( used == true ){
						BuyGiftDataItem buygiftdataitem = new BuyGiftDataItem();
						buygiftdataitem.black_gift.put(black_price, black_gift_quantity);
						buygiftdataitem.white_gift.put(white_price, white_gift_quantity);
						buygiftdataitem.additional_price = added_price;
						dataset.put(j, buygiftdataitem);
						j++;
						used = false;
					}
					
					
				} else {
					if ( black_gift_quantity == 0 ){
						black_gift_quantity = Integer.parseInt(stringtokenizer.nextToken());
					} else if (white_gift_quantity == 0){
						white_gift_quantity = Integer.parseInt(stringtokenizer.nextToken());
					}
					 
				}
				
				
			}
		}
		
		System.out.println("");
		System.out.print("Amount spent over the gifts: ");
		
		for (int key: dataset.keySet()){
			
			BuyGiftDataItem buygiftdataitem;
			
			buygiftdataitem = dataset.get(key);
			
			for (int black_key: buygiftdataitem.black_gift.keySet()){
				for (int white_key: buygiftdataitem.white_gift.keySet()){
					if (black_key == white_key){
						System.out.print(((black_key * buygiftdataitem.black_gift.get(black_key))
								+(white_key * buygiftdataitem.white_gift.get(white_key)))+ " ");
					} else {
						if (black_key > white_key){
							if ((white_key + buygiftdataitem.additional_price) >= black_key){
								System.out.print(((black_key * buygiftdataitem.black_gift.get(black_key))
								+(white_key * buygiftdataitem.white_gift.get(white_key)))+ " ");
							} else {
								System.out.print((((white_key + buygiftdataitem.additional_price) * buygiftdataitem.black_gift.get(black_key))
										+(white_key * buygiftdataitem.white_gift.get(white_key)))+ " ");
							}
						} else {
							if ((black_key + buygiftdataitem.additional_price) >= white_key){
								System.out.print(((black_key * buygiftdataitem.black_gift.get(black_key))
								+(white_key * buygiftdataitem.white_gift.get(white_key)))+ " ");
							} else {
								System.out.print((((black_key + buygiftdataitem.additional_price) * buygiftdataitem.white_gift.get(white_key))
										+(black_key * buygiftdataitem.black_gift.get(black_key)))+ " ");
							}
						}
					}
				}
			}
			
		}
		
		scanner.close();
	}
}
