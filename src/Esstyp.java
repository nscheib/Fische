public enum Esstyp {

    VEGANER(true),
    VEGETARIER(true),
    FLEXITARIER(true),
    FISCHESSER(true),
    FLEISCHESSER(true);


    private Boolean erlaubt;

    Esstyp(boolean erlaubt){
        this.erlaubt = erlaubt;
    }

    public boolean essbar( Nahrungstyp nahrungstyp) {

        switch (nahrungstyp){
            case PFLANZE: return true;
            case FLEISCH: return true;
            case MUELL: return true;
            case FISCH: return true;
            default: return false;
        }

    }

}
