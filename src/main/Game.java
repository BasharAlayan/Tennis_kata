package main;

public class Game {
    private Player player1;
    private Player player2;
    private Player winner;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.setPoint(0);
        player2.setPoint(0);
        winner = null;

    }

    public Game(Set set) {
        this.player1 = set.getPlayer1();
        this.player2 = set.getPlayer2();
        winner = null;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    private void decrementGameScore(Player player) {
        if (player1.equals(player)) {
            player2.setPoint(3);
        } else {
            player1.setPoint(3);
        }
    }

    private void incrementGameScore(Player player, boolean isDeuce) {
        if (!isDeuce) {
            if (player1.equals(player)) {
                player1.winPoint();
            } else {
                player2.winPoint();
            }
        } else {
            if (player1.equals(player)) {

                player1.winPoint();
                player1.winPoint();
            } else {
                player2.winPoint();
                player2.winPoint();
            }
        }
    }

    public void incrementGameScorePlayer(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score with {X<40} is ( X - 40 ) or ( 40 - X ) leading to score above 40 => designate a winner
        if ((player1.getPoint() == 3 && player2.getPoint() < 3 && player1Scoring) || (player2.getPoint() == 3 && player1.getPoint() < 3 && player2Scoring)) {
            getWinner(player);
        }
        // Game Score is ( 40 - 40 ) or above => activate deuce rule
        else if (player1.getPoint() >= 3 && player2.getPoint() >= 3) {
            activateDeuceRule(player);
        }
        // All other cases => increment scores
        else {
            incrementGameScore(player, false);
        }
    }


    private void activateDeuceRule(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Game Score is ( 40 - 40 ) => increment score to ADV
        if (player1.getPoint() == 3 && player2.getPoint() == 3) {
            incrementGameScore(player, true);
        }
        else if (player1.getPoint() == 4 && player2.getPoint() == 4) {
            decrementGameScore(player);
            incrementGameScore(player, false);
        }
        // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score above ADV => designate a winner

        else if ((player1.getPoint() == 5 && player2.getPoint() == 3 && player1Scoring) || (player2.getPoint() == 5 && player1.getPoint() == 3 && player2Scoring)) {

            getWinner(player);
        }

        // Game Score is ( ADV - 40 ) or ( 40 - ADV ) leading to score ( ADV - ADV ) =>  activate deuce rule ==> DEUCE
        else if ((player1.getPoint() == 3 && player2.getPoint() == 5 && player1Scoring) || (player2.getPoint() == 3 && player1.getPoint() == 5 && player2Scoring)) {
            player1.setPoint(4);
            player2.setPoint(4);
        }
    }

    public void getWinner(Player player) {
        if (player1.equals(player)) {
            winner = player1;
            resetGameScores();
        }
        if (player2.equals(player)) {
            winner = player2;
            resetGameScores();
        }
    }

    public Player getWinner() {

        return winner;
    }

    private void resetGameScores() {
        player1.setPoint(0);
        player2.setPoint(0);
    }
}
