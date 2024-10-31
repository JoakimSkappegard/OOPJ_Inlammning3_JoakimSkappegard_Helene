import java.util.*;

public class Bricka {

    private static

    int desierdLocationX;
    int desierdLocationY;


    int currentLocationX;
    int currentLocationY;

    String desplayedText;

    //bild

    public static void createBrickor(int rotenUrAntal, Bricka[][] spelplan,Spelplan instanceSpelplan) {
        int brickaNr = 0;
        for (int i = 0; i < spelplan.length; i++) {
            for (int j = 0; j < spelplan[0].length; j++) {
                Bricka bricka = new Bricka((brickaNr+""),i,j);
                instanceSpelplan.setSpelplanLayout(bricka,i,j);
                brickaNr++;
            }
        }
    }

    @Override
    public String toString() {
        return desplayedText;
    }



//Setters/getters

    public int getDesierdLocationX() {
        return desierdLocationX;
    }

    public void setDesierdLocationX(int desierdLocationX) {
        this.desierdLocationX = desierdLocationX;
    }

    public int getDesierdLocationY() {
        return desierdLocationY;
    }

    public void setDesierdLocationY(int desierdLocationY) {
        this.desierdLocationY = desierdLocationY;
    }

    public int getCurrentLocationX() {
        return currentLocationX;
    }

    public void setCurrentLocationX(int currentLocationX) {
        this.currentLocationX = currentLocationX;
    }

    public int getCurrentLocationY() {
        return currentLocationY;
    }

    public void setCurrentLocationY(int currentLocationY) {
        this.currentLocationY = currentLocationY;
    }

    public String getDesplayedText() {
        return desplayedText;
    }

    public void setDesplayedText(String desplayedText) {
        this.desplayedText = desplayedText;
    }

    //-----------------------------------------------konstruktor

    Bricka(String brickaNummer, int desierdLocationX, int desierdLocationY) {
        this.desierdLocationX = desierdLocationX;
        this.desierdLocationY = desierdLocationY;
        this.desplayedText = brickaNummer;
    }

    Bricka(){

    }
}
    /*
    variblar
    kordinatsystem
    slumpgen
    %4=0


    ------------------------------------------

    Skapa grid (4x4)(men bra om modulärt)
    knyt knapparna till objekt i grid



    konstruktor behöver ta x/y kordinat

    -------------------------------------------------

    knappar kan sedan vara förankrade till objekten i arrayn
    spelplanLayout[0][0].getDesplayedText

    typ



     */