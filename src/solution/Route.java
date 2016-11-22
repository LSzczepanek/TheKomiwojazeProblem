package solution;

import java.util.Arrays;

public class Route implements Comparable<Route> {

	final City DEFAULT_CITY;
	City[] routeAsArray;
	private  double distanceOfTheRoute = 0;
	private  double distanceOfTheRouteInKm = 0;


	public Route(City[] listOfCities) {
		DEFAULT_CITY = Main.listOfCities[0];

		routeAsArray = new City[listOfCities.length];
		routeAsArray[0] = DEFAULT_CITY;
		for (int i = 1; i < listOfCities.length; i++) {
			routeAsArray[i] = listOfCities[i];
		}

	}

	public void calcluateDistanceOfRoute() {
		City[] cityInRoute = routeAsArray;
		calculateDistance(cityInRoute);
		calculateDistanceInKm(cityInRoute);

	}

	private void calculateDistance(City[] cityInRoute) {
		for (int i = 0; i < (cityInRoute.length -1); i++) {

			if (cityInRoute[i].distanceList.containsKey(cityInRoute[i+1].name)) {
				distanceOfTheRoute += cityInRoute[i].getDistanceToCity(cityInRoute[i+1].name);
				//distanceOfTheRoute = new BigDecimal(distanceOfTheRoute).setScale(2, RoundingMode.HALF_UP).doubleValue();
			} else {

				System.out.println("Cos nie pyklo");
			}
		}
		distanceOfTheRoute = Main.round(distanceOfTheRoute, 2);
		
	}
	
	
	private void calculateDistanceInKm(City[] cityInRoute) {
		for (int i = 0; i < (cityInRoute.length -1); i++) {

			if (cityInRoute[i].distanceListCloserToKm.containsKey(cityInRoute[i+1].name)) {
				distanceOfTheRouteInKm += cityInRoute[i].getDistanceToCityInKm(cityInRoute[i+1].name);
				//distanceOfTheRouteInKm = new BigDecimal(distanceOfTheRouteInKm).setScale(2, RoundingMode.HALF_UP).doubleValue();
			} else {

				System.out.println("Cos nie pyklo");
			}
		}
		
		distanceOfTheRouteInKm = Main.round(distanceOfTheRouteInKm, 2);
	}

	public double getDistanceOfTheRoute() {
		return distanceOfTheRoute;
	}
	
	public double getDistanceOfTheRouteInKm() {
		return distanceOfTheRouteInKm;
	}

	@Override
	public String toString() {
		return "Route [" + Arrays.toString(routeAsArray);
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

		// do usuniecia z czasem

	int getCity(int i) {
		return 0;
	}

	@Override
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
