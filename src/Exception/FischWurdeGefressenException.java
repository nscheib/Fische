package Exception;
//=====================================================================

/**
 * Exception wenn der Angreifer das Opfer frisst
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class FischWurdeGefressenException extends FressException {
    //Konstruktor
    public FischWurdeGefressenException(String message) { super(message); }
}
