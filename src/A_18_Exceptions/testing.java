package A_18_Exceptions;

import java.util.Scanner;

public class testing {

    public static void main(String[] args) throws myException {
        try {
            System.out.print("Please enter an integer: ");
            Scanner scan = new Scanner(System.in);
            String input = scan.next(); // String einlesen

            //raise exception
            if(Integer.parseInt(input) == 0)
                throw new myException("hi");

            int intNumber = Integer.parseInt(input);
            System.out.println("Tripled: " + 3 * intNumber);

            //mehrere exceptions
        } catch (NumberFormatException | myException e) {
            System.err.println("Error during conversion: "
                    + e.getMessage());
            e.printStackTrace();
        }

    }
}
