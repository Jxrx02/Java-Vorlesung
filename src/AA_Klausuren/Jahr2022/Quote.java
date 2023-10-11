package AA_Klausuren.Jahr2022;

public class Quote {
  private String text, person, role, source;
  private QuoteType quoteType;

  public Quote(String part, String part1, String part2, String part3, QuoteType quoteType) {
    this.text = part;
    this.person = part1;
    this.role = part2;
    this.source = part3;
    this.quoteType = quoteType;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getPerson() {
    return person;
  }

  public void setPerson(String person) {
    this.person = person;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public QuoteType getQuoteType() {
    return quoteType;
  }

  public void setQuoteType(QuoteType quoteType) {
    this.quoteType = quoteType;
  }

  public String getCitation() {
    return  "From: " + person +
            " (" + role +
            ", " + source +
            ")";
  }
}
