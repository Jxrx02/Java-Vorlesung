package AA_Klausuren.Jahr2021;

public enum Variant {

  WILD_TYPE("Wildtype", "SARS-CoV-2"),
  ALPHA("Alpha", "B.1.1.7"),
  BETA("Beta","B.1.351"),
  GAMMA("Gamma", "P.1"),
  DELTA("Delta", "B.1.617"),
  FETA("Feta", "O.u.z.o"),
  LAMBDA("Lambda", "C.37"),
  OMICRON("Omikron", "B1.1.529");


  private String label;
  private String designation;

  Variant(String label, String designation){
    this.label = label;
    this.designation = designation;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }
}
