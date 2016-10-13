package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private int player;
    private PigGameState pigGame;

    /**
     * This actor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        super();
        pigGame = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        player = pigGame.getPlayerTurn();
        if (playerIdx == player) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (pigGame.getPlayerTurn() == player) {
            if (action instanceof PigHoldAction) {
                if (pigGame.getPlayerTurn() == 0) {
                    pigGame.setPlayer0Score(pigGame.getRunningTotal());
                    pigGame.setPlayerTurn(player);
                } else if (pigGame.getPlayerTurn() == 1) {
                    pigGame.setPlayer1Score(pigGame.getRunningTotal());
                    pigGame.setPlayerTurn(player);
                }
                pigGame.setRunningTotal(1);
                return true;
            } else if (action instanceof PigRollAction) {
                Random rand = new Random();
                pigGame.setDieValue(rand.nextInt(6) + 1);
                if (pigGame.getDieValue() == 1) {
                    pigGame.setRunningTotal(1);
                    pigGame.setPlayerTurn(player);
                } else {
                    pigGame.setRunningTotal(pigGame.getDieValue());
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState temp = new PigGameState(pigGame);
        p.sendInfo(temp);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (pigGame.getPlayer0Score() >= 50) {
            return "Player 0 has won the game with a score of " +pigGame.getPlayer0Score();
        } else if (pigGame.getPlayer1Score() >= 50) {
            return "Player 1 has won the game with a score of " +pigGame.getPlayer1Score();
        } else {
            return null;
        }
    }

}// class PigLocalGame
