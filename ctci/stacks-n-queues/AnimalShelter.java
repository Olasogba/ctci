import java.util.LinkedList;

/**
 *  Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
    out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
    or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
    that type). They cannot select which specific animal they would like. Create the data structures to
    maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
    and dequeueCat. You may use the built-in Linked list data structure. 
 */



public class AnimalShelter {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    

    public static void main(String[] args) {
        var shelter = new AnimalShelter();
        shelter.enqueue(new Dog("Bingo"));
        shelter.enqueue(new Dog("Chelsea"));
        shelter.enqueue(new Cat("girly"));
        shelter.enqueue(new Dog("Ashley"));
        shelter.enqueue(new Cat("Melfey"));

        System.out.println(shelter.dequeueCat().name);


        var q = new Queue<Integer>();
        q.add(1);
        q.print();
    }


    public void enqueue(Animal animal) {
        animal.order = order;
        if(animal instanceof Cat) {
            this.cats.addLast((Cat)animal);
        } else {
            this.dogs.addLast((Dog) animal);
        }

        order++;
    }


    public Animal dequeueAny() {
        // remove the last from either
        var cat = this.cats.peek();
        var dog = this.dogs.peek();
        if(cat==null) return this.dequeueDog();
        if(dog==null) return this.dequeueCat();
        
        if(dog.order > cat.order) return cat;
        else return dog;
    }


    public Animal dequeueDog() {
        return this.dogs.poll();
    }


    public Animal dequeueCat() {
        return this.cats.poll();
    }
}

abstract class Animal {
    public int order;
    public String name;


    public Animal(String name) {
        this.name = name;
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}