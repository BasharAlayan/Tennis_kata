package main;

public class Set {
    private Player player1;
    private Player player2;
    private Game currentGame;
    private Player winner;

    public Set(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        player1.setSet(0);
        player2.setSet(0);
        currentGame = null;
        winner = null;
    }


    public Set(Player player1, Player player2, Game game) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentGame = game;
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


    public Game getGame() {
        return currentGame;
    }

    public void setGame(Game games) {
        this.currentGame = games;
    }

    public void incrementSetScorePlayer(Player player) {
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        // Set Score is ( 5 - 4 ) or ( 4 - 5 ) leading to ( 4 - 6 ) or ( 6 - 4 ) => increment scores & designate a winner
        if ((player1.getSet() == 5 && player2.getSet() <= 4 && player1Scoring) || (player2.getSet() == 5 && player1.getSet() <= 4 && player2Scoring)) {
            incrementSetScore(player);
            winnerSet(player);
        }

        // Set Score is ( 6 - 6 ) => activate tie break rule
        else if (player2.getSet() == 6 && player1.getSet() == 6) {
            activateTieBreak(player);
        }

        // Set Score is ( 5 - 6 ) or ( 6 - 5 ) leading to ( 5 - 7 ) or ( 7 - 5 ) => increment scores & designate a winner
        else if ((player1.getSet() == 6 && player2.getSet() <= 5 && player1Scoring) || (player2.getSet() == 6 && player1.getSet() <= 5 && player2Scoring)) {
            incrementSetScore(player);
            winnerSet(player);
            // All other cases => increment set scores
        } else {
            incrementSetScore(player);
        }
    }

    private void activateTieBreak(Player player){
        boolean player1Scoring = player.equals(player1);
        boolean player2Scoring = player.equals(player2);

        incrementTieBreakScore(player);
        if ((player1.getTieBreakScore() >= 7 && (player1.getTieBreakScore() >= (player2.getTieBreakScore() + 2)) && player1Scoring)
                || (player2.getTieBreakScore() >= 7 && (player2.getTieBreakScore() >= (player1.getTieBreakScore() + 2))) && player2Scoring) {
            incrementSetScore(player);
            winnerSet(player);
        }
    }

    private void incrementTieBreakScore(Player player) {
        if (player.equals(player1)) {
            player1.increaseTieBreakScore();
        } else {
            player2.increaseTieBreakScore();
        }
    }

    private void winnerSet(Player player) {
        if (player1.equals(player)) {
            winner = player1;
        } else {
            winner = player2;
        }
       // player.winSetDisplay();
    }

    public Player getSetWinner(){
        if (winner.equals(player1)){
            return player1;
        }
        if (winner.equals(player2)){
            return player2;
        }
        return null;
    }
    private void incrementSetScore(Player player) {
        if (player.equals(player1)) {
            player1.winSet();
        } else {
            player2.winSet();
        }
    }
}
