package solution;

import java.util.Arrays;
import java.util.List;

public class Main {

	static City[] listOfCities = { new City("Lodz", 19.33, 51.46), 
			new City("Kutno", 19.22, 52.14),
			new City("Zgierz", 19.25, 51.52),
			new City("Leczyca", 19.12, 52.03),
			new City("Piatek", 19.28, 52.04),
			new City("Witonia", 19.18, 52.08), 
			new City("Strykow", 19.35, 51.54),
			new City("Ozorkow", 19.17, 51.58) };

	public static void main(String[] args) {

		// Route route = new Route(listOfCities);
		//
		// for(City x : listOfCities){
		// System.out.println(x);
		// }
		City.calculateAllDistancesToTheAllPoints(listOfCities);
		City.calculateKm(listOfCities);

		// for(City x : listOfCities)
		// System.out.println(x.name+" "+x.distanceList);
		//
		//
		//
		//
		// System.out.println();
		// for(City x : listOfCities)
		// System.out.println(x.name+" "+x.distanceListCloserToKm);
		//
		// System.out.println();
		// new Route(listOfCities);
		//

		// if(Route.isTheCityAlreadyInRoute(new City("Lodz",19.33,51.46),
		// listOfCities))
		// System.out.println("Tak");
		//

		// route.createList(listOfCities);
		int cityNumber = 1;
		List<City> list = Arrays.asList(listOfCities);
		System.out.println();
		RouteHelper.permute(list, 1);
		System.out.println(RouteHelper.ilosc);
		for (String key : listOfCities[cityNumber].distanceList.keySet()) {
			System.out.print(key + ": " + listOfCities[cityNumber].distanceList.get(key) + ", ");
		}
		System.out.println();
		for (String key : listOfCities[cityNumber].distanceListCloserToKm.keySet()) {
			System.out.print(key + ": " + listOfCities[cityNumber].distanceListCloserToKm.get(key) + ", ");
		}
		System.out.println();
		double suma;
		
		
		
		BruteForce.doBruteForce(RouteHelper.listOfRoutes);
		BFS.doBFS(RouteHelper.listOfRoutes);
		
		
		suma = listOfCities[0].getDistanceToCityInKm("Strykow");
		suma += listOfCities[6].getDistanceToCityInKm("Zgierz");
		suma += listOfCities[2].getDistanceToCityInKm("Ozorkow");
		suma += listOfCities[7].getDistanceToCityInKm("Leczyca");
		suma += listOfCities[3].getDistanceToCityInKm("Witonia");
		suma += listOfCities[5].getDistanceToCityInKm("Kutno");
		suma += listOfCities[1].getDistanceToCityInKm("Piatek");
		System.out.println("Suma: "+ suma);
		System.out.println("Pokaz droge");
		
		
		HeuristicMethod.doHeuristicMethod(listOfCities);
		
		
		DFS.doDFS(RouteHelper.listOfRoutes, listOfCities);
		
		
		for(City city : listOfCities){
			city.printClosestCities();
		}
		
		RouteHelper.listOfRoutes.get(0).routeAsArray[0].printClosestCities();
		
		
//		System.out.println(RouteHelper.listOfRoutes.get(a));
//		System.out.println(RouteHelper.listOfRoutes.get(a).getDistanceOfTheRoute());
//		System.out.println(RouteHelper.listOfRoutes.get(a).getDistanceOfTheRouteInKm());
//		Route.calcluateDistanceOfRoute(RouteHelper.listOfRoutes.get(a).routeAsArray);
//		System.out.println(RouteHelper.listOfRoutes.get(a).getDistanceOfTheRoute());
//		System.out.println(RouteHelper.listOfRoutes.get(a).getDistanceOfTheRouteInKm());
//		
		// System.out.println(Route.listOfRoutes.size());
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
