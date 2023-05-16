package images;

// An abstract class that implement of Image.
// This class represents a basic of an image.
public abstract class BaseImage implements Image {

	// Class properties:
	private int width;
	private int height;

	// Constructor.
	public BaseImage(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	// getWidth method, returns the width.
	public int getWidth() {
		return width;
	}

	@Override
	// getHeight method, returns the height.
	public int getHeight() {
		return height;
	}

	@Override
	// get method, returns the RGB of x,y on the image. (default=white=1,1,1).
	public RGB get(int x, int y) {
		return new RGB(1);
	}
}
