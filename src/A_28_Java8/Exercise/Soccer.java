package A_28_Java8.Exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Soccer {

    static String path ="src/A_28_Java8/Exercise/28_Java8_Aufgaben_TeamDE.txt";
    static LinkedList<Player> players = new LinkedList<>();

    public static void main(String[] args) {

        Soccer soccer = new Soccer();
        soccer.loadPlayers();

        System.out.println("\nAlle Spieler:");
        Stream.of(players).sequential().forEach( System.out::println );

        System.out.println("\nAlle Spieler, sortiert nach Rückennummer:");
        players.stream()
                .sorted((a, b) -> Player.comparePlayerByNumber(a, b))
                .forEach(System.out::println);


        System.out.println("\nAlle Spieler, mit mehr als 50 Länderspielen, sortiert nach (Vor-)Name:");
        players.stream()
                .filter(n->(n.getGames()>50))
                //.filter(player -> player.getPosition().equals("Torwart"))
                .sorted( (a,b) ->Player.comparePlayerByName(a,b))
                .forEach(System.out::println);

        System.out.println("\nSämtliche Clubs der Spieler, wobei jeder Club nur genau 1x ausgegeben werden soll: ");
        players.stream()
                .map(Player::getClub ) // Extrahiere den Club für jeden Spieler
                .distinct() // Entferne Duplikate
                .forEach(System.out::println); // Gib jeden Club aus


        System.out.println("\nWie viele der Spieler weniger als 5 Tore geschossen haben: ");
        System.out.println(players.stream()
                                .filter(n->(n.getGoals()<5))
                                .count());


        System.out.println("\nWie viele Tore alle Spieler des Kaders insgesamt erzielt haben: ");
        System.out.println(players.stream()
                .mapToInt(Player::getGoals) // Extrahiere die Anzahl der Tore für jeden Spieler
                .sum()); // Summiere alle Tore

    }




    public void loadPlayers() {
        Path p = Paths.get(path);
        try {
            List<Player> playerList = Files.readAllLines(p) // alle Zeilen lesen
                    .stream() // als Stream weiterverarbeiten
                    .map(this::parsePlayer) // Zeile in Player umwandeln
                    .filter(Objects::nonNull) // null-Werte aussortieren
                    .collect(Collectors.toList()); // Stream in Liste umwandeln

            players = new LinkedList<>(playerList); // Spielerliste zu LinkedList hinzufügen
        } catch (IOException ex) {
            System.err.println("Read error: " + ex.getLocalizedMessage());
        }
    }
    private Player parsePlayer(String line) {
        String[] p = line.split(";");
        return new Player(
                Integer.parseInt(p[0]), // umwandeln in Integer
                p[1],
                p[2],
                p[3],
                p[4],
                Integer.parseInt(p[5]), // umwandeln in Integer
                Integer.parseInt(p[6]) // umwandeln in Integer
        );

    }
}