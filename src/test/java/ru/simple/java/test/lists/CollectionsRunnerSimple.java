package ru.simple.java.test.lists;

import java.util.Arrays;
import java.util.List;

public class CollectionsRunnerSimple {

  public static void main(String[] args) {

  }

  /*
  Comparable<Card> параметризирован тем типом, к-й мы сравниваем
   */
  public static class Card implements Comparable<Card> {

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

    @Override
    public int compareTo(Card card) {
      List<Face> faceList = Arrays.asList(Face.values());

      if (faceList.indexOf(this.face) < faceList.indexOf(card.getFace())) {
        return -1;
      } else if (faceList.indexOf(this.face) > faceList.indexOf(card.getFace())) {
        return +1;
      } else if (faceList.indexOf(this.face) == faceList.indexOf(card.getFace())) {
        return String.valueOf(this.suit).compareTo(String.valueOf(card.getSuit()));
      }
      return 0;
    }
  }

  enum Face {
    Ace, Deuce, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
  }

  enum Suit {
    SPADES, HEARTS, CLUBS, DIMONDS
  }

}
