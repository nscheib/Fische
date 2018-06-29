package Exception;

public class ZuGrossException extends FressException{

    public ZuGrossException(String message){
        super(message);
//throw new ZuGrossException("Ein kleines Zwicken, dass aber Ignoriert werden kann. 'Warte hat dieser Pimpf gerade versucht mich zu fressen?'");
    }
}
