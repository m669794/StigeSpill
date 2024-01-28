package no.hvl.dat109;

import java.util.Random;

public class Terning {
    private Random random;

    public Terning() {
        random = new Random();
    }

    public int trill() {
        return random.nextInt(6) + 1; // Genererer et tilfeldig tall mellom 1 og 6
    }
}
