package circuits;

//A subclass of Gate.
public class OrGate extends Gate {

	// Constructor.
	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// Method calculate the value of the gate.
	protected boolean func(boolean[] inValues) throws CircuitException {
		try {
			boolean flag = false;
			for (int i = 0; i < inValues.length; i++)
				flag = inValues[i] || flag;
			return flag;
		} catch (Exception e) { // catch any exception and throw my exception instead.
			throw new CircuitException();
		}

	}

	@Override
	// Returns the name of the Or Gate.
	public String getName() {
		return "OR";
	}

	@Override
	// Simplify method
	public Gate simplify() {
		Gate tempGate;
		int count = 0;
		for (int i = 0; i < inGates.length; i++) { // pass all the gates}
			tempGate = inGates[i].simplify();
			if (tempGate instanceof TrueGate) // If a GateTrue is found
				return TrueGate.instance();
			if (!(tempGate instanceof FalseGate))
				count++;
			if (i + 1 == inGates.length && count == 0)
				return tempGate;
		}
		Gate[] varGate = new Gate[count];
		int flag = 0;
		for (int j = 0; j < inGates.length; j++) { // pass all the gates
			tempGate = inGates[j].simplify();
			if (!(tempGate instanceof FalseGate))
				varGate[flag++] = inGates[j].simplify();
		}
		if (count == 1)
			return varGate[0];
		return new OrGate(varGate);

	}
}
