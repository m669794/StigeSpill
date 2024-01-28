package no.hvl.dat109;

import java.util.List;

public class StigeSpill {
    private Brett brett;
    private List<Spiller> spillere;
    private Terning terning;

    
    //Oppretter spillet.
    public StigeSpill(Brett brett, List<Spiller> spillere, Terning terning) {
        this.brett = brett;
        this.spillere = spillere;
        this.terning = terning;
    }

    //Spill logikk. System.out maa slettes.
    public void spill() {
        while (!erSlutt()) {
            for (Spiller spiller : spillere) {
                int kast = terning.trill();
                System.out.println(spiller.getNavn() + " kaster " + kast);
                int nyPosisjon = spiller.getPosisjon() + kast;
                Rute rute = brett.hentRute(nyPosisjon);
                if (rute != null) {
                    switch (rute.getType()) {
                        case SNAKE:
                            System.out.println("Beklager, du havnet paa en slange! Flytter ned til rute " + rute.getDestinasjon());
                            spiller.setPosisjon(rute.getDestinasjon());
                            break;
                        case LADDER:
                            System.out.println("Gratulerer, du klatrer opp en stige! Flytter til rute " + rute.getDestinasjon());
                            spiller.setPosisjon(rute.getDestinasjon());
                            break;
                        default:
                            spiller.setPosisjon(nyPosisjon);
                            break;
                    }
                }
                System.out.println(spiller.getNavn() + " er na paa rute " + spiller.getPosisjon());
                if (spiller.getPosisjon() >= 100) {
                    System.out.println(spiller.getNavn() + " har vunnet!");
                    return;
                }
            }
        }
    }
    
    //Sjekke om spillet er over.
    private boolean erSlutt() {
        for (Spiller spiller : spillere) {
            if (spiller.getPosisjon() >= 100) {
                return true;
            }
        }
        return false;
    }
}
