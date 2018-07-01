package Exception;
//=====================================================================

/**
 * Exception wenn der Angreifer schon tot ist
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class EinZombieWillFischFressenException extends FressException {
    //Konstruktor
    public EinZombieWillFischFressenException(String message) {
        super(message);
    }
}
