package java_example.collections.lambda;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;

public class lambdaMain {

  public static void main(String[] args) {

    String[] colours = {"green", "white", "black", "blue", "pink", "grey"};

    Player player1 = new Player("Igor", 50);
    Player player2 = new Player("Vasia", 68);
    Player player3 = new Player("Victor", 80);
    Player player4 = new Player("John", 91);

    Arrays.sort(colours, Comparator.comparingInt(c -> c.charAt(c.length() - 1)));

  }

  @ToString
  @AllArgsConstructor
  private static class Player {
    private String name;
    private int scope;
  }


}
