package ohtu;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OstoskoriTest {

    Ostoskori kori;

    @Before
    public void setUp() {
        kori = new Ostoskori();
    }

    // step 1
    @Test
    public void ostoskorinHintaJaTavaroidenMaaraAlussa() { 
        assertEquals(0, kori.hinta());
        assertEquals(0, kori.tavaroitaKorissa());
    }

    // step 2
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiTuote() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(1, kori.tavaroitaKorissa());
    }

    // step 3
    @Test
    public void yhdenTuotteenLisaamisenJalkeenOstoskorinHintaSamaKuinTuotteenHinta() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);

        assertEquals(3, kori.hinta());
    }

    // step 4
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenOstoskorissaOnKaksiTuotetta() {
        Tuote maito = new Tuote("maito", 3);
        Tuote leipa = new Tuote("leipä", 5);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(leipa);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    // step 5
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenOstoskorinHintaOnSamaKuinTuotteidenSumma() {
        Tuote maito = new Tuote("maito", 3);
        Tuote leipa = new Tuote("leipä", 5);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(leipa);

        assertEquals(8, kori.hinta());
    }

    // step 6
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenOstoskorinTavaramaaraOnOikein() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(2, kori.tavaroitaKorissa());
    }

    // step 7
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenOstoskorinHintaOnSamaKuinTuotteidenSumma() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(6, kori.hinta());
    }

    // step 8
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        Tuote tuote1 = new Tuote("maito", 3);

        kori.lisaaTuote(tuote1);

        List<Ostos> ostokset = kori.ostokset();

        assertEquals(1, ostokset.size());
    }

    // step 9
    @Test
    public void yhdenTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaTuotteenNimiJaMaara() {
        Tuote maito = new Tuote("maito", 3);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(1, ostos.lukumaara());
    }

    // step 10
    @Test
    public void kahdenEriTuotteenLisaamisenJalkeenKorissaKaksiOstosOliota() {
        Tuote maito = new Tuote("maito", 3);
        Tuote leipa = new Tuote("leipä", 5);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(leipa);

        assertEquals(2, kori.ostokset().size());
    }

    // step 11
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlio() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        assertEquals(1, kori.ostokset().size());
    }

    // step 11
    @Test
    public void kahdenSamanTuotteenLisaamisenJalkeenKorissaYksiOstosOlioJollaOikeaNimiJaLukumaaraOnKaksi() {
        Tuote maito = new Tuote("maito", 3);

        kori.lisaaTuote(maito);
        kori.lisaaTuote(maito);

        Ostos ostos = kori.ostokset().get(0);

        assertEquals("maito", ostos.tuotteenNimi());
        assertEquals(2, ostos.lukumaara());
    }
}
