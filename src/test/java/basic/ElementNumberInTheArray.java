package basic;

/**
 * Возвращаем номер элемента в массиве
 */
public class ElementNumberInTheArray {

    public static void main(String[] args) {
        int[] mas = {1, 3, 5, 76, 98, 77};

        System.out.println(findNumberInMass(mas, 77));

    }

    /*
     * на вход подаем сам массив и то значение, которое нужно найти
     * возвращает порядковый номер элемента (привычный для людей) если данный
     * элемент был найден, иначе возвращает 0 (ноль)
     */
    public static int findNumberInMass(int[] incomingMass, int needFind) {
        // проходим по циклу от первого элемента до "последнего"
        for (int i = 0; i < incomingMass.length; i++) {
            // если число найдено - цикл прерывается и возвращается номер позиции "для людей"
            if (needFind == incomingMass[i]) {
                return i + 1;
            }
        }
        //если в массиве нет нужного элемента - возвращаем ноль
        return 0;

    }

}
