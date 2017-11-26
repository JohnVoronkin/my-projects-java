package ru.simple.java.test.anonymousInnerClassesAndLambda;

public class Lamp implements ElectricityConsumer {

    public void lightOn() {
        System.out.println("lamp switch ON");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }
}
