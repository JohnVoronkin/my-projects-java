package ru.simple.java.test.lists.map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class WordWrapper implements Comparable<WordWrapper> {

  private final String word;
  private final int count;


  @Override
  public int compareTo(WordWrapper word) {
    return Integer.compare(word.getCount(), this.count);

  }
}
