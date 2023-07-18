package AA_Klausuren.Jahr2020;

import java.util.Date;

public class Token {

    private String value;
    private Date date;


    public Token() {
        value = java.util.UUID.randomUUID().toString();
        date = new Date();

    }

    public Token(String value, Date date) {
        this.value = value;
        this.date = date;
    }

    @Override
    public String toString() {
        return value + ";"+  date ;
    }

    public Date getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }
}

