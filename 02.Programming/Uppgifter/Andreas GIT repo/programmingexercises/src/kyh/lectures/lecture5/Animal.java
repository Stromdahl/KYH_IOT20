package kyh.lectures.lecture5;

public class Animal {
    protected String name;
    protected String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public Animal(String name) {
        this(name, "LÄTE!");
    }

    protected int calculateSpeed() {
        return name.length()*5;
    }

    public String getName() {
        return name;
    }

    public void setName(String inputName) {
        name = inputName;
    }

    public void printSound() {
        System.out.println(name + ": " + sound);
    }

    public final void printRunning() {
        System.out.println("I'm running");
    }
}
