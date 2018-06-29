
public enum Esstyp {

    VEGANER, VEGETARIER, FLEXITARIER, FISCHESSER, FLEISCHESSER;

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
