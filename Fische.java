
public class Fische implements Leckerbissen{

    private String name;
    private Nahrungstyp  nahrungstyp;
    private Esstyp esstyp;
    private int gewicht, appetit, menge;

    public Fische(String name, Nahrungstyp nahrungstyp, int gewicht, int appetit, Esstyp esstyp){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.gewicht = gewicht;
        this.appetit = appetit;
        this.esstyp = esstyp;
    }

    public Fische(String name, Nahrungstyp nahrungstyp, int menge, int gewicht){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.menge = menge;
        this.gewicht = gewicht;
    }

    @Override
    public int getGramm() {
        return gewicht;
    }

    @Override
    public boolean getfressen() {
        if(gewicht == 0) return false;
        else if(esstyp.equals(nahrungstyp)) return true;
        else return false;
    }

    @Override
    public boolean istLebendig() {
        if(gewicht == 0) return false;
        else return true;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }


    public Leckerbissen fressen(Leckerbissen beute) { return beute; }

    public String getName() { return name; }

}
