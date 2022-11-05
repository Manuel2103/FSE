public class EURO2YEN extends WR {

    @Override
    public double getFaktor() {
        return 144.579;
    }

    @Override
    public boolean zustaendig(String variante) {
        if (variante.equals("EURO2YEN")) {
            return true;
        } else {
            return false;
        }
    }
}
