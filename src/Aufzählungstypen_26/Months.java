package Aufzählungstypen_26;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public enum Months {
    JANUARY("January", 31, "Hartung"),
    FEBRUARY("February", 28, "Hornung"),
    MARCH("March", 31, "Lenzing"),
    APRIL("April", 30, "Ostermond"),
    MAY("May", 31, "Winnemond"),
    JUNE("June", 30, "Brachet"),
    JULY("July", 31, "Heuert"),
    AUGUST("August", 31, "Ernting"),
    SEPTEMBER("September", 30, "Scheiding"),
    OCTOBER("October", 31, "Gilbhart"),
    NOVEMBER("November", 30, "Nebelung"),
    DECEMBER("December", 31, "Julmond");

    private final String name;
    private final int days;
    private final String oldGermanName;

    Months(String name, int days, String oldGermanName) {
        this.name = name;
        this.days = days;
        this.oldGermanName = oldGermanName;
    }
    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public String getOldGermanName() {
        return oldGermanName;
    }

    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);
        Months currentMonth = Months.valueOf(currentDate.getMonth().name());

        System.out.println("Current Month: " + currentMonth.getName());
        System.out.println("Days: " + currentMonth.getDays());
        System.out.println("Old German Name: " + currentMonth.getOldGermanName());



    }
}
