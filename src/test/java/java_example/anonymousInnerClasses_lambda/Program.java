package java_example.anonymousInnerClasses_lambda;

import domain.consumer.Radio;
import domain.consumer.Switcher;
import domain.song.Lamp;

import static java.lang.System.out;

public class Program {

  public static void main(String[] args) {

    Switcher switcher = new Switcher();

    // подписка на событие
    switcher.addElectricityListener(new Lamp());
    switcher.addElectricityListener(new Radio());

        /*
        Анонимный класс - включает в себя описание класса (как такового) и создание объекта данного
        класса
         */
    switcher.addElectricityListener(() -> out.println("Fire!")); // Лямбда-выражения (фактически - использование объекта, как функции)

    switcher.switchOn();

  }

}
