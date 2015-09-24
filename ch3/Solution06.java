package ch3;

import java.util.LinkedList;

public class Solution06 {

    /**
     * Use two linkedlist to separately store dog and cat
     * Use an array to store the type information of the animal added, with cat as 0, dog as 1, empty slot as -1
     * */
    private static class AnimalShelter{
        final static int SHELTER_SIZE = 200;
        final static int EMPTY_SLOT = -1;

        int[] indicator = new int[SHELTER_SIZE];
        int animalNum = 0;

        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();

        AnimalShelter(){
            for(int i = 0; i < indicator.length; i++)
                indicator[i] = EMPTY_SLOT;
        }

        void enqueue(Animal a){
            if(a.type == Animal.CAT){
                cats.add((Cat)a);
                indicator[animalNum] = Animal.CAT;
            }
            if(a.type == Animal.DOG){
                dogs.add((Dog)a);
                indicator[animalNum] = Animal.DOG;
            }

            animalNum++;
        }

        Animal dequeueAny() {
            if(animalNum == 0)
                return null;

            int i = 0;
            while (indicator[i] == EMPTY_SLOT)
                i++;

            // dequeue the certain animal
            Animal a = null;

            if (indicator[i] == Animal.CAT)
                a = cats.poll();
            if (indicator[i] == Animal.DOG)
                a = dogs.poll();

            // update the indicator list
            indicator[i] = EMPTY_SLOT;
            animalNum -- ;

            return a;
        }
        Cat dequeueCat(){
            if (cats.isEmpty())
                return null;

            int i = 0;
            while(indicator[i] != Animal.CAT)
                i++;

            indicator[i] = EMPTY_SLOT;

            return cats.poll();
        }

        Dog dequeueDog(){
            if (dogs.isEmpty())
                return null;

            int i = 0;
            while(indicator[i] != Animal.DOG)
                i++;

            indicator[i] = EMPTY_SLOT;

            return dogs.poll();
        }

    }



    public static void main(String[] args) {
        Dog dog1 = new Dog("Tony1");
        Dog dog2 = new Dog("Tony2");
        Dog dog3 = new Dog("Tony3");
        Cat cat1 = new Cat("Cleo1");
        Cat cat2 = new Cat("Cleo2");
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);
        shelter.enqueue(cat2);
        shelter.enqueue(dog3);
        System.out.println("Animals in the shelter (in sequence)..");
        System.out.format("%s %s %s %s %s\n", dog1.getName(), cat1.getName(), dog2.getName(), cat2.getName(), dog3.getName());

        System.out.println("Dequeue any animal..");
        System.out.println(shelter.dequeueAny().getName());
        System.out.println("Dequeue a dog..");
        System.out.println(shelter.dequeueDog().getName());
        System.out.println("Dequeue a cat..");
        System.out.println(shelter.dequeueCat().getName());
    }

    private static abstract class Animal{
        final static int CAT = 0;
        final static int DOG = 1;

        int type;
        String name;

        Animal(String name) {
            this.name = name;
        }

        String getName(){
            return this.name;
        }

    }

    private static class Cat extends Animal {
        Cat(String name){
            super(name);
            type = CAT;
        }
    }

    private static class Dog extends Animal {
        Dog(String name){
            super(name);
            type = DOG;
        }
    }





}
