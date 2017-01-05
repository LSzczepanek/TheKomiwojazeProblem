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


		City.calculateAllDistancesToTheAllPoints(listOfCities);
		City.calculateKm(listOfCities);

		List<City> list = Arrays.asList(listOfCities);

		RouteHelper.permute(list, 1);
		
		RouteHelper.print();


		
		BruteForce.doBruteForce(RouteHelper.listOfRoutes);
		
		BFS.doBFS(RouteHelper.listOfRoutes);
			
		HeuristicMethod.doHeuristicMethod(listOfCities);

	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
