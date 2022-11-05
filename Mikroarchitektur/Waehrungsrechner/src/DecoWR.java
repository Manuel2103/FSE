public abstract class DecoWR extends WR {
    /**
     * Datenfeld wr um einen Währungsrechner zu verwenden
     */
    private WR wr;

    public DecoWR(WR wr) {
        this.wr = wr;
    }

    @Override
    public double getFaktor() {
        return wr.getFaktor();
    }

    @Override
    public boolean zustaendig(String variante) {
        return wr.zustaendig(variante);
    }
}
