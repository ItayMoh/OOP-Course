package images;

// This class is an extension of BaseImage.
public class Circle extends BaseImage {

	// Class properties:
	private int centerX, centerY, radius;
	private RGB center, outside;

	// Constructor:
	public Circle(int width, int height, int centerX, int centerY, int radius, RGB center, RGB outside) {
		super(width, height);
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	// Constructor:
	public Circle(int size, int radius, RGB center, RGB outside) {
		super(size, size);
		centerX = size / 2;
		centerY = size / 2;
		this.radius = radius;
		this.center = center;
		this.outside = outside;
	}

	// Method that calculates and returns the RGB of pixel x,y on the image.
	@Override
	public RGB get(int x, int y) {
		double dis = distanceFromCenter(x, y);
		double alpha = dis / (double) radius;
		if (alpha > 1) // if the distance if above the radius (out of the circle) no need to mix.
			alpha = 1;
		return RGB.mix(outside, center, alpha);
	}

	// Private method which gets x,y and it calculates and returns the
	// distance from x,y to the center of the circle.
	private double distanceFromCenter(double x, double y) {
		double dx = centerX - x;
		double dy = centerY - y;
		return Math.sqrt(dx * dx + dy * dy);
	}

}
