//=====================================================================

/**
 * Interface für die Meeresbewohnerklasse
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public interface Leckerbissen {

    Nahrungstyp nahrungstyp = null;

    int getGramm();

    void setGramm(int gewicht);

    boolean getfressen();

    boolean istLebendig();

    Nahrungstyp getNahrungstyp();

    Leckerbissen fressen();

    String getName();

    int getAppetit();

    void setAppetit(int appetit);

    void setBeute(Leckerbissen beute);

    void setMenge(int menge);

    Esstyp getEsstyp();
}
