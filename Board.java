/**************************************************************************
  * @author Yutao Zhong and Jitin Krishnan
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: Board.java
  *
  * Description: Abstract Board class from which a board class specific to
  * any game can be constructed. This file SHOULD NOT be modified.
  ***************************************************************************/

public abstract class Board<T extends Card> {
  
  protected Player<T> currentPlayer;
  protected int numPlayer;
  protected Deck<T> deck;
  
  /**
   * constructor to create deck for the game
   * start with zero players
   * 
   * @param deck is deck needed to construct
   */
  public Board(Deck<T> deck){
    this.currentPlayer = null;
    this.numPlayer = 0;
    this.deck = deck;
  }
  
  /**
   * get the current player
   * O(1)
   * 
   * @returns the current player
   */
  abstract Player<T> getCurrentPlayer();
  
  /**
   * how many players are currently playing
   * O(1)
   * 
   * @return how many players
   */
  abstract int getNumPlayers();
  
  /**
   * what the current deck is
   * O(1)
   * 
   * @returns the current deck
   */
  abstract Deck<T> getDeck();
  
  /**
   * now to the next player (node) on the list
   * with a given rank and suit
   * O(1)
   * 
   * @return false if cannot move, else true
   */
  abstract boolean changeTurn();
  
  /**
   * add a new player in the game (list)
   * add it to the left of the current player
   * O(N)
   * 
   * @param x is the player that needs to be added
   */
  abstract void addPlayer(Player<T> x);
  
}