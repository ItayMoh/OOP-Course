package circuits;

//A subclass of AndGate.
public class And2Gate extends AndGate {

	// Constructor:
	public And2Gate(Gate g1, Gate g2) {
		super(new Gate[] { g1, g2 });
	}

}
