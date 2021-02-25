/**************************************************************************
  * @author Niha Imam
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: Hand.java
  *
  * Description: Class that holds an array of cards that can be expanded
  ***************************************************************************/

public class Hand<T extends Card>{
  
  private T [] cards; // array of cards
  private int numCards; // number of cards in the array
  private int size; //keep track of size of array
  
  /**
   * constructor initialize the array of cards and numCards
   */
  public Hand(){
    size = 5;
    cards =  (T[]) new CardSwitch[size];
    numCards = 0;
  }
  
  /**
   * getter of number of cards
   * O(1)
   * 
   * @returns how many cards there are
   */
  public int numCards(){
    return numCards;
  } 
  
  /**
   * get the value of card
   * O(1)
   * 
   * @param index is the index of card
   * @returns true if the card is same as another Card
   * @throws RuntimeException
   *   only if index is invalid
   */
  public T getCard(int index) throws RuntimeException{
    if (index < 0 || index > numCards){
      throw  new RuntimeException();
    }
    return cards[index];
  }
  
  /**
   * set the card to index c
   * O(1)
   *
   * @param index is the index of card
   * @param c is the new index of card
   * @throws RuntimeException
   *   only if index is invalid
   */
  public void setCard(int index, T c) throws RuntimeException{
    if (index <0 || index > numCards){
      throw new RuntimeException();
    }
    cards[index] = c;
  }
  
  /**
   * add the given card to the end
   * O(N)
   * 
   * @param c is the card that needs to be added
   */
  public void addCard(T c){
    if (numCards < size){
      cards[numCards] = c;
      numCards +=1;
    }
    else{
      T[] newCards = (T[]) new CardSwitch[size + 1];
      System.arraycopy(cards, 0, newCards, 0, cards.length);
      cards = newCards;
      size += 1;
      cards[numCards] = c;
      numCards += 1;
    }
  }
  
  /**
   * return index of card
   * O(N)
   * 
   * @param c is the card
   * @returns index of card, if not valid return -1
   */
  public int indexOf(T c){
    for(int i = 0; i < numCards; i++){
      if (cards[i] == c){
        return i;
      }
    }
    return -1;
  }
  
  /**
   * remove card at particular index
   * O(N)
   * 
   * @param index is the index to remove card from
   * @returns the removed card
   * @throws RuntimeException
   *   only if index is invalid
   */
  public T removeCard(int index) throws RuntimeException{
    T r = cards[index];
    if (index <0 || index > numCards){
      throw new RuntimeException();
    }
    for (int i = 0; i < numCards; i++){
      if (i == index){
        for (int j = i; j + 1 < numCards; j++){
          cards[j] = cards[j + 1];
        }
        numCards -= 1;
        break;
      }
    }
    return r;
  }
  
  /**
   * remove card c
   * O(N)
   * 
   * @param c is the card that needs to be removes
   * @returns false if card doesnt exist
   */
  public boolean removeCard(T c){
    for (int i = 0; i < numCards; i++){
      if (cards[i] == c){
        cards[i] = null;
        return true;
      }
    }
    return false;
  }
  
  // --------------------------------------------------------
  // example test code... edit this as much as you want!
  // you will need a working CardSwitch class to run the given code
  
  // Not required, update for your testing purpose
  @Override
  public String toString(){
    // return string representation of hand
    // update if you want to include information for all cards in hand
    return "Hand with " + numCards + " cards";  
  }
  
  public static void main(String[] args) {
    CardSwitch card1 = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
    CardSwitch card2 = new CardSwitch(Card.Rank.JACK, Card.Suit.SPADES);
    CardSwitch card3 = new CardSwitch(Card.Rank.NINE, Card.Suit.HEARTS);
    Hand<CardSwitch> myHand = new Hand<CardSwitch>();
    myHand.addCard(card1);
    myHand.addCard(card2);
    if ((myHand.numCards() == 2) && (myHand.getCard(0).equals(card1))){
      System.out.println("Yay 1");
    }
    myHand.addCard(card3);
    if ( card2.equals(myHand.removeCard(1)) && myHand.getCard(1).equals(card3)){
      System.out.println("Yay 2");
    }
    if ((myHand.indexOf(card1)==0) && (myHand.indexOf(card2) == -1 )){
      System.out.println("Yay 3");
    }
  }
}