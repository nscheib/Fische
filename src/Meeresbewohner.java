//=====================================================================

/**
 * Mithilfe der Klasse Fisch werden die Objekte der Meerbewohner erzeugt.
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class Meeresbewohner implements Leckerbissen{

    private String name;
    private Nahrungstyp  nahrungstyp;
    private Esstyp esstyp;
    private int gewicht, appetit, menge;
    private Leckerbissen beute;

    //Konstruktor fuer die Fische
    public Meeresbewohner(String name, Nahrungstyp nahrungstyp, int gewicht, int appetit, Esstyp esstyp){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.gewicht = gewicht;
        this.appetit = appetit;
        this.esstyp = esstyp;
    }

    // Konstruktor fuer die uebrigen Meeresbewohner
    public Meeresbewohner(String name, Nahrungstyp nahrungstyp, int menge, int gewicht){
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
    public int getGramm() { return gewicht; }

    /**
     * Methode um das Gewicht zu setzten
     * @param gewicht das Gewicht
     */
    @Override
    public void setGramm(int gewicht) { this.gewicht = gewicht; }

    /**
     * Methode prueft, ob ein Fisch/ Meeresbewohner schon gefressen wurde
     * @return true/false ob ein gefressen wurde oder nicht
     */
    @Override
    public boolean getfressen() {
        if(gewicht == 0) return false;
        else {
            gewicht = 0;
            return true;
        }
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
    public Nahrungstyp getNahrungstyp() { return nahrungstyp; }

    /**
     * Methode um die Beute des Angreifers zu setzten
     * @param beute ist die Beute des Angreifers
     */
    @Override
    public void setBeute(Leckerbissen beute){ this.beute = beute; }

    /**
     * Methode gibt die Beute zurueck
     * @return die Beute
     */
    @Override
    public Leckerbissen fressen() { return beute;}

    /**
     * Methode gibt den Namen zurueck
     * @return den Namen
     */
    @Override
    public String getName() { return name; }

    /**
     * Methode gibt den Appetit zurueck
     * @return den Appetitwert
     */
    @Override
    public int getAppetit() { return appetit; }

    /**
     * Methode setzt den Appetitwert eines Objekts
     * @param appetit ist der Appetitwert
     */
    @Override
    public void setAppetit(int appetit) { this.appetit += appetit; }

    /**
     * Methode setzt die Menge eines Objekts
     * @param menge ist die Anzahl
     */
    @Override
    public void setMenge(int menge) {
        if ((this.menge -= menge) < 0) this.menge = 0;
        else this.menge -= menge;
    }

    /**
     * Methode gibt den Esstyp zurueck
     * @return den Esstyp
     */
    @Override
    public Esstyp getEsstyp() { return esstyp; }
}
