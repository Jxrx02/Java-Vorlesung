package A_28_Java8;

public record Record(
        int trikotnummer,
        String name,
        String position,
        String birthday,
        String club,
        int games,
        int goals
) {

    static int comparePlayerByNumber(Record p1, Record p2) {
        return Integer.compare(p2.trikotnummer, p1.trikotnummer);
    }

    static int comparePlayerByName(Record p1, Record p2) {
        return p1.name.compareTo(p2.name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "trikotnummer=" + trikotnummer +
                ", name='" + name +
                ", position='" + position +
                ", birthday='" + birthday +
                ", club='" + club +
                ", games=" + games +
                ", goals=" + goals +
                '}';
    }

}