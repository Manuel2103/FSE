package ChainofResponsibility;

public abstract class WR implements IUmrechnen{
    private WR nextChainElem = null;

    /**
     * Berechnet den Betrag
     * @param variante Wie soll umgerechnet werden
     * @param betrag Wie viel soll umgerechnet werden
     * @return Ergebnis
     * @throws ENoElementinChain Wenn es keine solche Variante gibt
     */
    @Override
    public double umrechnen(String variante, double betrag) throws ENoElementinChain {
        if(zustaendig(variante)){
            return betrag * getFaktor();
        }else {
            if (nextChainElem != null){
                return nextChainElem.umrechnen(variante, betrag);
            }else {
                throw new ENoElementinChain();
            }
        }
    }

    /**
     * Fügt ein neues Element der Kette hinzu
     * @param nextChainElem
     */
    public void addNextChainElem(WR nextChainElem){
        if(this.nextChainElem == null){
            this.nextChainElem = nextChainElem;
        }else{
            this.nextChainElem.addNextChainElem(nextChainElem);
        }
    }

    /**
     * Gibt das nächste Element in der Kette zurück
     * @return nächste Element
     */
    public WR getNextChainElem(){
        return nextChainElem;
    }

    /**
     * Findet das letzte Element in der Kette und setzt das nächste Element des Vorgängers auf NULL
     */
    public void removeNextChainElem(){
        if(nextChainElem.getNextChainElem()==null){
            nextChainElem = null;
        }else{
            nextChainElem.removeNextChainElem();
        }
    }


}
