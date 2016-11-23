package solution;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class City {
	
	String name;
	double x;
	double y;
	
	Map<String, Double> distanceList;
	Map<String, Double> distanceListCloserToKm;
	
	public City[] closestCities;

	
	public City(){
		this.name = "";
		this.x = -1;
		this.y = -1;
		this.distanceList =  new LinkedHashMap<String, Double>();
		this.distanceListCloserToKm =  new LinkedHashMap<String, Double>();
	}
	
	
	public City(String name, double x, double y) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.distanceList =  new LinkedHashMap<String, Double>();
		this.distanceListCloserToKm =  new LinkedHashMap<String, Double>();
	}
	
	double getDistanceToCity(String nameOfCity){
		double distance = distanceList.get(nameOfCity);
		return distance;
	}
	
	double getDistanceToCityInKm(String nameOfCity){
		double distance = distanceListCloserToKm.get(nameOfCity);
		return distance;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
	static void calculateAllDistancesToTheAllPoints(City[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distanceList.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].distanceList.put(listOfObjects[j].name,
						calculateEuklidesDistance(listOfObjects[i], listOfObjects[j]));
			}
		}
	}
	
	
	static void calculateKm(City[] listOfObjects) {
		for (int i = 0; i < listOfObjects.length; i++) {
			for (int j = 0; j < listOfObjects.length; j++) {
				if (i == j) {
					listOfObjects[i].distanceListCloserToKm.put(null, (double) 0);
					continue;
				}
				listOfObjects[i].distanceListCloserToKm.put(listOfObjects[j].name,
						calculateEuklidesDistance(listOfObjects[i], listOfObjects[j])*100);
			}
		}
	}
	
	
	
	public void setClosestCities(City[] listOfCities) {
		
		
		double minDistance;
		double tmpDistance;
		City closestCity = null;
		List<City> bannedCities = new ArrayList<City>();
		closestCities = new City[listOfCities.length-1];

		bannedCities.add(this);

		for (int j = 0; j < closestCities.length; j++) {
			minDistance = Double.MAX_VALUE;
			tmpDistance = Double.MAX_VALUE;
			closestCity = new City();
			for (int i = 0; i < listOfCities.length; i++) {

				if (!this.name.equals(listOfCities[i].name)) {
					tmpDistance = this.distanceList.get(listOfCities[i].name);
				}

				if (minDistance > tmpDistance && !bannedCities.contains(listOfCities[i])) {
					minDistance = tmpDistance;
					closestCity = listOfCities[i];
				}

			}
			bannedCities.add(closestCity);
			closestCities[j] = closestCity;

		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.equals((City) obj);
		
	}
	
	
	public boolean equals(City city) {
		if(this.name.equals(city.name)){
			return true;
		}
		return false;
	}

	
	private static double calculateEuklidesDistance(City firstObject, City secondObject) {
		double sum = 0;
		sum += Math.pow((firstObject.x - secondObject.x), 2);
		sum += Math.pow((firstObject.y - secondObject.y), 2);
		Math.sqrt(sum);
		return Math.sqrt(sum);
	}
	
}
