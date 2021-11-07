package ohtuesimerkki;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void topScorersReturnsCorrectAmountOfEntries() {
        assertEquals(stats.topScorers(3).size(), 4);
    }

    @Test
    public void teamReturnsCorrectAmountOfPlayers() {
        assertEquals(stats.team("EDM").size(), 3);
    }

    @Test
    public void searchFindsCorrectPlayer() {
        assertEquals(stats.search("Kurri").getName(), "Kurri");
    }

    @Test
    public void searchReturnsNullIfPLayerNotFound() {
        assertNull(stats.search("Tikkanen"));
    }
}
