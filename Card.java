/**************************************************************************
  * @author Yutao Zhong and Jitin Krishnan
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: Card.java
  *
  * Description: Abstract Card class from which a card class specific to
  * any game can be constructed. This file SHOULD NOT be modified.
  ***************************************************************************/

public abstract class Card {
  
  /**
   * enumeration of ranks 
   */
  enum Rank{
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
  }
  
  /**
   * enumeration of suits
   */
  enum Suit{
    HEARTS, CLUBS, DIAMONDS, SPADES;
  }
  
  protected Rank rank;
  protected Suit suit;
  
  /**
   * constructor to create card for the game
   * with a given rank and suit
   * 
   * @param r is the rank
   * @param s is the suit
   */
  public Card(Rank r, Suit s){
    rank = r;
    suit = s;
  }
  
  /**
   * getter for rank
   * 
   * @returns rank of card
   */
  public Rank getRank(){
    return rank;
  }
  
  /**
   * getter for suit
   * 
   * @returns suits of cards
   */
  public Suit getSuit(){
    return suit;
  }
  
  /**
   * checks if two cards equals and returns a boolean
   * 
   * @param another Card is the card being compared to
   * @returns true if the card is same as another Card
   */
  abstract boolean equals(Card c);
  
  /**
   * returns an integer according to the point of this card
   * ACE = 1 point, 2 = 2 points, ... , 9 = 9 points
   * (10, JACK, QUEEN, KING) = 10 points each
   * 
   * @return points of the card or -1 if invalid card
   */
  abstract int getPoints();
  
  /**
   * convert card to string consisting of as "(rank,suit)"
   * for example: (KING,SPADES) or (EIGHT,HEARTS)
   * 
   * @returns the string representation of the card
   */
  @Override
  public abstract String toString();
  
}