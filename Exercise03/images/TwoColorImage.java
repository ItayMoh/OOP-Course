package images;

//Class that represents an image built by using two given RGB colors
public class TwoColorImage extends BaseImage {

	// Class properties:
	private RGB zero;
	private RGB one;
	private TwoDFunc func;

	// Constructor.
	public TwoColorImage(int width, int height, RGB zero, RGB one, TwoDFunc func) {
		super(width, height);
		this.zero = zero;
		this.one = one;
		this.func = func;
	}

	@Override
	// Returns the RGB of x,y on the image.
	public RGB get(int x, int y) {
		double tmpX = ((double) x) / getWidth(); // 0<=x<=1
		double tmpY = ((double) y) / getHeight(); // 0<=y<=1
		double num = func.f(tmpX, tmpY); // use the f() function.
		if (num <= 0)
			return zero;
		if (num >= 1)
			return one;
		return RGB.mix(one, zero, num); // mixing.
	}
}
