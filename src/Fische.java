
public class Fische implements Leckerbissen{

    private String name;
    private Nahrungstyp nahrungstyp;
    private Esstyp esstyp;
    private int gewicht, appetit;

    public Fische(String name, Nahrungstyp nahrungstyp, Esstyp esstyp){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.esstyp = esstyp;
    }
    public Fische(String name, Nahrungstyp nahrungstyp, Esstyp esstyp, int gewicht, int appetit){
        this(name, nahrungstyp, esstyp);
        this.gewicht = gewicht;
        this.appetit = appetit;
    }

    @Override
    public int getGramm() {
        return gewicht;
    }

    @Override
    public boolean getgefressen() {
        return false;
    }

    @Override
    public boolean istLebendig() {
        return true;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }


    public Leckerbissen fressen(Leckerbissen beute){
        return beute;
    }

}
