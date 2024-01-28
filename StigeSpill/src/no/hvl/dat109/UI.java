package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class UI {
    public static void main(String[] args) {
        // Lag spillere
        Spiller player1 = new Spiller("Player 1");
        Spiller player2 = new Spiller("Player 2");

        // Lag brettruter
        List<Rute> squares = new ArrayList<>();
        squares.add(new Rute(1, Rute.Type.NORMAL, 0)); // Start square

        //Leggtil stige og slangeruter
        squares.add(new Rute(2, Rute.Type.LADDER, 38));
        squares.add(new Rute(5, Rute.Type.SNAKE, 14));
        squares.add(new Rute(9, Rute.Type.LADDER, 31));
        squares.add(new Rute(18, Rute.Type.SNAKE, 7));
        squares.add(new Rute(20, Rute.Type.LADDER, 41));
        squares.add(new Rute(24, Rute.Type.SNAKE, 5));
        squares.add(new Rute(39, Rute.Type.SNAKE, 3));
        squares.add(new Rute(47, Rute.Type.LADDER, 63));
        squares.add(new Rute(55, Rute.Type.SNAKE, 19));
        squares.add(new Rute(59, Rute.Type.LADDER, 80));
        squares.add(new Rute(65, Rute.Type.SNAKE, 36));
        squares.add(new Rute(70, Rute.Type.LADDER, 90));
        squares.add(new Rute(76, Rute.Type.SNAKE, 50));
        squares.add(new Rute(82, Rute.Type.LADDER, 100));

        // Lag brettet
        Brett board = new Brett();
        for (int i = 0; i < 100; i++) {
            // Sjekk om ruten er allerede lagt til (hopp over hvis det er en stige eller slangerute)
            boolean squareExists = false;
            for (Rute square : squares) {
                if (square.getPosition() == i + 1) {
                    squareExists = true;
                    break;
                }
            }
            if (!squareExists) {
                board.leggTilRute(new Rute(i + 1, Rute.Type.NORMAL, 0)); // Leggtil vanlig rute
            }
        }

        // Legg til stige og slangeruter på brettet
        for (Rute square : squares) {
            board.leggTilRute(square);
        }

        // Lag spillerliste
        List<Spiller> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        // Lag spillet
        StigeSpill game = new StigeSpill(board, players, new Terning());

        // Start spill
        game.spill();
    }
}
