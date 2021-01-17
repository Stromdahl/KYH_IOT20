package kyh.lectures.lecture11;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void swap(List<Integer> l, int i, int j) {
        int tmp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, tmp);
    }

    public static void sort(List<Integer> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i; j<list.size(); j++) {
                if(list.get(j) > list.get(i)) {
                    swap(list, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10;i++) {
            list.add((int)(Math.random()*9+1));
        }
        sort(list);
        for(int l: list) {
            System.out.println(l);
        }
    }
}
