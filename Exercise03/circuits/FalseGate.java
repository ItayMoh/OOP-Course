package circuits;

//A subclass of Gate.f
public class FalseGate extends Gate {

	// Class properties:
	private static FalseGate instance = null; // singleton.

	// Constructor.
	private FalseGate() {
		super(null);
	}

	// A method to ensure a single instance
	public static Gate instance() {
		if (instance == null)
			instance = new FalseGate();
		return instance;
	}

	@Override
	// Method calculate the value of the gate (false).
	protected boolean func(boolean[] inValues) throws CircuitException {
		return false;
	}

	@Override
	// Returns the name of the FalseGate.
	public String getName() {
		return "F";
	}

	@Override
	// Simplify method
	public Gate simplify() {
		return this;
	}

}
