package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5;   // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5; // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;       // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;         // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLkm = 0;   // Tyhjässä joukossa alkioiden_määrä on nolla.

    public IntJoukko() {
        this.lukujono = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            return;
        }

        this.lukujono = new int[kapasiteetti];
        this.kasvatuskoko = OLETUSKASVATUS;

    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 || kasvatuskoko < 0) {
            return;
        }

        this.lukujono = new int[kapasiteetti];
        this.kasvatuskoko = kasvatuskoko;
    }

    public void lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;

            if (alkioidenLkm == lukujono.length) {
                kasvataTaulukkoa();
            }
        }
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                return true;
            }
        }

        return false;
    }

    public void poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                if (alkioidenLkm - (i + 1) >= 0) {
                    System.arraycopy(lukujono, i + 1, lukujono, i, alkioidenLkm - (i + 1));
                }

                alkioidenLkm--;
            }
        }
    }

    private void kasvataTaulukkoa() {
        int[] uusi = new int[lukujono.length + kasvatuskoko];
        System.arraycopy(lukujono, 0, uusi, 0, lukujono.length);
        lukujono = uusi;
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        StringBuilder tuotos = new StringBuilder("{");

        for (int i = 0; i < alkioidenLkm; i++) {
            tuotos.append(lukujono[i]);
            if (i != alkioidenLkm - 1) {
                tuotos.append(", ");
            }
        }

        return tuotos + "}";
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        System.arraycopy(lukujono, 0, taulu, 0, taulu.length);
        return taulu;
    }


    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdisteJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int luku : aTaulu) {
            yhdisteJoukko.lisaa(luku);
        }

        for (int luku : bTaulu) {
            yhdisteJoukko.lisaa(luku);
        }

        return yhdisteJoukko;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkausJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int luku1 : aTaulu) {
            for (int luku2 : bTaulu) {
                if (luku1 == luku2) {
                    leikkausJoukko.lisaa(luku2);
                }
            }
        }

        return leikkausJoukko;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko erotusJoukko = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();

        for (int luku : aTaulu) {
            erotusJoukko.lisaa(luku);
        }

        for (int luku : bTaulu) {
            erotusJoukko.poista(luku);
        }

        return erotusJoukko;
    }
} 