package images;

//This class is an extension of ImageDecorator.
public class Filter extends ImageDecorator {

	// Class properties:
	private RGB filter;

	// Constructor:
	public Filter(Image base, RGB filter) {
		super(base);
		this.filter = filter;
	}

	@Override
	// This method,returns the filtered RGB of x,y on the base image.
	public RGB get(int x, int y) {
		return getBase().get(x, y).filter(filter);
	}

}
