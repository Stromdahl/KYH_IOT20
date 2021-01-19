package com.company.lecture11;

import java.util.List;

public class Sorter {

    public static void swap(List<Long> list, int i, int j){
        Long temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void bubbleSort(List<Long> list){
        boolean swapped;
        do{
            swapped = false;
            for(int i = 0; i < list.size()-1; i++){
                if(list.get(i) > list.get(i+1)){
                    swap(list, i, i+1);
                    swapped = true;
                }
            }
        }while(swapped);
    }

    public static void selectionSort(List<Long> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(i) > list.get(j)){
                    swap(list,i,j);
                }
            }
        }
    }
}
