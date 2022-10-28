package Decorator;

public class Main {
    public static void main(String[] args) {

        //Erstellen der Objekte mit dem Interface
        //Hierbei kann man nicht erkennen, dass ein Decorator dazwischen liegt
        IKomponente intelCPU = new Intel("Intel i7", "7757", "4 GHz", "Übertakten bis 5 GHz");
        IKomponente amdCPU = new AMD("AMD Ryzen 5", "5859", "3 GHz", "RGB quiet Fan");

        //Aufruf der Methode getEigenschaften die schon im Interface deklariert wurde
        System.out.println(intelCPU.getEigenschaften());
        System.out.println(amdCPU.getEigenschaften());

    }
}
