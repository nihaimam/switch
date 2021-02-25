/**************************************************************************
  * @author Yutao Zhong and Jitin Krishnan
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: Deck.java
  *
  * Description: Class representing a deck of cards with basic functionalities
  * of shuffling, adding, dealing, etc.
  *
  * TASK: Comment using JavaDoc and show the Big-O runtime of each method.
  * Code on this file should NOT be modified.
  ***************************************************************************/

public class Deck<T extends Card> {
  
  private Hand<T> setOfCards; 
  
  /**
   * constructor to create card deckfor the game
   */
  public Deck(){
    setOfCards = new Hand<T>();
  }
  
  /**
   * add card to the deck
   * O(1)
   * 
   * @param c is the card that needs to added
   * @return true is card is added, else false
   */
  public boolean addCard(T c){
    if (hasCard(c))
      return false;
    setOfCards.addCard(c);
    return true;
  }
  
  /**
   * check if deck has a specific card
   * O(1)
   * 
   * @param c is the card to be checked if it in deck
   * @return true of deck has card
   */
  public boolean hasCard(T c){
    return (setOfCards.indexOf(c)!=-1);
    
  }
  
  /**
   * shuffle the deck
   * O(N)
   */
  public void shuffle() {
    for (int i = setOfCards.numCards()-1; i >= 0; i--){
      int rand = (int)(Math.random()*(i+1));
      T temp = setOfCards.getCard(i);
      setOfCards.setCard(i, setOfCards.getCard(rand));
      setOfCards.setCard(rand, temp);
    }
  }
  
  /**
   * deal the card 
   * O(1)
   * 
   * @returns the card 
   */
  public T dealNextCard() {
    if (setOfCards.numCards() == 0) return null;
    T temp = this.setOfCards.removeCard(setOfCards.numCards()-1);
    return temp;
  }
  
  /**
   * check if deck is empty
   * O(1)
   * 
   * @returns true if empty, else false
   */
  public boolean isEmpty() {
    return this.setOfCards.numCards() == 0;
  }
  
  /**
   * count the number of cards in the deck
   * O(1)
   * 
   * @returns the number of cards
   */
  public int cardCount(){
    return this.setOfCards.numCards();
  }
  
  /**
   * creates a string of how many cards in deck
   * O(1)
   * 
   * @returns the string
   */
  public String toString(){
    StringBuilder sb = new StringBuilder("Deck ");
    int numCards = cardCount();
    if (numCards ==0){
      sb.append("currently with no cards.");
    }
    else{
      sb.append("with "+numCards+ " cards:\n");
      sb.append(setOfCards.toString());
    }
    return sb.toString();
  }
  
}
