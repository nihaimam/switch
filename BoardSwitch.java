/**************************************************************************
  * @author Niha Imam
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: BoardSwitch.java
  *
  * Description: Class specific to the game SWITCH by extending the
  * abstract class Board
  * ClassRequired methods:
  ***************************************************************************/

public class BoardSwitch<T extends Card> extends Board<T>{
  
  /**
   * constructor to create deck for the game
   * start with zero players
   * 
   * @param deck is deck needed to construct
   */
  public BoardSwitch(Deck<T> deck){
    super(deck);
  }
  
  /**
   * get the current player
   * O(1)
   * 
   * @returns the current player
   */
  @Override
  public Player<T> getCurrentPlayer() {
    return currentPlayer;
  }
  
  /**
   * how many players are currently playing
   * O(1)
   * 
   * @return how many players
   */
  @Override
  public int getNumPlayers() {
    return numPlayer;
  }
  
  /**
   * what the current deck is
   * O(1)
   * 
   * @returns the current deck
   */
  @Override
  public Deck<T> getDeck(){
    return deck;
  }
  
  /**
   * now to the next player (node) on the list
   * with a given rank and suit
   * O(1)
   * 
   * @return false if cannot move, else true
   */
  @Override
  public boolean changeTurn(){
    if (currentPlayer.hasNext()){
      currentPlayer = currentPlayer.getNext();
      return true;
    }
    return false;
  }
  
  /**
   * add a new player in the game (list)
   * add it to the left of the current player
   * O(N)
   * 
   * @param x is the player that needs to be added
   */
  @Override
  public void addPlayer(Player<T> x){
    numPlayer+=1;
    Player prev;
    if (currentPlayer == null){
      currentPlayer = x;
      currentPlayer.setNext(x);
      return;
    }
    if (currentPlayer.getNext() == currentPlayer){
      x.setNext(currentPlayer);
      currentPlayer.setNext(x);
      return;
    }
    Player temp = currentPlayer.getNext();
    while (true){
      if (temp.getNext() == currentPlayer){
        prev = temp;
        break;
      }
      if (temp.hasNext()){
        temp =temp.getNext();
      }
    }
    x.setNext(currentPlayer);
    prev.setNext(x);
  }
  
  /**
   * find who has the most points and determine the winner
   * O(N)
   * 
   * @return player with the highest points
   */
  public Player<T> findWinner(){
    int maxpoints = currentPlayer.getPoints();
    Player winner = currentPlayer;
    Player temp = currentPlayer.getNext();
    while (temp != currentPlayer){
      if (temp.getPoints()>maxpoints){
        winner = temp;
      }
      if (temp.getPoints()==maxpoints){
        if (temp.getName().compareTo(winner.getName())<0){
          winner = temp;
        }
      }
      temp = temp.getNext();
    }
    return winner;
  }
  
  //-----------------------------------------------------
  // example test code... edit this as much as you want!
  // you will need working CardSwitch, Hand, Player, Deck and PlaySwitch classes to run the given code
  
  public static void main(String[] args) {
    Deck<CardSwitch> deck = new Deck<CardSwitch>();
    PlaySwitch.init_deck(deck);
    BoardSwitch<CardSwitch> myBoard = new BoardSwitch<CardSwitch>(deck);
    Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
    Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");
    myBoard.addPlayer(player1);
    if (myBoard.getNumPlayers() ==1  && myBoard.getCurrentPlayer() == player1
          && player1.getNext() == player1){
      System.out.println("Yay 1");
    }
    myBoard.addPlayer(player2);
    if (myBoard.getNumPlayers() ==2  && myBoard.getCurrentPlayer() == player1
          && (myBoard.changeTurn()==true) && myBoard.getCurrentPlayer() == player2){
      System.out.println("Yay 2");
    }
    player1.receiveCard(new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES));
    player1.receiveCard(new CardSwitch(Card.Rank.JACK, Card.Suit.CLUBS));
    player2.receiveCard(new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS));
    player2.receiveCard(new CardSwitch(Card.Rank.THREE, Card.Suit.SPADES));
    if (player1.getNext() == player2 && player2.getNext() == player1
          && myBoard.findWinner() == player2){
      System.out.println("Yay 3");
    }
  }
}