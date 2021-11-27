package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    List<Ostos> ostoskori;
    int yhteishinta;
    int tavaramaara;

    public Ostoskori() {
        this.ostoskori = new ArrayList<>();
        this.yhteishinta = 0;
        this.tavaramaara = 0;
    }

    public int tavaroitaKorissa() {
        return this.tavaramaara;
    }

    public int hinta() {
        return yhteishinta;
    }

    public void lisaaTuote(Tuote lisattava) {
        for (Ostos ostos : ostoskori) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                yhteishinta += lisattava.getHinta();
                tavaramaara++;
                return;
            }
        }
        ostoskori.add(new Ostos(lisattava));
        yhteishinta += lisattava.getHinta();
        tavaramaara++;
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
