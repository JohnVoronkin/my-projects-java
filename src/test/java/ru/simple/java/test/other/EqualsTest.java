package ru.simple.java.test.other;

/**
 * Created by john on 15.06.2017.
 */
public class EqualsTest {

    public static void main(String[] args) {
        String str1 = "string";
        String str2 = new String("string");
        System.out.println(str1.intern()==str2.intern() ? "the same" : "not the same");

        float f1 = 0.3f;
        float f2 = 0.4f;
        float f3 = f1 + f2;
        float f4 = 0.7f;
        System.out.println("|f3-f4|<1e-6: "+( Math.abs(f3-f4) < 1e-6 ));
    }
}
