package solution;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DFS {

	// static private Map<String, City[]> closestCities = new
	// LinkedHashMap<String, City[]>();

	private static int amountOfRoutes = 486;

	static void doDFS(List<Route> listOfRoutes, City[] listOfCities) {

		List<Route> dfsListOfRoutes = new ArrayList<Route>();

		System.out.println("Before for");
		System.out.println(dfsListOfRoutes.size());

		Route tmp2Route = null;

		for (int i = 0; i < amountOfRoutes; i++) {

			Route tmpRoute = new Route();
			int postionInRouteAsArray = 1;
			int positionInClosestCities = 0;
			int tmpIndex = 1;
			for (postionInRouteAsArray = 1; postionInRouteAsArray < tmpRoute.routeAsArray.length; postionInRouteAsArray++) {
				tmpRoute.routeAsArray[postionInRouteAsArray - 1].setClosestCities(listOfCities);

				for (positionInClosestCities = 0; positionInClosestCities < tmpRoute.routeAsArray[postionInRouteAsArray
						- 1].closestCities.length; positionInClosestCities++) {
					if (!(tmpRoute.isCityInRoute(
							tmpRoute.routeAsArray[postionInRouteAsArray - 1].closestCities[positionInClosestCities]))) {
						tmpRoute.addCityToRoute(
								tmpRoute.routeAsArray[postionInRouteAsArray - 1].closestCities[positionInClosestCities],
								postionInRouteAsArray);
						break;
					}
				}
				System.out.println("Added: " + tmpRoute);
				if (postionInRouteAsArray == 7) {
					if (dfsListOfRoutes.contains(tmpRoute)) {

						postionInRouteAsArray = 1;
						positionInClosestCities = tmpIndex;
						tmpIndex++;
					} else {
						dfsListOfRoutes.add(tmpRoute);
						tmp2Route = tmpRoute;
					}
				}
			}
		}

		System.out.println("After for");
		System.out.println(dfsListOfRoutes.size());

		// for (Route route : dfsListOfRoutes)
		// System.out.println(route);

		System.out.println(dfsListOfRoutes.contains(tmp2Route));

		System.out.println("================D F S================");
		System.out.println("Minimalna droga to: ");
		System.out.println();
		System.out.println("jej dlugosc to: ");
		System.out.println("Dystans w km to: ");
		System.out.println("Koszt operacji to: ");

	}

	// private static void printClosestCitiesForAll() {
	//
	// System.out.println();
	// for (Map.Entry entry : closestCities.entrySet()) {
	//
	// City[] arrayOfClosestCities = (City[]) entry.getValue();
	// System.out.print(entry.getKey() + ", ");
	// for (int i = 0; i < 7; i++) {
	// System.out.print(arrayOfClosestCities[i] + ", ");
	// }
	// System.out.println();
	// }
	// System.out.println();
	// }

	private static void getLevelOfTree(List<Route> workingList, City[] closestCities) {
		for (int i = 0; i < workingList.size(); i++) {
			boolean toDelete = true;
			for (int j = 0; j < closestCities.length; j++) {
				if (((workingList.get(i).routeAsArray[1].name).equals(closestCities[j].name))) {

					toDelete = false;
				}
			}
			if (toDelete) {

				workingList.remove(i);
				i = i - 1;

			}
		}
	}
}
