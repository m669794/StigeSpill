package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Brett {
    private List<Rute> ruter;

    public Brett() {
        ruter = new ArrayList<>();
    }

    public void leggTilRute(Rute rute) {
        ruter.add(rute);
    }

    public Rute hentRute(int posisjon) {
        for (Rute rute : ruter) {
            if (rute.getPosition() == posisjon) {
                return rute;
            }
        }
        return null;
    }
}
