package main.lessons.lesson9.solid.open;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Barsik");
        Animal animal2 = new Animal("Rijik");
        Animal animal3 = new Animal("Murzik");
        AnimalOperations animalOperations = new AnimalOperationsWithLog();
        animalOperations.saveAnimal(animal);
        animalOperations.saveAnimal(animal2);
        animalOperations.saveAnimal(animal3);
        System.out.println(animalOperations.getAnimal(animal2));
    }

}
