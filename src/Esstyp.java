//=====================================================================

/**
 * Enum mit Konstanten der verschiedenen Esstypen
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public enum Esstyp {

    VEGANER(Nahrungstyp.PFLANZE), VEGETARIER(Nahrungstyp.PFLANZE), FLEXITARIER(Nahrungstyp.FISCH, Nahrungstyp.FLEISCH, Nahrungstyp.PFLANZE), FISCHESSER(Nahrungstyp.FISCH), FLEISCHESSER(Nahrungstyp.FLEISCH);

    private Nahrungstyp nahrungstypEins;
    private Nahrungstyp nahrungstypZwei;
    private Nahrungstyp nahrungstypDrei;

    // Konstruktor
    Esstyp(Nahrungstyp typEins){
        nahrungstypEins = typEins;
    }

    Esstyp(Nahrungstyp typEins, Nahrungstyp typZwei, Nahrungstyp typDrei) {
        this.nahrungstypEins = typEins;
        this.nahrungstypZwei = typZwei;
        this.nahrungstypDrei = typDrei;
    }

    /**
     * Methode soll ueberpruefen, ob der uebergebene Nahrungstyp von dem jeweiligen Esstyp gefressen werden darf.
     * @param nahrungstyp ist eine Konstante des Nahrungstyps
     * @return true/false, ob das Opfer gegessen werden darf
     */
    public static boolean akzeptiert(Nahrungstyp nahrungstyp, Esstyp esstyp) {

        // Ueberpruefe ob der Inhalt eines Esstyp der passende Part zum Nahrungstyp ist
        for (Esstyp inhalt : Esstyp.values()) {
            if (nahrungstyp.equals(esstyp.nahrungstypEins) || nahrungstyp.equals(esstyp.nahrungstypZwei) || nahrungstyp.equals(esstyp.nahrungstypDrei))
                return true;
            else return false;
        }
        return false;
    }

}
