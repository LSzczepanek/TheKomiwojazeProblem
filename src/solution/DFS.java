package solution;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	// static private Map<String, City[]> closestCities = new
	// LinkedHashMap<String, City[]>();

	private static int amountOfRoutes = 486;

	static void doDFS(List<Route> listOfRoutes, City[] listOfCities) {
		List<Route> workingList = new ArrayList<Route>(listOfRoutes);
		List<Route> dfsListOfRoutes = new ArrayList<Route>();

		for (int i = 0; i < listOfCities.length; i++) {
			listOfCities[i].setClosestCities(listOfCities);
		}

		for (int i = 0; i < workingList.size(); i++) {
			for (int j = 0; j < 3; j++) {
				if (workingList.get(i).routeAsArray[1].equals(listOfCities[0].closestCities[j])  && !dfsListOfRoutes.contains(workingList.get(i))) {
					dfsListOfRoutes.add(workingList.get(i));
				}
			}
		}

		workingList = new ArrayList<Route>(dfsListOfRoutes);
		dfsListOfRoutes = new ArrayList<Route>();

		for (int i = 0; i < workingList.size(); i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++)
					if (workingList.get(i).routeAsArray[2].equals(listOfCities[0].closestCities[j].closestCities[k])  && !dfsListOfRoutes.contains(workingList.get(i))) {
						dfsListOfRoutes.add(workingList.get(i));
					}
			}
		}

//		workingList = new ArrayList<Route>(dfsListOfRoutes);
//		dfsListOfRoutes = new ArrayList<Route>();
//
//		for (int i = 0; i < workingList.size(); i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++)
//					for (int l = 0; l < 3; l++) {
//						if (workingList.get(i).routeAsArray[3]
//								.equals(listOfCities[0].closestCities[j].closestCities[k].closestCities[l]) && !dfsListOfRoutes.contains(workingList.get(i))) {
//							dfsListOfRoutes.add(workingList.get(i));
//						}
//					}
//			}
//		}

//		workingList = new ArrayList<Route>(dfsListOfRoutes);
//		dfsListOfRoutes = new ArrayList<Route>();
//
//		for (int i = 0; i < workingList.size(); i++) {
//			for (int j = 0; j < 3; j++) {
//				for (int k = 0; k < 3; k++)
//					for (int l = 0; l < 3; l++) {
//						for (int m = 0; m < 3; m++) {
//							if (workingList.get(i).routeAsArray[4].equals(
//									listOfCities[0].closestCities[j].closestCities[k].closestCities[l].closestCities[m])) {
//								dfsListOfRoutes.add(workingList.get(i));
//							}
//						}
//					}
//			}
//		}

		for (Route route : dfsListOfRoutes)
			System.out.println(route);

		System.out.println(dfsListOfRoutes.size());
		System.out.println("================D F S================");
		System.out.println("Minimalna droga to: ");
		System.out.println();
		System.out.println("jej dlugosc to: ");
		System.out.println("Dystans w km to: ");
		System.out.println("Koszt operacji to: ");

		// System.out.println("Before for");
		// System.out.println(dfsListOfRoutes.size());
		//
		// int dupa = 0;
		// int test = 0;
		// for (int i = 0; i < amountOfRoutes; i++) {
		//
		// Route tmpRoute = new Route();
		// int postionInRouteAsArray = 1;
		// int positionInClosestCities = 0;
		// int tmpIndex = 0;
		// for (; postionInRouteAsArray < tmpRoute.routeAsArray.length;
		// postionInRouteAsArray++) {
		// tmpRoute.routeAsArray[postionInRouteAsArray -
		// 1].setClosestCities(listOfCities);
		//
		// for (positionInClosestCities = tmpIndex; positionInClosestCities <
		// tmpRoute.routeAsArray[postionInRouteAsArray
		// - 1].closestCities.length; positionInClosestCities++) {
		// if (!(tmpRoute.isCityInRoute(
		// tmpRoute.routeAsArray[postionInRouteAsArray -
		// 1].closestCities[positionInClosestCities]))) {
		// tmpRoute.addCityToRoute(
		// tmpRoute.routeAsArray[postionInRouteAsArray -
		// 1].closestCities[positionInClosestCities],
		// postionInRouteAsArray);
		// break;
		// }
		// }
		// //System.out.println("Added: " + tmpRoute);
		// if (postionInRouteAsArray == 7) {
		// System.out.println("Pozycja jest na 7: "+ test++);
		// if (dfsListOfRoutes.contains(tmpRoute)) {
		// System.out.println("Ilosc duy:" +dupa++);
		// postionInRouteAsArray = 0;
		// tmpIndex++;
		// tmpRoute = new Route();
		// //positionInClosestCities = tmpIndex;
		//
		// } else {
		// dfsListOfRoutes.add(tmpRoute);
		// }
		// }
		// }
		// }
		//
		// System.out.println("After for");
		// System.out.println(dfsListOfRoutes.size());

		// List<Route> dfsListOfRoutes2 = new ArrayList<Route>();
		//
		// dfsListOfRoutes2.add(new Route());
		//
		//
		// Route tes2t = new Route();
		// dfsListOfRoutes2.add(tes2t);
		//
		//
		// System.out.println(dfsListOfRoutes2.contains(listOfRoutes.get(6)));
		// System.out.println("Test: "+dfsListOfRoutes2.contains(tes2t));
		// System.out.println(listOfCities[0].closestCities[6]);
		// System.out.println(tes2t);

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
