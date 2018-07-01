package Exception;
//=====================================================================

/**
 * Exception wenn das Opfer schon tot ist
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class FischIstSchonToTException extends FressException {
    //Konstruktor
    public FischIstSchonToTException(String message){
        super(message);
    }
}
