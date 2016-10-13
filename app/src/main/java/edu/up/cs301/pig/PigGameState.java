package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by vandewar19 on 10/12/2016.
 */
public class PigGameState extends GameState {
    private int playerTurn;
    private int player0Score;
    private int player1Score;
    private int runningTotal;
    private int dieValue;


    public PigGameState() {
        super();
        this.playerTurn = 0;
        this.player0Score = 0;
        this.player1Score = 0;
        this.runningTotal = 0;
        this.dieValue = 0;

    }

    public PigGameState(PigGameState p) {
        super();
        playerTurn = getPlayerTurn();
        player0Score = getPlayer0Score();
        player1Score = getPlayer1Score();
        runningTotal = getRunningTotal();
        dieValue = getDieValue();

    }

    public int getPlayerTurn() {
        return playerTurn;

    }

    public int getPlayer0Score() {
    return player0Score;

    }

    public int getPlayer1Score() {
    return player1Score;

    }

    public int getRunningTotal() {
    return runningTotal;

    }

    public int getDieValue() {
    return dieValue;

    }

    public void setPlayerTurn(int player) {
        //player = 1-player;
        playerTurn = player;
    }

    public void setPlayer0Score(int score) {
        player0Score += score;
    }

    public void setPlayer1Score(int score) {
        player1Score += score;
    }

    public void setRunningTotal(int total) {
        if (total == 1 ) {
            runningTotal = 0;
        }
        else {
            runningTotal += total;
        }
    }

    public void setDieValue(int value) {
        dieValue = value;
    }

}
