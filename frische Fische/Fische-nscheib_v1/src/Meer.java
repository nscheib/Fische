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
 * und aus den angegebenen Parametern kann ein passendes Objekt erzeugt werden. Mit der <szene.txt> kann eine Art Geschichte
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
    private static List<Leckerbissen> meeresbewohner = new ArrayList<>();

    /**
     * Dies ist die Start Methode, wodruch das Programm startet.
     * @param args sind Parameter die aus der Kommandozeile mitgegeben werden koennen.
     */
    public static void main(String[]args) throws CarnivoreException, TodException, PlastikException {
        setAkteure(args);
        setSzene(args);

    }

    /**
     * Diese Methode speichert alle Meeresbewohner mit ihren unterschiedlichen Eigenschaften in Form von Parametern
     * als ein eigenes Objekt ab.
     * @param args sind Parameter die aus der Kommandozeile mitgegeben werden koennen.
     */
    public static void setAkteure(String[] args) {

        try {
            akteure = TextIO.read(new File(args[0]));
            String [] arr;

            for( String inhalt : akteure) {
                arr = inhalt.split(",");
                System.out.println(inhalt);
                int zahlEins;
                int zahlZwei;
                Nahrungstyp nahrungstyp = Nahrungstyp.valueOf(arr[2]);
                Esstyp esstyp = null;
                if (arr[0].equals("Fisch")) {
                    esstyp = Esstyp.valueOf(arr[3]);
                    zahlEins = Integer.parseInt(arr[4]);
                    zahlZwei = Integer.parseInt(arr[5]);
                }else{
                    zahlEins = Integer.parseInt(arr[3]);
                    zahlZwei = Integer.parseInt(arr[4]);
                }

                if (arr[0].equals("Fisch")) { fisch.add(new Fische(arr[1], nahrungstyp, zahlEins, zahlZwei, esstyp));
                } else { meeresbewohner.add(new Fische(arr[1], nahrungstyp, zahlEins, zahlZwei)); }

            }

        } catch (IOException e) {
            System.out.println("Errorrrrrrrrrrrrrrrrr");
        }
    }

    /**
     * Diese Methode verarbeitet die erstellte Geschichte aus der szene.txt Datei
     * @param args sind Parameter die aus der Comandozeile mitgegeben werden koennen.
     */
    public static void setSzene(String[] args){

        Fische angreifer = null;
        Fische opfer = null;

        try {
            szene = TextIO.read(new File(args[1]));
            List<String> arrZwei = null;

            for ( String inhalt : szene) { arrZwei = Arrays.asList(inhalt.split(" ")); }


            for (Leckerbissen inhalt : fisch) {
                if(inhalt.getName().equals(arrZwei.get(0))) angreifer = (Fische) inhalt;
                if(inhalt.getName().equals(arrZwei.get(2))) opfer = (Fische) inhalt;
                try {
                    jagt(angreifer, opfer);
                }catch (NullPointerException e){

                }

            }

        } catch (IOException e) {
            System.out.println("Es konnte keine Textdatei eingelesen werden. ERROR<MAIN,szene>");
            e.printStackTrace();
        }



    }

    private static void jagt(Fische angreifer, Fische opfer){
        try {
            System.out.print(angreifer.getName() + " will " + opfer.getName() + " fressen. ");
            if(angreifer.hunger() < opfer.getGramm()){
                throw new SattGefressenException("ERROR");
            }
            angreifer.setGewicht(opfer.getFressen(angreifer.getEsstyp()));
            opfer.setGewicht(-(opfer.getGramm()));
        } catch (TodException e) {
            System.out.println(e);
        } catch (CarnivoreException e) {
            System.out.println(e);
        } catch (PlastikException e) {
            System.out.println(e);
        } catch (SattGefressenException e) {
            System.out.println("Aber er hat keinen Hunger");
        }
    }

}
