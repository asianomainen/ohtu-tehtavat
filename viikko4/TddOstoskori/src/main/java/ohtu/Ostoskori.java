package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Ostoskori {
    List<Ostos> ostoskori;

    public Ostoskori() {
        this.ostoskori = new ArrayList<>();
    }

    public int tavaroitaKorissa() {
        int maara = 0;

        for (Ostos ostos : ostoskori) {
            maara += ostos.lukumaara();
        }

        return maara;
    }

    public int hinta() {
        int summa = 0;

        for (Ostos ostos : ostoskori) {
            summa += ostos.hinta();
        }

        return summa;
    }

    public void lisaaTuote(Tuote lisattava) {
        for (Ostos ostos : ostoskori) {
            if (ostos.tuotteenNimi().equals(lisattava.getNimi())) {
                ostos.muutaLukumaaraa(1);
                return;
            }
        }
        ostoskori.add(new Ostos(lisattava));
    }

    public void poista(Tuote poistettava) {
        for (Ostos ostos : ostoskori) {
            if (ostos.tuotteenNimi().equals(poistettava.getNimi())) {
                ostos.muutaLukumaaraa(-1);
                if (ostos.lukumaara() == 0) {
                    ostoskori.remove(ostos);
                }
                return;
            }
        }
    }

    public List<Ostos> ostokset() {
        return this.ostoskori;
    }

    public void tyhjenna() {
        ostoskori = new ArrayList<>();
    }
}
