package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HighScore highScore = new HighScore();
        ArrayList<Score> scores =  highScore.getScoresFromFile();
        scores.forEach(score -> System.out.println(score.toString()));
    }
}