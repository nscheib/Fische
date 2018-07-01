import Reader.TextIO;
import Exception.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//=====================================================================

/**
 * Das Programm verarbeitet zwei Textdateien. Mit der <akteure.txt> koennen sehr viele Meeresbewohner eingelesen werden
 * und aus den angegebenen Parametern kann ein passendes Objekt erzeugt werde. Mit der <szene.txt> kann eine Art Geschichte
 * manuell geschrieben werden, in welcher ein Ablauf vorgegen wird. In diesem Ablauf kann man verschiedene Meeresbewohner
 * versuchen lassen, andere Meeresbewohner zu fressen.
 * Es gibt bestimmte Voraussetzungen die erfuellt sein muessen, damit dies funktioniert.
 * @author Felix Fuhrman, Nick Scheib
 * @version inProgress
 */
public class Meer {

    private static List<String> akteure = null;
    private static List<String> szene = null;
    private static List<Leckerbissen> fisch = new ArrayList<>();
    private static Leckerbissen angreifer;

    /**
     * Dies ist die Start Methode, wodruch das Programm startet.
     * @param args sind Parameter die aus der Comandozeile mitgegeben werden koennen.
     */
    public static void main(String[]args) throws FressException {

        setAkteure(args);
        setSzene(args);

    } // END main

    /**
     * Diese Methode speichert alle Meeresbewohner mit ihren unterschiedlichen Eigenschaften in Form von Parametern
     * als ein eigenes Objekt ab.
     * @param args sind Parameter die aus der Comandozeile mitgegeben werden koennen.
     */
    public static void setAkteure(String[] args) {

        try {
            akteure = TextIO.read(new File(args[0]));
            String [] arr;
            for (String inhalt : akteure) {
                arr = inhalt.split(",");

                int zahlEins = Integer.parseInt(arr[3]);
                int zahlZwei = Integer.parseInt(arr[4]);
                Nahrungstyp nahrungstyp = Nahrungstyp.valueOf(arr[2]);
                Esstyp esstyp = null;

                if (arr[0].equals("Fisch")) esstyp = Esstyp.valueOf(arr[5]);
                if (arr[0].equals("Fisch")) fisch.add(new Meeresbewohner(arr[1], nahrungstyp, zahlEins, zahlZwei, esstyp));
                else fisch.add(new Meeresbewohner(arr[1], nahrungstyp, zahlEins, zahlZwei));
            }
        } catch (IOException e) {
            System.out.println("Fehler <setAkteure> Es konnten keine Akteure eingelesen werde!");
        }
    } // END setAkteure

