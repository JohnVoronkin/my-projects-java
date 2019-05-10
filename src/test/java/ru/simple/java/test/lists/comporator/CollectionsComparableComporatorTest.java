package ru.simple.java.test.lists.comporator;

import java.util.*;

public class CollectionsComparableComporatorTest {

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


}
