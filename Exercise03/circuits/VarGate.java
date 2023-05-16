package circuits;

//A subclass of Gate.
public class VarGate extends Gate {

	// Class properties:
	private String name;

	// Constructor
	public VarGate(String name) {
		super(null);
		this.name = name;
	}

	// Returns the name of the Gate.
	public String getName() {
		return "V" + name;
	}

	@Override
	// Method calculate the value of the gate.
	protected boolean func(boolean[] inValues) throws CircuitException {
		try {
			return inGates[0].calc();
		} catch (Exception e) { // catch any exception and throw my exception instead.
			throw new CircuitException();
		}
	}

	// setVal method.
	public void setVal(boolean value) {
		if (value == true)
			inGates = new Gate[] { TrueGate.instance() };
		else
			inGates = new Gate[] { FalseGate.instance() };
	}

	@Override
	// Simplify method
	public Gate simplify() {
		if (inGates != null)
			return inGates[0];
		return this; // return itself.

	}
}
