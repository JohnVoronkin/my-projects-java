package extend.polymorphism;

import java.util.ArrayList;

public class ChessBoard {

  public static void main(String[] args) {
    drawAllChessItems();
  }

  public static void drawAllChessItems()
  {
    //добавляем фигуры в список
    ArrayList<ChessItem> items = new ArrayList<>();
    items.add(new King());
    items.add(new Queen());
    items.add(new Bishop());

    //рисуем их независимо от их типа.
    for (ChessItem item: items)
    {
      item.draw();
    }
  }


}
