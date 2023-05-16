package images;

//An abstract class that implement Image.
public abstract class BinaryImageDecorator implements Image {

	// class properties:
	protected Image base1;
	protected Image base2;
	private int width;
	private int height;

	// Constructor.
	public BinaryImageDecorator(Image base1, Image base2) {
		this.base1 = base1;
		this.base2 = base2;
		this.width = Math.max(base1.getWidth(), base2.getWidth());
		this.height = Math.max(base1.getHeight(), base2.getHeight());
	}

	// Returns the width of base1.
	public int getBase1Width() {
		return base1.getWidth();
	}

	// Returns the height of base1.
	public int getBase1Height() {
		return base1.getHeight();
	}

	// Returns the width of base2.
	public int getBase2Width() {
		return base2.getWidth();
	}

	// Returns the height of base2.
	public int getBase2Height() {
		return base2.getHeight();
	}

	@Override
	// Returns the max width of base1 and base2 by default.
	public int getWidth() {
		return width;
	}

	@Override
	// Returns the max height of base1 and base2 by default.
	public int getHeight() {
		return height;
	}

	@Override
	// Returns the RGB of index (x,y) on the image.
	public RGB get(int x, int y) {
		return new RGB(0, 0, 0);
	}
}
