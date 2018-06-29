import Reader.TextIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Exception.*;

public class Meer {

    private static List<Leckerbissen> fisch;

    public static void main(String[]args) throws FressException {

        List<String> akteure = null;
        List<String> szene = null;

        try {
            akteure = TextIO.read(new File(args[0]));

            fisch = new ArrayList<>();
            List<Leckerbissen> meeresbewohner = new ArrayList<>();

            for( String inhalt : akteure) {
                    System.out.println(inhalt);
                    String [] arr = inhalt.split(",");
                    int zahlEins;
                    int zahlZwei;
                    if(arr[0].equals("Fisch")) {
                        zahlEins = Integer.parseInt(arr[4]);
                        zahlZwei = Integer.parseInt(arr[5]);
                        fisch.add(new Fische(arr[1], arr[2], arr[3], zahlEins, zahlZwei));
                    } else {
                        zahlEins = Integer.parseInt(arr[3]);
                        zahlZwei = Integer.parseInt(arr[4]);
                        fisch.add(new Fische(arr[1], arr[2], zahlEins, zahlZwei));
                    }

            }
            System.out.println("hdhd");

        } catch (IOException e) {
            throw new FressException("Datei konnte nicht geladen werde.");
        }

        try {
            szene = TextIO.read(new File(args[1]));

            for (String inhalt : szene){
                String [] arr2 = inhalt.split(" ");
                Leckerbissen typ1 = getObjekt(arr2[0]);
                Leckerbissen typ2 = getObjekt(arr2[2]);

                try{
                    Fische.fressen(typ1, typ2);

                } catch() {

                }

            }


        } catch (IOException e) {
            System.out.println("Es konnte keine Textdatei eingelesen werden. ERROR<MAIN,szene>");
            e.printStackTrace();
        }



    }


    public static Leckerbissen getObjekt(String arr2){

        for (Leckerbissen inhalt : fisch) {
            if (arr2.equals(inhalt)) {
                return inhalt;
            }
        }
        return null;
    }
}
