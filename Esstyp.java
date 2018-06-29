//=====================================================================

/**
 * Enum mit Konstanten der verschiedenen Esstypen
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public enum Esstyp {

    VEGANER, VEGETARIER, FLEXITARIER, FISCHESSER, FLEISCHESSER;

    /**
     * Methode soll ueberpruefen, ob der uebergebene Nahrungstyp von dem jeweiligen Esstyp gefressen werden darf.
     * @param nahrungstyp ist eine Konstante des Nahrungstyps
     * @return true/false, ob das Opfer gegessen werden darf
     */
    public static boolean akzeptiert(Nahrungstyp nahrungstyp) {

        switch(nahrungstyp){
            case FISCH: return true;
            case MUELL: return false;
            case FLEISCH: return true;
            case PFLANZE: return true;
            default: return true;
        }
    }

}
