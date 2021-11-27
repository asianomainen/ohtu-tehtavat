package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    List<Ostos> ostoskori;
    int yhteishinta;

    public Ostoskori() {
        this.ostoskori = new ArrayList<>();
        this.yhteishinta = 0;
    }

    public int tavaroitaKorissa() {
        return ostoskori.size();
    }

    public int hinta() {
        return yhteishinta;
    }

    public void lisaaTuote(Tuote lisattava) {
        ostoskori.add(new Ostos(lisattava));
        yhteishinta += lisattava.getHinta();
    }

    public void poista(Tuote poistettava) {
        // poistaa tuotteen
    }

    public List<Ostos> ostokset() {
        return this.ostoskori;
    }

    public void tyhjenna() {
        // tyhjentää korin
    }
}
