package kyh.lectures.lecture10;

public class Person {
    protected int needForCalories;
    private int currentIntakeOfCalories;

    public Person(int needForCalories) {
        this.needForCalories = needForCalories;
    }

    public boolean isFull() {
        return currentIntakeOfCalories >= needForCalories;
    }

    public void eat(Food f) {
        currentIntakeOfCalories += f.getNumberOfCalories();
    }

    public void printEatenCaloriesToday() {
        System.out.println(currentIntakeOfCalories + "/" + needForCalories);
    }

    public boolean equals(Person p) {
        return p.needForCalories == this.needForCalories &&
               p.currentIntakeOfCalories == this.currentIntakeOfCalories;
        /*
        if(p.needForCalories == this.needForCalories) {
            return true;
        } else {
            return false;
        }
        */
        /*
        boolean result = (p.needForCalories == this.needForCalories);
        return result;
         */

    }
}
