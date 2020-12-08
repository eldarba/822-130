package a;

public abstract class Sport implements Rulles {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getRulles() {
		return "general rulles";
	}

}
