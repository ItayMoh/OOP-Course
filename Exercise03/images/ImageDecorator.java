package images;

public abstract class ImageDecorator implements Image {
	// class properties:
	private Image base;

	// constructor.
	public ImageDecorator(Image base) {
		this.base = base;
	}

	@Override
	// getWidth method, returns the width.
	public int getWidth() {
		return base.getWidth();
	}

	@Override
	// getHeight method, returns the height.
	public int getHeight() {
		return base.getHeight();
	}

	@Override
	// get method, returns the RGB of x,y on the base image.
	public RGB get(int x, int y) {
		return base.get(x, y);
	}

	// getBase method, return the base image of the class.
	public Image getBase() {
		return base;
	}
}
