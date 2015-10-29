package englard.ufo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import com.google.gson.Gson;

public class TopTenSorting {

	public static void main(String[] args) {
		try {
			// read file into list of ufo sightings
			BufferedReader in = new BufferedReader(new FileReader(
					"./ufo_awesome.json"));
			Gson gson = new Gson();
			UFOSightingLIst list = gson.fromJson(in, UFOSightingLIst.class);
			in.close();

			// keep track of times a location appears - in hashmap of
			// <locationName, numTimes>
			HashMap<String, Integer> locationMap = new HashMap<String, Integer>();
			Iterator<UFOSighting> iter = list.iterator();
			while (iter.hasNext()) {
				String location = iter.next().getLocation();
				// if the location is in the map incrment numTimes
				if (locationMap.containsKey(location)) {
					locationMap.replace(location,
							(locationMap.get(location) + 1));
				} else {// else create new location in map
					locationMap.put(location, 1);
				}

			}// end while

			// got all values and sort, take the top ten
			List<Integer> allValues = new ArrayList<Integer>(
					locationMap.values());
			Collections.sort(allValues, Collections.reverseOrder());
			allValues = allValues.subList(0, 10); // get only the 10 values

			// find locations that match top ten numTimes
			ArrayList<String> cityAndNumber = new ArrayList<String>();
			StringBuilder build = new StringBuilder();
			for (Entry<String, Integer> entry : locationMap.entrySet()) {
				for (int i = 0; i < allValues.size(); i++) {
					if (allValues.get(i).equals(entry.getValue())) {
						build.append(entry.getValue());
						build.append(" - ");
						build.append(entry.getKey());
						build.append("\n");
						cityAndNumber.add(build.toString());
						build.setLength(0);// empty builder
						allValues.remove(i); // dont keep looking for the number
												// if it was found
						break;
					}
				}
			}
			Collections.sort(cityAndNumber); // display results in number order
			System.out.println(cityAndNumber);
			System.out.println(System.currentTimeMillis());

		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}

}
