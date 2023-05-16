package images;

//An inheriting subclass extension of BinaryImageDecorator class.
public class Mix extends BinaryImageDecorator {

	//Class properties:
	private double alpha;

	//Constructor.
	public Mix(Image base1, Image base2, double alpha) {
		super(base1, base2);
		this.alpha = alpha;
	}

	@Override
	//RFeturns the RGB of index (x,y) on the image.
	public RGB get(int x, int y) {
		// in both:
		if (x < getBase1Width() && x < getBase2Width() && y < getBase1Height() && y < getBase2Height())
			return RGB.mix(base1.get(x, y), base2.get(x, y), alpha);
		// in base1 but not in base2:
		if (x < getBase1Width() && y < getBase1Height() && (x >= getBase2Width() || y >= getBase2Height()))
			return base1.get(x, y);
		// in base2 but not in base1:
		if (x < getBase2Width() && y < getBase2Height() && (x >= getBase1Width() || y >= getBase1Height()))
			return base2.get(x, y);
		// else: not in bound of any of the bases:
		return new RGB(0, 0, 0);
	}

}
