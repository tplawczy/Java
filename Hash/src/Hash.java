import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.transform.Templates;

public class Hash {

	public static void main(String[] args) {
		
		String[][] dishes = { { "Salad", "Tomato", "Cucumber", "Salad", "Sauce" },
				{ "Pizza", "Tomato", "Sausage", "Sauce", "Dough" }, { "Quesadilla", "Chicken", "Cheese", "Sauce" },
				{ "Sandwich", "Salad", "Bread", "Tomato", "Cheese" } };
		String[][] grouped =new String[0][0];
		Map<String, ArrayList<String>> multiValueMap = new HashMap<String, ArrayList<String>>();
		for (int i = 0; i < dishes.length; i++) {
			for (int j = 1; j < dishes[i].length; j++) {
				multiValueMap.put(dishes[i][j], new ArrayList<String>());

			}
		}
		for (int i = 0; i < dishes.length; i++) {
			for (int j = 1; j < dishes[i].length; j++) {

				multiValueMap.get(dishes[i][j]).add(dishes[i][0]);
				Collections.sort(multiValueMap.get(dishes[i][j]));

			}
		}

		for (int i = 0; i < dishes.length; i++) {
			for (int j = 1; j < dishes[i].length; j++) {

				if (multiValueMap.get(dishes[i][j]).size() < 2) {
					multiValueMap.remove(dishes[i][j]);
				}

			}
		}

		TreeMap<String, ArrayList<String>> sorted = new TreeMap<>();

		// Copy all data from hashMap into TreeMap
		sorted.putAll(multiValueMap);

		// Display the TreeMap which is naturally sorted
		int x = 0;
	
		for (Entry<String, ArrayList<String>> entry : sorted.entrySet()) {
			
			
			x++;
			String[][] temp = new String[x][];
			grouped = temp;
		}
		
		int y = 0;
		for (Entry<String, ArrayList<String>> entry : sorted.entrySet()) {
			
			String data[] = new String[entry.getValue().size()+1];
			data[0]=entry.getKey();
			for (int i = 0; i < entry.getValue().size(); i++) {
			
				data[i+1] =entry.getValue().get(i);
				grouped[y]=data;
			}
	
			y++;

		}
		/*for (Entry<String, ArrayList<String>> entry : sorted.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());}*/
		
		System.out.println(Arrays.deepToString(grouped));
	}
}
