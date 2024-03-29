package cities;

public class Road {
	private int length;
	private City city1, city2;
	
	public Road(City city1, City city2, int length) {
		this.length = length;
		this.city1 = city1;
		this.city2 = city2;
		
		
		city1.connect(this);
		city2.connect(this);
	}
	
	public City getCity1() {
		return this.city1;
	}
	
	public City getCity2() {
		return this.city2;
	}
	
	public int getLength() {
		return this.length;
	}

}
