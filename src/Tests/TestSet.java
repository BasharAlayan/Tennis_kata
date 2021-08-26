package Tests;

import main.Game;
import main.Player;
import main.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSet {

    Player player1;
    Player player2;
    Game game;
    Set set;

    @Before
    public void init() {
        player1 = new Player(1, "Roger", "Federer");
        player2 = new Player(2, "Rafa", "Nadal");
        game = new Game(player1, player2);
        set = new Set(player1, player2,game);

    }

    @Test
    public void testSimple(){

        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),0);
        Assert.assertEquals(player1.getPoint(),0);
        Assert.assertEquals(player2.getPoint(),0);

        game.incrementGameScorePlayer(player1); // 15 - 0
        game.incrementGameScorePlayer(player1); // 30 - 0
        game.incrementGameScorePlayer(player2); // 30 - 15
        game.incrementGameScorePlayer(player1); // 40 - 15
        game.incrementGameScorePlayer(player1); // player win
        set.incrementSetScorePlayer(set.getGame().getWinner()); // The winner win the first set

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-1)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),1);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-2)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),2);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-3)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),3);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-4)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),4);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-5)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (1-6)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),6);
        Assert.assertEquals(set.getSetWinner(),player2);
    }

    @Test
    public void testSevenFive() { // 5 - 7
        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-1)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),1);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-2)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),2);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-3)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),3);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-4)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),4);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-5)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (1-5)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-2)
        Assert.assertEquals(player1.getSet(),2);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-3)
        Assert.assertEquals(player1.getSet(),3);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-4)
        Assert.assertEquals(player1.getSet(),4);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-5)
        Assert.assertEquals(player1.getSet(),5);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (6-5)
        Assert.assertEquals(player1.getSet(),6);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (7-5)
        Assert.assertEquals(player1.getSet(),7);
        Assert.assertEquals(player2.getSet(),5);

        Assert.assertEquals(set.getSetWinner(),player1); // player1 wins the set
    }


    @Test
    public void testTieBreak() { // 5 - 7
        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-1)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),1);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-2)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),2);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-3)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),3);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-4)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),4);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (0-5)
        Assert.assertEquals(player1.getSet(),0);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (1-5)
        Assert.assertEquals(player1.getSet(),1);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-2)
        Assert.assertEquals(player1.getSet(),2);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-3)
        Assert.assertEquals(player1.getSet(),3);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-4)
        Assert.assertEquals(player1.getSet(),4);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (5-5)
        Assert.assertEquals(player1.getSet(),5);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player1); //Player 1 wins 1 Game (6-5)
        Assert.assertEquals(player1.getSet(),6);
        Assert.assertEquals(player2.getSet(),5);

        set.incrementSetScorePlayer(player2); //Player 2 wins 1 Game (6-6)
        Assert.assertEquals(player1.getSet(),6);
        Assert.assertEquals(player2.getSet(),6);

        set.incrementSetScorePlayer(player2); // TieBreak 0-1
        Assert.assertEquals(player1.getTieBreakScore(),0);
        Assert.assertEquals(player2.getTieBreakScore(),1);

        set.incrementSetScorePlayer(player1); // TieBreak 1-1
        Assert.assertEquals(player1.getTieBreakScore(),1);
        Assert.assertEquals(player2.getTieBreakScore(),1);

        set.incrementSetScorePlayer(player2); // TieBreak 1-2
        Assert.assertEquals(player1.getTieBreakScore(),1);
        Assert.assertEquals(player2.getTieBreakScore(),2);

        set.incrementSetScorePlayer(player1); // TieBreak 2-2
        Assert.assertEquals(player1.getTieBreakScore(),2);
        Assert.assertEquals(player2.getTieBreakScore(),2);

        set.incrementSetScorePlayer(player1); // TieBreak 3-2
        Assert.assertEquals(player1.getTieBreakScore(),3);
        Assert.assertEquals(player2.getTieBreakScore(),2);

        set.incrementSetScorePlayer(player2); // TieBreak 3-3
        Assert.assertEquals(player1.getTieBreakScore(),3);
        Assert.assertEquals(player2.getTieBreakScore(),3);

        set.incrementSetScorePlayer(player2); // TieBreak 3-4
        Assert.assertEquals(player1.getTieBreakScore(),3);
        Assert.assertEquals(player2.getTieBreakScore(),4);

        set.incrementSetScorePlayer(player1); // TieBreak 4-4
        Assert.assertEquals(player1.getTieBreakScore(),4);
        Assert.assertEquals(player2.getTieBreakScore(),4);

        set.incrementSetScorePlayer(player2); // TieBreak 4-5
        Assert.assertEquals(player1.getTieBreakScore(),4);
        Assert.assertEquals(player2.getTieBreakScore(),5);

        set.incrementSetScorePlayer(player2); // TieBreak 4-6
        Assert.assertEquals(player1.getTieBreakScore(),4);
        Assert.assertEquals(player2.getTieBreakScore(),6);

        set.incrementSetScorePlayer(player2); // TieBreak 4-7
        Assert.assertEquals(player1.getTieBreakScore(),4);
        Assert.assertEquals(player2.getTieBreakScore(),7);

        Assert.assertEquals(set.getSetWinner(),player2); // player1 wins the set
    }
}
