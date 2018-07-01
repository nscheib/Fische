package Exception;
//=====================================================================

/**
 * Exception wenn der Angreifer schon satt ist
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class SattGefressenException extends FressException {
    //Konstruktor
    public SattGefressenException(String message) { super(message); }
}