//=====================================================================

/**
 * Interface für die Fischklasse
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public interface Leckerbissen {

    Nahrungstyp nahrungstyp = null;

    int getGramm();

    boolean getfressen();

    boolean istLebendig();

    Nahrungstyp getNahrungstyp();

    String getName();
}
