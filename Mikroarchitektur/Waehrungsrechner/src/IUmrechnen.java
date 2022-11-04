public interface IUmrechnen {
    double umrechnen(String variante, double betrag) throws ENoElementinChain;
    double getFaktor();
    boolean zustaendig(String variante);


}
