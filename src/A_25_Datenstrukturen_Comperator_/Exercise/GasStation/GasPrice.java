package A_25_Datenstrukturen_Comperator_.Exercise.GasStation;

public class GasPrice<T> {
    String diesel;
    String superE5;
    String superE10;

    @Override
    public String toString() {
        return "GasPrice{" +
                "diesel='" + diesel + '\'' +
                ", superE5='" + superE5 + '\'' +
                ", superE10='" + superE10 + '\'' +
                '}';
    }

    public GasPrice(String key, String diesel, String superE5, String superE10) {

        this.diesel = diesel;
        this.superE5 = superE5;
        this.superE10 = superE10;
    }
}
