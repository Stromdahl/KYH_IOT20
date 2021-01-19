package kyh.lectures.lecture13;

public class Statics {
    private String s = "Hello world";

    public void printString() {
        System.out.println(s);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Statics s1 = new Statics();
        s1.setS("Hej");
        Statics s2 = new Statics();
        s2.setS("Hej2");
        s1.printString();
        s2.printString();
    }
}
