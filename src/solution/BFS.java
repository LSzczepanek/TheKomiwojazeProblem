package solution;

import java.util.List;

public class BFS {

static void doBFS(List<Route> listOfRoutes){
		
		Route minRoute = null;
		double minLenghtOfRoute = 100.4;
		int cost = 0;
		
		do{

			RouteHelper.listOfRoutes.get(cost).calcluateDistanceOfRoute();
			
			cost++;
		}while(minLenghtOfRoute!=RouteHelper.listOfRoutes.get(cost).getDistanceOfTheRouteInKm());
			minRoute = RouteHelper.listOfRoutes.get(cost);
			
			System.out.println("================B F S================");
			System.out.println("Minimalna droga to: \n"+minRoute);
			System.out.println("Jej dlugosc to: "+ minRoute.getDistanceOfTheRoute());
			System.out.println("Jej dlugosc w km to: "+ minRoute.getDistanceOfTheRouteInKm());
			System.out.println("Koszt operacji to: "+cost);
		
		
	}
}
