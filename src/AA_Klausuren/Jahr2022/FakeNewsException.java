package AA_Klausuren.Jahr2022;

public class FakeNewsException extends Exception {
  public FakeNewsException() {
    super("Provided quote catalog does not contain enough (hot|bull)shit!");
  }

  public FakeNewsException(String message) {
    super(message);
  }
}