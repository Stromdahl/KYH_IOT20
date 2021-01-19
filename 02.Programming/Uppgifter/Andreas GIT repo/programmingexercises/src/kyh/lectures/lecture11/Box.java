package kyh.lectures.lecture11;

import java.util.Scanner;

public class Box<T> {
    private T content;

    public Box(T i) {
        this.content = i;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T i) {
        this.content = i;
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<>(5);
        System.out.println(box.getContent() * 5);
        box.setContent(1);
        System.out.println(box.getContent());

        Box<Double> box2 = new Box<>(1.5);
        box2.setContent(6.0);
    }
}
