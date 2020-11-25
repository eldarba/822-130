package d.abstracts.animals;

public class TestZoo {

	public static void main(String[] args) {

		Zoo zoo = new Zoo();

		zoo.add(new Fox());
		zoo.add(new Cat());
		zoo.add(new Ant());
		zoo.add(new Butterfly());
		zoo.add(new Bat());

		zoo.makeAllAnimalSpeak();
	}
}
