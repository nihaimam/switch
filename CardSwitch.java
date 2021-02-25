/**************************************************************************
  * @author Niha Imam
  * CS310 Spring 2018
  * Project 1
  * George Mason University
  * 
  * File Name: CardSwitch.java
  *
  * Description: Class specific to the game SWITCH by extending the 
  * abstract class Card.  
  ***************************************************************************/

public class CardSwitch extends Card{
  
  /**
   * constructor to create card for the game
   * with a given rank and suit
   * 
   * @param r is the rank
   * @param s is the suit
   */
  public CardSwitch(Rank r, Suit s){
    super(r,s);
  }
  
  /**
   * checks if two cards equals and returns a boolean
   * 
   * @param another Card is the card being compared to
   * @returns true if the card is same as another Card
   */
  @Override
  public boolean equals(Card anotherCard){
    if (anotherCard.getRank() == rank && anotherCard.getSuit() == suit){
      return true;
    }
    return false;
  }
  
  /**
   * returns an integer according to the point of this card
   * ACE = 1 point, 2 = 2 points, ... , 9 = 9 points
   * (10, JACK, QUEEN, KING) = 10 points each
   * 
   * @return points of the card or -1 if invalid card
   */
  @Override
  public int getPoints(){
    if (rank == Rank.ACE){
      return 1;
    }
    else if (rank == Rank.JACK ||rank == Rank.TEN||rank == Rank.QUEEN ||rank == Rank.KING){
      return 10;
    }
    else if (rank == Rank.TWO){
      return 2;
    }
    else if (rank == Rank.THREE){
      return 3;
    }
    else if (rank == Rank.FOUR){
      return 4;
    }
    else if (rank == Rank.FIVE){
      return 5;
    }
    else if (rank == Rank.SIX){
      return 6;
    }
    else if (rank == Rank.SEVEN){
      return 7;
    }
    else if (rank == Rank.EIGHT){
      return 8;
    }
    else if (rank == Rank.NINE){
      return 9;
    }
    return -1;
  }
  
  /**
   * convert card to string consisting of as "(rank,suit)"
   * for example: (KING,SPADES) or (EIGHT,HEARTS)
   * 
   * @returns the string representation of the card
   */
  @Override
  public String toString(){
    return "(" + rank.toString() + "," + suit.toString() + ")";
  }
  
  //----------------------------------------------------
  //example test code... edit this as much as you want!
  public static void main(String[] args) {
    CardSwitch card = new CardSwitch(Card.Rank.ACE, Card.Suit.SPADES);
    if (card.getRank().equals(Card.Rank.ACE)){
      System.out.println("Yay 1");
    }
    if (card.toString().equals("(ACE,SPADES)")){
      System.out.println("Yay 2");
    }
    if (card.getPoints()==1){
      System.out.println("Yay 3");
    }
  }
}