package no.hvl.dat109;

public class Rute {
    private int position;
    private Type type;
    private int destinasjon;

    public enum Type {
        NORMAL,
        SNAKE,
        LADDER
    }

    public Rute(int position, Type type, int destinasjon) {
        this.position = position;
        this.type = type;
        this.destinasjon = destinasjon;
    }

    public int getPosition() {
        return position;
    }

    public Type getType() {
        return type;
    }

    public int getDestinasjon() {
        return destinasjon;
    }
}
