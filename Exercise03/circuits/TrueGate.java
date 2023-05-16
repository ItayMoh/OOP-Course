package circuits;

//A subclass of Gate.
public class TrueGate extends Gate {

	// Class properties:
	private static TrueGate instance = null; // singleton.

	// Constructor.
	private TrueGate() {
		super(null);
	}

	// A method to ensure a single instance
	public static Gate instance() {
		if (instance == null)
			instance = new TrueGate();
		return instance;
	}

	@Override
	// Method calculate the value of the gate (true).
	protected boolean func(boolean[] inValues) throws CircuitException {
		return true;
	}

	@Override
	// Returns the name of the TrueGate.
	public String getName() {
		return "T";
	}

	@Override
	// Simplify method
	public Gate simplify() {
		return this;
	}

}
