package Exception;

public class CarnivoreException extends FressException{

    public CarnivoreException(String message){
        super(message);
        // throw new CarnivoreException("Ein wahrer Fleischfresser gibt sich nicht mit Kompost zufrieden");
    }
}