    /**
     * Diese Methode verarbeitet die erstellte Geschichte aus der szene.txt Datei
     * @param args sind Parameter die aus der Comandozeile mitgegeben werden koennen.
     */
    public static void setSzene(String[] args) {
        try {
            szene = TextIO.read(new File(args[1]));
            List<String> arrZwei = null;

            for ( String inhalt : szene) {
                arrZwei = Arrays.asList(inhalt.split(" "));
                Leckerbissen opfer = null;
                for (Leckerbissen objekte : fisch) {
                    if (objekte.getName().equals(arrZwei.get(0))) angreifer = objekte;
                    if (objekte.getName().equals(arrZwei.get(2))) opfer = objekte;
                    if (angreifer != null && opfer != null) {
                        angreifer.setBeute(opfer);
                        verarbeiteSzene(angreifer);
                        angreifer = null;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Es konnte keine Textdatei eingelesen werden. ERROR<setSzene,IOException>");
            e.printStackTrace();
        }
    } // END setSzene

    /**
     * Methode dient dazu zu pruefen ob der Angreifer das Opfer fressen kann, hierzu muessen bestimmte Voraussetzungen erfuellt sein
     * @param angreifer ist das Objekt das das andere Objekt fressen moechte
     * @throws FischIstSchonToTException falls das Opfer schon Tot ist
     * @throws SattGefressenException falls der Angreifer schon satt ist
     * @throws DasOpferIstMuell falls das Opfer Muell ist (Eine Chance besteht das es trotzdem gefressen wird)
     * @throws KeinPassenderNahrungsTyp fall der Nahrungstyp nicht übereinstimmt
     * @throws FischWurdeGefressenException  wenn das Opfer wirklich gefressen wird
     * @throws EinZombieWillFischFressenException falls der Angreifer schon tot ist
     * @throws DasOpferIstZuGroßeException wenn das Opfer zu groß fuer den Angreifer ist
     */
    public static void verarbeiteSzene(Leckerbissen angreifer) {

        try {
            System.out.print("\n<" + angreifer.getName() + "> will <" + angreifer.fressen().getName() + "> fressen. ");
            /*
             * Ueberprueft verschiedene Szenarien/Voraussetzungen ob ein Angreifer das Opfer fressen kann
             */
            if(angreifer.getAppetit() < angreifer.fressen().getGramm() && angreifer.fressen().getGramm() > (angreifer.getGramm() - angreifer.getAppetit())) {
                throw new DasOpferIstZuGroßeException("...");
            } else if (angreifer.getGramm() != 0 && (angreifer.getAppetit() >= angreifer.getGramm())) {
                throw new SattGefressenException("...");
            } else if (Boolean.FALSE.equals(angreifer.fressen().istLebendig())) {
                throw new FischIstSchonToTException("...");
            } else if (angreifer.fressen().getNahrungstyp().equals(Nahrungstyp.MUELL)) {
                throw new DasOpferIstMuell("...");
            } else if (angreifer.getGramm() == 0) {
                throw new EinZombieWillFischFressenException("...");
            } else if (Boolean.FALSE.equals(Esstyp.akzeptiert(angreifer.fressen().getNahrungstyp(), angreifer.getEsstyp() ))) {
                throw new KeinPassenderNahrungsTyp("...");
            } else {
                // Wenn das Opfer ein Fisch ist oder ein Meeresbewohner oder aehnliches ist
                if(angreifer.fressen().getEsstyp() != null) {
                    angreifer.setAppetit(angreifer.fressen().getGramm());
                    angreifer.fressen().getfressen();
                } else {
                    angreifer.setAppetit(angreifer.fressen().getGramm());
                    angreifer.fressen().setMenge(angreifer.getAppetit());
                }
                throw new FischWurdeGefressenException("...");
            }

            //angreifer.setGewicht(angreifer.fressen(getFressen(angreifer.getEsstyp())));
            //opfer.setGewicht(-(opfer.getGramm()));

        } catch (FischIstSchonToTException e) {
            System.out.print("\nDer Fisch ist schon Tot... <" + angreifer.getName() + "> spuckt seine Beute <" + angreifer.fressen().getName() + "> wieder aus!");
            angreifer.setBeute(null);
        } catch (SattGefressenException e) {
            System.out.print("\nDer Fisch <" + angreifer.getName() + "> ist schon satt!");
        } catch (DasOpferIstZuGroßeException e) {
            System.out.print("\nDer Fisch <" + angreifer.getName() + "> versuchen an seiner Beute <" + angreifer.fressen().getName() + "> zu nagen, das Opfer ist aber viel zu groß!");
        }catch (DasOpferIstMuell e) {
            //Chance besteht das der Muell doch gefressen wird.
            int k = (int) (Math.random() * 2);
            if (k == 0) {
                System.out.print("\nDer Fisch <" + angreifer.getName() + "> spuckt den Müll wieder aus!");
            } else {
                int redu = angreifer.getGramm() - angreifer.getAppetit();
                angreifer.fressen().setMenge(redu);
                System.out.print("\nDer Fisch <" + angreifer.getName() + "> hat den Müll ausversehen verschluckt!");
            }
        } catch (KeinPassenderNahrungsTyp e) {
            System.out.print("\nDas Opfer <" + angreifer.fressen().getName() + "> hat den falschen Nahrungstyp <" + angreifer.fressen().getNahrungstyp().toString() + "> !");
        } catch (FischWurdeGefressenException e) {
            System.out.print("\nDas Opfer <" + angreifer.fressen().getName() + "> wurde von <" + angreifer.getName() + "> gefressen! RIP \u2671");
            angreifer.setBeute(null);
        } catch (EinZombieWillFischFressenException e) {
            System.out.print("\nEin Untoter <" + angreifer.getName() + "> verbreitet Angst und Schrecken unter den Meeresbewohnern. \nEs gab ein weiteres Opfer <"+ angreifer.fressen().getName() + "> ");
            if(angreifer.fressen().getEsstyp() != null) {
                angreifer.fressen().setGramm(0);
            } else {
                angreifer.fressen().setMenge(angreifer.getAppetit());
            }
        }

    } // END verarbeiteSzene

} // END Meer.class
