package kyh.lectures.lecture10;

public class IceCream implements Food, Desert {

    @Override
    public int getNumberOfCalories() {
        return 360;
    }

    @Override
    public int getNumberOnDesertMenu() {
        return 7;
    }
}
