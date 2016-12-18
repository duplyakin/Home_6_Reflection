/**
 * Created by Vlad on 16.12.2016.
 */
public class Alien {
    private String firstName;
    private int age;
    private int color;
    private double weight;
    private double  height;
    private Pet pet;

    public Alien(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", weight=" + weight +
                ", height=" + height +
                ", pet=" + pet +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
