package java_example.collections.comporator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Comparable<Card> параметризирован тем типом, к-й мы сравниваем
 */
public class Card implements Comparable<Card> {

  private final Suit suit;
  private final Face face;

  public Card(Suit suit, Face face) {
    this.suit = suit;
    this.face = face;
  }

  public Suit getSuit() {
    return suit;
  }

  public Face getFace() {
    return face;
  }

  enum Face {
    Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
  }

  enum Suit {
    SPADES, HEARTS, CLUBS, DIAMONDS
  }

  @Override
  public int compareTo(Card card) {
    List<Face> faceList = Arrays.asList(Face.values());

    if (faceList.indexOf(this.face) < faceList.indexOf(card.getFace())) {
      return -1;
    } else if (faceList.indexOf(this.face) > faceList.indexOf(card.getFace())) {
      return 1;
    } else if (faceList.indexOf(this.face) == faceList.indexOf(card.getFace())) {
      return String.valueOf(this.suit).compareTo(String.valueOf(card.getSuit()));
    }
    return 0;
  }

  static class CardComparator implements Comparator<Card> {
    List<Face> faceList = Arrays.asList(Face.values());


    @Override
    public int compare(Card card1, Card card2) {
      if (faceList.indexOf(card1.getFace()) < faceList.indexOf(card2.getFace())) {
        return 1;
      } else if (faceList.indexOf(card1.getFace()) > faceList.indexOf(card2.getFace())) {
        return -1;
      } else if (faceList.indexOf(card1.getFace()) == faceList.indexOf(card2.getFace())) {
        return String.valueOf(card1.getSuit()).compareTo(String.valueOf(card2.getSuit()));
      }
      return 0;
    }
  }

  @Override
  public String toString() {
    return this.face + " of " + this.suit;
  }
}
