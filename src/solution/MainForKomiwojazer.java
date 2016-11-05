package solution;

import java.util.Arrays;
import java.util.List;

public class MainForKomiwojazer {

	public static void main(String[] args) {
		
		City[] listOfCities = {new City("Lodz",19.33,51.46),
							 	new City("Kutno",19.22,52.14),
							 	new City("Zgierz",19.25,51.52),
							 	new City("Leczyca",19.12,52.03),
							 	new City("Piatek",19.28,52.04),
							 	new City("Witonia",19.18,52.08),
							 	new City("Strykow",19.35,51.54),
							 	new City("Ozorkow",19.17,51.58)
		};
		
		Route route = new Route(listOfCities);
		
		for(City x : listOfCities){
		System.out.println(x);
		}
		City.calculateAllDistancesToTheAllPoints(listOfCities);
		City.calculateKm(listOfCities);
		
		for(City x : listOfCities)
		System.out.println(x.name+" "+x.distanceList);
		
		
		
		
		System.out.println();
		for(City x : listOfCities)
			System.out.println(x.name+" "+x.distanceListCloserToKm);
		
		System.out.println();
		new Route(listOfCities);
		
		
		
		
		if(Route.isTheCityAlreadyInRoute(new City("Lodz",19.33,51.46), listOfCities))
			System.out.println("Tak");
		
		
		//route.createList(listOfCities);
		
		List<City> list = Arrays.asList(listOfCities);
		System.out.println();
		Route.permute(list, 1);
		System.out.println(Route.ilosc);
		System.out.println(Route.listOfRoutes.size());
	}

}
