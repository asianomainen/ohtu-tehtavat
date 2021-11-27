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
        for (Ostos ostos : ostoskori) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                ostoskori.remove(ostos);
                ostos.muutaLukumaaraa(-1);
                yhteishinta -= poistettava.getHinta();
                tavaramaara--;
                return;
            }
        }
    }

    public List<Ostos> ostokset() {
        return this.ostoskori;
    }

    public void tyhjenna() {
        ostoskori = new ArrayList<>();
        yhteishinta = 0;
        tavaramaara = 0;
    }
}
