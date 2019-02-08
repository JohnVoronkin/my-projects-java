package song;

import consumer.ElectricityConsumer;

public class Lamp implements ElectricityConsumer {

    public void lightOn() {
        System.out.println("lamp switch ON");
    }

    @Override
    public void electricityOn() {
        lightOn();
    }
}
