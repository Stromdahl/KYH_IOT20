package com.company.exampletest;

import java.lang.reflect.Array;
import java.util.ArrayList;

class Competitor {
    String name;
    int score;

    public Competitor(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class HighScore {
    ArrayList<Competitor> competitors;

    public HighScore() {
        competitors = new ArrayList<>();
    }

    public void addCompetitorToList(Competitor competitor) {
        if(competitors.size() == 0) {
            return;
        }
        for (int i = 0; i < competitors.size(); i++) {
            Competitor tmp = competitors.get(i);
            if (competitor.score < tmp.score) {
                competitors.add(i, competitor);
                competitor = tmp;
            }
        }
    }

    public void printList() {
        for (int i = 0; i < competitors.size(); i++) {
            Competitor competitor =  competitors.get(i);
            System.out.println((i + 1) + ". " + competitor.name + " with " + competitor.score + " points");
        }
    }

    public static void main(String[] args) {
        HighScore highScore = new HighScore();
        highScore.addCompetitorToList(new Competitor("Anna", 10));
        highScore.addCompetitorToList(new Competitor("Bertil", 100));
        highScore.addCompetitorToList(new Competitor("Cecilia", 50));
        highScore.addCompetitorToList(new Competitor("Dennis", 1000));
        highScore.printList();
    }
}


/*
package com.company.exampletest;

class Competitor {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Competitor(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
class HighScore {
    Competitor[] competitors;//Competitor[] list;
    public HighScore() {
        competitors = new Competitor[10];
        for(int i=0;i<=9;i++) {
            competitors[i] = new Competitor("Not occupied", 0);
        }
    }

    public void addCompetitorToList(Competitor nextCompetitor) { //Competitor c
        //Competitor upNextCmp = c;
        for(int i=0;i< competitors.length;i++) {
            Competitor tmp = competitors[i];
            if(nextCompetitor.getScore() < tmp.getScore()) {
                competitors[i] = nextCompetitor;
                nextCompetitor = tmp;
            }
        }
    }

    public void printList() {
        for(int i=0;i< competitors.length;i++) {
            System.out.println((i+1) + ". " + competitors[i].getName() + " with " + competitors[i].getName() + " points");
        }
    }

    public static void main(String[] args) {
        HighScore hs = new HighScore();
        hs.printList();
        hs.addCompetitorToList(new Competitor("Anna", 10));  hs.addCompetitorToList(new Competitor("Bertil", 100));  hs.addCompetitorToList(new Competitor("Cecilia", 50));  hs.addCompetitorToList(new Competitor("Dennis", 1000));  hs.printList();
    }
}
*/
