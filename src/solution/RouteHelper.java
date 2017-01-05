package solution;

import java.util.ArrayList;
import java.util.List;

public class RouteHelper {

	static List<Route> listOfRoutes = new ArrayList<Route>();
	static int ilosc = 0;

	public static void print() {
		int i = 0;
		for (Route routes : listOfRoutes) {
			System.out.println();
			System.out.println(i + " : " + routes.toStringInline());
			i++;
			
		}
		System.out.println();
	}

	static void permute(List<City> list, int k) {
		for (int i = k; i < list.size(); i++) {
			java.util.Collections.swap(list, i, k);
			permute(list, k + 1);
			java.util.Collections.swap(list, k, i);
		}
		if (k == list.size() - 1) {

			listOfRoutes.add(new Route((City[]) list.toArray()));
			ilosc++;
		}
	}

}
