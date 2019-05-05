package ru.simple.java.test.lists;

import java.util.*;

public class CollectionsRunnerSimple {

  public static void main(String[] args) {
    List<Card> deckOfCards = new ArrayList<>();

    for (Card.Face face : Card.Face.values()) {
      for (Card.Suit suit : Card.Suit.values()) {
        deckOfCards.add(new Card(suit, face));
      }
    }

    System.out.println("Original deck of cards");
    printOutput(deckOfCards);
    Collections.shuffle(deckOfCards);

    System.out.println("\n\ncards auto shuffle");
    printOutput(deckOfCards);

    Collections.sort(deckOfCards);

    System.out.println("\n\ncards after sorted");
    printOutput(deckOfCards);

    Collections.sort(deckOfCards, Collections.reverseOrder());

    System.out.println("\n\ncards after sorted of reverse order");
    printOutput(deckOfCards);

    Collections.sort(deckOfCards, new Card.CardComparator());

    System.out.println("\n\ncards after sorted custom Comparator");
    printOutput(deckOfCards);

    // binary search (работает только в том случае, если коллекция отсортирована)

    Collections.sort(deckOfCards);
    Card cardSearch = new Card(Card.Suit.SPADES, Card.Face.Queen);
    // binarySearch Возвращает индекс найшей карты в коллекции
    int i = Collections.binarySearch(deckOfCards, cardSearch);
    if (i >= 0) {
      System.out.println("card was found at position " + i);
    } else System.out.println("card not found");


  }

  private static void printOutput(List<Card> deckOfCards) {
    for (int i = 0; i < deckOfCards.size(); i++) {
      System.out.printf("%-15s %s", deckOfCards.get(i), (i + 1) % 4 == 0 ? "\n" : " ");
    }
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

    /*@Override
    public int compareTo(Card o) {
      return 0;
    }*/

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


}
