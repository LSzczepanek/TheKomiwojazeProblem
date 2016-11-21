package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Route implements Comparable<Route> {

	
	
	final City DEFAULT_CITY ;
	City[] routeAsArray;
	static List<City[]> listOfRoutes = new ArrayList<City[]>(); // musze to wynesc na zewnatez oraz wszytskei metody ktore sa z tym zwiazane
	static int ilosc =0;
	private static double distanceOfTheRoute;

	public Route(City[] listOfCities) {

		this.routeAsArray = new City[listOfCities.length];

		routeAsArray[0] = listOfCities[0];

		for(int i = 1; i < listOfCities.length; i++){
			routeAsArray[i] = new City();
		}
		DEFAULT_CITY = new City();
		for(City city : routeAsArray)
		System.out.println(city);
		//createListOfRoutes(listOfCities);
	}
	
	

	

	
	static void calcluateDistanceOfRoute(City[] route){
		if(route[0].distanceListCloserToKm.containsKey(route[1].name)){
			System.out.println(route[0].distanceListCloserToKm.get(route[1]));
		}
		else{
			System.out.println("Cos nie pyklo");
		}
		
	}
	
	
	static double getDistanceOfTheRoute() {
		return distanceOfTheRoute;
	}
	
	
	@Override
	public String toString() {
		return "Route [route=" + Arrays.toString(routeAsArray);
	}







	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public boolean equals(Route route) {
		// TODO Auto-generated method stub
		return this.toString().equals(route.toString());
	}





	/**
	 * 
	 * Return false if city exist in route
	 * 
	 * @param city
	 * @param route
	 * @return
	 */

	static boolean isTheCityAlreadyInRoute(City city, City[] route) {

		for (City citiesInRoute : route) {

			if (citiesInRoute.equals(city)) {
				// System.out.println("Miasto jest juz w drodze!");
				return false;
			}

		}
		//System.out.println("Nie ma miasta w drodze!");
		return true;
	}

	void addCityToRoute(City[] route, int position, City city) {

		if (isTheCityAlreadyInRoute(city, route) && route[position].equals(DEFAULT_CITY)) {
			route[position] = city;
		}

	}
	
	
	void createList(City[] listOfCities){
		createListOfRoutes(listOfCities);
	}

	void createListOfRoutes(City[] listOfCities) {
		City[] route = null;
		//do{
		for (int i = 1; i < listOfCities.length; i++) {
			 route = this.routeAsArray;
			for (int j = 0; j < listOfCities.length; j++) {

				addCityToRoute(route, i, listOfCities[j]);

			}
			
			// listOfRoutes.add(route);
		}
		System.out.println(Arrays.toString(route));
		listOfRoutes.add(route);
		//while()
	}

	// do usuniecia z czasem

	int getCity(int i) {
		return 0;
	}

	
	public void print(){
		int i = 0;
		for (City[] routes : listOfRoutes) {
			System.out.println();
			System.out.println("Route " + i + " : ");
			i++;
			for (City se : routes) {
				System.out.println(se);
			}
		}
	}
	
	
	
	  static void permute(List<City> list, int k){
          for(int i = k; i < list.size(); i++){
              java.util.Collections.swap(list, i, k);
              permute(list, k+1);
              java.util.Collections.swap(list, k, i);
          }
          if (k == list.size() -1){
              
        	  listOfRoutes.add((City[]) list.toArray());
              System.out.println(ilosc+": "+java.util.Arrays.toString(list.toArray()));
//              System.out.println("Ilosc: "+ ilosc);
              ilosc++;
          }
//          System.out.println("Ilosc obiektow: "+list);
      }
	
	public int compareTo(Route other) {
		int tmp = 0;

		int[] cities = new int[5];

		for (int i = 0; i < cities.length; i++) {
			if (cities[i] != other.getCity(i)) {
				tmp = 1;
				break;
			}
		}

		return tmp;
	}
}
