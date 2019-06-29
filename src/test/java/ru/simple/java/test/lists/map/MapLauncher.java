package ru.simple.java.test.lists.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

public class MapLauncher {

  public static void main(String[] args) throws IOException {

    Map<String, Integer> wordMap = new HashMap<>();

    System.out.println("Please enter some text");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String string = reader.readLine();

    String[] tokens = string.split(" ");

    for (String token : tokens) {
      String word = token.toLowerCase();
      // в качестве ключа передаем наше слово
      Integer count = wordMap.get(word);
      if (count == null) { // если слова в коллекции еще нет, то возвращается null
        wordMap.put(word, 1);
      } else {
        wordMap.put(word, count + 1);
      }
    }

    NavigableSet<WordWrapper> wordWrappers = convertToSet(wordMap);
    printSet(wordWrappers);
  }

  private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> wordMap) {
    NavigableSet<WordWrapper> wordSet = new TreeSet<>();
    for (Map.Entry<String, Integer> pair : wordMap.entrySet()) {
      wordSet.add(new WordWrapper(pair.getKey(), pair.getValue()));
    }
    return wordSet;
  }

  private static void printSet(NavigableSet<WordWrapper> wordMap) {

  }


}
