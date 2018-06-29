
public enum Nahrungstyp {

    PFLANZE("Pflanze"), FISCH("akteure.txt"), FLEISCH("Fleisch"), MUELL("Mull");



    private String nahrungstyp;

    Nahrungstyp(String nahrungstyp){
        this.nahrungstyp = nahrungstyp;
    }

    public String getNahrungstyp() {
        return nahrungstyp;
    }
}
