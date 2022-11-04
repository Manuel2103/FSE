package ChainofResponsibility;

public class EURO2Dollar extends WR{
    @Override
    public double getFaktor() {
        return 0.988;
    }

    @Override
    public boolean zustaendig(String variante) {
        if(variante.equals("EURO2Dollar")){
            return true;
        }else {
            return false;
        }
    }
}
