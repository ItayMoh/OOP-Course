package circuits;

//An abstract class that describes a general logic gate.
public abstract class Gate {

	// Class properties:
	protected Gate[] inGates;

	// Constructor:
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}

	// Boolean value calculation of the logic gate.
	// If not all variables have a value, an exception will be thrown.
	public boolean calc() throws CircuitException {
		try {
			if (inGates == null) // The gate array is empty
				return func(null);
			boolean temp[] = new boolean[inGates.length];
			for (int i = 0; i < temp.length; i++)
				temp[i] = inGates[i].calc();
			return func(temp);
		} catch (Exception e) { // catch any exception and throw my exception instead.
			throw new CircuitException();
		}
	}

	// An abstract method that calculates what the gateway is supposed to figure
	// given a boolean array.
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

	// An abstract method that returns the name of the gate.
	public abstract String getName();

	// An abstract method that returns the gate after simplification.
	public abstract Gate simplify();

	@Override
	// toString method
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		if (inGates == null)
			return sb.toString();
		if (getName().charAt(0) == 'V')
			return sb.toString();
		sb.append("[");
		for (int i = 0; i < inGates.length; i++) {
			sb.append(inGates[i].toString());
			if (i + 1 != inGates.length)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();

	}
}
