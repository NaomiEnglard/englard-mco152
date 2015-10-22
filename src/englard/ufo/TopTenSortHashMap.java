package englard.ufo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;

public class TopTenSortHashMap {

	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> locationMap = new HashMap<String, Integer>();
		// read file into list of ufo sightings
		BufferedReader in = new BufferedReader(new FileReader(
				"./ufo_awesome.json"));
		Gson gson = new Gson();
		UFOSightingLIst list = gson.fromJson(in, UFOSightingLIst.class);
		in.close();

		// keep track of times a location appears - in hashmap of
		// <locationName, numTimes>
		Iterator<UFOSighting> iter = list.iterator();
		while (iter.hasNext()) {
			String location = iter.next().getLocation();
			// if the location is in the map incrment numTimes
			if (locationMap.containsKey(location)) {
				locationMap.replace(location, (locationMap.get(location) + 1));
			} else {// else create new location in map
				locationMap.put(location, 1);
			}

		}// end while
		
		NumComparator nc = new NumComparator(locationMap);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(nc);
		sortedMap.putAll(locationMap);
		Iterator<?> iterTwo = sortedMap.entrySet().iterator();
		int count = 0;
			while(count<10){
			count++	;
			System.out.println(iterTwo.next());
			
		}
	}

}

class NumComparator implements Comparator<String> {

	Map<String, Integer> map;

	public NumComparator(Map<String, Integer> base) {
		this.map = base;
	}

	public int compare(String a, String b) {
		if (map.get(a) >= map.get(b)) {
			return -1;
		} else {
			return 1;
		}
	}
}
