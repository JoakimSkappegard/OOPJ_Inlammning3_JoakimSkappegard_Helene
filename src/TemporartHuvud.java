import java.util.*;

public class TemporartHuvud {

    TemporartHuvud(int brikstorlek) {
        Spelplan spelplanLayout = new Spelplan(brikstorlek);

        Bricka.createBrickor(brikstorlek,spelplanLayout.getSpelplanLayout(),spelplanLayout);

        spelplanLayout.ritaSpelplan();


    }



    public static void main(String[] args){
        TemporartHuvud huvudprogram = new TemporartHuvud(4);
    }


    TemporartHuvud(){

    }

}
