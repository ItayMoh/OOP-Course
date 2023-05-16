package images;

// This Class is an extension of BaseImage. 
public class Gradient extends BaseImage {

	// Class properties:
	private RGB start;
	private RGB end;

	public Gradient(int width, int height, RGB start, RGB end) {
		super(width, height);
		this.start = start; // the color in the right column
		this.end = end; // the color in the left column.
	}

	@Override
	public RGB get(int x, int y) {
		double alpha = (double) x / getWidth(); // the mixing parameter.
		return RGB.mix(end, start, alpha);
	}

}
