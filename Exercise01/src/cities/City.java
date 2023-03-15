package cities;

public class City {
	private Road[] roads = new Road[10];
	private int numRoads;
	private String name;
	
	public City(String name) {
		this.name = name;
	}
	
	public void connect(Road r) {
		roads[this.numRoads] = r;
		this.numRoads++;
	}
	
	public City nearestCity() {
		int minimum = this.roads[0].getLength();
		City nearestCity = this.roads[0].getCity2();
		
		for(int i=1; i<numRoads; i++) {
			if(roads[i].getLength() < minimum) {
				minimum = this.roads[i].getLength();
				nearestCity = this.roads[0].getCity2();	
			}
			
		}
		return nearestCity;
		
	}
	
	public String toString() {
		return this.name;
	}
	
}
