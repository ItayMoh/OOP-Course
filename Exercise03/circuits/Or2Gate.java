package circuits;

//A subclass of OrGate.
public class Or2Gate extends OrGate {

	// Constructor:
	public Or2Gate(Gate o1, Gate o2) {
		super(new Gate[] { o1, o2 });
	}
}
