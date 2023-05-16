package circuits;

//A subclass of Gate.
public class NotGate extends Gate {

	// Constructor:
	public NotGate(Gate in) {
		super(new Gate[] { in }); // allocate the array of gate to one gate and sets the gate into the array.
	}

	@Override
	// Method calculate the value of the gate.
	protected boolean func(boolean[] inValues) throws CircuitException {
		try {
			if (inValues[0] == true) // returns the opposite.
				return false;
			return true;
		} catch (Exception e) { // catch any exception and throw my exception instead.
			throw new CircuitException();
		}
	}

	@Override
	// Returns the name of the Not Gate.
	public String getName() {
		return "NOT";
	}

	@Override
	// Simplify method
	public Gate simplify() {
		if (inGates[0] instanceof NotGate)
			return inGates[0].inGates[0].simplify();
		if (inGates[0] instanceof FalseGate)
			return TrueGate.instance();
		if (inGates[0] instanceof TrueGate)
			return FalseGate.instance();
		return this;
	}

}
