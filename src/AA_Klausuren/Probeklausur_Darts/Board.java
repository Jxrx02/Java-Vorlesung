package AA_Klausuren.Probeklausur_Darts;

public class Board {

  Field _zahlenwert[] = new Field[20];
  Field _D_zahlenwert[] = new Field[20];
  Field _T_zahlenwert[] = new Field[20];
  Field _singleBull;
  Field _mid;
  Field hilfsfeldField;

  Field allFields[] = new Field[63];

  public Board() {


    for (int i = 0; i < 19; i++) {
      _T_zahlenwert[i] = new Field(String.valueOf(i), 3, false);

      _zahlenwert[i] = new Field(String.valueOf(i), 1, false);

      _D_zahlenwert[i] = new Field(String.valueOf(i), 2, true);

    }

    _singleBull = new Field("Single Bull", 50, false);
    _singleBull.setValue(2);

    _mid = new Field("BULL", 25, false);

    hilfsfeldField = new Field("x", 0, false);


    // allfields = ArrayUtil.addAll(allfields, _T_zahlenwert);

    //addarraytoarray(allfields, _zahlenwert);
    //addarraytoarray(allfields, _d_zahlenwert);
    //addarraytoarray(allfields, _singlebull);
    //addarraytoarray(allfields, _mid);
    //addarraytoarray(allfields, hilfsfeldfield);


  }

  public Field parseField(String label) {

    for (int i = 0; i < allFields.length; i++)
			if (allFields[i].getLabel() == label)
				return allFields[i];
    return null;
  }


}
