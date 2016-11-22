package solution;

import java.util.List;

public class BruteForce {

	
	static void doBruteForce(List<Route> listOfRoutes){
		
		Route minRoute = null;
		double minLenghtOfRoute = Double.MAX_VALUE;
		double tmpMinLengthOfRoute;
		int cost = 0;
		
		for(int i = 0 ; i < listOfRoutes.size(); i++){

			RouteHelper.listOfRoutes.get(i).calcluateDistanceOfRoute();

			tmpMinLengthOfRoute = RouteHelper.listOfRoutes.get(i).getDistanceOfTheRoute();
			if(minLenghtOfRoute > tmpMinLengthOfRoute){
				minRoute = RouteHelper.listOfRoutes.get(i);
				minLenghtOfRoute = tmpMinLengthOfRoute;
				
			}
			cost++;
		}
		
			
			System.out.println("=============Brute Force=============");
			System.out.println("Minimalna droga to: \n"+minRoute);
			System.out.println("Jej dlugosc to: "+ minRoute.getDistanceOfTheRoute());
			System.out.println("Jej dlugosc w km to: "+ minRoute.getDistanceOfTheRouteInKm());
			System.out.println("Koszt operacji to: "+cost);
		
	}
}
