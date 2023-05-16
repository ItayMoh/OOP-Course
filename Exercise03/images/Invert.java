package images;

//This class is an extension of ImageDecorator.
public class Invert extends ImageDecorator {

	// Constructor.
	public Invert(Image base) {
		super(base);
	}

	@Override
	// This method,returns the opposite (invert) RGB of x,y on the base image.
	public RGB get(int x, int y) {
		return getBase().get(x, y).invert();
	}

}
