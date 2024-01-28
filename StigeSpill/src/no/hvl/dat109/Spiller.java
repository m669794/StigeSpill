package no.hvl.dat109;

public class Spiller {
    private String navn; 
    private int posisjon; // Plassering paa brettet.

    public Spiller(String navn) {
        this.navn = navn;
        this.posisjon = 1; // Startposisjon er 1
    }

    public String getNavn() {
        return navn;
    }

    public int getPosisjon() {
        return posisjon;
    }

    public void setPosisjon(int posisjon) {
        this.posisjon = posisjon;
    }
}
