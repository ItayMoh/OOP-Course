package circuits;

//A subclass of Gate.
public class AndGate extends Gate {

	// Constructor.
	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	@Override
	// Method calculate the value of the gate.
	protected boolean func(boolean[] inValues) throws CircuitException {
		try {
			boolean flag = true;
			for (int i = 0; i < inValues.length; i++)
				flag = inValues[i] && flag;
			return flag;
		} catch (Exception e) { // catch any exception and throw my exception instead.
			throw new CircuitException();
		}

	}

	@Override
	// Returns the name of the And Gate.
	public String getName() {
		return "AND";
	}

	@Override
	// Simplify method
	public Gate simplify() {
		Gate tempGate;
		int count = 0;
		for (int i = 0; i < inGates.length; i++) { // pass all the gates}
			tempGate = inGates[i].simplify();
			if (tempGate instanceof FalseGate) // If a GateTrue is found
				return FalseGate.instance();
			if (!(tempGate instanceof TrueGate))
				count++;
			if (i + 1 == inGates.length && count == 0) // only true values
				return tempGate;
		}
		Gate[] varGate = new Gate[count];
		int flag = 0;
		for (int j = 0; j < inGates.length; j++) { // pass all the gates
			tempGate = inGates[j].simplify();
			if (!(tempGate instanceof TrueGate))
				varGate[flag++] = inGates[j].simplify();
		}
		if (count == 1)
			return varGate[0];
		return new AndGate(varGate);

	}
}
