//=====================================================================

/**
 * Enum mit Konstanten der verschiedenen Esstypen
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public enum Esstyp {

    VEGANER("Pflanze"), VEGETARIER("Pflanze"), FLEXITARIER("Pflanze"), FISCHESSER("Fisch"), FLEISCHESSER("Fleisch");

    private String esstyp;

    // Konstruktor
    Esstyp(String esstypEins){
        this.esstyp = esstypEins;
    }

    /**
     * Methode soll ueberpruefen, ob der uebergebene Nahrungstyp von dem jeweiligen Esstyp gefressen werden darf.
     * @param nahrungstyp ist eine Konstante des Nahrungstyps
     * @return true/false, ob das Opfer gegessen werden darf
     */
    public static boolean akzeptiert(Nahrungstyp nahrungstyp, Esstyp esstyp) {

        // Ueberpruefe ob der Inhalt eines Esstyp der passende Part zum Nahrungstyp ist
        for (Esstyp inhalt : Esstyp.values()) {
            if (esstyp == inhalt) {
                if (inhalt.esstyp.equalsIgnoreCase(nahrungstyp.toString())) return true;
            }
        }
        return false;
    }

}
