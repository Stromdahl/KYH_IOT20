package kyh.lectures.lecture9;

public class Lecture9 {
    public static int numberOfItem;

    /**
     * Adds two numbers
     * @param a The first term
     * @param b The second term
     * @return the sum of both terms
     */
    public static int add(int a, int b) {
        return a+b;
    }

    public static void loopThroughAndPrintEveryIndex(int numberOfItem) {
        add(1,3);
        for(int i = 0; i < numberOfItem; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        loopThroughAndPrintEveryIndex(5);
        loopThroughAndPrintEveryIndex(10);
        System.out.println("Hello World");
        double pi = Math.PI;
    }
}
