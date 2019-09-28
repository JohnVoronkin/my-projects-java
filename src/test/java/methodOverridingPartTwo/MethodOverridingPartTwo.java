package methodOverridingPartTwo;

public class MethodOverridingPartTwo {

  public static void main(String[] args) {

    /*
    Все отлично. Тут мы даже не знаем, что в классе наследнике тип результата метода getMyParent был расширен.
«Старый код» как работал так и работает.
     */
    Cat parent = new Cat();
    Cat me = new Cat();
    me.setMyParent(parent);
    Cat myParent = me.getMyParent();


    /*
    Тут вызывается метод, у которого расширили тип результата.
  Если бы этого сделать было нельзя, всегда можно было бы объявить метод в Tiger:
  public Tiger getMyTigerParent() {
    return (Tiger) this.parent;
    }
  Т.е. ни о каком нарушении безопасности и/или контроля приведения типов нет речи.
     */
    Tiger parentTiger = new Tiger();
    Tiger meTiger = new Tiger();
    me.setMyParent(parent);
    Tiger myParentTiger = meTiger.getMyParent();


    /*
    И тут все отлично работает, хотя мы сузили тип переменных до базового класса (Cat).
  Благодаря перегрузке вызовется правильный метод setMyParent.

  И нет ничего страшного при вызове метода getMyParent, т.к. его результат, хоть и класса Tiger,
  все равно сможет отлично присвоиться в переменную myParent базового класса (Cat).

  Объекты Tiger можно смело хранить как в переменных класса Tiger, так и в переменных класса Cat.
     */
    Tiger parentTiger2 = new Tiger();
    Cat meTiger2 = new Tiger();
    me.setMyParent(parentTiger2);
    Cat myParentTiger2 = meTiger2.getMyParent();

  }


}
