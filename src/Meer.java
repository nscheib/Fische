import Reader.TextIO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Exception.*;

public class Meer {

    public static void main(String[]args) throws FressException {

        List<String> akteure = null;
        List<String> szene = null;

        try {
            akteure = TextIO.read(new File(args[0]));

            List<Leckerbissen> fisch = new ArrayList<>();

            for( String inhalt : akteure) {
                System.out.println(inhalt);
                String [] arr = inhalt.split(",");
                int zahlEins = Integer.parseInt(arr[4]);
                int zahlZwei = Integer.parseInt(arr[5]);
                fisch.add(new Fische(arr[1], arr[2], arr[3], zahlEins, zahlZwei));
                System.out.println(zahlEins);
            }


        } catch (IOException e) {
            throw new FressException("Test_1");
        }

        try {
            szene = TextIO.read(new File(args[1]));
        } catch (IOException e) {
            System.out.println("Es konnte keine Textdatei eingelesen werden. ERROR<MAIN,szene>");
            e.printStackTrace();
        }



    }

}
