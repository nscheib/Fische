//=====================================================================

/**
 * Mithilfe der Klasse Fisch werden die Objekte der Meerbewohner erzeugt.
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class Fische implements Leckerbissen{

    private String name;
    private Nahrungstyp  nahrungstyp;
    private Esstyp esstyp;
    private int gewicht, appetit, menge;

    //Konstruktor fuer die Fische
    public Fische(String name, Nahrungstyp nahrungstyp, int gewicht, int appetit, Esstyp esstyp){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.gewicht = gewicht;
        this.appetit = appetit;
        this.esstyp = esstyp;
    }

    // Konstruktor fuer die uebrigen Meeresbewohner
    public Fische(String name, Nahrungstyp nahrungstyp, int menge, int gewicht){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.menge = menge;
        this.gewicht = gewicht;
    }

    /**
     * Methode um das aktuelle Gewicht abzufragen.
     * @return gibt das aktuelle Gewicht zurueck
     */
    @Override
    public int getGramm() {
        return gewicht;
    }

    /**
     * Methode prueft, ob ein Fisch/ Meeresbewohner schon gefressen wurde
     * @return true/false ob ein gefressen wurde oder nicht
     */
    @Override
    public boolean getfressen() {
        if(gewicht == 0) return false;
        else if(esstyp.equals(nahrungstyp)) return true;
        else return false;
    }

    /**
     * Methode zum abfragen, ob ein Fisch/Meeresbewohner noch lebt
     * @return true/fals ob lebendig oder nicht
     */
    @Override
    public boolean istLebendig() {
        if(gewicht == 0) return false;
        else return true;
    }

    /**
     * Methode zum abfragen des Nahrungstyp (Konstante <Enum>)
     * @return die Konstante des Enums Nahrungstyp
     */
    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }

    /**
     * Methode
     * @param beute ist der zu fressenden Meeresbewohner
     * @return gibt den zu fressenden Meeresbewohner zurueck
     */
    public Leckerbissen fressen(Leckerbissen beute) { return beute; }

    public String getName() { return name; }

}
