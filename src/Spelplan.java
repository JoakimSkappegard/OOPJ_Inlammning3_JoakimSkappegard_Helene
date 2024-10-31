public class Spelplan {

    private Bricka[][] spelplanLayout;



    /*
    public String test1(String){

    }

     */

    public void setSpelplanLayout(Bricka bricka, int i, int j) {
        this.spelplanLayout[i][j] = bricka;
    }

    public void ritaSpelplan() {
        System.out.println("\n*************************************************************************\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for (int i = 0; i < spelplanLayout.length; i++) {
            System.out.println("\n-----------------------------------------");
            System.out.print("| ");
            for (int j = 0; j < spelplanLayout[0].length; j++) {
                System.out.print(spelplanLayout[i][j].toString() + " | ");
            }
        }
    }

    public Bricka[][] getSpelplanLayout() {
        return this.spelplanLayout;
    }

    public Bricka getBrickaFromSpelplan(int i, int j) {
        return this.spelplanLayout[i][j];
    }

    Spelplan(int strolek){
        spelplanLayout = new Bricka[strolek][strolek];
    }

    Spelplan(){

    }

}
