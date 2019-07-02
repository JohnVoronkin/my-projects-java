package ru.simple.java.test.lists.map.hashmap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@ToString
public class WordWrapper implements Comparable<WordWrapper> {

  private final String word;
  private final int count;

  @Override
  public int compareTo(WordWrapper thatWord) {
    if (this.count < thatWord.getCount()) {
      return -1;
    } else if (this.count > thatWord.getCount()) {
      return 1;
    }
    return this.word.compareTo(thatWord.getWord());
  }
}
