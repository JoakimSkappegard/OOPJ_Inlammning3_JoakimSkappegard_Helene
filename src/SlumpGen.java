import javax.swing.*;
import java.util.*;


public class SlumpGen {
    public void genereraNyttSpel(int spelstorlek,ArrayList<JButton> knappObjekt){
        int conter = 0;
        Random slumpGen = new Random();
        /*
        ArrayList<JButton> knappar= new ArrayList();
        for (int i = 0; i < (spelstorlek*spelstorlek); i++) {
        }

         */
        for (int i = 0; i < spelstorlek; i++) {
            for (int j = 0; j < spelstorlek; j++) {
                conter++;
                if(!knappObjekt.isEmpty()) {
                    int denUtvalda = slumpGen.nextInt(knappObjekt.size());
                    //knappObjekt.get(denUtvalda).getSize().width;

                }
            }
        }
    }
}
/*
Behöver använda koordinat/knappbredd=rad matrisen
 */