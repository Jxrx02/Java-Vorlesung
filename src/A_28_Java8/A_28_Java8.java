package A_28_Java8;

import java.util.ArrayList;
import java.util.List;

public class A_28_Java8 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        // Namen hinzufügen ...
        names.add("Bern");
        // Gibt nacheinander alle Namen aus
        names.forEach( System.out::println );
    }
}
