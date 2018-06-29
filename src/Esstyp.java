import java.util.EmptyStackException;

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


    public static boolean akzeptiert(Nahrungstyp nahrungstyp) {

        Esstyp e = Esstyp.FISCHESSER;


        switch(nahrungstyp){

            case FISCH: return Esstyp.FLEXITARIER.erlaubt;
            case MUELL: return false;
            case FLEISCH: return Esstyp.FLEXITARIER.erlaubt;
            case PFLANZE: return Esstyp
        }
    }

}
