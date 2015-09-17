package englard.math;

import java.util.HashSet;

public class ShowDuplicate {
	public static void main(String[] args) {
		String array[] = new String[] { "A", "B", "B", "B" ,"leah", "leah"};
		HashSet<String> set = new HashSet<String>();
		HashSet<String> setB = new HashSet<String>();
		for (String s : array) {
			if (set.contains(s)) {
				if(!setB.contains(s)){
					System.out.println(s);
					setB.add(s);
				}
			}
			
			set.add(s);
		}
	}
}
