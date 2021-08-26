package Tests;

import main.Game;
import main.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGame {
    Player player1;
    Player player2;
    Game game;

    @Before
    public void init(){
        player1 = new Player(1, "Roger", "Federer");
        player2 = new Player(2, "Rafa", "Nadal");
        game = new Game(player1,player2);

    }

    @Test
    public void TestUserStory2() {
        // 0 - 0
        Assert.assertEquals(player1.translateScore(),"0");
        Assert.assertEquals(player2.translateScore(),"0");

        // 15 - 0
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"15");
        Assert.assertEquals(player2.translateScore(),"0");

        // 30 - 0
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"0");

        //30 - 15
        game.incrementGameScorePlayer(player2);

        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"15");

        //40 - 15
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"40");
        Assert.assertEquals(player2.translateScore(),"15");

        //40 - 30
        game.incrementGameScorePlayer(player2);
        Assert.assertEquals(player1.translateScore(),"40");
        Assert.assertEquals(player2.translateScore(),"30");

        //40 - 40
        game.incrementGameScorePlayer(player2);
        Assert.assertEquals(player1.translateScore(),"40");
        Assert.assertEquals(player2.translateScore(),"40");


        //40 - ADV
        game.incrementGameScorePlayer(player2);



        Assert.assertEquals(player1.translateScore(),"40");
        Assert.assertEquals(player2.translateScore(),"ADV");

        //DEUCE - DEUCE
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"DEUCE");
        Assert.assertEquals(player2.translateScore(),"DEUCE");

        //ADV - 40
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"ADV");
        Assert.assertEquals(player2.translateScore(),"40");


        //Player 1 win the game
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(game.getWinner(),player1);

        //Restart
        Assert.assertEquals(player1.translateScore(),"0");
        Assert.assertEquals(player2.translateScore(),"0");

    }

    @Test
    public void TestSimple() {
        // 0 - 0
        Assert.assertEquals(player1.translateScore(),"0");
        Assert.assertEquals(player2.translateScore(),"0");

        // 15 - 0
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"15");
        Assert.assertEquals(player2.translateScore(),"0");

        // 30 - 0
        game.incrementGameScorePlayer(player1);
        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"0");

        //30 - 15
        game.incrementGameScorePlayer(player2);

        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"15");

        //30 - 30
        game.incrementGameScorePlayer(player2);
        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"30");

        //30 - 40
        game.incrementGameScorePlayer(player2);
        Assert.assertEquals(player1.translateScore(),"30");
        Assert.assertEquals(player2.translateScore(),"40");


        //Player 1 win the game
        game.incrementGameScorePlayer(player2);
        Assert.assertEquals(game.getWinner(),player2);

        //Restart
        Assert.assertEquals(player1.translateScore(),"0");
        Assert.assertEquals(player2.translateScore(),"0");

    }
}
