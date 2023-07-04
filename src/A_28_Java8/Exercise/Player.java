package A_28_Java8.Exercise;

public class Player {

    private int Trikotnummer;
    private String name, position, birthday, club;
    private int games, goals;

    public Player(int trikotnummer, String name, String position, String birthday, String club, int games, int goals) {
        Trikotnummer = trikotnummer;
        this.name = name;
        this.position = position;
        this.birthday = birthday;
        this.club = club;
        this.games = games;
        this.goals = goals;
    }

    static int comparePlayerByNumber(Player p1, Player p2){
        //return Integer.compare(p1.getTrikotnummer(),p2.getTrikotnummer());
        //return p1.getTrikotnummer()-p2.getTrikotnummer();

        return Integer.compare(p2.getTrikotnummer(),p1.getTrikotnummer());

    }
    static int comparePlayerByName(Player p1, Player p2){
        return p1.getName().compareTo(p2.getName());
    }



    @Override
    public String toString() {
        return "Player{" +
                "Trikotnummer=" + Trikotnummer +
                ", name='" + name +
                ", position='" + position +
                ", birthday='" + birthday +
                ", club='" + club +
                ", games=" + games +
                ", goals=" + goals +
                '}';
    }

    public int getTrikotnummer() {
        return Trikotnummer;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getClub() {
        return club;
    }

    public int getGames() {
        return games;
    }

    public int getGoals() {
        return goals;
    }
}

