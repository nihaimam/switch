/**************************************************************************
  * @author Niha Imam
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: Player.java
  *
  * Description: A representation of a player (node) of a game (list) 
  * and it consists of name, points, hand, and who the next player is
  ***************************************************************************/

class Player <T extends Card> {
  
  // required fields
  private String name;
  private int points;
  private Hand<T> hand; 
  private Player<T> next;
  
  /**
   * constructor to create a player
   * 
   * @param name is te name of the player
   */
  public Player(String name){
    this.name = name;
    this.points = 0;
    this.hand = new Hand<>();
    this.next = null; 
  }
  
  /**
   * set the next player (node)
   * 
   * @param p is the next player
   */ 
  public void setNext(Player<T> p){
    this.next = p;
  }
  
  /**
   * get the next player
   * 
   * @return the next player (node)
   */
  public Player<T> getNext(){
    return this.next;
  }
  
  /**
   * check if there is a player after the current player
   * 
   * @return true if this.next is not null, else false
   */
  public boolean hasNext(){
    if (this.next != null){
      return true;
    }
    return false;
  }
  
  /**
   * how many points does a player has based on cards
   * 
   * @return the points of a particular player
   */
  public int getPoints(){
    return points;
  }
  
  /**
   * the name of the player
   * 
   * @returns the name of player as a string
   */
  public String getName(){
    return name;
  }
  
  /**
   * get a card and add it
   * 
   * @param c is the incoming card
   * @return true if card is received and added
   */
  public boolean receiveCard(T c){
    for (int i = 0; i < hand.numCards(); i++){
      if (hand.getCard(i) == c){
        return false;
      }
    }
    hand.addCard(c);
    points += c.getPoints();
    return true;
  }
  
  /**
   * check is card is in hand
   * 
   * @param c is the card we need to check for
   * @return true if card is in hand, else false
   */
  public boolean hasCard(T c){
    for (int i = 0; i < hand.numCards(); i++){
      if (hand.getCard(i) == c){
        return true;
      }
    }
    return false;
  }
  
  /**
   * make a move/play a card and give one away
   * 
   * @param c is the card we play
   * @return false if card not found, else true
   */
  public boolean playCard(T c){
    for (int i = 0; i < hand.numCards(); i++){
      if (hand.getCard(i) == c){
        hand.removeCard(c);
        points -= c.getPoints();
        return true;
      }
    }
    return false;
  }
  
  /**
   * give the card away that is located at a particular index
   * 
   * @param index is the index of card we want to play
   * @return the card we play
   * @throws RuntimeException
   *   only if index is invalid
   */
  public T playCard(int index) throws RuntimeException{
    if (index < 0 || index > hand.numCards()){
      throw new RuntimeException();
    }
    return hand.removeCard(index);
  }
  
  //---------------------------------------------------
  //example test code... edit this as much as you want!
  // you will need working CardSwitch and Hand classes to run the given code
  
  public String toString(){
    // Not required; edit for your own testing 
    return "Player "+ name;
  }
  
  public static void main(String[] args) {
    CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
    CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
    CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
    Player<CardSwitch> player1 = new Player<CardSwitch>("Tom");
    Player<CardSwitch> player2 = new Player<CardSwitch>("Jerry");
    player1.receiveCard(card2);
    player1.receiveCard(card3);
    player2.receiveCard(card1);
    player1.setNext(player2);
    if (player1.getName().equals("Tom") && player1.getNext() == player2){
      System.out.println("Yay 1");
    }
    if (player1.hasCard(card2) == true && player1.getPoints() == 19){
      System.out.println("Yay 2");
    }
    if ((player2.hasNext()==false) && player1.playCard(0) == card2){
      System.out.println("Yay 3");
    }
  }
}