package c.enums.machines;

public class Machine {

	private int id;
	private MachineMode mode;

	public Machine(int id) {
		super();
		this.id = id;
		this.mode = MachineMode.OFF;
	}

	public MachineMode getMode() {
		return mode;
	}

	public void setMode(MachineMode mode) {
		this.mode = mode;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", mode=" + mode + "]";
	}

}
