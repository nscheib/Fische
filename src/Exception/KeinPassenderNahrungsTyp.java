package Exception;
//=====================================================================

/**
 * Exception wenn das Opfer kein passender Nahrungstyp ist
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class KeinPassenderNahrungsTyp extends FressException {
    //Konstruktor
    public KeinPassenderNahrungsTyp(String massage) { super(massage); }
}
