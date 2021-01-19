package kyh.lectures.lecture12.arvrepetition;

public class Box {
    private int side;

    public Box(int side) {
        this.side = side;
    }

    // Fråga: Hur gör man denna mer synlig om man vill komma åt den utifrån för testning till exempel?
    // Svar: Ärv klassen, och ändra synligheten. Se BoxPublic.java
    int getVolume() {
        // Räknar ut totala volymen på kuben
        return this.side * this.side * this.side;
    }
}
