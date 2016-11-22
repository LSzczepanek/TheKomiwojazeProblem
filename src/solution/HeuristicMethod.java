package solution;

import java.util.ArrayList;
import java.util.List;

public class HeuristicMethod {

	static void doHeuristicMethod(City[] listOfCities) {

		double minDistance = 0;
		double tmpDistance;
		City closestCity = null;
		List<City> bannedCities = new ArrayList<City>();
		int tmp = 0;
		int positionOfLastCity = 0;
		int cost = 0;
		

		City[] route = new City[listOfCities.length];
		
		route[0] = listOfCities[0];
		bannedCities.add(listOfCities[0]);

		for (int j = 1; j < listOfCities.length; j++) {
			minDistance = Double.MAX_VALUE;
			tmpDistance = Double.MAX_VALUE;
			closestCity = new City();
			for (int i = 0; i < listOfCities.length; i++) {

				if (!listOfCities[positionOfLastCity].name.equals(listOfCities[i].name)) {
					tmpDistance = listOfCities[positionOfLastCity].distanceList.get(listOfCities[i].name);
				}

				if (minDistance > tmpDistance && !bannedCities.contains(listOfCities[i])) {
					minDistance = tmpDistance;
					closestCity = listOfCities[i];
					tmp = i;
				}
				cost++;
			}
			positionOfLastCity = tmp;
			bannedCities.add(closestCity);
			route[j] = closestCity;
			cost++;
		}
		
		System.out.println("==============Heuristic==============");
		Route shortestRoute = new Route(route);
		shortestRoute.calcluateDistanceOfRoute();
		System.out.println("Minimalna droga to: ");
		System.out.println(shortestRoute);
		System.out.println("jej dlugosc to: " + shortestRoute.getDistanceOfTheRoute());
		System.out.println("Dystans w km to: " + shortestRoute.getDistanceOfTheRouteInKm());
		System.out.println("Koszt operacji to: " + cost);

	}

}
