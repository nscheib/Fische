import Reader.TextIO;
import Exception.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Meer {

    private static List<String> akteure = null;
    private static List<String> szene = null;
    private static List<Leckerbissen> fisch = new ArrayList<>();
    private static List<Leckerbissen> meeresbewohner = new ArrayList<>();

    public static void main(String[]args) {
        setAkteure(args);
        setSzene(args);

    }

    public static void setAkteure(String[] args) {

        try {
            akteure = TextIO.read(new File(args[0]));
            String [] arr;

            for( String inhalt : akteure) {
                arr = inhalt.split(",");
                System.out.println(inhalt);

                int zahlEins = Integer.parseInt(arr[3]);
                int zahlZwei = Integer.parseInt(arr[4]);
                Nahrungstyp nahrungstyp = Nahrungstyp.valueOf(arr[2]);
                Esstyp esstyp = null;
                if (arr[0].equals("Fisch")) esstyp = Esstyp.valueOf(arr[5]);

                if (arr[0].equals("Fisch")) { fisch.add(new Fische(arr[1], nahrungstyp, zahlEins, zahlZwei, esstyp)); }
                else { meeresbewohner.add(new Fische(arr[1], nahrungstyp, zahlEins, zahlZwei)); }

            }

        } catch (IOException e) {
            System.out.println("Errorrrrrrrrrrrrrrrrr");
        }
    }

    public static void setSzene(String[] args){

        try {
            szene = TextIO.read(new File(args[1]));
            List<String> arrZwei = null;

            for ( String inhalt : szene) { arrZwei = Arrays.asList(inhalt.split(" ")); }

            Leckerbissen angreifer;
            Leckerbissen opfer;
            for (Leckerbissen inhalt : fisch) {
                if(inhalt.getName().equals(arrZwei.get(0))) angreifer = inhalt;
                if(inhalt.getName().equals(arrZwei.get(2))) opfer = inhalt;
            }

            try {
                if(angreifer.getNahrungstyp())

            } catch (PlastikException){

            }

        } catch (IOException e) {
            System.out.println("Es konnte keine Textdatei eingelesen werden. ERROR<MAIN,szene>");
            e.printStackTrace();
        }
    }


}
