
public class Fische implements Leckerbissen{

    private String name;
    private String  nahrungstyp;
    private String esstyp;
    private int gewicht, appetit, menge;

    public Fische(String name, String nahrungstyp, String esstyp, int gewicht, int appetit){
        this.name = name;
        this.nahrungstyp = nahrungstyp;
        this.esstyp = esstyp;
        this.gewicht = gewicht;
        this.appetit = appetit;
    }

    public Fische(String name, String nahrungstyp, int menge, int gewicht){
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
        if (Esstyp.akzeptiert() == true){}
        return false;
    }

    @Override
    public boolean istLebendig() {
        if(gewicht == 0) return false;
        else return true;
    }

    @Override
    public String getNahrungstyp() {
        return nahrungstyp;
    }


    public Leckerbissen fressen(Leckerbissen beute){

        return beute;
    }

}
