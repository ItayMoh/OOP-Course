package root;

public class Rooter {
	private double precision;

	public Rooter(double precision) {
		this.precision = precision;
	}

	public void setPrecision(double precision) {
		this.precision = precision;
	}

	public double sqrt(double x) {
		double one, two;
		one = x / 2;

		while (true) {
			two = x / one;
			if (one == two) {
				return one;
			} else {
				if (one - two < precision && one - two > 0)
					return one;

				if (two - one < precision && two - one > 0)
					return two;

				one = (one + two) / 2;
			}
		}
	}

}
