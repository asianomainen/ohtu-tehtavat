package ohtu;

import java.util.Objects;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            if (getPlayerScore(player2Name).equals("Deuce")) {
                return "Deuce";
            } else {
                score.append(getPlayerScore(player1Name))
                        .append("-All");
                return score.toString();
            }
        }

        if (player1Score >= 4 || player2Score >= 4) {
            int difference = player1Score - player2Score;
            if (difference == 1) {
                return "Advantage player1";
            } else if (difference == -1) {
                return "Advantage player2";
            } else if (difference >= 2) {
                return "Win for player1";
            } else {
                return "Win for player2";
            }
        }

        score.append(getPlayerScore(player1Name))
                .append("-")
                .append(getPlayerScore(player2Name));

        return score.toString();
    }

    private String getPlayerScore(String playerName) {
        int score;

        if (Objects.equals(playerName, player1Name)) {
            score = player1Score;
        } else {
            score = player2Score;
        }

        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "Deuce";
        }
    }
}