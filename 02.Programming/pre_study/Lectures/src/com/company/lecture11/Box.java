package com.company.lecture11;

public class Box<T>{
    private T content;

    public Box(T i){
        this.content = i;
    }

    public T getContent(){
        return content;
    }

    public void setContent(T i){
        this.content = i;
    }

}
