package d.abstracts.animals;

public class Zoo {

	private Animal[] animals = new Animal[10];
	private int index;

	public void makeAllAnimalSpeak() {
		for (int i = 0; i < animals.length; i++) {
			Animal currAnimal = animals[i];
			if (currAnimal != null) {
				currAnimal.speak();
			}
		}
	}

	public void add(Animal animal) {
		animals[index] = animal;
		index++;
	}

}
