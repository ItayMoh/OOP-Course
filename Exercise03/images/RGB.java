package images;

// The class describes color in the RGB standard.
public class RGB {

	// Class properties:
	private double red;
	private double green;
	private double blue;

	// Given public predefined:
	public static final RGB BLACK = new RGB(0);
	public static final RGB WHITE = new RGB(1);
	public static final RGB RED = new RGB(1, 0, 0);
	public static final RGB GREEN = new RGB(0, 1, 0);
	public static final RGB BLUE = new RGB(0, 0, 1);

	// Constructor.
	// Method sets the RGB(red, green, blue) values to those got as arguments.
	public RGB(double red, double green, double blue) {
		this.red = red > 1 ? 1 : red < 0 ? 0 : red;
		this.green = green > 1 ? 1 : green < 0 ? 0 : green;
		this.blue = blue > 1 ? 1 : blue < 0 ? 0 : blue;
	}

	// Constructor
	// A method that initializes the base colors to all be gery's value.
	public RGB(double grey) {
		red = grey;
		green = grey;
		blue = grey;
	}

	// Method that return the red color.
	public double getRed() {
		return red;
	}

	// Method that return the blue color.
	public double getBlue() {
		return blue;
	}

	// Method that return the green color.
	public double getGreen() {
		return green;
	}

	// Method that returns a new RGB which is an inversion of the current one.
	// each field of the returned RGB is 1 minus the current.
	public RGB invert() {
		return new RGB(1 - red, 1 - green, 1 - blue);
	}

	// Method that returns a new RGB which is multiplied by the values of filter
	// RGB.
	public RGB filter(RGB filter) {
		return new RGB(red * filter.getRed(), green * filter.getGreen(), blue * filter.getBlue());
	}

	// Method that returns a new RGB built by the sum of two RGB.
	// The method represents the color creates by flashing both colors together.
	public static RGB superpose(RGB rgb1, RGB rgb2) {
		double r = rgb1.getRed() + rgb2.getRed();
		double g = rgb1.getGreen() + rgb2.getGreen();
		double b = rgb1.getBlue() + rgb2.getBlue();
		return new RGB(r, g, b); // check in the constructor if the sum is under 1.
	}

	// Method that returns a new RGB built by the calculated average of rgb1 and
	// rgb2
	// with alpha value. Using the formula: alpha * color1 + (1-alpha) * color2 .
	public static RGB mix(RGB rgb1, RGB rgb2, double alpha) {
		double r = alpha * rgb1.getRed() + (1 - alpha) * rgb2.getRed();
		double g = alpha * rgb1.getGreen() + (1 - alpha) * rgb2.getGreen();
		double b = alpha * rgb1.getBlue() + (1 - alpha) * rgb2.getBlue();
		return new RGB(r, g, b);
	}

	// toString method.
	public String toString() {
		return String.format("<%.4f, %.4f, %.4f>", red, green, blue);
	}

}
