package kyh.lectures.lecture10;

public class Broccoli implements Food {
    private static int numberOfCalories = 60;

    public Broccoli() {

    }

    public int getNumberOfCalories() {
        return numberOfCalories;
    }

    public String getColor() {
        return "Green";
    }
}
