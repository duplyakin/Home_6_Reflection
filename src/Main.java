import java.util.ArrayList;

/**
 * Created by Vlad on 16.12.2016.
 */
public class Main {
    public static void main(String[] args) {



        Dog dog = new Dog();
        dog.setSpeed(10.10);
        dog.setAge(7);
        dog.setName("Reks");

        Dog youngdog = new Dog();
        dog.setSpeed(10.10);
        dog.setAge(3);
        dog.setName("Bobby");

        Cat cat = new Cat();
        cat.setColor(1);
        cat.setAge(3);
        cat.setName("Garfield");

        Person oldPerson = new Person(dog);
        oldPerson.setAge(70);
        oldPerson.setFirstName("Alex");
        oldPerson.setLastName("Ivanov");
        oldPerson.setWeight(170);
        oldPerson.setHeight(70);
        oldPerson.setPet(dog);

        Person youngPerson = new Person(dog);
        youngPerson.setAge(20);
        youngPerson.setFirstName("Ivan");
        youngPerson.setLastName("Aleksandrov");
        youngPerson.setWeight(160);
        youngPerson.setHeight(60);
        youngPerson.setPet(dog);


        Alien alien = new Alien(cat);
        alien.setColor(2);
        alien.setAge(999);
        alien.setFirstName("Yoda");
        alien.setWeight(10);
        alien.setHeight(10);
        alien.setPet(cat);
        System.out.println("oldPerson:");
        System.out.println(oldPerson);
        System.out.println("youngPerson:");
        System.out.println(youngPerson);
        System.out.println(alien);
        BeanUtils beanUtils = new BeanUtils();
        System.out.println("youngPerson ---> oldPerson");
        beanUtils.assign(youngPerson, oldPerson);
        System.out.println("youngPerson:");
        System.out.println(youngPerson);

        System.out.println("youngPerson ---> alien");
        beanUtils.assign(youngPerson, alien);
        System.out.println("youngPerson:");
        System.out.println(youngPerson);

        int[] array = new int[10];


    }
}
