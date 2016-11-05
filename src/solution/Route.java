package solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Route implements Comparable<Route> {

	
	
	final City DEFAULT_CITY ;
	City[] route;
	static HashSet<City[]> listOfRoutes = new HashSet<City[]>();
	static int ilosc =0;

	public Route(City[] listOfCities) {

		this.route = new City[listOfCities.length];

		route[0] = listOfCities[0];

		for(int i = 1; i < listOfCities.length; i++){
			route[i] = new City();
		}
		DEFAULT_CITY = new City();
		for(City city : route)
		System.out.println(city);
		//createListOfRoutes(listOfCities);
	}

	

	
	
	
	
	@Override
	public String toString() {
		return "Route [route=" + Arrays.toString(route);
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
			 route = this.route;
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
