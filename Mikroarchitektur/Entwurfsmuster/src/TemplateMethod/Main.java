package TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Charakter charakterA = new CharakterA();
        Charakter charakterB = new CharakterB();

        charakterA.spezialAngriff();
        charakterA.kaempfen(5);
        charakterB.spezialAngriff();
        charakterB.kaempfen(7);

    }
}
