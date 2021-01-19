package kyh.lectures.lecture5;

public class Chicken extends Animal {
    public Chicken(String name) {
        super(name, "CHAAA!");
    }

    public String getName() {
        return "Kycklingen " + super.getName();
    }

    public void printSound() {
        System.out.println("Kuckelikuu!");
    }
}
