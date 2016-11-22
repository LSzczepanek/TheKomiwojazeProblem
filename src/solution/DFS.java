package solution;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DFS {

	static private Map<String, City[]> closestCities = new LinkedHashMap<String, City[]>();

	static void doDFS(List<Route> listOfRoutes, City[] listOfCities) {
		List<Route> workingList = new ArrayList<>(listOfRoutes);

		for (int i = 0; i < listOfCities.length; i++) {
			closestCities.put(listOfCities[i].name, get3ClosestCities(listOfCities, listOfCities[i]));
		}

		

		System.out.println("================D F S================");
		System.out.println("Minimalna droga to: ");
		System.out.println();
		System.out.println("jej dlugosc to: ");
		System.out.println("Dystans w km to: ");
		System.out.println("Koszt operacji to: ");
		
		printClosestCitiesForAll();
	}

	static City[] get3ClosestCities(City[] listOfCities, City city) {

		double minDistance;
		double tmpDistance;
		City closestCity = null;
		List<City> bannedCities = new ArrayList<City>();
		City[] closestCities = new City[3];

		bannedCities.add(city);

		for (int j = 0; j < closestCities.length; j++) {
			minDistance = Double.MAX_VALUE;
			tmpDistance = Double.MAX_VALUE;
			closestCity = new City();
			for (int i = 0; i < listOfCities.length; i++) {

				if (!city.name.equals(listOfCities[i].name)) {
					tmpDistance = city.distanceList.get(listOfCities[i].name);
				}

				if (minDistance > tmpDistance && !bannedCities.contains(listOfCities[i])) {
					minDistance = tmpDistance;
					closestCity = listOfCities[i];
				}

			}
			bannedCities.add(closestCity);
			closestCities[j] = closestCity;

		}
		return closestCities;
	}

	private static void printClosestCitiesForAll() {

		System.out.println();
		for (Map.Entry entry : closestCities.entrySet()) {

			City[] arrayOfClosestCities = (City[]) entry.getValue();
			System.out.println(entry.getKey() + ", " + arrayOfClosestCities[0] + ", " + arrayOfClosestCities[1] + ", "
					+ arrayOfClosestCities[2]);
		}
		System.out.println();
	}
}
