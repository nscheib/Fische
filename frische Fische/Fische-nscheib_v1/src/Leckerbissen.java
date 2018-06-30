//=====================================================================
import Exception.*;
/**
 * Interface für die Fischklasse
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public interface Leckerbissen {

    Nahrungstyp nahrungstyp = null;

    int getGramm();

    int getFressen(Esstyp esstyp) throws TodException, CarnivoreException, PlastikException, SattGefressenException;

    boolean istLebendig();

    Nahrungstyp getNahrungstyp();

    String getName();
}
