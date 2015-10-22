package englard.ufo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class NumComparator implements Comparator<String> {

	private Map<String, Integer> map;

	public NumComparator(Map<String, Integer> base) {
		this.map = base;
	}

	public NumComparator(HashMap<String, Integer> locationMap) {
		this.map = locationMap;
	}

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
			return -1;
		} else {
			return 1;
		}
	}
}
